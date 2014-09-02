//inkluderte hjelpeprogrammer
import 	javax.swing.JOptionPane;
import  java.text.DecimalFormat;


public class oppgave5
	{ 
		public static void main(String[] args) 
		{
			
		//Variabeldeklarasjon: type - navn - verdi. 
			String		utStreng		=	"";
			String		inputmoms 		= 	JOptionPane.showInputDialog("Skal du spise inne? Skriv: inne, eventuelt skriv ute for  spise ute.");
			String		inputTall1 		= 	JOptionPane.showInputDialog("Skriv inn prisen uten moms for  f utregnet prisen med moms.");
			double		tall1			= 	Double.parseDouble(inputTall1);;				
			double		moms			=	0;
			double		sum				= 	0;
			DecimalFormat	toDesimaler 	=  	new  DecimalFormat("0.00");	
			
			//Utfrelse av programmet. {
			
			//sjekker hvilken moms man skal bruke. 
			if (inputmoms.equals("inne")){
				moms = 1.25;
			}
			else if (!inputmoms.equals("inne")||inputmoms.equals("ute")){
				moms = 1.14; 
				
			}
			
			//regner ut pris  betale og skriver den ut.
			sum = tall1*moms;
			sum = Double.parseDouble(toDesimaler.format(sum));
			utStreng = (
					"Du har valg  spise " + inputmoms + ", da betaler du: " + sum + "kr for varen inkludert moms."
					);
			JOptionPane.showMessageDialog(null,utStreng);
			
			// } slutt p det programmet gjr.  
			
			//Avslutter
			System.exit(0);
			
		}	//end metode main( )
	}	//end of program

	