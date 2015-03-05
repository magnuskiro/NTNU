package Parsing;

import Models.Chapter;
import Models.Paragraph;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static Parsing.Utils.*;

public class HTMLparser {

    public ArrayList<Chapter> getGeneralChapters(String folder){
        System.out.println("Parsing files in: " + folder);

        ArrayList<Chapter> chapters = new ArrayList<Chapter>();
        ArrayList<String> files = getFilesInFolder(folder);

        String filename = "";
        for (String path: files){
            // split the file path at / to get the individual folders and the file name.
            // the file name is the forth element in the array.
            // example name: "./data/T/filename"
            filename = path.split("/")[3];

            Document doc = null;
            try {
                // the use of something other than UTF-8 is an utter embuggerance
                doc = Jsoup.parse(new File(path), "iso-8859-1");
            } catch (IOException e) {
                e.printStackTrace();
                System.err.print("Could not open HTML file, for  parsing.");
            }


            // get chapter title.
            String title = getHtmlDocTitle(doc, filename);

            Chapter chapter = new Chapter(filename, title);

            addParagraphsFromHtmlElement(chapter, doc.select("#page"));

            chapters.add(chapter);
        }

        return chapters;
    }

    public ArrayList<Chapter> getChapters(String folder){
        System.out.println("Parsing files in: " + folder);

        ArrayList<Chapter> chapters = new ArrayList<Chapter>();
        ArrayList<String> files = getFilesInFolder(folder);

        String filename = "";
        for (String path: files){
            // split the file path at / to get the individual folders and the file name.
            // the file name is the forth element in the array.
            // example name: "./data/T/filename"
            filename = path.split("/")[3];

            // we don't care about the top level chapters, they have no relevant content.
            if (isSuperChapter(filename)) continue;

            Document doc = null;
            try {
                // the use of something other than UTF-8 is an utter embuggerance
                doc = Jsoup.parse(new File(path), "iso-8859-1");
            } catch (IOException e) {
                e.printStackTrace();
                System.err.print("Could not open HTML file, for  parsing.");
            }

            // get chapter title.
            String title = getHtmlDocTitle(doc, filename);

            Chapter chapter = new Chapter(filename, title);

            Elements elements = doc.select("#menu li a");

            if (elements.size()==0) addParagraphsFromHtmlElement(chapter, doc.select("#content").first().select("div .def"));
            for (Element element: elements) {
                if (element.text().matches("[A-Z]([0-9]\\.?)+.*")) {

                    // [0] = chapter name
                    // [1] = element id
                    String[] link = element.attr("href").split("#");

                    // create chapter
                    Chapter subChapter = new Chapter(element.text().split(" ")[0], element.text());
                    // add paragraphs
                    addParagraphsFromHtmlElement(subChapter, doc.getElementById(link[1]).select("div .def"));

                    // add the subchapter to the parent.
                    chapter.addSubChapter(subChapter);
                    subChapter.setSuperChapter(chapter);
                }
            }
            chapters.add(chapter);
        }

        return chapters;
    }

    public static boolean isSuperChapter(String filename){
        return filename.matches("[LTG]\\d{1,2}\\.htm");
    }

    /**
     * get the title of the given html document.
     * @param doc
     * @return the string containing the title of this chapter.
     */
    public static String getHtmlDocTitle(Document doc, String filename){

        String title;
        if( isSuperChapter(filename) ){
            Element e = doc.select("#page").first();
            title = e.select("h1").text();
        } else {
            title = doc.select("h2").first().text();
        }

        return title;
    }

    /**
     * get paragraphs from element.
     * @param elements
     * @return
     */
    public static ArrayList<Paragraph> addParagraphsFromHtmlElement(Chapter chapter, Elements elements){
        ArrayList<Paragraph> paragraphs = new ArrayList<Paragraph>();

        for (Element e: elements) {

            // if there are no title of content in the given div we skip it.
            try{
                // TODO consider paragraphs that don't have the p element.
                // example: 3.1.2.2-bivirkniger.

                String title = e.select("h5").first().text();

                ArrayList<String> content = new ArrayList<String>();
                for (Element p: e.select("p")){
                    if(!p.text().equals("")) content.add(p.text());
                }

                chapter.addParagraph( new Paragraph(title, content) );

            }catch (NullPointerException ex){
                continue;
            }

        }

        return paragraphs;
    }
}
