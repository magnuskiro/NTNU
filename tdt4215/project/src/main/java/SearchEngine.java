import Models.*;
import Searches.ATCsearch;
import Searches.ChapterSearch;
import Searches.FullCaseSearch;
import Searches.ICDsearch;

import java.util.ArrayList;

public class SearchEngine {

    private ArrayList<ICD> icds;
    private ArrayList<ATC> atcs;
    private ArrayList<Chapter> drugs;
    private ArrayList<Chapter> therapy;
    private ArrayList<Chapter> general;

    SearchEngine(ArrayList<Case> cases, ArrayList<ICD> icds, ArrayList<ATC> atcs, ArrayList<Chapter> drugs, ArrayList<Chapter> therapy, ArrayList<Chapter> general){
        this.icds = icds;
        this.atcs = atcs;
        this.drugs = drugs;
        this.therapy = therapy;
        this.general = general;
    }

    /**
     * calling methods to add ranked info to patient cases.
     * @param currentCase
     */
    public void addAttributes(Case currentCase) {
        System.out.println("Indexing and Searching");

        new ICDsearch().index(currentCase, icds, 11000);
        new ATCsearch().index(currentCase, atcs, 8000);
        new ChapterSearch().index(currentCase,general,1000,"general");
        new ChapterSearch().index(currentCase,drugs,1000,"drug");
        new ChapterSearch().index(currentCase,therapy,1000,"therapy");
        ArrayList<Chapter> all = new ArrayList<Chapter>();
        all.addAll(general);
        all.addAll(drugs);
        all.addAll(therapy);
        new FullCaseSearch().index(currentCase, all, 1000);
    }

}
