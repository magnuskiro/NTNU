import javax.swing.JOptionPane; 

class Oppgave3 {
	public static void main(String[] args){
		String input;
		String utStreng;
		String kontoeier;
		double kontonr;
		double kontosaldo;
		Bank k = new Bank(); 
		
		
		//valg
			utStreng = ("Hva vil du gjøre? \n" +
			"1 - Opprette en konto. \n" +
			"2 - oppdatere en konto \n" +
			"3 - få en utskrift av kontodataene?"
			);
			input = JOptionPane.showInputDialog(utStreng);
			
		do{
			if (input.equals("1")){
				
				input = JOptionPane.showInputDialog("Skriv inn navnet på eieren av kontoen.");
				kontoeier = input;
				input = JOptionPane.showInputDialog("Skriv inn konto nr.");
				kontonr = Double.parseDouble(input);
				input = JOptionPane.showInputDialog("skriv inn saldo.");
				kontosaldo = Double.parseDouble(input);
				k.konto(kontoeier, kontonr, kontosaldo);
			}
			else if(input.equals("2")){
				k.oppdatereK();
			}
			else if (input.equals("3")){
				k.utskriftKdata();
			}
			input = JOptionPane.showInputDialog(utStreng);
		}while (!input.equals("0"));
		System.exit(0);	
		
	}
}

class Bank {
	//variabler/konto info:
		private String	kontoeier = "";
		private double 	kontonr = 0; 
		private double 	saldo = 0;
		
	void konto (String inputkontoeier, double inputkontonr, double inputkontosaldo){
		
		kontoeier = inputkontoeier;
		kontonr = inputkontonr;
		saldo = inputkontosaldo; 
	}
	
	public void oppdatereK(){
		if (kontonr!=0){
			String input;
			double var;
			String utStreng = ("Hva vil du oppdatere? \n" +
					"1 - Sett ny eier\n" +
					"2 - Ta ut penger." + 
					"3 - Sette inn penger.\n"
					);
			input = JOptionPane.showInputDialog(utStreng);
			
			if (input.equals("1")){
				input = JOptionPane.showInputDialog("Skriv inn ny eier.");
				kontoeier = input;
			}
			else if(input.equals("2")){
				input = JOptionPane.showInputDialog("Skriv inn det du vil ta ut..");
				var = Double.parseDouble(input);
				saldo = saldo - var;
			}	
			else if(input.equals("3")){
				input = JOptionPane.showInputDialog("Skriv inn det du vil sette inn.");
				var = Double.parseDouble(input);
				saldo = saldo + var;
			}
		}	
		else {
			System.out.print("Det fins ingen konto, du må opprette en.  \n");
		}
	}
	public void utskriftKdata(){
		System.out.print(
				" Kontonr: " + kontonr  +
				" Kontonr: " + kontoeier +
				" Saldo: " + saldo + "\n"
				);
	}
}






	