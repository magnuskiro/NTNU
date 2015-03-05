import java.rmi.*;
import java.rmi.server.*;
import java.util.Scanner;
import java.io.Serializable;

public class TicTacToeGame implements TicTacToe {

	private static String adresse = "127.0.0.1:1099";//"78.91.14.252:1099";
	private static Boolean gameOver = false;
	private TicTacToeGui gui;
	private TicTacToe client;
	
	public TicTacToeGame() {
		initiate();
	}
	
	public void initiate() {

        // the security manager needs comments.
		System.setSecurityManager(new LiberalSecurityManager());
		
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("Please enter IP address and port to connect to");
			System.out.println("If no address or port is supplied, you will take the role as server\nIP: ");
			String ip = scan.nextLine();
			System.out.println("Port: ");
			String port = scan.nextLine();
			
			if(ip.equals("") && port.equals(""))
				server();
			else
				client(ip, port, scan);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    /**
     * The server part of the code. It is the first instance that becomes the server. If there are noe given arguments.
     */
	public void server() {
		try {
			System.out.println("Starting game ...");
            //create my gui.
			TicTacToeGui serverGui = new TicTacToeGui("Server", 'X', null);
			//set the flag so that it is not my turn. Now I can't place any crosses on the board.
            serverGui.setFlag();
            // creates the communication instance.
			TicTacToeImpl impl = new TicTacToeImpl(serverGui);
			System.out.println("Binding game to registry ...");
			//binding the communication class to the rmi container. This makes it visible for others.
            Naming.rebind("rmi://"+adresse+"/TicTacToe",impl);
			System.out.println("Game is up and running, waiting for opponent");
			System.out.println("Tell your opponent to connect to " + adresse);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void client(String ip, String port, Scanner scan) {
		try {
            adresse = ip+":"+port;
            System.setProperty("java.rmi.server.hostname", ip);
			String url = "rmi://"+adresse+"/TicTacToe";
            //Looks for the server on the given address. And connects to it. this line sets the server variable to point to the impl class on the server instance of this program.
			TicTacToe server = (TicTacToe)Naming.lookup(url);
			//creates the client gui.
            TicTacToeGui clientGui = new TicTacToeGui("Client", 'O', server);
			//creates my communications instance.
            TicTacToeImpl client = new TicTacToeImpl(clientGui);
			//sets my communication instance with the server, so the server can contact the client.
            server.setClient(client);
			while (!gameOver) {
                //takes command line input - not important.
				System.out.println("What is x? ");
				int x = Integer.parseInt(scan.nextLine());
				System.out.println("What is y? ");
				int y = Integer.parseInt(scan.nextLine());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TicTacToeGame game = new TicTacToeGame();
	}

    /**
     * The method that is called when the opponent wins.
     */
    public void loose() {
        gui.newGame();
    }

    /**
     * The method that is called when a player does a move. Takes a placement on the board.
     * @param x
     * @param y
     * @param mark
     * @return
     */
    public String doMove(int x, int y, char mark) {
		gui.squareClicked(x, y);
//		System.out.println("Suksess!");
		return "suksess";
	}

    /**
     * Sets the client at the other party on our two way communication.
     * The opponent uses this method to set it's GUI in our code.
     * @param gui
     */
	public void setClient(TicTacToe gui) {
		this.client = gui;
	}
	public void requestNew(){}
}


