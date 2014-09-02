import javax.swing.JOptionPane;
import java.text.DecimalFormat;

class Oppgave2b {
	public static void main(String[] args){
		String 	utstreng; 
		String	input; 
		double	bankinnskudd;
		double	rente		;
		int 	antallaar	;
		Beregn1 	regn = new Beregn1();
		double 	penger; 
		DecimalFormat mangeDesimaler = new DecimalFormat("###,###,###kr");
		
		do {
			input = JOptionPane.showInputDialog("Skriv inn bankinnskudd. Skriv ferdig for a avslutte.");
			bankinnskudd	=	Double.parseDouble(input);
			rente			=	Double.parseDouble(JOptionPane.showInputDialog("Skriv inn rente."));
			antallaar		=	Integer.parseInt(JOptionPane.showInputDialog("Skriv inn antall år."));
			
			penger = regn.penger(bankinnskudd, rente, antallaar);
			
			utstreng = (
			"Et innskudd på "+ bankinnskudd + "kr. til" + rente + "% rente er i løpet av" +antallaar+ " år vokst til" +  mangeDesimaler.format(penger)
			);
			JOptionPane.showMessageDialog(null, utstreng);
			
		}while(!input.equals("ferdig"));
	}
}


class Beregn1{
	double resultat;
	public double penger(double bankinnskudd, double rente, double antallaar){
		int i = 0; 
		resultat = bankinnskudd; 
		for (i=1; i<=antallaar; i++) {
			resultat = resultat*((1+(rente/100)));	
		}
		return resultat;
	}
}