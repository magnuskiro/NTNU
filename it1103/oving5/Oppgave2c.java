import javax.swing.JOptionPane;

class Oppgave2c {
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
		tall = Integer.parseInt(inputT);
		
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
		else if (tall==0) {
			System.out.println("Du har avslutte programmet.");
		}
		else {
			String inputR = JOptionPane.showInputDialog("Skrit inn en rekke(bortover) mellom 1 og 9. 0 for å avslutte.");
			String inputK = JOptionPane.showInputDialog("Skriv inn en kolonne(nedover) mellom 1 og 9.0 for å avslutte.");
			rekke = Integer.parseInt(inputR);
			kolonne = Integer.parseInt(inputK);
			
			//sjekker om inputen er lovlig. tall 1-9
			if(tall>=1 && tall<=9 &&rekke>=1 && rekke<=9 &&kolonne>=1 && kolonne<=9){
				System.out.println("tall="+tall+" rekke="+rekke+" kolonne="+kolonne);
				lovliginput=true;
			}
			else{
				System.out.println("Ikke gyldeig input!");
			}
			
		//sjekker om tallet kan plasseres i rekke og kolonne. 
			//oppgave 2a
			if(lovliginput){
				if(sudoku[rekke][kolonne]==0){
					lovligplassering=true; 
				}
				else {
					lovligplassering=false;
				}
			}
			
			//oppgave 2b
			if(lovliginput && lovligplassering){
				//rekker
				int sumr=0;
				for (int i=1; i<10; i++ ){
					sumr += sudoku[i][rekke]; 
					if(sudoku[i][rekke]==tall){
						lovligplassering=false;
					}
					if ((tall+sumr)>45){
						lovligplassering=false; 
					}
				}
				//kolonner
				int sumk=0;
				for (int j=1; j<10 ; j++ ){
					sumk += sudoku[kolonne][j]; 
					if(sudoku[kolonne][j]==tall){
						lovligplassering=false;
					}
					if ((sumk+tall)>45){
						lovligplassering=false; 
					}
				}
			}
			
		//oppgave2c
			if(lovligplassering&&lovliginput){
				int or=0;
				int nr=0;
				int ok=0;
				int nk=0;
				//1,3-1,3 		
				if(1<=rekke && rekke<=3 && kolonne>=1 && kolonne<=3){
					or=1;	nr=3;	ok=1;	nk=3;
				}
				// 1,3-4,6		
				else if(1<=rekke && rekke<=3 && kolonne>=4 && kolonne<=6){
					or=1;	nr=3;	ok=4;	nk=6;
				}
				// 1,3-7,9		
				else if(1<=rekke && rekke<=3 && kolonne>=7 && kolonne<=9){
					or=1;	nr=3;	ok=7;	nk=9;
				}
				// 4,6-1,3		
				else if(4<=rekke && rekke<=6 && kolonne>=1 && kolonne<=3){
					or=4;	nr=6;	ok=1;	nk=3;
				}
				// 4,6-4,6		
				else if(4<=rekke && rekke<=6 && kolonne>=4 && kolonne<=6){
					or=4;	nr=6;	ok=4;	nk=6;
				}			
				// 4,6-7,9		
				else if(4<=rekke && rekke<=6 && kolonne>=7 && kolonne<=7){
					or=4;	nr=6;	ok=7;	nk=9;
				}
				// 7,9-1,3		
				else if(7<=rekke && rekke<=9 && kolonne>=1 && kolonne<=3){
					or=7;	nr=9;	ok=1;	nk=3;
				}
				// 7,9-4,6		
				else if(7<=rekke && rekke<=9 && kolonne>=4 && kolonne<=6){
					or=7;	nr=9;	ok=4;	nk=6;
				}
				// 7,9-7,9		
				else if(7<=rekke && rekke<=9 && kolonne>=7 && kolonne<=9){
					or=7;	nr=9;	ok=7;	nk=9;
				}
				else { System.out.println("else if og andre if setninger suGer balle!"); }
						
				int sumrk=0;
				for(int r=or; r<=nr; r++){
					for (int k=ok; k<=nk; k++){
						sumrk += sudoku[r][k];
						if(sudoku[r][k]==tall){
							lovligplassering=false;
						}
						if((sumrk+tall)>45){
							lovligplassering=false;
						}
					}
				}
			}
		//registreing av verdi. og utskrift. 	
			if(lovligplassering){
				sudoku[rekke][kolonne]=tall;
				System.out.println("Plassering godkjent.");
			}
			else {
				System.out.println("Plassering ikke godkjent.");
			}
		}		
		}while(tall!=0);
	}
}