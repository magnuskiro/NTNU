
//inkluderte hjelpeprogrammer
import 	javax.swing.JOptionPane;  

class oppgave2a {
	public static void main(String[] args){
		
			
		//Variabeldeklarasjon: type - navn - verdi. 
			String 		utStreng; 
			String		inputTall1 		= 	JOptionPane.showInputDialog("skriv inn ett tall.");
			int 		tall1			= 	Integer.parseInt( inputTall1 );	
			int			count			= 	1;					
			int			sum				=	1;
			
			//Utfrelse av programmet. {
				
				//regner ut summen av alle heltall fra 0 til og med tall1.
				while (count<=tall1){
					sum = (tall1+1)*(tall1/2);
					count++;
				}	
				
							
				//utStreng inneholder det programmet skal skrive til skjermen. 
				utStreng = (
		    		  	"Summen av alle heltall, til og med " + tall1 + " har summen: " + sum
		      	);
				
				//Her blir teksten vis p skjermen. 
				JOptionPane.showMessageDialog(null,utStreng);
	      		
				// } slutt p det programmet gjr.  
			
			//Avslutter
			System.exit(0);
			
		}	//end metode main( )
	}	//end of program

	