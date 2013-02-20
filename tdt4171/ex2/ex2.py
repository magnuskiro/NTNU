
import numpy as nup

# forward chaining. 
def forward(fw, evidence, o, d):
	# identity matrix subtraction
	if not evidence: 
		o = nup.eye(len(o))-o

	# AIMA equation 15.12
	res = nup.dot(o, nup.transpose(d))
	res = nup.dot(res, fw)

	# normalize the result befor returning. 
	return res/res.sum()

def backward( bw, evidence, o, d ):
	# identity matrix subtraction
	if not evidence:
		o = nup.eye(len(o)) - o
	
	# AIMA equation 15.13
	res = nup.dot(d, o)
	res = nup.dot(res, bw)
	
	return res

def doFwBw(evidence, prior, o, d):

	# lenght of evidence array
	ev_len = len(evidence) + 1	

	# init empty forward mesage array.
	fw = nup.array( [None]*ev_len )
	# add the initial probabilities to the array. 
	fw[0] = prior

	print "Forward:"	
	# for all evidence observations 
	for e in range(1, ev_len):
		fw[e] = forward( fw[e-1], evidence[e-1], o, d )
		print "fw msg %i: %s" %(e, fw[e])
	
	# smoothing and backward init
	smooth = nup.array( [None]*ev_len )
	smooth[0] = prior

	bw = nup.array( [1,1] )

	print "Backward:"
	# for all 
	for b in range(ev_len-1, -1, -1):
		
		# normalize and calculate new probability on account of the previous value
		norm = fw[b]*bw
		smooth[b] = norm/norm.sum()
			
		print "bw msg: %i: %s" %(b, bw)

		# get the backward result
		bw = backward( bw, evidence[b-1], o, d )
		

	# printing the smoothed matrix.

	print "smoothed: "
	for i in range( len(smooth) ):
		print "%i: %s" %(i, smooth[i])
	
### main execution

# observation model 
o = nup.array([[0.9, 0.0],[0.0, 0.2]])

# dynamic model
d = nup.array([[0.7, 0.3],[0.3, 0.7]])

# initial probabilities for rain and not rain. 
prior = nup.array([0.5, 0.5])

# the evidence of rain the last days. true= it was raining
evidence = [True, True, False, True, True]

# get the reslt 
result = doFwBw(evidence, prior, o, d) 

exit()
