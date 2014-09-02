//import
import javax.swing.JOptionPane;
import java.text.DecimalFormat; 

// main klasse.
class Oppgave1b{
	public static void main(String[] args){
		String	input	=	JOptionPane.showInputDialog("Skal du ha rektangel eller sylinder? Skriv rektangel eller sylinger. skriv ferdig for å fullføre.");
		String	inputl;	
		String	inputb;
		String	inputh;
		String	inputr;
		String	utstreng;
		double	hoyde;
		double	radius;
		double	bredde;
		double	lengde;
		regn utregning = new regn(); 
		double	syl		=	0;
		double	rekt	=	0; 
		double 	tot		=	0; 
		double 	volum	=	0; 
		DecimalFormat toDesimaler = new DecimalFormat("0.00");
		
		//input
		do {
			if (input.equals("sylinder")){
				inputr = JOptionPane.showInputDialog("Radius.");
				radius = Double.parseDouble(inputr);
				inputh = JOptionPane.showInputDialog("Høyde.");
				hoyde = Double.parseDouble(inputh);
				syl++;
				tot++;
				volum += utregning.volumsylinder(radius, hoyde);
				
			}
			else if (input.equals("rektangel")){
				inputb = JOptionPane.showInputDialog("Bredde.");
				bredde = Double.parseDouble(inputb);
				inputl = JOptionPane.showInputDialog("Lengde.");
				lengde = Double.parseDouble(inputl);
				inputh = JOptionPane.showInputDialog("Høyde.");
				hoyde = Double.parseDouble(inputh);
				rekt++;
				tot++;
				volum += utregning.volumrektangel(lengde, hoyde, bredde);
			}
			else if (!input.equals("rektangel") && !input.equals("sylinder")){
				System.out.println("du har ikke valgt riktig type figur");		
			}
			input	=	JOptionPane.showInputDialog("Skal du ha rektangel eller sylinder? Skriv rektangel eller sylinger. skriv ferdig for å fullføre.");
		}while(!input.equals("ferdig"));
				
		utstreng =(
				"total volum av pakningene er :" + toDesimaler.format(volum) +  "\n"+
				"sylinder prosent =" + (syl/tot*100) + "\n"+
				"rektangel prosent =" + (rekt/tot*100) +"\n"
				);
		
		JOptionPane.showMessageDialog(null,utstreng);
		
		
	}
}
	

//klasse for beregninger
class regn {
double	volum; 

	//metode for sylinder
	public double volumsylinder(double radius, double hoyde){
		volum=Math.PI*radius*radius*hoyde;
		return volum;
	}
	//metode for rektangel
	public double volumrektangel(double lengde, double bredde,double hoyde){
		volum = lengde*bredde*hoyde;
		return volum;
	}
}