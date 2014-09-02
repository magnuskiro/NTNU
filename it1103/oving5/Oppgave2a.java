import javax.swing.JOptionPane;

class Oppgave2a {
	public static void main(String[] args){

		int[][] sudoku = new int[10][10];
		int rekke=-1; 
		int kolonne=-1;
		int tall=-1; 
		boolean lovliginput=false;
		
//input start
		do {
		String inputT = JOptionPane.showInputDialog("Skriv inn et tall mellom 1 og 9. 0 for å avslutte.");

	// skriver ut sudokubrettet. 
		if(inputT.equals("brett")){
			for(int c=1; c<10; c++){
				for(int d=1; d<10; d++){
					System.out.print(sudoku[c][d]+" ");
					if (d % 3 == 0) {
	                    System.out.print(" ");
	                }
				}
				if(c % 3 == 0) {
	                System.out.print("\n");
	            }
	            System.out.print("\n");
			}
		}
		else {
			String inputR = JOptionPane.showInputDialog("Skrit inn en rekke(bortover) mellom 1 og 9. 0 for å avslutte.");
			String inputK = JOptionPane.showInputDialog("Skriv inn en kolonne(nedover) mellom 1 og 9.0 for å avslutte.");
			
			tall = Integer.parseInt(inputT);
			rekke = Integer.parseInt(inputR);
			kolonne = Integer.parseInt(inputK);
			
			
			//sjekker om inputen er lovlig. tall 1-9
	
			if(tall>=1 && tall<=9 &&rekke>=1 && rekke<=9 &&kolonne>=1 && kolonne<=9){
				System.out.println("Lovlig input.");
				lovliginput=true;
			}
			else if (tall==0 || rekke==0 || kolonne==0) {
				System.out.println("Du har avslutte programmet.");
			}
			else{
				System.out.println("Ikke gyldeig input!");
			}
			
		//sjekker om tallet kan plasseres i rekke og kolonne. 
			//oppgave 2a
			if(lovliginput){
				if(sudoku[rekke][kolonne]==0){
					System.out.println("plassering ok, oppgave2a utført.");
					sudoku[rekke][kolonne]=tall;
				}
				else {
					System.out.println("Plassering ikke godkjent.");
				}
			}
		}		
		}while(tall!=0);
	}
}