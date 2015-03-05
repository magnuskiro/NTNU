import java.util.*;

/**
 * This class maintains a queue of events used for
 * simulating the behaviour of the system. Events are
 * kept in a cronologically sorted list. This class is
 * an example of a priority queue (event time being the
 * priority in this case).
 */
public class EventQueue
{
	/** The list of events */
	private ArrayList events;

	/**
	 * Creates a new Event Queue.
	 */
	public EventQueue() {
		events = new ArrayList();
	}

	/**
	 * Inserts an event in the queue.
	 * The event is added to the event list, which
	 * is then resorted.
	 * @param event	The event to be inserted.
	 */
    public void insertEvent(Event event) {
		if(event != null) {
			events.add(event);
			Collections.sort(events);
		}
    }

	/**
	 * Removes and returns the earliest event (the event
	 * with the lowest time value) from the queue.
	 * @return	The event with the lowest time value in the queue.
	 */
    public Event getNextEvent() {
		  return (Event)events.remove(0);
    }

    /**
     * Checks whether or not the event queue is empty.
     * @return	Whether or not the event queue is empty.
     */
    public boolean isEmpty() {
		return events.size() == 0;
	}
}







