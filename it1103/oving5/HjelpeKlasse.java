class HjelpeKlasse{
	int finnPris(int innrad, int innsete){
		int pris=0; 
		int rad=innrad-1;
		int sete=innsete-1; 
		if(0<=rad && rad<=2){
			if(0<=sete && sete<=3){
				pris=200;
			}
			else if(4<=sete && sete<=10){
				pris=400;
			}
			else if(11<=sete && sete<=14){
				pris=200;
			}
		}
		else if(3<=rad && rad<=6){
			if(0<=sete && sete<=3){
				pris=300;
			}
			else if(4<=sete && sete<=10){
				pris=500;
			}
			else if(11<=sete && sete<=14){
				pris=300;
			}
		}
		else if(7<=rad && rad<=10){
			if(0<=sete && sete<=3){
				pris=100;
			}
			else if(4<=sete && sete<=10){
				pris=300;
			}
			else if(11<=sete && sete<=14){
				pris=100;
			}
		}
		else { System.out.println("Finner ikke prisen på denne plassen."); }
		return pris; 
	}
}