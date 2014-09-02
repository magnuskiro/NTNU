
//inkluderte hjelpeprogrammer
import 	javax.swing.JOptionPane;  

public class oppgave1 
	{ 
		public static void main(String[] args) 
		{
			
		//Variabeldeklarasjon: type - navn - verdi. 
			String 		utStreng; 
			String		inputTall1 		= 	JOptionPane.showInputDialog("Hvor mange CD-plater vil du kjpe?");
			double 		tall1			= 	Double.parseDouble( inputTall1 );	
			double		pris			= 	0;			
			double		betale			= 	0;		
			
			//Utfrelse av programmet. {
				
				//sjekker hvor mange cd plater som skal kjpes, og beregner prisen. 
				if (tall1<50){
					pris 	= 	5;
					betale	=	(tall1*pris);
				}	
				else if (49<tall1 && tall1<99){
					pris 	= 	3.5;
					betale	=	(tall1*pris);
				}
				else if (tall1>99){
					pris 	= 	3;
					betale	=	(tall1*pris);
				}
							
				//utStreng inneholder det programmet skal skrive til skjermen. 
				utStreng = (
		    		  	"Du vil kjpe: " + tall1 + " cder, det vil koste: " + betale +
		    		  	"kr \n Da koster hver cd: " + pris + "kr"
		      	);
				
				//Her blir teksten vis i tekstboksen. 
				JOptionPane.showMessageDialog(null,utStreng);
	      		
				// } slutt p det programmet gjr.  
			
			//Avslutter
			System.exit(0);
			
		}	//end metode main( )
	}	//end of program

	