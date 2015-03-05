import Models.Case;
import Models.Sentence;
import Parsing.CaseParser;

import java.io.IOException;
import java.util.ArrayList;

public class CaseController {

    private CaseParser caseParser;
    private SearchEngine searchEngine;
    private ArrayList<Case> cases;

    CaseController() throws IOException {
        System.out.println("Importing cases....");
        caseParser = new CaseParser();
        cases = caseParser.getPatientCases();
        System.out.println("Initialised "+cases.size()+", ready to display cases");
    }

    /**
     * When a new searchengine is set we repopulate the cases with relevant information.
     * @param searchEngine1
     */
    public void setSearchEngine(SearchEngine searchEngine1){
        this.searchEngine=searchEngine1;
        populateCases();
    }

    /**
     * populate all cases with relevant information in the searchEngine
     */
    public void populateCases(){
        for(Case c: cases){
            searchEngine.addAttributes(c);
        }
    }

    /**
     * displays information about a given case.
     * @param patientCase
     */
    public void displayCase(String patientCase){
        // for all cases we look for the one we want.
        for(Case c: cases){
            // for the case we want output the relevant info.
            if(patientCase.equals(c.getId())){

                System.out.println("case: "+c.getId());

                System.out.print("\tfullCase: ");
                for(int i = 0; i<c.getChapters().size(); i++){
                    System.out.print(c.getChapter(i).getId() + ", ");
                }
                System.out.println();

                // display sentences.
                for (Sentence s: c.getSentences()){
                    s.dispaly("\t");
                }

            }
        }
    }

    public ArrayList<Case> getCases() {
        return cases;
    }
}
