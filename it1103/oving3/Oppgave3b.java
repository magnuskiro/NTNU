import javax.swing.JOptionPane;

class Oppgave3b {
	public static void main(String[] args){
		String input;
		String utStreng;
		String utStreng2;
		String utStreng3;
		String kontoeier;
		double kontonr;
		double kontosaldo;
		Konto k1= new Konto(4299231, "Nils Pedersen", 24567);
		Konto k2= new Konto(4299232, "Kari By", 10000);
		Konto k3= new Konto(4299233, "Hans Martinsen", 120000);
		Konto k4= new Konto(4299234, "Siri Tokvam", 14289);
		int kontovelger = 0; 
		int switchinput;
		
		do {
			utStreng = ("Hva vil du gjøre? \n" +
					"1 - Opprette en konto. \n" +
					"2 - oppdatere en konto \n" +
					"3 - få en utskrift av kontodataene?"
					);
					switchinput = Integer.parseInt(JOptionPane.showInputDialog(utStreng));
			switch (switchinput) {
				case 1:{
					input = JOptionPane.showInputDialog("Skriv inn navnet på eieren av kontoen.");
					kontoeier = input;
					input = JOptionPane.showInputDialog("Skriv inn konto nr.");
					kontonr = Double.parseDouble(input);
					input = JOptionPane.showInputDialog("skriv inn saldo.");
					kontosaldo = Double.parseDouble(input);
					k1.oppretteKonto(kontonr, kontoeier, kontosaldo);
				} 	break;
				case 2: {
					utStreng2 = ("Hva vil du gjøre? \n" +
							"1 - Oppdatere Konto 1. \n" +
							"2 - Oppdatere Konto 2. \n" +
							"3 - Oppdatere Konto 3. \n" +
							"4 - Oppdatere Konto 4. \n" 
							);
					kontovelger = Integer.parseInt(JOptionPane.showInputDialog(utStreng2));
					switch (kontovelger) {
				    case 1:  k1.oppdatereK(); break;
				    case 2:  k2.oppdatereK(); break;
				    case 3:  k3.oppdatereK(); break;
				    case 4:  k4.oppdatereK(); break;
					}
				}	break;
				case 3:	 {
					utStreng3 = ("Hva vil du gjøre? \n" +
							"1 - Vis data for Konto 1. \n" +
							"2 - Vis data for Konto 2. \n" +
							"3 - Vis data for Konto 3. \n" +
							"4 - Vis data for Konto 4. \n" +
							"5 - Vis data for alle Kontoene. \n" 
							);
					kontovelger = Integer.parseInt(JOptionPane.showInputDialog(utStreng3));
					switch (kontovelger) {
				    case 1:  k1.utskriftKdata(); break;
				    case 2:  k2.utskriftKdata(); break;
				    case 3:  k3.utskriftKdata(); break;
				    case 4:  k4.utskriftKdata(); break;
				    case 5:	 k1.utskriftKdata(); k2.utskriftKdata(); k3.utskriftKdata(); k4.utskriftKdata(); break;
					}
				}	break;
				default: System.out.println("Invalid valg.");break;
			}
		}while (switchinput!=0);
	}
}


class Konto {
	//variabler/konto info:
		private String	kontoeier = "";
		private double 	kontonr = 0; 
		private double 	saldo = 0;
		
	public Konto(double inputkontonr, String inputkontoeier,  double inputkontosaldo){
		kontoeier = inputkontoeier;
		kontonr = inputkontonr;
		saldo = inputkontosaldo; 
	}
	void oppretteKonto (double inputkontonr, String inputkontoeier,  double inputkontosaldo){
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
					"2 - Ta ut penger.\n" + 
					"3 - Sette inn penger.\n"
					);
			input = JOptionPane.showInputDialog(utStreng);
			
			if (input.equals("1")){
				input = JOptionPane.showInputDialog("Skriv inn ny eier.");
				kontoeier = input;
			}
			else if(input.equals("2")){
				input = JOptionPane.showInputDialog("Skriv inn det du vil ta ut.");
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