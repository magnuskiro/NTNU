import java.rmi.*;
import javax.swing.*;

public interface TicTacToe extends Remote {

    /**
     * The method that is called when the other party wins.
     * @throws RemoteException
     */
    public void loose() throws RemoteException;

    /**
     * The method that is called when the other party makes a move.
     * @param x
     * @param y
     * @param mark
     * @return
     * @throws RemoteException
     */
	public String doMove(int x, int y, char mark) throws RemoteException;

    /**
     * The method that maps the other party's GUI. So we can do stuff back.
     * @param gui
     * @throws Exception
     */
    public void setClient(TicTacToe gui) throws Exception;
    
    public void requestNew() throws RemoteException;
}

