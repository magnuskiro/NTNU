#!/bin/sh

#Default values:
port=5000
folder='cases'
#Check commandline arguments:
if [ $# -ne 2 ]; then
	echo 'Usage: ./run_all_tests.sh :portNumber :testCaseFolder'
	echo 'Using' $port and $folder as default
else
	if [ $1 -gt 1024 ] && [ $1 -le 65535 ] && [ -d $2 ];then
	port=$1
	folder=$2
	else
		echo 'Either portnumber was wrong, needs to be larger than 1024 and smaller than 65535, or test case folder is not a directory'
		echo 'Using defaults'
	fi
fi

echo 'Deleting old output files'
rm $folder/output*

#Run tests
echo 'Compiling java files'
javac *.java

echo 'Using rmic'
rmic ServerImpl
rmic RegistryProxyImpl

echo 'Starting RMI Registry'
#Uncomment the line which works on your OS/Window manager
#xterm -e java StartRegistry $port &
#konsole -e java StartRegistry $port &
gnome-terminal -x java StartRegistry $port &

#Sleep to let java registry get up
sleep 2

#Run test set A to J, this can be altered to A..A if you just want
#to run test A or A..B if you want to run A and B and so on.
for letter in {A..C}; do
	#Run server impl 1 to 4
	for i in 1 2 3 4; do
		#Redirect output to nothing to not pollute output from this script
		java ServerImpl localhost:$port $folder/input_test_case_${letter}_server_${i}.txt > /dev/null &
	done
	echo 'Run test' $letter', turn off all servers and press [Enter] to continue:'
	read -p ''
done

#All test are now done, write to final result file
cd $folder
date > final_results.txt
outputs=`ls output_test_case* | sort`
for output in $outputs; do
	echo '---------' >> final_results.txt
	echo $output >> final_results.txt
	cat $output >> final_results.txt
done
echo 'Done'
