
import javax.swing.JOptionPane;

public class test{
    
        public static void main(String[] lol){
            int[][] mat1 = new int[9][9];

            String innTall, innRad, innKol;
            int tall, y, x;
            
            innRad = JOptionPane.showInputDialog("Skriv inn et tall mellom 0 og 8 for rad");
            y = Integer.parseInt(innRad);
            innKol = JOptionPane.showInputDialog("Skriv inn et tall mellom 0 og 8 for kolonne");
            x= Integer.parseInt(innKol);
            innTall = JOptionPane.showInputDialog("Skriv inn et tall mellom 1 og 9(0 for og avslutte");
            tall = Integer.parseInt(innTall);
            
            
            while(tall > 0 && x >= 0 && x < 9 && y >= 0 && y < 9){
                if(mat1[x][y]==0 && sjekkRad(mat1, x, tall) == true && sjekkKolonne(mat1, y, tall) == true){
                    mat1[x][y]=tall;
                    JOptionPane.showMessageDialog(null,"Plassering lovlig");
                }
                else{
                    JOptionPane.showMessageDialog(null,"Plassering ulovlig");
                }
                innRad = JOptionPane.showInputDialog("Skriv inn et tall mellom 0 og 8 for rad");
                x = Integer.parseInt(innRad);
                innKol = JOptionPane.showInputDialog("Skriv inn et tall mellom 0 og 8 for kolonne");
                y = Integer.parseInt(innKol);
                innTall = JOptionPane.showInputDialog("Skriv inn et tall mellom 1 og 9(0 for og avslutte");
                tall = Integer.parseInt(innTall);
                System.out.println("tall"+tall+"x"+x+"y"+y);
                for(int c=0; c<9; c++){
    				for(int d=0; d<9; d++){
    					System.out.println(mat1[c][d]);
    				}
    				System.out.println();
    			}
            }
        }
        
        
        public static boolean sjekkRad(int[][] mat1, int x, int tall){
            boolean resultat = true;
            
            for(int teller=0; teller<=8; teller++){
                if(mat1[teller][x] == tall){
                    resultat = false;
                    System.out.println("feil rekke"+resultat);
                }
            }
            System.out.println(resultat);
            return resultat;
        }
        
        public static boolean sjekkKolonne(int[][] mat1, int y, int tall){
            boolean resultat = true;
            
            for(int teller=0; teller<=8; teller++){
                if(mat1[y][teller] == tall){
                    resultat = false;
                    System.out.println("feil kolonne"+resultat);
                }
            
}
            System.out.println(resultat);
            return resultat;
}
}

