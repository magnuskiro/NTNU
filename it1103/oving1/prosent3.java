
//inkluderte hjelpeprogrammer
import 	javax.swing.JOptionPane;  

class prosent3 
	{ 
		public static void main(String[] args) 
		{
			
		//Variabeldeklarasjon: type - navn - verdi. 
			String 		utStreng; 
			String		inputTall1 		= 	JOptionPane.showInputDialog("Skriv inn et tall her!");
			double 		tall1			= 	Double.parseDouble( inputTall1 );	
			double		pris			=	(tall1*1.25);
			double		mva 			=	(tall1*0.25);
					
			
			//Utførelse av programmet. {
				
				//utStreng inneholder det programmet skal skrive til skjermen. 
				utStreng = (
		    		  	"Pris uten avgift: " + tall1 +  "kr \n"+
		    			"Mva(25%)= " + mva + "kr \n" +
		    		  	"Pris inkl. mva: " + pris + "kr \n" 
		      	);
				
				//Her blir teksten vis i tekstboksen. 
				JOptionPane.showMessageDialog(null,utStreng);
	      		
				// } slutt på det programmet gjør.  
			
			//Avslutter
			System.exit(0);
			
		}	//end metode main( )
	}	//end of program

	