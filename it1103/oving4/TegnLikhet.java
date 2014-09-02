
class TegnLikhet {
	boolean resultat; 
	
	boolean Likhet(char char1, char char2){		
		if (char1==char2){
			resultat = true; 
		}
		else{
			resultat = false; 
		}
		return resultat; 
	}
	
	boolean Mindre(char a, char b){
		if(a>b){
			return false;
		}
		else{
			return true; 
		}
			
	}
	
	boolean Storre(char a, char b){
		if(a>b){
			return true;
		}
		else{
			return false; 
		}
	}
}