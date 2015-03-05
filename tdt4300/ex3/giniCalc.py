columnSums = [
{1: 0.0, 2: 0.0, 3: 0.0, 4: 0.0, 5: 0.0, 6: 0.0, 7: 0.0, 8: 0.0, 9: 0.0, 10: 0.0, 11: 0.0, 12: 0.0, 13: 0.0, 14: 0.0, 15: 0.0, 16: 0.0, 17: 0.0, 18: 0.0, 19: 0.0, 20: 0.0},
{'young': 0.0, 'medium young': 0.0, 'old': 0.0},
{'low': 0.0, 'medium': 0.0, 'high': 0.0},
{'yes': 0.0, 'no': 0.0},
{'pass': 0.0, 'high': 0.0},
{'Yes': 0.0, 'No': 0.0}
]

dataset = [
[1, "young", "high", "no", "pass", "No"],
[2, "young", "high", "no", "high", "No"],
[3, "medium young", "high", "no", "pass", "Yes"],
[4, "old", "medium", "no", "pass", "Yes"],
[5, "old", "low", "no", "pass", "Yes"],
[6, "old", "low", "yes", "high", "No"],
[7, "medium young", "low", "yes", "high", "Yes"],
[8, "young", "medium", "no", "pass", "No"],
[9, "young", "low", "yes", "pass", "Yes"],
[10, "old", "medium", "yes", "pass", "Yes"],
[11, "young", "medium", "yes", "high", "Yes"],
[12, "medium young", "medium", "no", "high", "Yes"],
[13, "medium young", "high", "yes", "pass", "Yes"],
[14, "old", "medium", "no", "high", "No"],
[15, "medium young", "medium", "yes", "pass", "No"],
[16, "medium young", "medium", "yes", "high", "Yes"],
[17, "young", "low", "yes", "high", "Yes"],
[18, "old", "high", "no", "pass", "No"],
[19, "old", "low", "no", "high", "No"],
[20, "young", "medium", "yes", "high", "Yes"],
]

columnCount=20.0
colNames=["id", "age", "income", "student", "creditworthiness", "pc"]

def getColNum(a):
	count = 0
	for n in colNames:
		if n == a:
			return count
		count +=1

def count():
	# counts all rows and cols in the dataset
	# store it in the columns cont. 
	for record in dataset:
		column = 0
		for col in record:
#			print col
#			print column
#			print columnSums[column]
			columnSums[column][col] += 1.0
			column += 1

def getgini(cName="all"):
	
	sum = 0 # is the sum of all subsets of the gini value; [p(j|t)]^2
	colNum = getColNum(cName)
	for val in columnSums[colNum]:
	#	print val
		sum += (columnSums[colNum][val] / columnCount ) **2 
		#print val, sum

	return 1-sum


# count number of incidents in the dataset.
count()

sum = 0
for n in colNames:
    sum += (getgini(n) / 6 )**2
print "tot gini=" , 1 - sum

# get all column individual gini indexes. 
for n in colNames:
	print n, ": gini=", getgini(n)
	#print "n:" + getgini(n)

exit()
