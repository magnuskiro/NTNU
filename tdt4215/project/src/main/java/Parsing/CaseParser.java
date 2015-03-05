package Parsing;

import Models.*;
import java.io.IOException;
import java.util.ArrayList;

import static Parsing.Utils.getLinesFromFile;

public class CaseParser {

    /**
     * @return a list of all patient cases that are to be evaluated.
     * @throws IOException
     */
    public ArrayList<Case> getPatientCases() throws IOException {
        ArrayList<Case> cases = new ArrayList<Case>();

        Case currentCase = null;
        String id;
        int lineNum = 0;

        // for all lines in the patient case file
        for(String line: getLinesFromFile("./patientCases.txt")){

            // if new case.
            if( line.contains("Case")){
                // get the ID from the line containing "Case X"
                id = line.split(" ")[1];
                currentCase = new Case(id);
                cases.add(currentCase);
                lineNum = 0;
            } else{
                // add sentences to case.

                for(String s: line.split("\\. ") ){
                    // TODO fix regex to ignore numbers like "8."
                    if(!s.isEmpty() && !s.equals(" ")){
                        //System.out.println("linenum " + lineNum);
                        currentCase.addSentence(new Sentence(s, lineNum));
                        lineNum++;
                    }
                }
            }

        }

        return cases;
    }


}
