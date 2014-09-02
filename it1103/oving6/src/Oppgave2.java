import java.io.*;
import javax.swing.JOptionPane; 

class Oppgave2 {
	public static void main(String[] args) throws IOException{
		String[] filename = new String[6];  
		String temp="", resultat="";
		String[][] fileentries = new String[5][];
		fileentries[0] = new String[8];
		fileentries[1] = new String[5];
		fileentries[2] = new String[6];
		fileentries[3] = new String[6];
		fileentries[4] = new String[7];
		String[] indextable = new String[23];
		String input= JOptionPane.showInputDialog("hei");
		String docs="";
		FileReader read = new FileReader("oversikt.txt");
		BufferedReader BRead = new BufferedReader(read); 
		methods Methods = new methods();

		//overview file in.
		BRead = new BufferedReader(new FileReader("oversikt.txt")); 
		while((temp=BRead.readLine()) !=null){
			resultat +=temp + " ";
		}
		BRead.close();
		read.close();
		filename=resultat.split(" ");

		//read content files. 
		Methods.fileinput(filename, fileentries); 

		//creates the indextable. 
		indextable=Methods.createindextable(indextable,fileentries);

		//finds the documents where input is present. 
		for(int i=0; i<fileentries.length; i++){
			for(int j=0; j<fileentries[i].length; j++){
				if(fileentries[i][j].equals(input)){
					temp = filename[i];
					docs += temp + ", ";
					break;
				}
			}
		}

		//search
		if(Binary.Search(indextable,input)){
			System.out.println(input + " was found in " + docs);
		}

	}
}