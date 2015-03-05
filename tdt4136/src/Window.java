import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Window extends JFrame {

	/**
	 * @param title The title of the Window or application.
	 * @param data The randomized set of numbers to use for populating the board grid.
	 */
	public Window(String title, int[][] data) {

		Grid grid = new Grid(data);

		this.setTitle(title);
	    this.setResizable(false);
	    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setPreferredSize(new Dimension(450,450));
        this.setSize(new Dimension(450,450));
		this.setContentPane( grid );
        this.setVisible(true);

	}
}