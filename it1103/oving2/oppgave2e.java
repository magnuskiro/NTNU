
//inkluderte hjelpeprogrammer
import 	javax.swing.JOptionPane;  

class oppgave2e
	{ 
		public static void main(String[] args) 
		{
			
		//Variabeldeklarasjon: type - navn - verdi. 
			String		inputTall1;
			String		innpersoner 	= 	JOptionPane.showInputDialog("Skriv inn hvor mange personer du skal skrive inn alderen på.  ");
			String		resultat		= 	"";
			double		personer		=	Double.parseDouble( innpersoner );
			double 		alder;	
			double		a1				=	0;
			double		a2				=	0;
			double		a3				=	0;
			double		a4				=	0;
			double		a5				=	0;
			double		ptot			=	0;
			double		p1;
			double		p2;				
			double		p3;				
			double		p4;				
			double		p5;
			int			count			=	1;

			
			//Utførelse av programmet. {
								
					//while løkke som kjører til du har skrevet inn alle alderene. 
					while(count<=personer) {
						inputTall1 		= 	JOptionPane.showInputDialog("Skriv inn alder på en person. ");
						alder			= 	Double.parseDouble( inputTall1 );	
						// if/elseif som sjekker hvilken aldersgruppe inputalderen hører til og oppdaterer hvor mange personer det er i hver enkelt aldersgruppe. 
						if (alder<19){
							a1=a1+1;
							System.out.println(a1);
						}
						else if (alder>19 && alder<31){
							a2=a2+1;
							System.out.println(a2);
						}
						else if (alder>31 && alder<41){
							a3=a3+1;
							System.out.println(a3);
						}
						else if (alder>41 && alder<61){
							a4=a4+1;
							System.out.println(a4);
						}
						else if (alder>=61){
							a5=a5+1;
							System.out.println(a5);
						}
						count++;
					}//endwhile
				//utregninger, prosenter og summer. 
					ptot = a1+a2+a3+a4+a5; 
					System.out.println(ptot);
					p1 = ((a1/ptot)*100);
					p2 = ((a2/ptot)*100);
					p3 = ((a3/ptot)*100);
					p4 = ((a4/ptot)*100);
					p5 = ((a5/ptot)*100);
				//lage en oversikt over hvor mange personer det er i hver gruppe og totalt.		
				resultat = (
						"Det er " + ptot + " personer totalt." +
						"\nDet er " + a1 + " personer i aldersgruppe 1.(0-18år) " + "Dette tilsvarer " + p1 + " prosent av totalt antall personer." +
						"\nDet er " + a2 + " personer i aldersgruppe 2.(19-30) " + "Dette tilsvarer " + p2 + " prosent av totalt antall personer." +
						"\nDet er " + a3 + " personer i aldersgruppe 3.(31-40) " + "Dette tilsvarer " + p3 + " prosent av totalt antall personer." +
						"\nDet er " + a4 + " personer i aldersgruppe 4.(41-50) " + "Dette tilsvarer " + p4 + " prosent av totalt antall personer." +
						"\nDet er " + a5 + " personer i aldersgruppe 5.(61-->) " + "Dette tilsvarer " + p5 + " prosent av totalt antall personer." 
						);	
			
				//skriver ut utregnede resultater. 
				JOptionPane.showMessageDialog(null,resultat);
				
			// } slutt på det programmet gjør.  
			
			//Avslutter
			System.exit(0);
			
		}	//end metode main( )
	}	//end of program

	