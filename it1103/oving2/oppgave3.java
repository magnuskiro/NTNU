class oppgave3
	{ 
		public static void main(String[] args) 
		{
			
		//Variabeldeklarasjon: type - navn - verdi. 
			//String		inputTall1 		= 	JOptionPane.showInputDialog("Skriv inn et tall.");
			//int			tall1			= 	0;					
			int			gange			= 	0;	
			int			count			= 	0;
			int			multi			=	1;
			
			//Utførelse av programmet. {
			
			//skriver ut gangtabellen. 
			for (count=1;  count<=10;  count=count+1)  {
				for (gange=1;  gange<=10;  gange=gange+1)  {
			 	  	System.out.print(multi*gange + " ");
			    	}//endfor
				multi++; 
			    	System.out.println( );
			}//endfor

			
			// } slutt på det programmet gjør.  
			
			//Avslutter
			System.exit(0);
			
		}	//end metode main( )
	}	//end of program

	