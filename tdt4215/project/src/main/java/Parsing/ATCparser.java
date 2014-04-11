package Parsing;

import Models.ATC;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.ResourceFactory;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;
import com.hp.hpl.jena.vocabulary.RDFS;

import java.util.ArrayList;
import java.util.List;

import static Parsing.Utils.loadModel;

public class ATCparser {

    //public static final String SOURCE_URL = "http://www.semanticweb.org/ontologies/2013/3/Ontology1365003423152.owl";
    // todo get correct url
    private static final String SOURCE_URL = "";

    // file path.
    private static final String SOURCE_FILE = "./atc.owl";

    // the namespace of the ontology
    private static final String NS = SOURCE_URL + "#";

    // hopefully the about field of the class.
    private static Property about = ResourceFactory.createProperty(SOURCE_URL + "about");

    /**
     * deficiencies: It does not take account of multiple superclasses
     * @return a list of all ATCs in the owl file.
     */
    public ArrayList<ATC> getATCs() {
        System.out.println("ATC parsing");
        ArrayList<ATC> atcs = new ArrayList<ATC>();

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

            // get id of the ATC class.
            String id;
            Statement codeStatement = ontClass.getProperty(about);
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

            // get the 'seeAlso' property if it exists.
            String seeAlso;
            Statement alsoStatement = ontClass.getProperty(RDFS.seeAlso);
            // see if the string actually exists, preventing null pointers and such.
            if (alsoStatement != null){
                seeAlso = alsoStatement.getString();
            } else {
                seeAlso = null;
            }

            // create the new ATC object.
            ATC atc = new ATC(id, label, seeAlso);
            // add it to ATCs.
            atcs.add( atc );

        }

        // find and set parents.
        for (OntClass child: ontClasses){
            OntClass parent = child.getSuperClass();

            // if parent and child is the same object.
            if(parent == child) continue;
            // of child has no parent.
            if(child.getSuperClass() == null) continue;

            // get id of the ATC class.
            String parentId;
            Statement parentStatement = child.getSuperClass().getProperty(about);
            if( parentStatement != null){
                parentId = parentStatement.getString();
            } else{
                parentId = child.getSuperClass().getLocalName();
            }

            // if there is a parent (if the id of the parent exists.)
            if( parentId != null ){
                // get the parent if it has been created.
                ATC parentATC = getAtcIfItExists(parentId, atcs);
                // if the parent exists.
                if(parentATC != null){

                    // get the child ATC object instance
                    String childId;
                    Statement childStatement = child.getProperty(about);
                    if( childStatement != null){
                        childId = childStatement.getString();
                    } else{
                        childId = child.getLocalName();
                    }
                    // get ATC instance.
                    ATC childATC = getAtcIfItExists(childId, atcs);

                    // register the child in the parent
                    parentATC.addChild(childATC);
                    //set the parent in the child
                    childATC.setParent(parentATC);
                }
            }
        }

        return atcs;
    }

    private ATC getAtcIfItExists(String id, ArrayList<ATC> atcs){
        for(ATC atc: atcs){
            if (atc.getId().equals(id)) return atc;
        }
        return null;
    }

}
