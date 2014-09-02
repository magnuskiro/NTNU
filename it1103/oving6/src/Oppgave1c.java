import java.io.*;
import javax.swing.JOptionPane;
import java.io.BufferedReader;


class Oppgave1c {
	public static void main(String[] args) throws IOException{
		FileReader readfile = new FileReader("resultat.txt"); //reads file
		BufferedReader in = new BufferedReader(readfile); //reads from file
		String tff; //temp from file
		String[] orda= new String[100]; //array for words. 
		search bs = new search(); //calls the search method
		String input = JOptionPane.showInputDialog("Skriv inn et ord du vil finne.");
		String resultat=""; 
		
		//reads from file
		in = new BufferedReader(new FileReader("resultat.txt")); 
		
		//reads word by word from file while word!=null
		while((tff=in.readLine()) !=null){
			resultat +=tff + " ";
		}
		//close files
		in.close();
		readfile.close();
		orda=resultat.split(" ");//splits the string into bits and puts inn an array.  
		
		bs.bubbleSort(orda); // sorts the array
		//searches the indexfile for the designated word. 
		if (bs.binS(orda, input)){
			System.out.println(bs.binS(orda, input)+ " Ord funnet!");
		}
		else{
			System.out.println(bs.binS(orda, input)+ " Ord ikke funnet.");
		}
	}
}

//boubble sort. 
class search{
	public void bubbleSort(String[] A){
		int n=A.length-1;
		boolean swapped = false;
		String temp="";
		do{
			swapped = false;
			for (int i=0; i<n;i++){
				if((A[i].compareTo(A[i+1]))>0){
					temp=A[i+1];
					A[i+1]=A[i];
					A[i]=temp;
					swapped = true;
				}//end if
			}//end for
			n -= 1;
		}while(swapped);
	}

	//binary search. 
	public boolean binS(String[] inputA, String input){
		int mid;
		int min=0;
		int max=45;
		int r;
		for (int i=0; i<7;i++){
			mid = (min+max)/2;
			r = input.compareTo(inputA[mid]);
			if(r>0 ){ 
				min = mid + 1;
			}
			else if(r<0){ 
				max = mid - 1;
			}
			else if(r==0){
				return true; 
			}
		}
		return false; 
	}
}