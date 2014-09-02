import javax.swing.JOptionPane;

class Oppgave2b {
	public static void main(String[] args){

		int[][] sudoku = new int[10][10];
		int rekke=-1; 
		int kolonne=-1;
		int tall=-1;
		boolean lovliginput=false;
		boolean lovligplassering=false; 
		
//input start
		do {
		String inputT = JOptionPane.showInputDialog("Skriv inn et tall mellom 1 og 9. 0 for å avslutte.");

	//skriver ut sudokubrettet. 
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
				System.out.println("Lovlig input."+"tall="+tall+" rekke="+rekke+" kolonne="+kolonne);
				lovliginput=true;
			}
			else if (tall==0 || rekke==0 || kolonne==0) {
				System.out.println("Du har avslutte programmet.");
			}
			else{
				System.out.println("Ikke gyldeig input!");
			}
			 
			//oppgave 2a
			if(lovliginput){
				if(sudoku[rekke][kolonne]==0){
					System.out.println("2a utført, felt=0 ");
					lovligplassering=true; 
				}
				else {
					System.out.println("Plassering ikke godkjent.");
					lovligplassering=false;
				}
			}
			
			//oppgave 2b
			if(lovliginput && lovligplassering){
				int sumr=0;
				int sumk=0;
				//rekker
				for (int i=1; i<10; i++ ){
					sumr += sudoku[i][rekke]; 
					if(sudoku[i][rekke]==tall){
						lovligplassering=false;
						System.out.println("rekke feil");
					}
					if ((tall+sumr)>45){
						lovligplassering=false; 
					}
				}
				//kolonner
				for (int j=1; j<10 ; j++ ){
					sumk += sudoku[kolonne][j]; 
					if(sudoku[kolonne][j]==tall){
						lovligplassering=false;
						System.out.println("kolonne feil");
					}
					if ((sumk+tall)>45){
						lovligplassering=false; 
					}
				}
				
				if(lovligplassering){
					System.out.println("Rekker og Kolonner godkjent");
				}
			}

			if(lovligplassering){
				sudoku[rekke][kolonne]=tall;
				System.out.println("Godkjent plassering, verdien er satt.");
			}
			else {
				System.out.println("Plassering ikke godkjent..");
			}
		}		
		}while(tall!=0);
	}
}