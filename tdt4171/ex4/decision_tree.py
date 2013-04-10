import numpy as np
import random

# random variable for use in the importance function
# it is set first in the main function, by input argument to the main function.
is_random = None 

# node class for tree building. 
# each node without children is the root of this subtree. 
# a node without children is leaf node. 
class Node():
	def __init__(self, data):
		self.data = data
		self.children = {}
	
	# add child to node	
	def new_child(self, key, value):
		self.children.update({key: value})

	# function for printing the tree of this node.
	def display(self, space):
	#	print self.children, self.data
		if len(self.children) == 0:
			print space + "L:%s" % self.data
		else: 
#			print len(self.children)
#			print self.children
			for key, value in self.children.iteritems():
				# print this node of the tree. 
				print space + "-%s" % self.data
				# print the child nodes. 
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

# read the text files for training data and test data. 
def get_data(file_name):
	# init dataset
	data = []

	# open data file
	input_file = open("./data/"+file_name+".txt")
	# read data file
	for line in input_file.readlines():
		# insert data into dataset
		data.append(line.rstrip("\n").split("\t"))
	
	# debug to see the data structure. 
	#print data

	# return dataset
	return data

# calculate the information gain. 
def gain(data, parent):
	n = float(len(parent))
	remainder = 0.0

	# for all attribute sets in the dataset. 
	for a in data:
		alen = float(len(a))
		# if there are no elements in a return 0
		if not alen: return 0
		# calculate the gain by the formula in the book.
		# remainder = this sets persentage of all observations multiplied with B(), where B() is given the number of desierables diveded by the length of the current set. 
		remainder += (alen/n)*B( a.count(1) / alen )
		#print "%s / %s * B(%s / %s) - result: %s" % (al, n, a.count(1), al, remainder)

	return 1-remainder

# function to calculate the B value
# critical part for the gain function. 
def B(q):
	# when q is 1 or 0, the logarithm will return 0 or infinity, therefore we return 0 always. 
	if q >= 1 or q <= 0: return 0
	# calculate the B formula from the book. 
	return -(q * np.log2(q) + ((1.0-q) * np.log2(1.0-q)))

# plurality value
def pv(parent):
	# if the parten data set has no entries. 
	if not parent: return None
	# element count
	ec = {}
	# for all elements in the parent dataset 	
	for e in parent:
		# if the last element in a set exsists in our dictionary
		if e[-1] in ec:
			# increment the instance count
			ec[e[-1]] += 1
		else: 
			# if the element dosn't exsist in the dictionary, add it. 
			ec.update({e[-1]: 1})
	# sort the element list in decreasing order. 
	wlist = sorted(ec, key = ec.get, reverse = True)
	
	# select a random value of the top 4 elements 
	n = random.randint(0, 3)

	# if we have no values 
	if len(wlist) == 0 : return 0
	# while we can't find an existing value
	while(True):	
		try: 
			# try to retur an existing value.
			return wlist[n]
		except IndexError:
			# if the value don't exist try another list element. 
			n = random.randint(0, 3)	

# check if all values in a data set are equal. eg all_elemets==1. 
def all_equal(data):
	for li in data[1:]:
		if li != data[0]: return False
	return True

# random and gain importance functions. 
def importance(data, attributes):
	if is_random:
		# for the random importance function we just return a random value for b. 
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
		# for all attributes
		for key,val in attributes.iteritems():
			# calculate the b value
			b[key] = gain([att_vals[i], arr[i]], outcomes)	
			i += 1

		# find the highest B value
		high = max(b.values())	
		# find all nodes that has the highest value
		high_list = [key for key in b.keys() if b[key] == high]	
		# return one of the nodes that has the highest value. 		
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

	# populate the attributes list
	# for the length of the data set
	for i in range(len(data)):
		# for the length of the data record. 
		for j in range(1,len(data[i])):
			# if the data-record value equals "1"
			if(data[i][j] == "1"):
				# add data-record value to the attribute dictionary under the j key. 
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
