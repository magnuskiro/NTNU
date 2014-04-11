package Parsing;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.util.FileManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Utils {

    /**
     * List all files files in a folder, add string to arrayList, return it.
     * @param folderName
     * @return a list of all files in a folder.
     */
    public static ArrayList<String> getFilesInFolder(String folderName) {
        File folder = new File(folderName);
        ArrayList<String> paths = new ArrayList<String>();
        for (File fileEntry : folder.listFiles()) {

            // filter out the files ans folders we don't want.
            if (!fileEntry.isDirectory()
                    && !fileEntry.getPath().contains("innhold.htm")
                    ){
                //System.out.println(fileEntry.getPath());
                paths.add(fileEntry.getPath());
            }
        }
        // IMPORTANT
        // soring and reverse to create superchapters before subchapters.
        Collections.sort(paths);
        Collections.reverse(paths);
        return paths;
    }

    /**
     * Reads a file and returns the content. The content should be parsed to a more useful format in the calling function.
     * @param filename, the name of the file that is to be read.
     * @return ArrayList<String>, a list of all lines in the current file.
     * @throws java.io.IOException
     */
    public static ArrayList<String> getLinesFromFile(String filename) throws IOException {
        ArrayList<String> lines = new ArrayList<String>();

        BufferedReader br = new BufferedReader(new FileReader(filename));
        try {
            String line = br.readLine();
            while (line != null) {

                lines.add(line);

                // read new line.
                line = br.readLine();
            }
        }
        finally {
            br.close();
        }

        return lines;
    }

    /**
     * Loads the OWL file into the model so we can retrieve the describes calsses.
     * @param m, the Ontology Model object.
     */
    public static OntModel loadModel( OntModel m, String SOURCE_FILE, String SOURCE_URL, String NS ) {
        FileManager.get().getLocationMapper().addAltEntry( SOURCE_URL, SOURCE_FILE );
        Model baseOntology = FileManager.get().loadModel( SOURCE_URL );
        m.addSubModel( baseOntology );

        // for compactness, add a prefix declaration st: (for Sam Thomas)
        m.setNsPrefix( "st", NS );

        return m;
    }

}
