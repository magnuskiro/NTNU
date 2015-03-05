package Searches;

import Models.ATC;
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

public class FullCaseSearch {

    public void index(Case currentCase, ArrayList<Chapter> chapters, int limit){

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

            String q= "";
            for (Sentence s: currentCase.getSentences()){
                q+=s.toString();
            }
            //System.out.println(q);

            Query query = parser.parse(q);
            ScoreDoc[] hits = isearcher.search(query, null, 4).scoreDocs;

            // Iterate through the results:
            for (int i = 0; i < hits.length; i++) {
                Document hitDoc = isearcher.doc(hits[i].doc);

                Chapter chapter = getChapter(hitDoc.get("label"), chapters);
                currentCase.addChapter(i, chapter);
                //System.out.println("This is the text to be indexed== " + hitDoc.get("label"));
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
