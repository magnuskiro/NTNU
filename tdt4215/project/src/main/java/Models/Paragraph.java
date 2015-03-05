package Models;

import java.util.ArrayList;

public class Paragraph {

    private final String title;
    private ArrayList<String> content;


    public Paragraph(String title, ArrayList<String> content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void addContent(String paragraph){
        this.content.add(paragraph);
    }

    public ArrayList<String> getContent() {
        return content;
    }
}
