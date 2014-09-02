import javax.swing.JOptionPane;
import java.text.DecimalFormat;

class BrukGeofig{
		//metode for input og output. 
		public static void main(String[ ] args){
			//variabler
			String 	inputr	= 	JOptionPane.showInputDialog("Skriv inn radiusen til  sirkelen.");
			double 	radius		=	Double.parseDouble(inputr);
			if (radius>=0){
			GeoFig.rad(radius);
			DecimalFormat	treDesimaler	= new DecimalFormat("0.00cm");
			
			System.out.println("Arealet av sikelen er: "+ treDesimaler.format(GeoFig.regnareal())); 
			System.out.println("Omkretsen av sikelen er: "+ treDesimaler.format(GeoFig.regnomkrets()));
			System.exit(0);
			}
			else {
				System.out.println("Negativ verdi! Programmet er avsluttet.");
			}
		}
	}		

class GeoFig {
private static double 	areal;
private static double 	omkrets;
private	static double	r; 
		public static void rad(double radius){
			r=radius;
		}
		//metode for å regner ut omkretsen av en sirkel.
		public static double regnareal(){
			areal= (Math.PI*r*r);
			return areal; 
		}
		//metode for å regne ut arealet av en sirkel.
		public static double regnomkrets(){
			omkrets= (2*Math.PI*r);
			return omkrets; 
		}
	}