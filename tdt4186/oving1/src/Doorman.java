/**
 * This class implements the doorman's part of the
 * Barbershop thread synchronization example.
 */
public class Doorman {

    public final CustomerQueue q;
    public final Gui gui;
    public boolean run;
    public Thread thread;

    /**
     * Creates a new doorman.
     * @param queue		The customer queue.
     * @param gui		A reference to the GUI interface.
     */
    public Doorman(CustomerQueue queue, Gui gui) {
        this.q = queue;
        this.gui = gui;
    }

    /**
     * Starts the doorman running as a separate thread.
     */
    public void startThread() {
        this.run = true;
        Runnable runnable = new Runnable() {
            public void run() {
                //To change body of implemented methods use File | Settings | File Templates.
                while (run){
                    try{
                        writeGuiMessage("Waiting for: " + Globals.doormanSleep + "ms");
                        Thread.sleep(Globals.doormanSleep);
                    }catch (InterruptedException e){
                        writeGuiMessage("Interrupted");
                    }
                    if(run){
                        writeGuiMessage("Woke up, fetching new customer");
                        if(!q.add(new Customer())){
                            writeGuiMessage("Queue full, remaining: " + q.getRemainingCapacity());
                        }
                        else{
                            writeGuiMessage("Added new customer");
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
     * Stops the doorman thread.
     */
    public void stopThread() {
        this.run = false;
        writeGuiMessage("Leaving");
        this.thread.interrupt();
        while (thread.isAlive()){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void writeGuiMessage(String message){
        this.gui.println("Doorman:" + message);
        System.out.println("Doorman:" + message);
    }
}
