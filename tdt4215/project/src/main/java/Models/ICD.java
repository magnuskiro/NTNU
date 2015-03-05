package Models;

import java.util.ArrayList;

public class ICD {

    private final String id;
    private ICD parent;
    private String label;
    private ArrayList<ICD> children = new ArrayList<ICD>();
    private ArrayList<String> synonyms = new ArrayList<String>();

    public ICD(String id) {
        this.id = id;
    }

    public ICD(String id, String label) {
        this.id = id;
        this.label = label;
    }

    public void addChild(ICD icd){
        this.children.add(icd);
    }

    public ArrayList<ICD> getChildren() {
        return children;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ArrayList<String> getSynonyms() {
        return this.synonyms;
    }

    public void addSynonym(String synonym) {
        this.synonyms.add(synonym);
    }

    public String getId() {
        return id;
    }

    public ICD getParent() {
        return parent;
    }

    public void setParent(ICD parent) {
        this.parent = parent;
    }
}
