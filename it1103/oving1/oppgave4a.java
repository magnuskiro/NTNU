
//inkluderte hjelpeprogrammer
import 	javax.swing.JOptionPane;
import 	javax.swing.JTextArea; 

class oppgave4a 
	{ 
		public static void main(String[] args) 
		{
			//Variabeldeklarasjon: 
			JTextArea	utOmrade;
			String 		utStreng;
			String		inputTall1;
			String		inputTall2;
			double		gjennomsnitt;
			double		sum;
			double 		tall1; 
			double 		tall2;
			
			//Variabel definisjon. Verdien til hver enkelt variabel. 
			inputTall1 		= 	JOptionPane.showInputDialog("Skriv inn et tall her!");
			inputTall2 		= 	JOptionPane.showInputDialog("Skriv inn et annet tall her!");
			tall1			= 	Double.parseDouble( inputTall1 );	
			tall2			=	Double.parseDouble( inputTall2 );
			sum 			=	(tall1 + tall2);
			gjennomsnitt 	=	(sum/2);		
						
			//Initiering
			utOmrade = new JTextArea();
						
			//Utførelse:
			utStreng = (
					"Du skrev inn tallene " + inputTall1 + " og " + inputTall2 + ".\n" + 
					"Summen av disse tallen er: " + sum + ".\n" +
					"Gjennomsnittet av tallene er: " + gjennomsnitt + ".\n"
			);
						
			//Utskrift
      		utOmrade.setText(utStreng);
      		JOptionPane.showMessageDialog(null,utOmrade, "Resultat",JOptionPane.PLAIN_MESSAGE );
			
      		//Avslutter
			System.exit(0);
			
		}	//end metode main( )
	}	//end of program

	