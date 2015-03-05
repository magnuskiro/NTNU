package Models;

import java.util.ArrayList;

public class Chapter {


    private final String id;
    private final String title;
    private Chapter superChapter;
    private ArrayList<Paragraph> paragraphs = new ArrayList<Paragraph>();
    private ArrayList<Chapter> subChapters = new ArrayList<Chapter>();

    public Chapter(String id, String title) {
        this.id = id.replace(".htm", "");
        this.title = title;
    }

    public Chapter getSuperChapter() {
        return superChapter;
    }

    public void setSuperChapter(Chapter superChapter) {
        this.superChapter = superChapter;
    }

    public ArrayList<Chapter> getSubChapters() {
        return subChapters;
    }

    public void setSubChapters(ArrayList<Chapter> subChapters) {
        this.subChapters = subChapters;
    }

    public void addSubChapter(Chapter chapter){
        this.subChapters.add(chapter);
    }

    public void setParagraphs(ArrayList<Paragraph> paragraphs) {
        this.paragraphs = paragraphs;
    }

    public String getId() {
        return id;
    }

    public ArrayList<Paragraph> getParagraphs() {
        return paragraphs;
    }

    public void addParagraph(Paragraph paragraph) {
        this.paragraphs.add(paragraph);
    }

    public String getTitle() {
        return title;
    }

    public void display(String spacing){
        System.out.println(spacing + this.id);
        for (Chapter chapter: this.getSubChapters()){
            chapter.display(spacing + "-");
        }
    }

    public String getAllParagraphs(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Paragraph p: this.paragraphs){
            stringBuilder.append(p.getContent());
        }
        return stringBuilder.toString();
    }

}
