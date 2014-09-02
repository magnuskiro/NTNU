import javax.swing.JOptionPane;
class Oppgave1b{
	public static void main(String[] args){
		String tegn1 = JOptionPane.showInputDialog("Skriv inn et tegn"); 
		String tegn2 = JOptionPane.showInputDialog("Skriv inn et tegn");
		TegnLikhet st = new TegnLikhet(); // st - sammenlign tegn.
		char a = tegn1.charAt(0);
		char b = tegn2.charAt(0);
		
		System.out.println( 
				tegn1 + " er lik  \t \t" 		+ tegn2 + "\t-->" + st.Likhet(a, b) + "\n" +
				tegn1 + " er storre enn  \t" 	+ tegn2 + "\t-->" + st.Storre(a, b) + "\n" +
				tegn1 + " er mindre enn  \t" 	+ tegn2 + "\t-->" + st.Mindre(a, b) + "\n"
				);
		
		//utskrift av resultatet true/false
	}
}