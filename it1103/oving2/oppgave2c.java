import javax.swing.*;

public class oppgave2c{
	public static void main(String[] args) {
		// Variabeldeklarasjon
		String 	inputElever, inputKarakter;
		double 	karakter, karakterSum, karakterMaks, karakterMin, klasseBest;
		int		klasse, antElever, elever, klasseMaks, klasseMin, klasseBestNr; 
		
		// Initiering (forklarer variabler her for å spare plass)
		klasse = 0;
		antElever = 0;
		inputKarakter = "";
		inputElever = "";
		karakterMaks = 0; // Høyeste karakter
		karakterMin = 6; // Laveste karakter
		karakterSum = 0; // Brukt kun i utregning av snittkarakter
		klasseMaks = 0; // Klasse med høyeste karakter
		klasseMin = 0; // Klasse med laveste karakter
		klasseBest = 0; // Beste snittkarakter
		klasseBestNr = 0; // Klasse med beste snittkarakter
		
		for (klasse=1; klasse<=3; klasse++) {
			inputElever = JOptionPane.showInputDialog("Skriv inn antall elever i klasse " + klasse);
			elever = Integer.parseInt(inputElever);
			for (antElever=1; antElever<=elever; antElever++) {
				inputKarakter = JOptionPane.showInputDialog("Karakter til elev nr. " + antElever + ":");
				karakter = Double.parseDouble(inputKarakter);
				karakterSum = karakterSum + karakter;
				if (karakter > karakterMaks) {
					karakterMaks = karakter;
					klasseMaks = klasse;
				}//endIf
				if (karakter < karakterMin) {
					karakterMin = karakter;
					klasseMin = klasse;
				}//endIf
			}//endFor
			if ((karakterSum / elever) > klasseBest) {
				klasseBest = (karakterSum / elever);
				karakterSum = 0;
				klasseBestNr = klasse;
			}//endIf
			else {
				karakterSum = 0;
			}//endElse
		}//endFor
		
		// Print resultat
		System.out.println("Makskarakter er " + karakterMaks + ", fra klasse " + klasseMaks);
		System.out.println("Minimumskarakter er " + karakterMin + ", fra klasse " + klasseMin);
		System.out.println("Beste gjennomsnittskarakter er " + klasseBest + ", fra klasse " + klasseBestNr);
		
		// Avslutt program
		System.exit( 0 );
	}
}