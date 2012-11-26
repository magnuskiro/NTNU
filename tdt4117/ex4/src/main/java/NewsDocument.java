import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class NewsDocument {

	private String from;
	private String content;
	private String path;
    private String subject;

	public NewsDocument(File file) {
		FileReader fr;
		StringBuffer content = new StringBuffer();
		try {
			fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = null;

			for (int j = 0; (line = br.readLine()) != null; j++) {

				boolean contentLine = true;
				if (line.startsWith("From:")) {
					this.from = line.substring(line.indexOf("From:") + 6);
					contentLine = false;
				}
				if (line.startsWith("Subject:")) {
					this.subject = line.substring(line.indexOf("Subject:") + 9);
					contentLine = false;
				}
				if (contentLine) {
					content.append(line);
				}
			}
			br.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.path = file.getPath();
		this.content = content.toString();
	}

	@Override
	public String toString() {
		return path + ": " + from + " / " + subject + ": " + content;
	}

	public String getContent() {
		return content;
	}

	public String getFrom() {
		return from;
	}

	public String getSubject() {
		return subject;
	}
}
