import javax.swing.JOptionPane;
class Oppgave1d {
	public static void main(String[] args){
		String input;
		input = JOptionPane.showInputDialog("Skriv inn en liten bokstav."); 
		char letter = input.charAt(0);
		int intletter = (int)letter;
		//konvertering fra små til store bokstaver. 
		while (intletter>96 && intletter<123 || intletter==248/*ø*/ || intletter==229/*å*/ || intletter==230/*æ*/ ){
			intletter = intletter-32;
			letter = (char)intletter;
			JOptionPane.showMessageDialog(null, letter);
			input = JOptionPane.showInputDialog("Skriv inn en liten bokstav.");
			letter = input.charAt(0);
			intletter = (int)letter;
		}
		
	}
}