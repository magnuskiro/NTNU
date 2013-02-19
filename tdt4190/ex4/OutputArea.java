import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * A component used to output textual information.
 */
@SuppressWarnings("serial")
public class OutputArea extends JPanel
{
	/** The headline of this output area */
	private JLabel headline;
	/** TextArea containing outputted information */
	private JTextArea textArea;

	/**
	 * Creates a new output area.
	 * @param title		The headline of the area.
	 */
	public OutputArea(String title) {
		headline = new JLabel(title);
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setAutoscrolls(true);
		setLayout(new BorderLayout());
		add(headline, BorderLayout.NORTH);
		add(new JScrollPane(textArea), BorderLayout.CENTER);
	}

	/**
	 * Outputs a text string, with a newline added at the end, to this output area.
	 * @param s		The information to display.
	 */
	public void println(String s) {
		print(s+"\n");
	}

	/**
	 * Outputs a text string to this output area.
	 * @param s		The information to display.
	 */
	public void print(String s) {
		textArea.append(s);
	}
}
