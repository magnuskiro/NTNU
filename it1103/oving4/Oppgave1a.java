import javax.swing.JOptionPane;
class Oppgave1a{
	public static void main(String[] args){
		String tegn1 = JOptionPane.showInputDialog("Skriv inn et tegn"); 
		String tegn2 = JOptionPane.showInputDialog("Skriv inn et tegn");
		TegnLikhet st = new TegnLikhet(); // st - sammenlign tegn.
		boolean resultat;
		char a = tegn1.charAt(0);
		char b = tegn2.charAt(0);
		
		resultat = st.Likhet(a, b);
		System.out.println( tegn1 + " og " + tegn2 + " er sammenlignet og fikk resultatet: " + resultat );
		
		//utskrift av resultatet true/false
	}
}