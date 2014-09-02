import javax.swing.JOptionPane;
import java.text.DecimalFormat;

class Oppgave2a {
	public static void main(String[] args){
		String 	utstreng; 
		String	input; 
		double	bankinnskudd;
		double	rente		;
		int 	antallaar	;
		Beregn 	regn = new Beregn();
		double 	penger; 
		DecimalFormat toDesimaler = new DecimalFormat("0.00kr");
		
		//input, output og henting av resultat. 
		do {
			//Input av variabler. 
			input = JOptionPane.showInputDialog("Skriv inn bankinnskudd. Skriv ferdig for a avslutte.");
			bankinnskudd	=	Double.parseDouble(input);
			rente			=	Double.parseDouble(JOptionPane.showInputDialog("Skriv inn rente."));
			antallaar		=	Integer.parseInt(JOptionPane.showInputDialog("Skriv inn antall år."));
			
			//regner ut hvor mye penger du har, ved å sende variablene til variabelen regn, som peker på klasen Beregn. Beregn sender svaret tilbake. 
			penger = regn.penger(bankinnskudd, rente, antallaar);
			
			//skriver ut, resultatet og input vaiablene. 
			utstreng = (
			"Et innskudd på "+ bankinnskudd + "kr. til" + rente + "% rente er i løpet av" +antallaar+ " år vokst til" +  toDesimaler.format(penger)
			);
			JOptionPane.showMessageDialog(null, utstreng);
			
		}while(!input.equals("ferdig"));
	}
}

//beregnings klasse. Regner ut hvor mye penger du har etter x antall år. 
class Beregn{
	double resultat;
	public double penger(double bankinnskudd, double rente, double antallaar){
		int i = 0; 
		resultat = bankinnskudd; 
		//for-løkke som kjører så lenge 
		for (i=1; i<=antallaar; i++) {
			resultat = resultat*((1+(rente/100)));	
		}
		return resultat;
	}
}