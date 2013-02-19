import sys
import glob
import os
import shutil
import time

#Default values:
port='5000'
folder='cases'

print sys.argv[0]

#Check commandline arguments:
if sys.argv != 2: 
	print 'Usage: ./run_all_tests.sh :portNumber :testCaseFolder'
	print 'Using', port, 'and', folder, 'as default',
else:
	if(sys.argv[0] > 1024  and sys.argv[0] < 65535 and os.path.exsists(sys.argv[1])):
	    port=sys.argv[0]
	    folder=sys.argv[1]
	else:
		print 'Either portnumber was wrong, needs to be larger than 1024 and smaller than 65535, or test case folder is not a directory'
		print 'Using defaults'

print 'Deleting old output files'
os.system("rm " + folder + "/output*")

#Run tests
print 'Compiling java files'
os.system("javac *.java")

print 'Using rmic'
os.system("rmic ServerImpl")
os.system("rmic RegistryProxyImpl")

print 'Starting RMI Registry'
#Uncomment the line which works on your OS/Window manager
#xterm -e java StartRegistry $port &
#konsole -e java StartRegistry $port &
os.system("gnome-terminal -x java StartRegistry " + str(port) + "&")

#Sleep to let java registry get up
time.sleep(2)

#Run test set A to J, this can be altered to A..A if you just want
#to run test A or A..B if you want to run A and B and so on.
letters = [ 'A', 'B', 'C' ]
for letter in letters:
	#Run server impl 1 to 4
	for i in range(1,5):
		#Redirect output to nothing to not pollute output from this script
		call = 'java ServerImpl localhost:' + str(port) + ' ' + folder + '/input_test_case_' + letter + '_server_' + str(i) + '.txt > /dev/null &'
		os.system(call)
	print 'Run test' + letter + ', turn off all servers and press [Enter] to continue:'
	raw_input("Press Enter to continue...")


#All test are now done, write to final result file
print "Compiling final_results log"

os.system("rm "+folder+"/final_results.txt") #remove the existing results file.
os.system("date > "+folder+"/final_results.txt")

#finds all the filenames. 
path = folder + '/'
pathList = []
for infile in glob.glob( os.path.join(path, 'output*.txt') ):
    pathList.append(infile)

#writes all output files to final_results
with open(folder+"/final_results.txt", "a") as myfile:
    for output in sorted(pathList):
        myfile.write("-----------")
        myfile.write(output)
        content = []
        with open(output) as f:
            for l in f.readlines():
                myfile.write(l)
    myfile.close()

os.system("rm " + folder +"/output*")

print 'Done'
