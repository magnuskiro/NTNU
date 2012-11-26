import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;

import java.io.File;
import java.io.IOException;

public class MyDocument {

    public static Document Document(File f)
            throws IOException {

		// make a new, empty document
		Document doc = new Document();

		// use the news document wrapper
		NewsDocument newsDocument = new NewsDocument(f);

        doc.add(new Field("from", newsDocument.getFrom(), Field.Store.YES, Field.Index.NO));

        doc.add(new Field("subject", newsDocument.getSubject(), Field.Store.YES, Field.Index.ANALYZED));

        doc.add(new Field("path", f.getPath(), Field.Store.YES, Field.Index.ANALYZED));

        doc.add(new Field("content", newsDocument.getContent(), Field.Store.YES, Field.Index.ANALYZED));

		// return the document
		return doc;
	}

}
