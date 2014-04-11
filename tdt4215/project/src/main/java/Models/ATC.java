package Models;

import java.util.ArrayList;

public class ATC {

    private ATC parent;
    private ArrayList<ATC> children = new ArrayList<ATC>();
    private final String id;
    private String label;
    private String seeAlso;

    public ATC(String id, String label, String seeAlso) {
        this.label = label;
        this.id = id;
        this.seeAlso = seeAlso;
    }

    public String getSeeAlso() {
        return seeAlso;
    }

    public void setSeeAlso(String seeAlso) {
        this.seeAlso = seeAlso;
    }

    public String getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ATC getParent() {
        return parent;
    }

    public void setParent(ATC parent) {
        this.parent = parent;
    }

    public void addChild(ATC atc) {
        this.children.add(atc);
    }

    public ArrayList<ATC> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<ATC> children) {
        this.children = children;
    }
}
