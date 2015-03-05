/**
 * This class implements the barber's part of the
 * Barbershop thread synchronization example.
 */
public class Barber {

    private final Gui gui;
    private final CustomerQueue q;
    public final int position;
    public boolean run;
    public Thread thread;

	/**
	 * Creates a new barber.
	 * @param queue		The customer queue.
	 * @param gui		The GUI.
	 * @param pos		The position of this barber's chair
	 */
	public Barber(CustomerQueue queue, Gui gui, int pos) { 
	    this.gui=gui;
        this.q=queue;
        this.position=pos;
    }

	/**
	 * Starts the barber running as a separate thread.
	 */
	public void startThread() {
	    this.run = true;
        Runnable runnable = new Runnable() {
            public void run() {
                //To change body of implemented methods use File | Settings | File Templates.
                while (run){
                    try{
                        int time = (int) (Math.random() * Globals.barberSleep + 100);
                        writeGuiMessage("Daydreaming for: " + time + "ms");
                        gui.barberIsSleeping(position);
                        Thread.sleep(time);
                    }catch (InterruptedException e){
                        writeGuiMessage("Interrupted");
                    }
                    if(run){
                        gui.barberIsAwake(position);
                        writeGuiMessage("is Awake");
                        Customer c = q.getNext();
                        if(c != null){
                            writeGuiMessage("got new customer");
                            gui.fillBarberChair(position, c);
                            try {
                                writeGuiMessage("Working on customer");
                                Thread.sleep(Globals.barberWork);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            writeGuiMessage("Customer complete");
                            gui.emptyBarberChair(position);
                        }
                        else {
                            writeGuiMessage("NO customers");
                        }
                    }
                }
                writeGuiMessage("Finished");
            }
        };
        this.thread = new Thread(runnable);
        this.thread.start();
        writeGuiMessage("Working");
    }

	/**
	 * Stops the barber thread.
	 */
	public void stopThread() {
        this.run = false;
        writeGuiMessage("Leaving");
        thread.interrupt();
        while(this.thread.isAlive()){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
	}


	public void writeGuiMessage(String message){
        this.gui.println("Barber:" + message);
        System.out.println("Barber:" + message);
    }
}

