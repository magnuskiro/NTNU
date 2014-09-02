//Oppgave 2c er løst objektorientert, hviklet er det man skal gjøre i oppgave2d. 
import javax.swing.JOptionPane;
class Oppgave2c{
	public static void main(String[] args){
		String input	= JOptionPane.showInputDialog("Skriv inne en tekst.");
		String input2	= JOptionPane.showInputDialog("Skriv inne en tekst.");	
		String utstreng="";
		likString ls = new likString();
		boolean fortsett = (input.length()!=0 && input2.length()!=0); 
		do {
			if(ls.delav(input, input2)){
				utstreng=(input + "\n" + input2 + "\n" + ls.delav(input, input2) + "\n"+ "Streng B er en del av streng A");
			}
			else {
				utstreng=(input + "\n" + input2 + "\n" + ls.delav(input, input2) + "\n"+ "Streng B er IKKE en del av streng A");
			}
			JOptionPane.showMessageDialog(null, utstreng);
			input	= JOptionPane.showInputDialog("Skriv inne en tekst.");
			input2	= JOptionPane.showInputDialog("Skriv inne en tekst.");
			fortsett = (input.length()!=0 && input2.length()!=0); 
		} while(fortsett);
		
	}
}
