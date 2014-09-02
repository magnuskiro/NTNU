public class Sort{
	public void bubbleSort(String[] A){
		int n=A.length-1;
		boolean swapped = false;
		String temp="";
		do{
			swapped = false;
			for (int i=0; i<n;i++){
				if((A[i].compareTo(A[i+1]))>0){
					temp=A[i+1];
					A[i+1]=A[i];
					A[i]=temp;
					swapped = true;
				}//end if
			}//end for
			n -= 1;
		}while(swapped);
	}
}