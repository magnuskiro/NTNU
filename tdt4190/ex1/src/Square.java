import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Component for displaying a square in a Tic Tac Toe board.
 */
public class Square extends JPanel implements Constants, MouseListener
{
	/** The mark that is currently marked in this square */
	private char currentMark;
	/** The coordinates of this square */
	private int row, column;
	/** A reference to the GUI that this square is a part of */
	private TicTacToeGui theGui;
	/** The size of all squares */
	private final static Dimension size = new Dimension(SQUARE_WIDTH, SQUARE_HEIGHT);

	/**
	 * Creates a new square.
	 * @param gui	A reference to the GUI that this square belongs to.
	 * @param r		The row index of this square.
	 * @param c		The column index of this square.
	 */
	public Square(TicTacToeGui gui, int r, int c) {
		theGui = gui;
		row = r;
		column = c;
		currentMark = ' ';
		setBackground(Color.white);
		addMouseListener(this);
	}

	/**
	 * Overridden API method to make the LayoutManager
	 * give squares the correct size.
	 * @return	The preferred size of a square.
	 */
	public Dimension getPreferredSize() {
		return size;
	}

	/**
	 * Paints the square.
	 * @param g	The graphics context to paint the square in.
	 */
	public void paint(Graphics g) {
		super.paint(g);
		g.drawRect(0, 0, SQUARE_WIDTH-1, SQUARE_HEIGHT-1);
		g.drawString(""+currentMark, 11, 20);
	}

	/**
	 * Sets the mark of this square.
	 * @param newMark	The new mark of this square.
	 */
	public void setMark(char newMark) {
		currentMark = newMark;
	}

	/**
	 * Gets the mark of this square.
	 * @return	The mark that this square is currently marked with.
	 */
	public char getMark() {
		return currentMark;
	}

	/**
	 * Registers a mouse click on this square.
	 * If the square is empty the GUI is notified.
	 * @param e	The MouseEvent that occured.
	 */
	public void mouseClicked(MouseEvent e) {
		if (currentMark == ' ')
			theGui.squareClicked(row, column);
	}

	// MouseListener methods that are not used:
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
}

