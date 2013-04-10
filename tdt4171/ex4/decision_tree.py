import numpy as np
import random

is_random = False 

class Node():
	def __init__(self, data):
		self.data = data
		self.children = {}
		
	def new_child(self, key, value):
		self.children.update({key: value})

	def display(self, space):
	#	print self.children, self.data
		if len(self.children) == 0:
			print space + "L:%s" % self.data
		else: 
#			print len(self.children)
#			print self.children
			for key, value in self.children.iteritems():
				print space + "-%s" % self.data
				self.children[key].display(space+" ")		
	
	def classify(self, attributes):
		# if is leaf
		if len(self.children) == 0:
			# attribute[7]
			# if lastValueOf(attribute) == data
			if attributes[7] == self.data:
				# this classification was correct. 
				return True
			else:
				return False
		else:
			# get child by attrbute where key is data value. 
			# children[attribute[data]]

			#print self.children
			#print self.children[2]
			key = int( attributes[self.data]  )
			#print self.children[key]
			return self.children[key].classify(attributes)

def get_data(file_name):
	# init dataset
	data = []

	# open data file
	input_file = open("./data/"+file_name+".txt")
	# read data file
	for line in input_file.readlines():
		# insert data into dataset
		data.append(line.rstrip("\n").split("\t"))

	# return dataset
	return data

# calculate the information gain. 
def gain(data, parent):
	n = float(len(parent))
	remainder = 0.0

	for a in data:
		alen = float(len(a))
		if not alen: return 0
		# remainder = this sets persentage of all observations multiplied with B(), where B() is given the number of desierables diveded by the length of the current set. 
		remainder += (alen/n)*B( a.count(1) / alen )
		#print "%s / %s * B(%s / %s) - result: %s" % (al, n, a.count(1), al, remainder)

	return 1-remainder

def B(q):
	if q >= 1 or q <= 0: return 0
	return -(q * np.log2(q) + ((1.0-q) * np.log2(1.0-q)))

# plurality value
def pv(parent):
	if not parent: return None
	# element count
	ec = {}	
	for e in parent:
		if e[-1] in ec:
			ec[e[-1]] += 1
		else: 
			ec.update({e[-1]: 1})
	# sort the element list in decreasing order. 
	wlist = sorted(ec, key = ec.get, reverse = True)
	
	# select a random value of the top 4 elements 
	n = random.randint(0, 3)

	if len(wlist) == 0 : return 0
	while(True):	
		try: 
			return wlist[n]
		except IndexError:
			n = random.randint(0, 3)	

def all_equal(data):
	for li in data[1:]:
		if li != data[0]: return False
	return True

def importance(data, attributes):
	if is_random:
		return random.choice(attributes.keys())
	else:
		# list of all values for an attribute 
		att_vals = [attributes[key] for key,value in attributes.iteritems()]
		# all data records. 
		outcomes = [e[-1] for e in data]
	
		# creates an inverse of the attributes. A list of all data that is not present in the attributes. 
		arr = []
		# for all attribute sets 	
		for att in att_vals:
			current = list(outcomes)
			# for each attribute in a set
			for a in att: 
				# if the current data set contains the attribute, remove it. 
				if a in current:
					current.remove(a)
			# append all data values that is not in attributes. 
			arr.append(current) 

		b = {} 
		i = 0
		for key,val in attributes.iteritems():
			b[key] = gain([att_vals[i], arr[i]], outcomes)	
			i += 1

		high = max(b.values())	
		high_list = [key for key in b.keys() if b[key] == high]	

		return random.choice(high_list)

# decision Node learning
def dt_learning(data, parent, attributes):
	if not data: 
		return Node(pv(parent))
	elif all_equal(data): 
		return Node(data[0][0])
	#elif no_attributes(attributes): 
	elif not attributes: 
		return Node(pv(data))
	else: 
		# the attribute that we are looking at. 
		A = int(importance(data, attributes))
	
		# the root node of the tree to be returned. 
		root = Node(A)	
		
		new_data = []
		
		for i in range(1,3):
			# for all records in the data set. 
			for record in range(len(data)):
				#if the data record value equals the importance value. 
				if data[record][A] == str(i):
					new_data.append(data[record])

			#print attributes
			# update the attributes
			if len(attributes) > 0: del attributes[str(A)]
			# go a level deeper to build subtree. 
			subtree = dt_learning(new_data, data, attributes)
			#print i, subtree
			root.new_child(i, subtree)
		return root		 



def main(random_importanse = False):
	is_random = random_importanse
	# get data
	data = get_data("training") # training dataset
	#print "Data:"
	#print data

	# decision tree attributes. 
	attributes = {
        "1": [],
        "2": [],
        "3": [],
        "4": [],
        "5": [],
        "6": [],
        "7": [],
    }

	for i in range(len(data)):
		for j in range(1,len(data[i])):
			if(data[i][j] == "1"):
				attributes[str(j)].append(data[i][j-1])

	# test gain function
	#data = [[2,2],[1,1,1,1],[1,1,2,2,2,2]]
	#parent = [1,1,1,1,1,1,2,2,2,2,2,2]
	#print gain(data, parent)		 

	parent = None

	# generate tree from training data.
	tree = dt_learning(data, parent, attributes)
	
	# print training tree
	print "\n ----- \n"
	print "Training tree: "
	tree.display("")

	# check towards test. 

	# get test data	
	data =  get_data("test") # test dataset
	
	#print data, "\n", len(data)
	counter = 0
	# for all test data	records
	for record in data:
		# test if the decision tree has the correct answer.
		if tree.classify(record): 
			# count the correct classification cases.
			counter += 1 

	print "\nResults: "
	print "correct / total"
	print "%s / 28" % counter
	print "percentage: %s" % (counter/28.0)
	return 0

# start execution of the program
print "Decision tree, importance implementation exercise"
print "\n ----- \n"
# use random importance
main(True)
# use importance function with gain calculations and such. 
main(False)
print "\n ----- \n"
print "Finished"
