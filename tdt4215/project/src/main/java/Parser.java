import Models.*;
import Parsing.ATCparser;
import Parsing.CaseParser;
import Parsing.HTMLparser;
import Parsing.ICDparser;

import java.util.ArrayList;

public class Parser {
    // Data folders
    //g = generelle kapitler (general drugs)
    private final String generalFolder = "./data/G/";

    //l = legemidler ( drug drugs )
    private final String drugsFolder = "./data/L/";

    //t = terapi / ( therapy drugs )
    private final String therapyFolder = "./data/T/";

    private HTMLparser htmLparser = new HTMLparser();
    private ATCparser atcParser= new ATCparser();
    private ICDparser icdParser= new ICDparser();
    private ArrayList<ICD> icds;
    private ArrayList<ATC> atcs;
    private ArrayList<Chapter> drugs;
    private ArrayList<Chapter> therapy;
    private ArrayList<Chapter> general;

    Parser(){}

    public SearchEngine index(ArrayList<Case> cases){
        // get ICDs
        icds =  icdParser.getICDs();
        icdDebug();

        // get ATCs
        atcs = atcParser.getATCs();
        atcDebug();

        // getChapters
        drugs = htmLparser.getChapters(this.drugsFolder);
        therapy = htmLparser.getChapters(this.therapyFolder);
        general = htmLparser.getGeneralChapters(this.generalFolder);
        chapterDebug();

        System.out.println("Data gathering complete");

        // return a new searchEngine with all the data.
        return new SearchEngine(cases, icds, atcs, drugs, therapy, general);
    }

    public void chapterDebug(){
        System.out.println("# Drug size: " + drugs.size());
        System.out.println("# Therapy size: " + therapy.size());
        System.out.println("# General size: " + general.size());

        /*
        // for chapters
        for(Chapter d: drugs){

            if(d.getId().equals("L3.1.htm")){
                System.out.println("name: " + d.getTitle());
                System.out.println("Sub drugs: " + d.getSubChapters().size());
                d.display("");

                if(d.getSubChapters().size()==0){
                    for(Paragraph p: d.getParagraphs()){
                        //System.out.println("--"+p.getContent().size()+"--" + p.getTitle() +": " + p.getContent());
                        for (String s:p.getContent()){
                            System.out.println("#######"+p.getTitle()+"######Content#####\n" + s);
                        }
                    }
                }
                for (Chapter c:d.getSubChapters()){
                    for(Paragraph p: c.getParagraphs()){
                        for (String s:p.getContent()){
                            System.out.println("#######"+p.getTitle()+"######Content#####\n" + s);
                        }
                    }
                }
            }
        }
        */
    }

    public void atcDebug(){
        System.out.println("# ATC Size: " + atcs.size());

        /*
        for (ATC atc: atcs){
            //if (atc.getId().equals("DB00295")){
            if (atc.getId().equals("V10XX02")){
                System.out.println(atc.getLabel());
                System.out.println(atc.getId());
                System.out.println(atc.getSeeAlso());
                System.out.println(atc.getParent().getId());
            }
        }
        */
    }

    public void icdDebug(){
        System.out.println("# ICD Size: " + icds.size());

        /*
        for (ICD icd: icds){
            System.out.println(icd.getId());
            System.out.println(icd.getLabel());
            if(icd.getId().equals("Z993")){
                System.out.println("Synonyms: " + icd.getSynonyms().size());
            }
            if(icd.getSynonyms().size()>1){
                System.out.println("mer enn en!");
            }
            System.out.println(icd.getParent());
            System.out.println(icd.getChildren());
        }
        */
    }


}
