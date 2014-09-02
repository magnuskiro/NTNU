import javax.swing.JOptionPane;
class Oppgave2a{
	public static void main(String[] args){
		String input	= JOptionPane.showInputDialog("Skriv inne en tekst.");
		String input2	= JOptionPane.showInputDialog("Skriv inne en tekst.");
		String utstreng="";
		likString ls = new likString();
		boolean fortsett = (input.length()!=0 && input2.length()!=0); 
		do {
			if((ls.Likhet(input, input2))==0){
				utstreng=("Stringene er like"); 
			}
			else{
				utstreng=("Stringene er IKKE like");
			}
			JOptionPane.showMessageDialog(null, utstreng);
			input	= JOptionPane.showInputDialog("Skriv inne en tekst.");
			input2	= JOptionPane.showInputDialog("Skriv inne en tekst.");
			fortsett = (input.length()!=0 && input2.length()!=0); 
		} while(fortsett);
		
	}
}
