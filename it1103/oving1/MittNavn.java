
//inkluderte hjelpeprogrammer
import  javax.swing.JOptionPane;
import javax.swing.JTextArea; 

class MittNavn 
	{ 
		public static void main(String[] args) 
		{
			//Variabeldeklarasjon: 
			String 		utStreng;
			String		inputNavn;
			JTextArea	utOmrade;
			
			//Initiering
			utOmrade = new JTextArea();
			
			//Leser inn navn.
			inputNavn = JOptionPane.showInputDialog("Skriv navnet ditt her!");
					
			
			//Utførelse:
			utStreng = ("Hei, jeg heter " + inputNavn + "!\n");
			
			//Utskrift
      		utOmrade.setText(utStreng);
      		JOptionPane.showMessageDialog(null,utOmrade, "Resultat",JOptionPane.PLAIN_MESSAGE );
			
      		//Avslutter
			System.exit(0);
			
		}	//end metode main( )
	}		//end class Program2c

	