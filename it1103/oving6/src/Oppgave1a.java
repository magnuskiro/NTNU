import java.io.*;
class Opgpave1a {
	public static void main(String[] agrs) throws IOException{
		File existsfil = new File("text.txt");
		FileReader readfile = new FileReader("text.txt");
		int tk; 
		String ord=""; 
		if(existsfil.exists()){
			System.out.println("filen eksisterer, fortsetter...");
			do{
			tk=readfile.read();
				if(tk==46 || tk==44 || tk==32 ){
					System.out.println(ord);
					ord=""; 
				}
				else{
					ord = ord + (char)tk;
					ord=ord.toLowerCase();
				}			
			}while(tk>0);
		}
		else{
			System.out.println("ingen fil");
		}
		
		
	}
}