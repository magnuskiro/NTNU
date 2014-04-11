import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

    private static boolean quit = false;
    private static String[] input;

    public static void main(String[] args) throws IOException {

        // initialise the class that controls the case files.
        CaseController caseController = new CaseController();
        Parser parser = new Parser();
        caseController.setSearchEngine(parser.index(caseController.getCases()));

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("------------------------ Ready ------------------------");
        quit = false;
        while(! quit){
            // input[0] is the command
            // input[1] is the patient case to present.
            input = bufferedReader.readLine().split(" ");
            try{
                switch (Commands.valueOf(input[0].toUpperCase())) {
                    case QUIT:
                        System.out.println("Quit");
                        quit = true;
                        break;
                    case INDEX:
                        System.out.println("Indexing data");
                        // for simplicity we get a new searchEngine from the parser
                        // when a new searchEngine is set all data is indexed and linked to cases.
                        caseController.setSearchEngine(parser.index(caseController.getCases()));
                        break;
                    case CASE:
                        try{
                            System.out.println("Finding current case: " + input[1]);
                            //System.out.println(input[1]);
                            caseController.displayCase(input[1]);
                        } catch (IndexOutOfBoundsException e){
                            System.out.println("Case file not valid, insert a valid number from 1-8");
                        }
                        break;
                    default:
                        System.out.println("Not a command. Valid: 'quit' 'case x' 'index' ");
                }
            }catch (IllegalArgumentException e){
                System.out.println("Not a command. Valid: 'quit' 'case x' 'index' ");
            }

            System.out.println("------------------------CMD END ------------------------");
        }
    }

    enum Commands {
        QUIT,
        INDEX,
        CASE,
    }

}
