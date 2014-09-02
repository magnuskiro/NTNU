
//inkluderte hjelpeprogrammer
import 	javax.swing.JOptionPane;  
import  java.text.DecimalFormat;

class oppgave2f 
	{ 
		public static void main(String[] args) 
		{
			
		//Variabeldeklarasjon: type - navn - verdi. 
			String 			utStreng; 
			String			inputTall1 		= 	JOptionPane.showInputDialog("Skriv inn hvor mange sekunder du vil konvertere til timer og minutter. ");
			double 			tall1			= 	Double.parseDouble( inputTall1 );	
			double			timer			= 	0;			
			double			minutter		= 	0;
			double			sekunder		= 	0; 
			double 			temp			= 	0;
			DecimalFormat	nullDesimaler 	=  	new  DecimalFormat("0");	
			
			
			//Utførelse av programmet. {
				
				//regner ut sekunder,minutter og timer. 	
				temp = tall1/3600;
				timer = Double.parseDouble(nullDesimaler.format(temp));

				
				minutter = (temp-timer)*60;
				temp=minutter;
				minutter =	Double.parseDouble(nullDesimaler.format(minutter));
				
				sekunder = (temp-minutter)*60;
				sekunder =	Double.parseDouble(nullDesimaler.format(sekunder));
				
				//utStreng inneholder det programmet skal skrive til skjermen. 
				utStreng = (
						"timer: " + timer +
						"\nminutter: " + minutter + 
						"\nsekunder: " + sekunder 
		      	);
				
				//Her blir teksten vis i tekstboksen. 
				JOptionPane.showMessageDialog(null,utStreng);
	      		
				// } slutt på det programmet gjør.  
			
			//Avslutter
			System.exit(0);
			
		}	//end metode main( )
	}	//end of program

	