import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class methods {
	public String[] createindextable(String[] indextable, String[][] fileentries){
		Sort sorting = new Sort();
		String resultat="",temp="";
		for(int i=0; i<fileentries.length; i++){
			for(int j=0; j<fileentries[i].length; j++){
				if(!resultat.contains(fileentries[i][j])){
					temp=fileentries[i][j];
					resultat +=temp + " ";	
				}
			}
		}
		indextable=resultat.split(" ");
		sorting.bubbleSort(indextable);
		return indextable;
	}
	public void fileinput(String[] filename, String[][] fileentries) throws IOException{
		String resultat="", file="",temp="";
		String[] temparray = new String[9];
		FileReader read = new FileReader("oversikt.txt");
		BufferedReader BRead = new BufferedReader(read); 
		Sort sorting = new Sort(); 

		for(int i=0; i<=4; i++){
			file = filename[i];
			resultat=""; 
			BRead = new BufferedReader(new FileReader(file)); 
			while((temp=BRead.readLine()) !=null){
				resultat +=temp + " ";
			}
			BRead.close();
			read.close();
			temparray=resultat.split(" ");
			sorting.bubbleSort(temparray);
			//write temparray to file entries.  
			for(int k=0; k<temparray.length; k++){
				if(temparray[k]!=null){
					fileentries[i][k]= temparray[k];
				}
			}
		}
	}
}
