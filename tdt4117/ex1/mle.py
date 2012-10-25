# literature constants. 
b = 0.75 
k = 1.2

a = 4.3 # average document length
#x = tf(word)

#	list of term frequency for the 10 documents. 
#	apple, melon, grape.
tflist = [
[1.0, 2.0, 0.0],
[3.0, 0.0, 1.0],
[1.0, 1.0, 1.0],
[1.0, 1.0, 0.0],
[1.0, 4.0, 3.0],
[0.0, 1.0, 0.0],
[2.0, 0.0, 0.0],
[0.0, 2.0, 0.0],
[0.0, 1.0, 2.0],
[2.0, 2.0, 1.0]
]

tfDoc = [11.0, 15.0, 8.0]

def getTf(word, doc):
#	print "word/doc", word, "/", doc
	if word == "Apple":
		return tflist[doc][0]
	elif word == "Melon":
		return tflist[doc][1]
	elif word == "Grape":
		return tflist[doc][2]
	else:
		return 0

def getDf(word):
#   print "df-word", word
    if word == "Apple":
        return tfDoc[0]
    elif word == "Melon":
        return tfDoc[1]
    elif word == "Grape":
        return tfDoc[2]
    else:
        return 0

def idf(word):
	if word == "Apple":
		return 0.046
	elif word == "Melon":
		return 0.097
	elif word == "Grape":
		return 0.301
	else:
		return 0 

qlist = [
["Apple"],
["Apple", "Melon"],
["Apple", "Coconut"],
]

# lambda
lam = 0.5

# tf = term frequency in document
# dl = total number of tokens in document. 
# cf = term frequency in collection. 
# cl = total number of tokens in collection.


#	calculate Jelinek-Mercer score.
def scoreJM(word, d):
#	score = (1-lam)* p(word,document) + lam* p(word, collection)
#	p(word,document) = (tf/dl)
#	p(word,collection) = (tf/ ) 
	
	dl = tflist[d][0]+tflist[d][1]+tflist[d][2]
	tf = getTf(word, d)
	cl = tfDoc[0]+tfDoc[1]+tfDoc[2] 
	cf = getDf(word)

	score = (1-lam)* (tf/dl) + lam*(cf/cl)
	#print word, score
	return score 


result = [ [0]*10, [0]*10, [0]*10 ]
for q in range(len(qlist)):
	for d in range(10):
		score = 1.0
		for term in qlist[q]:
			score = score * scoreJM(term, d)
		#	score = score * scoreDP(term, d)
		result[q][d]= (d,score)


#	Print the result. 
for a in result:
	print "query"
	for b in sorted(a, key=lambda student: student[1], reverse=True):
		print b
	
