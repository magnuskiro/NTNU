
//inkluderte hjelpeprogrammer
import 	javax.swing.JOptionPane;  

class oppgave2b 
	{ 
		public static void main(String[] args) 
		{
			
		//Variabeldeklarasjon: type - navn - verdi. 
			String 		utStreng		= 	""; 
			String		inputTall1 		= 	JOptionPane.showInputDialog("skriv inn ett tall.");
			String		inputTall2		= 	JOptionPane.showInputDialog("skriv inn ett tall.");
			int	 		tall1			= 	Integer.parseInt( inputTall1 );
			int 		tall2			= 	Integer.parseInt( inputTall2 );	
			int			inntall			= 	tall1;
			int			sumpartall		= 	0;					
			int			sumoddetall		=	0;
			int			stigning		=	0; 
			
			//Utførelse av programmet. {  
				
				//sjekker om tall1 er større enn tall2 og setter stigning sånn at inntall nærmer seg tall2.  
				if (tall1>tall2) { stigning = -1; }
				else {stigning = 1; }
				
				//sjekker om det er negative tall. Hvis vi har negative tall hopper programmet over while løkken og går rett til slutten av programmet. 
				if ((tall1>0)&&(tall2>0)){ 
					//skiller partall og oddetall go summerer de forskjellige. 
						while (inntall!=tall2){
							//sjekke om inntall er oddtall eller partall. og oppdaterer summen av de forskjellige.   
							if ((inntall%2)== 0){ //sjekker om det er partalle eller ikke. (partall er delelig med 2, det er ikke oddetall).
								sumpartall = sumpartall + inntall ;	//oppdaterer summen av partall.  
								System.out.println(	"Summen av partallene er så langt: " + sumpartall + "\n"); 
								}//end if.
							else {				 
								sumoddetall = sumoddetall + inntall ;//oppdaterer summen av oddetall. 
								System.out.println("Summen av oddetallene er så langt: " + sumoddetall + "\n"); 
								}//end else. 
							//teller opp inntall, sånn at løkken går videre. 
							inntall = inntall + stigning; 
							System.out.println("inntall=" + inntall);
						}//end while.
						//Retter opp for at loopen over ikke tar med verdien for inntall==tall2. 
						if ((tall2%2)==0){
							sumpartall = sumpartall + tall2 ;  //oppdaterer summen av partall. 
							}//end if.
						else {				 
							sumoddetall = sumoddetall + tall2 ;//oppdaterer summen av oddetall. 
							}//end else.
						//stter det som skal skrives ut til skjermen. 						
						utStreng = ("Summen av oddetallene er: " + sumoddetall + " og summen av partallene er " + sumpartall);
				}//end if. 	
				else { //hvis man har negative tall hopper programmet hit. 
					utStreng = ("Du skrev inn et negativt tall.")
					;}//end else. 
				
				//Her blir teksten vis på skjermen. 
				System.out.println(
						"Du skrev inn tallene: " + tall1 + " og " + tall2 + "\n" +
						utStreng + "\nProgrammet er Ferdig."
						);//end println.
	      		
			// } slutt på det programmet gjør.  
			
			//Avslutter
			System.exit(0);
			
		}	//end metode main( )
			
	}	//end of program

	