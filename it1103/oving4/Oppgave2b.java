import javax.swing.JOptionPane;
class Oppgave2b{
	public static void main(String[] args){
		String input	= JOptionPane.showInputDialog("Skriv inne en tekst.");
		String input2	= JOptionPane.showInputDialog("Skriv inne en tekst.");
		String utstreng="";
		likString ls = new likString();
		boolean fortsett = (input.length()!=0 && input2.length()!=0); 
		do {
			if((ls.Likhet(input, input2))==0){
				utstreng=(input + "\n" + input2 + "\n" + "Stringene er like"); 
			}
			else if((ls.Likhet(input, input2))==1){
				utstreng=(input +"\n" + input2+"\n" + "String A er større enn string B"); 
			}
			else if((ls.Likhet(input, input2))==-1){
				utstreng=(input +"\n" + input2+"\n" + "String B er større enn string A"); 
			}
			JOptionPane.showMessageDialog(null, utstreng);
			input	= JOptionPane.showInputDialog("Skriv inne en tekst.");
			input2	= JOptionPane.showInputDialog("Skriv inne en tekst.");
			fortsett = (input.length()!=0 && input2.length()!=0); 
		} while(fortsett);
		
	}
}
