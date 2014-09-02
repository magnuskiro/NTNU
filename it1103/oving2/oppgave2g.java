
//inkluderte hjelpeprogrammer
import 	javax.swing.JOptionPane;  

class oppgave2g
	{ 
		public static void main(String[] args) 
		{
			
		//Variabeldeklarasjon: type - navn - verdi. 
			String		inputTall1 		= 	JOptionPane.showInputDialog("Skriv inn et tall.");
			String		inputTall2 		= 	JOptionPane.showInputDialog("Skriv inn et tall.");
			String		inputTall3 		= 	JOptionPane.showInputDialog("Skriv inn et tall.");
			int			tall1			= 	Integer.parseInt(inputTall1);					
			int			tall2			= 	Integer.parseInt(inputTall2);	
			int			tall3			= 	Integer.parseInt(inputTall3);
			
			//Utførelse av programmet. {
				
			//1>2>3
				if (tall1>tall2 && tall2>tall3){
					System.out.println(tall3);
					System.out.println(tall2);
					System.out.println(tall1);
				}
			//2>1>3
				else if (tall2>tall1 && tall1>tall3){
					System.out.println(tall3);
					System.out.println(tall1);
					System.out.println(tall2);
				}
			//2>3>1
				else if (tall2>tall3 && tall3>tall1){
					System.out.println(tall1);
					System.out.println(tall3);
					System.out.println(tall2);
				}
			//3>1>2
				else if (tall3>tall1 && tall1>tall2){
					System.out.println(tall2 + "\n");
					System.out.println(tall1 + "\n");
					System.out.println(tall3 + "\n");
				}
			//3>2>1
				else if (tall3>tall2 && tall2>tall1){
					System.out.println(tall1);
					System.out.println(tall2);
					System.out.println(tall3);
				}
			//1>3>2
				else if (tall1>tall3 && tall3>tall2){
					System.out.println(tall2);
					System.out.println(tall3);
					System.out.println(tall1);
				}
				 
				
			// } slutt på det programmet gjør.  
			
			//Avslutter
			System.exit(0);
			
		}	//end metode main( )
	}	//end of program

	