
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Graphical user interface to a Tic Tac Toe application.
 * The GUI is incomplete because it has no associated player.
 * It also needs a routine for checking if one of the players
 * have got five marks in a row.
 */
public class TicTacToeGui extends JFrame implements Constants, ActionListener {
	/** Textfield showing what mark you use ('X' or 'O') */
	private JTextField id;
	/** TextArea giving feedback to the user */
	private TextArea display;
	/** The panel containing the board */
	private JPanel boardPanel;
	/** The squares of the board */
	private Square board[][];
	/** The menu bar */
	private JMenuBar menuBar;
	/** The game submenu */
	private JMenu gameMenu;
	/** Game submenu choices */
	private JMenuItem newGameItem, quitItem;
	
	/** The name of the player using this GUI */
	private String myName;
	/** The mark used by this player ('X' or 'O') */
	private char myMark;
	
	private TicTacToe opponent;
	
	private Boolean client;
	
	private int flag = 1;

    public HaveIWon haveIWon = new HaveIWon();

	/**
	 * Creates a new GUI.
	 * @param name	The name of that player.
	 * @param mark	The mark used by that player.
	 */
	public TicTacToeGui(String name, char mark, TicTacToe tic) {
		myName = name;
		myMark = mark;
		opponent = tic;
		if (tic == null)
			System.out.println("HALLELUJA!");
	
		// Create GUI components:
		// The display at the bottom:
		display = new TextArea("", 4, 30, TextArea.SCROLLBARS_VERTICAL_ONLY);
		display.setEditable(false);
		// The name field at the top:
		id = new JTextField();
		id.setEditable(false);
		id.setText(myName + ": You are player " + myMark);
		// The board:
		JPanel gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(BOARD_SIZE, BOARD_SIZE, 0, 0));
		board = new Square[BOARD_SIZE][BOARD_SIZE];
		for(int row = 0; row < board.length; row++) 
			for(int col = 0; col < board[row].length; col++) {
				board[row][col] = new Square(this, row, col);
				gridPanel.add(board[row][col]);
			}
		boardPanel = new JPanel();
		boardPanel.add(gridPanel);

		// Place the components:
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add("South", display);
		cp.add("North", id);
		cp.add("Center", boardPanel);

		// Create the menu.
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		gameMenu = new JMenu("Game");
		gameMenu.setMnemonic(KeyEvent.VK_G);
		menuBar.add(gameMenu);
		newGameItem = new JMenuItem("New game", KeyEvent.VK_N);
		newGameItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
		gameMenu.add(newGameItem);
		quitItem = new JMenuItem("Quit", KeyEvent.VK_Q);
		quitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
		gameMenu.add(quitItem);

		// Add listeners
		newGameItem.addActionListener(this);
		quitItem.addActionListener(this);
		// Add an anonymous WindowListener which calls quit() when the window is closing
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				quit();
			}
		});

		// Place and show the window:
		setTitle("Tic Tac Toe: " + name);
		setSize(WIN_WIDTH, WIN_HEIGHT);
		setLocation(200, 200);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * Called by the Square class when an empty square is clicked.
	 * @param row		The row of the square that was clicked.
	 * @param column	The column of the square that was clicked.
	 */
	public void squareClicked(int row, int column) {
		// This method must be modified!
		if (this.flag == -1)
			return;
		try {
			if (opponent != null)
				setFlag();
				setMark(row, column, myMark);
				opponent.doMove(row, column, myMark);
				if (haveIWon.check(row, column)) {
					setDisplayText("You won the game! Yay!");
//                    newGame();
                    opponent.loose();
				}
		} catch (Exception e) {
			System.out.println("Gui failed");
			e.printStackTrace();
		}
//		setMark(row, column, myMark);
	}

	/**
	 * Marks the specified square of the board with the specified mark.
	 * @param row		The row of the square to mark.
	 * @param column	The column of the square to mark.
	 * @param mark		The mark to use.
	 */
	public void setMark(int row, int column, char mark) {
		board[row][column].setMark(mark);
		repaint();
	}
	
	public void setFlag() {
		this.flag *= -1;
	}

	/**
	 * Called when a menu item has been selected.
	 * @param e	The ActionEvent that occured.
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == newGameItem)
			newGame();
		else if(e.getSource() == quitItem)
			quit();
	}

	/**
	 * Starts a new game, if the user confirms it in a dialog box.
	 */
	public void newGame() {
		// This method must be modified!
//        display.setText("Game Over!");
		try {
			if(JOptionPane.showConfirmDialog(this, "Are you sure you want to start a new game?", "Start over?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				clearBoard();
		        haveIWon.clearBoard();
		        opponent.requestNew();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setDisplayText(String text) {
		display.setText(text);
	}
	
	public void request() {
		if(JOptionPane.showConfirmDialog(this, "Your opponent wants to play again", "Accept?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			clearBoard();
            haveIWon.clearBoard();
		}
	}

	/**
	 * Removes all marks from the board.
	 */
	public void clearBoard() {
		for(int row = 0; row < board.length; row++)
			for(int col = 0; col < board[row].length; col++)
				board[row][col].setMark(' ');
		repaint();
	}

	/**
	 * Exits the game, if the user confirms it in a dialog box.
	 * Should notify the opponent that we left the game.
	 */
	public void quit() {
		// This method should be modified!
		if(JOptionPane.showConfirmDialog(this, "Are you sure you want to quit?", "Really quit?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	/**
	 * Outputs a message to the user.
	 * @param s	The string to display. Adds a newline to the end of the string.
	 */
	public void println(String s) {
		display.append(s + "\n");
	}

	/**
	 * Outputs a message to the user.
	 * @param s	The string to display.
	 */
	public void print(String s) {
		display.append(s);
	}

    /**
     * Sets the opponents Communication class.
     * @param tic
     */
	public void setTic(TicTacToe tic) {
		opponent = tic;
	}

	/**
	 * Starts up a GUI without an associated player, in order
	 * to check the appearance of the GUI.
	 */
//	public static void main(String args[]) {
//		TicTacToeGui hisGui = new TicTacToeGui("Ottar", 'X');
//	}
}

