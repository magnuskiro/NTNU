import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * This class implements a queue of customers as a circular buffer.
 */
public class CustomerQueue {

    public final int qlength;
    public final Gui gui;
    public final LinkedBlockingQueue<Customer> q;
    public final ConcurrentHashMap<Customer, Integer> chairQ;

	/**
	 * Creates a new customer queue.
	 * @param queueLength	The maximum length of the queue.
	 * @param gui			A reference to the GUI interface.
	 */
    public CustomerQueue(int queueLength, Gui gui) {
        this.gui = gui;
        this.qlength = queueLength;
        this.q = new LinkedBlockingQueue<Customer>(this.qlength);
        this.chairQ = new ConcurrentHashMap<Customer, Integer>();
	}

    //finds the first available seat and adds a customer to it.
    public boolean add(Customer c){
        boolean access = this.q.offer(c);
        if(access){
            for(int i = 0; i<qlength; i++){
                if(!chairQ.contains(i)){
                    chairQ.put(c, i);
                    this.gui.fillLoungeChair(i, c);
                    return access;
                }
            }
        }
        return access;
    }

    //gets the next customer in the queue.
    public Customer getNext(){
        Customer c = this.q.poll();
        if (c!=null){
            int p = chairQ.remove(c);
            this.gui.emptyLoungeChair(p);
        }
        return c;
    }

    //returns the remaining capacity of the queue.
    public int getRemainingCapacity(){
        return this.q.remainingCapacity();
    }

}
