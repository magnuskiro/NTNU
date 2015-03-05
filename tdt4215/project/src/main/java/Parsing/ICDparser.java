package Parsing;

import Models.ICD;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;
import com.hp.hpl.jena.vocabulary.RDFS;

import java.util.ArrayList;
import java.util.List;

import static Parsing.Utils.loadModel;

/**
 * ICD parsing
 * Reads the icd10no.owl file and creates classes.
 */

public class ICDparser {
    //public static final String SOURCE_URL = "http://www.semanticweb.org/ontologies/2013/3/Ontology1365003423152.owl";
    private static final String SOURCE_URL = "http://research.idi.ntnu.no/hilab/ehr/ontologies/icd10no.owl#";

    // file path.
    private static final String SOURCE_FILE = "./icd10no.owl";

    // the namespace of the ontology
    private static final String NS = SOURCE_URL + "#";

    // the 'compact code' of the ICD class.
    private static Property code_compacted = ResourceFactory.createProperty(SOURCE_URL + "code_compacted");
    // the synonym attribute of the ICD class.
    private static Property synonym = ResourceFactory.createProperty(SOURCE_URL + "synonym");

    /**
     * Parses the ICD-10 owl file and returns a list of ICD-10 objects.
     * Makes use of the Jena library to read the owl file and to extract attributes.
     * @return a list of all ICD-10 objects.
     */
    public ArrayList<ICD> getICDs() {
        System.out.println("ICD parsing");
        ArrayList<ICD> icds = new ArrayList<ICD>();

        // Create the model object.
        OntModel ontologyModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
        // load the data from file into the model.
        loadModel( ontologyModel, SOURCE_FILE, SOURCE_URL, NS );

        // list of ICD classes from the OWL file.
        ExtendedIterator<OntClass> ontClassExtendedIterator = ontologyModel.listClasses();
        List<OntClass> ontClasses = ontClassExtendedIterator.toList();

        // for all ICD classes.
        for (OntClass ontClass: ontClasses){
            //System.out.println("-------------------NEW---------------------");
            //System.out.println(ontClass.getLocalName());

            // get id of the ICD class.
            String id;
            Statement codeStatement = ontClass.getProperty(code_compacted);
            // if the attribute is not null
            if( codeStatement != null){
                id = codeStatement.getString();
            }
            // else use the local name of the object, which in all observed cases are equal to the code.
            else{
                id = ontClass.getLocalName();
            }

            // the label statement.
            String label;
            Statement labelStatement = ontClass.getProperty(RDFS.label);
            // see if the label actually exists, preventing null pointers and such.
            if (labelStatement != null){
                label = labelStatement.getString();
            } else {
                label = null;
            }

            // create the new ICD object.
            ICD icd = new ICD(id, label);
            // add it to icds.
            icds.add( icd );

            // TODO get multiple synonyms. Atm we only get one.
            // Statements to get object attributes.
            Statement synonymStatement = ontClass.getProperty(synonym);
            // if there are synonyms add them.
            if (synonymStatement != null){
                icd.addSynonym(synonymStatement.getString());
            }

        }

        // find and set parents.
        for (OntClass child: ontClasses){
            OntClass parent = child.getSuperClass();

            // if parent and child is the same object.
            if(parent == child) continue;
            // of child has no parent.
            if(child.getSuperClass() == null) continue;

            // get id of the ICD class.
            String parentId;
            Statement parentStatement = child.getSuperClass().getProperty(code_compacted);
            if( parentStatement != null){
                parentId = parentStatement.getString();
            } else{
                parentId = child.getSuperClass().getLocalName();
            }

            // if there is a parent (if the id of the parent exists.)
            if( parentId != null ){
                // get the parent if it has been created.
                ICD parentICD = getIcdIfItExists(parentId, icds);
                // if the parent exists.
                if(parentICD != null){

                    // get the child ICD object instance
                    String childId;
                    Statement childStatement = child.getProperty(code_compacted);
                    if( childStatement != null){
                        childId = childStatement.getString();
                    } else{
                        childId = child.getLocalName();
                    }
                    // get ICD instance.
                    ICD childICD = getIcdIfItExists(childId, icds);

                    // register the child in the parent
                    parentICD.addChild(childICD);
                    //set the parent in the child
                    childICD.setParent(parentICD);
                }
            }
        }

        return icds;
    }

    /**
     * get the parent of the current ICD, if the parent is already created. (has an object)
     * @param id, the id of the parent.
     * @return
     */
    private ICD getIcdIfItExists(String id, ArrayList<ICD> icds){
        for(ICD icd: icds){
            if (icd.getId().equals(id)) return icd;
        }
        return null;
    }


}
