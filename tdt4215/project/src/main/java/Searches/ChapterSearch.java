package Searches;

import Models.Case;
import Models.Chapter;
import Models.Sentence;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.no.NorwegianAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;

import java.util.ArrayList;

public class ChapterSearch {

    /**
     *
     * @param currentCase
     * @param chapters
     * @param limit the limit of atcs to be used in the indexing. Mostly for debugging purposes to reduce computation time.
     */
    public void index(Case currentCase, ArrayList<Chapter> chapters, int limit, String type){
        //System.out.println("Indexing " + type);

        try {
            Analyzer analyzer = new NorwegianAnalyzer(Version.LUCENE_41);

            // Store the index in memory:
            Directory directory = new RAMDirectory();
            // To store an index on disk, use this instead:
            //Directory directory = FSDirectory.open("/tmp/testindex");
            IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_41, analyzer);
            IndexWriter iwriter = new IndexWriter(directory, config);

            int stop = 0;
            for (Chapter a:chapters){
                if(a.getAllParagraphs() == null) continue;
                Document doc = new Document();
                //System.out.println(a.getLabel());
                doc.add(new Field("label", a.getAllParagraphs(), TextField.TYPE_STORED));
                iwriter.addDocument(doc);

                stop++;
                if (stop>limit) break;
            }

            iwriter.close();

            // Now search the index:
            DirectoryReader ireader = DirectoryReader.open(directory);
            IndexSearcher isearcher = new IndexSearcher(ireader);

            // Parse a simple query that searches for "text":
            QueryParser parser = new QueryParser(Version.LUCENE_41, "label", analyzer);

            for(Sentence s: currentCase.getSentences()){
                //System.out.println(s);
                Query query = parser.parse(s.getSentence());
                ScoreDoc[] hits = isearcher.search(query, null, 4).scoreDocs;

                // Iterate through the results:
                for (int i = 0; i < hits.length; i++) {
                    if(hits.length == 0){
                        System.err.print("Ingen match" + s.getId());
                    }
                    Document hitDoc = isearcher.doc(hits[i].doc);

                    Chapter chapter = getChapter(hitDoc.get("label"), chapters);
                    if(type.equals("general")) s.addGeneral(i, chapter);
                    else if(type.equals("drug")) s.addDrug(i, chapter);
                    else if(type.equals("therapy")) s.addTherapy(i, chapter);
                    //System.out.println("This is the text to be indexed== " + hitDoc.get("label"));
                }

            }

            ireader.close();
            directory.close();

            // catch em all.
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public Chapter getChapter(String label, ArrayList<Chapter> chapters){
        for(Chapter chapter: chapters){
            if (chapter.getAllParagraphs() == null) continue;
            if(chapter.getAllParagraphs().equals(label)) return chapter;
        }
        return null;
    }

}
