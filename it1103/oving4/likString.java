
class likString{
	
	int Likhet(String aInn, String bInn){ 
		int resultat=3;
		int[] sa = new int[aInn.length()+1];
		int[] sb = new int[bInn.length()+1];
		int sumsa = 0; 
		int sumsb = 0; 
		boolean lik=true; 
		boolean go;
		sa[aInn.length()]=0;
		sb[bInn.length()]=0;
		
		//gjør om string a til int array og regner ut summen av int verdiene til det nye arrayet.
		for(int i=0; i<aInn.length(); i++){
			sa[i] = (int)aInn.charAt(i);
			sumsa += sa[i];
		}
		//gjør om string b til int array og regner ut int summen av arrayet. 
		for(int i=0; i<bInn.length(); i++){
			sb[i] = (int)bInn.charAt(i);
			sumsb += sb[i];
		}
		
//oppgave 2a
		//sjekker om de er like.
		if( aInn.length()==bInn.length() ) {
			int i=0;
			go = sa[i]!=0 && sb[i]!=0;
			for(i=0; go; i++) {
				if(!(sb[i]==sa[i]) ){
					lik=false;	
				}
				go = sa[i]!=0 && sb[i]!=0;
			}
		}
		else {
			lik=false; 
		}

//oppgave 2b
		//sjekk om større eller mindre
		if(lik){
			resultat = 0;
		}
		else if(sumsa>sumsb){
			resultat=1;  
		}
		else if(sumsa<sumsb){
			resultat=-1; 
		}

		return resultat;
	}//end-Likhet
	
//oppgave 2c	
	boolean delav(String aInn, String bInn){   
		int[] sa = new int[aInn.length()+1];
		int[] sb = new int[bInn.length()+1];
		int sumsa = 0; 
		int sumsb = 0; 
		int start = 0; 
		boolean stringChk = true;
		boolean delav = false; 
		sa[aInn.length()]=0;
		sb[bInn.length()]=0;
		
		//gjør om string a til int array og regner ut summen av int verdiene til det nye arrayet.
		for(int i=0; i<aInn.length(); i++){
			sa[i] = (int)aInn.charAt(i);
			sumsa += sa[i];
		}
		//gjør om string b til int array og regner ut int summen av arrayet. 
		for(int i=0; i<bInn.length(); i++){
			sb[i] = (int)bInn.charAt(i);
			sumsb += sb[i];
		}
		
		//for alle bokstaver i string A 
		for (int i=0; stringChk && i<aInn.length(); i++){
			//sjekk om bokstav i av array A= bokstav 0 i array B
			if (sa[i]==sb[0]){
				int k=i; //teller for array a i forløkka under. 
				//for alle bokstaver i array B = alle bokstaver etterhverandre i array A
				for(int j=0; stringChk; j++){
					//om array verdien i array B=0 (siste feltet) da er string B en del av string A
					if(sb[j]==0){
						delav = true;
						stringChk = false; 
						start = i+1;
					}//end-if
					else if (sb[j]==sa[k]){
						stringChk = true;
					}//end-elseif
				}//end-for
			}//end-if
		}//end-for
		if (delav && start>0){
			System.out.println("Streng B starter på " + start + " bokstav i string A.");
		}
		
		//utskrift 		  	
		return delav;
	}
}