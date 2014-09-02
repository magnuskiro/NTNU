import javax.swing.JOptionPane;

class Oppgave1 {
	public static void main(String[] args){

	// telle opp de enkelte bokstavene i en string. 
		String input = JOptionPane.showInputDialog("Skriv inn en tekst.");
		String bruk = input.toLowerCase();  
		int[] count = new int[255];
		int[] sa = new int[input.length()+1]; 
		sa[input.length()]=0;
		
		//gjør om string til int array.
		for(int i=0; i<input.length(); i++){
			sa[i] = (int)bruk.charAt(i);
		}
		
		//finner tegn frekvensen. 
		for (int i=0; sa[i]!=0 ; i++){
				for (int j=0; j<=i;j++){
					if (i==j){
							count[sa[i]] ++;
						}
				}//end for
		}//end for
	
		//skriver ut resultatet. 
		System.out.println(bruk);
		 for (int k=0; k<255 ; k++){
			 //skriver ut valgte tegn, endre på grensene for å få utskrift av flere tegn. 
			 if ( k>96 && k<123 || k==230/*æ*/ || k==248/*ø*/ || k==229/*å*/ ){
				if(count[k]!=0){
					char atk = (char)k; 
					System.out.println( atk + ": "+ count[k]);
				}
			}
		}		
		
	}
	
}