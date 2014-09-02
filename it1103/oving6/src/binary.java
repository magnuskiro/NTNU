class Binary{	
	public static boolean Search(String[] inputA, String input){
		int mid;
		int min=0;
		int max=45;
		int r;
		for (int i=0; i<7;i++){
			mid = (min+max)/2;
			r = input.compareTo(inputA[mid]);
			if(r>0 ){ 
				min = mid + 1;
			}
			else if(r<0){ 
				max = mid - 1;
			}
			else if(r==0){
				return true; 
			}
		}
		return false; 
	}
}