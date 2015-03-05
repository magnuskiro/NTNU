package Models;

import java.util.ArrayList;
import java.util.HashMap;

public class Case {

    private ArrayList<Sentence> sentences;
    private final String id;
    private HashMap<Integer, Chapter> chapters = new HashMap<Integer, Chapter>();

    public Case(String id){
        this.id = id;
        sentences = new ArrayList<Sentence>();
    }

    public void addChapter(int rank, Chapter chapter){
        this.chapters.put(rank, chapter);
    }

    public Chapter getChapter(int rank){
        return this.chapters.get(rank);
    }

    public void setSentences(ArrayList<Sentence> sentences) {
        this.sentences = sentences;
    }

    public HashMap<Integer, Chapter> getChapters() {
        return chapters;
    }

    public void addSentence(Sentence sentence){
        this.sentences.add(sentence);
    }

    public ArrayList<Sentence> getSentences(){
        return this.sentences;
    }

    public String getId(){
        return this.id;
    }

    public String getAllContent(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Sentence p: this.sentences){
            stringBuilder.append(sentences.toString());
        }
        return stringBuilder.toString();
    }

}
