import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

public class MyIndexFiles {

	public MyIndexFiles() {
	}

	static final File INDEX_DIR = new File("index");

	/** Index all text files under a directory. */
	public static void main(String[] args) {
		String usage = "java org.apache.lucene.demo.IndexFiles <root_directory>";
        String filedir = "";

		if (args.length == 0) {
			System.err.println("Usage: " + usage);
            System.err.println("No Input Arguments, using default");
            filedir = "/home/kiro/ntnu/tdt4117/ex4/files";
		}
        else{
            filedir = args[0];
        }

		if (INDEX_DIR.exists()) {
			System.out.println("Cannot save index to '" + INDEX_DIR
					+ "' directory, please delete it first");
			System.exit(1);
		}

		final File docDir = new File(filedir);
		if (!docDir.exists() || !docDir.canRead()) {
			System.out
					.println("Document directory '"
							+ docDir.getAbsolutePath()
							+ "' does not exist or is not readable, please check the path");
			System.exit(1);
		}

		Date start = new Date();
		try {
			IndexWriter writer = new IndexWriter(FSDirectory.open(INDEX_DIR),
					new StandardAnalyzer(Version.LUCENE_CURRENT), true,
					IndexWriter.MaxFieldLength.LIMITED);
			System.out.println("Indexing to directory '" + INDEX_DIR + "'...");
			indexDocs(writer, docDir);
			System.out.println("Optimizing...");
			writer.optimize();
			writer.close();

			Date end = new Date();
			System.out.println(end.getTime() - start.getTime()
					+ " total milliseconds");

		} catch (IOException e) {
			System.out.println(" caught a " + e.getClass()
					+ "\n with message: " + e.getMessage());
		}
	}

	static void indexDocs(IndexWriter writer, File file) throws IOException {
		// do not try to index files that cannot be read
		if (file.canRead()) {
			if (file.isDirectory()) {
				String[] files = file.list();
				// an IO error could occur
				if (files != null) {
					for (int i = 0; i < files.length; i++) {
						indexDocs(writer, new File(file, files[i]));
					}
				}
			} else {
				System.out.println("adding " + file);
				try {
					writer.addDocument(MyDocument.Document(file));
				}
				// at least on windows, some temporary files raise this
				// exception with an "access denied" message
				// checking if the file can be read doesn't help
				catch (FileNotFoundException fnfe) {
					;
				}
			}
		}
	}

}
