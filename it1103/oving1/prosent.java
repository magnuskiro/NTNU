import java.io.*;

class prosent {

   public static void main (String[] args) {

      //  prompt the user to enter their name
      System.out.print("Skriv inn pris: ");

      //  open up standard input
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      String inntall = null;

      //  read the username from the command-line; need to use try/catch with the
      //  readLine() method
      try {
         inntall = br.readLine();
      } catch (IOException ioe) {
         System.out.println("IO error trying to read your name!");
         System.exit(1);
      }

      //bearbeider pris før moms.
      double 	tall1 	= 	Double.parseDouble( inntall );
      double	pris = (tall1*1.25);
      double	mva = (tall1*0.25);
      
      System.out.println(
    		  	"Pris uten avgift: " + tall1 +  "kr \n"+
    			"Mva(25%)= " + mva + "kr \n" +
    		  	"Pris inkl. mva: " + pris + "kr \n" 
      	);

      
   }

}  // end prosent
