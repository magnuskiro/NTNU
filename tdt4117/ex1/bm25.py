# literature constants. 
b = 0.75 
k = 1.2

a = 4.3 # average document length
#x = tf(word)

#	list of term frequency for the 10 documents. 
#	apple, melon, grape.
tflist = [
[1, 2, 0],
[3, 0, 1],
[1, 1, 1],
[1, 1, 0],
[1, 4, 3],
[0, 1, 0],
[2, 0, 0],
[0, 2, 0],
[0, 1, 2],
[2, 2, 1]
]

def tf(word, doc):
    if word == "Apple":
		return tflist[doc][0]
    elif word == "Melon":
        return tflist[doc][1]
    elif word == "Grape":
        return tflist[doc][2]
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

#score = idf(word) * ( (2.2 * x) / (x + 2.2 *(0.25+ (0.25*(10/a)))) )
#score = idf(word) * ( (2.2 * x) / (x + 2.2 *(0.25+ (0.25*(10/3.4)))) )
y = 2.2 *(0.25+ (0.25*(10/3.4)))

qlist = [
["Apple"],
["Apple", "Melon"],
["Apple", "Coconut"],
]

result = [ [0]*10, [0]*10, [0]*10 ]
for q in range(len(qlist)):
	#print "Query: ", q, ":", qlist[q]
	for d in range(10):
		score = 0
		for w in qlist[q]:
			x = tf(w, d)
			score += idf(w) * ( (2.2 * x) / (x + y) )
		#print "d:",d," score:",score
		result[q][d]= (d,score)
		#print result[q][d]


for a in result:
	print "query"
	for b in sorted(a, key=lambda student: student[1], reverse=True):
		print b
	
