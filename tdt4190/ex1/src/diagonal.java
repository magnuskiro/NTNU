
class Scorefin {
	
	public static void main(String[] args) {
		int ma[][] = new int[8][8];
		
		ma[1][1] = 1;
		ma[4][3] = 1;
		ma[4][4] = 1;
		ma[4][5] = 1;
		ma[4][6] = 1;
		ma[1][0] = 1;
		ma[2][0] = 1;
		ma[3][0] = 1;
		ma[4][0] = 1;
		ma[4][1] = 1;
		ma[3][2] = 1;
		ma[2][3] = 1;
		ma[1][4] = 1;
		
		for (int i=0; i<ma.length; i++) {
			for (int j=0; j<ma.length; j++){
				System.out.print(ma[i][j]+" ");
			}
			System.out.println();
		}
		checkrow(ma);
		checkcol(ma);
		diag(ma);
	}
	
	public static void checkrow(int ma[][]) {
		int count = 0;
		for (int i=0; i<ma.length; i++) {
			for (int j=0; j<ma.length; j++){
				if (ma[i][j] == 1) {
					count++;
				} else {
					count = 0;
				}
				if (count == 4)
					System.out.println("YAY!");
			}
			System.out.println();
		}
	}
	
	public static void checkcol(int ma[][]) {
		int count = 0;
		for (int i=0; i<ma.length; i++) {
			for (int j=0; j<ma.length; j++){
				if (ma[j][i] == 1) {
					count++;
				} else {
					count = 0;
				}
				if (count == 4)
					System.out.println("YAY!");
			}
			System.out.println();
		}
	}
	
	public static void diag(int ma[][]) {
		int i = 0;
		int count = 0;
		for(i=0; i<ma.length-3; i++){
			for(int j=0; j<ma.length-3; j++) {
				for(int k=0; k<4; k++) {
					if (ma[i+k][j+k] == 1) {
						count++;
					} else {
						count = 0;
					}
					if (count==4)
						System.out.println("DIAG1");
				}
			}
		}
		
		count = 0;
		for(i=0; i<ma.length-3; i++){
			for(int j=ma.length-3; j>3; j--) {
				for(int k=0; k<4; k++) {
					if (ma[i+k][j-k] == 1) {
						count++;
					} else {
						count = 0;
					}
					if (count==4)
						System.out.println("DIAG2");
				}
			}
		}
	}
}
