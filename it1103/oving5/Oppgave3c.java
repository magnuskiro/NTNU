import javax.swing.JOptionPane;
class Oppagve3c {
	public static void main(String[] args){ 
		String inputrad, inputsete;
		int sete, rad, regplass=0, inntekt=0;
		int[][] plass = new int[16][11];
		boolean kjor=true; 
		HjelpeKlasse pris = new HjelpeKlasse();
		
		do {
			inputrad  = JOptionPane.showInputDialog("Skriv inn hvilken rad du vil sitte på(1-10). 0 avslutter");
			inputsete  = JOptionPane.showInputDialog("Skriv inn hvilket sete du vil sitte på(1-15). 0 avslutter");
			sete = Integer.parseInt(inputsete);
			rad = Integer.parseInt(inputrad);
			
			System.out.println("sete: "+sete+" rad: "+rad);
			
			if(rad!=0 && sete!=0 && 1<=sete && sete<=15 && 1<=rad && rad<=10){
				if(plass[sete][rad]==0){
					plass[sete][rad]=1;
					regplass++;
					inntekt += pris.finnPris(rad, sete);
					System.out.println("Plassen er registrert. Og den koster: " + pris.finnPris(rad, sete));
				}
				else {
					System.out.println("Plassen er opptatt.");
				}
			}
			else if(sete==0 || rad ==0){
				kjor=false;
			}
			else{
				System.out.println("Input ikke gyldig");
			}
		}while(kjor);
		
		System.out.println("end input");
		for(int i=1; i<11; i++){
			for(int j=1; j<16; j++){
				System.out.print(plass[j][i]+" ");
			}
            System.out.print("\n");
		}
		
		System.out.println(
				"Antall solgte billetter er: " + regplass + "\n" + 
				"Billett inntekten er: " + inntekt
				);
	}
}
