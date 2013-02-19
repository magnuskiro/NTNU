import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;


public class Prober extends Thread {
	
	private static final AtomicInteger ID = new AtomicInteger(0);
	private static final boolean DEBUG = false;
	
	private final Queue<Integer> waitFor = new LinkedList<Integer>();
	private final ServerImpl serv;
	private final int id;
	
	public Prober(ServerImpl serv){
		this.serv = serv;
		this.id = ID.getAndIncrement();
	}
	
	protected void println(String message){
		if(DEBUG)
			System.err.println(this.id + ", " + message);
	}
	
	@Override
	public void run(){
		try {
			this.println("Starting prober");
			serv.receiveProbe(waitFor);
		} catch (RemoteException e) {
			this.println("RemoteException encountered server must have crashed");
		}
		this.println("Prober ended");
	}

}
