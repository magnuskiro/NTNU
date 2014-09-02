import java.io.*;
class Opgpave1b {
	public static void main(String[] agrs) throws IOException{
		File existsfil = new File("text.txt");
		FileReader readfile = new FileReader("text.txt");
		FileWriter skrivtilfil = new FileWriter("resultat.txt");
		int tk=0; 
		String[] orda= new String[100];
		String ord=""; 
		if(existsfil.exists()){
			System.out.println("filen eksisterer, fortsetter");
			for(int i=0; i<100; i++){
				orda[i]="";
			}

			while(tk>=0){
				tk=readfile.read();
				//if end line, carriage return or end of file, or space  
				if(tk==32 || tk==10 || tk==13 || tk==-1){
					// check if the word alreadey exists.
					for(int i=0; i<100; i++){
						if(orda[i].equals(ord)){
							break; 
						}
						else if(orda[i].equals("")){
							orda[i]=ord;	
							break; 
						}
					}
					ord="";
				}
				else if(tk==46 || tk==44){ //if , or . skip the character
					System.out.print("");
				}
				else{ // word = word + next character. 
					ord = ord + (char)tk;
					ord=ord.toLowerCase();
				}			

			}
			//readfile.close(); 

			//skriver ut array med ord. 
			for(int j=0; !orda[j].equals(""); j++){
				skrivtilfil.write(orda[j]+"\n");
				System.out.println(orda[j]);
			}
			skrivtilfil.close();

		}
		else{
			System.out.println("ingen fil");
		}
	}
}