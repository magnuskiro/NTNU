package Models;

import java.util.HashMap;

public class Sentence {

    private final int id;
    private final String sentence;
    private HashMap<Integer, ATC> atcs = new HashMap<Integer, ATC>();
    private HashMap<Integer, ICD> icds = new HashMap<Integer, ICD>();
    private HashMap<Integer, Chapter> therapy = new HashMap<Integer, Chapter>();
    private HashMap<Integer, Chapter> general = new HashMap<Integer, Chapter>();
    private HashMap<Integer, Chapter> drugs = new HashMap<Integer, Chapter>();

    public void dispaly(String spacingPrefix) {
        System.out.println(spacingPrefix + this.getId() + ": " + this.getSentence());

        System.out.print(spacingPrefix+"\tICDs: ");
        for(int i = 0; i<this.getIcds().size(); i++){
            System.out.print(this.getICD(i).getId() + ", ");
        }
        System.out.println();

        System.out.print(spacingPrefix+"\tATCs: ");
        for(int i = 0; i<this.getAtcs().size(); i++){
            System.out.print(this.getAtc(i).getId() + ", ");
        }
        System.out.println();

        System.out.print(spacingPrefix+"\tG: ");
        for(int i = 0; i<general.size(); i++){
            System.out.print(this.getGeneral(i).getId() + ", ");
        }
        System.out.println();

        System.out.print(spacingPrefix+"\tL: ");
        for(int i = 0; i<drugs.size(); i++){
            System.out.print(this.getDrug(i).getId() + ", ");
        }
        System.out.println();

        System.out.print(spacingPrefix+"\tT: ");
        for(int i = 0; i<therapy.size(); i++){
            System.out.print(this.getTherapy(i).getId() + ", ");
        }
        System.out.println();

    }

    public Chapter getGeneral(int rank){
        return this.general.get(rank);
    }

    public Chapter getDrug(int rank){
        return this.drugs.get(rank);
    }

    public Chapter getTherapy(int rank){
        return this.therapy.get(rank);
    }

    public Sentence(String sentence, int id) {
        this.sentence = sentence;
        this.id = id;
    }

    public void addAtc(int rank, ATC atc){
        this.atcs.put(rank, atc);
    }

    public ATC getAtc(int rank){
        return this.atcs.get(rank);
    }

    public HashMap<Integer, ATC> getAtcs() {
        return atcs;
    }

    public void setAtcs(HashMap<Integer, ATC> atcs) {
        this.atcs = atcs;
    }

    public int getId() {
        return id;
    }

    public String getSentence(){
        return this.sentence;
    }

    @Override
    public String toString() {
        return this.getSentence();
    }



    public void addIcd(int i, ICD icd) {
        this.icds.put(i, icd);
    }

    public HashMap<Integer, ICD> getIcds() {
        return icds;
    }

    public void setIcds(HashMap<Integer, ICD> icds) {
        this.icds = icds;
    }

    public ICD getICD(int rank){
        return this.icds.get(rank);
    }

    public void addGeneral(int i, Chapter chapter) {
        this.general.put(i, chapter);
    }

    public void addDrug(int i, Chapter chapter) {
        this.drugs.put(i,chapter);
    }

    public void addTherapy(int i, Chapter chapter) {
        this.therapy.put(i, chapter);
    }
}
