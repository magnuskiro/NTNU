import java.rmi.server.*;
import javax.swing.*;


public class TicTacToeImpl extends UnicastRemoteObject implements TicTacToe {

    //se the interface for method descriptions.

	private TicTacToeGui gui;
	private TicTacToe client;
	
	public TicTacToeImpl(TicTacToeGui gui) throws java.rmi.RemoteException {
		this.gui = gui;
	}

    public void loose() {
    	gui.setDisplayText("You lost!");
//        gui.newGame();
    }

    public String doMove(int x, int y, char mark) {
		gui.setMark(x, y, mark);
		gui.setFlag();
		return "suksess";
	}
	
	public void setClient(TicTacToe client) {
		this.client = client;
		this.gui.setTic(client);
	}
	
	public void requestNew() {
		this.gui.request();
	}
}
