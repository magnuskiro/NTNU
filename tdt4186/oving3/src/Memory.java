/**
 * This class implements functionality associated with
 * the memory device of the simulated system.
 */
public class Memory {
	/** The queue of processes waiting for free memory */
	private Queue memoryQueue;
	/** A reference to the statistics collector */
	private Statistics statistics;
	/** The amount of memory in the memory device */
	private long memorySize;
	/** The amount of free memory in the memory device */
	private long freeMemory;

	/**
	 * Creates a new memory device with the given parameters.
	 * @param memoryQueue	The memory queue to be used.
	 * @param memorySize	The amount of memory in the memory device.
	 * @param statistics	A reference to the statistics collector.
	 */
    public Memory(Queue memoryQueue, long memorySize, Statistics statistics) {
		this.memoryQueue = memoryQueue;
		this.memorySize = memorySize;
		this.statistics = statistics;
		freeMemory = memorySize;
    }

	/**
	 * Returns the amount of memory in the memory device.
	 * @return	The size of the memory device.
	 */
	public long getMemorySize() {
		return memorySize;
	}

	/**
	 * Adds a process to the memory queue.
	 * @param p	The process to be added.
	 */
	public void insertProcess(Process p) {
		memoryQueue.insert(p);
	}

    /**
     * Checks whether or not there is enough free memory to let
	 * the first process in the memory queue proceed to the cpu queue.
	 * If there is, the process that was granted memory is returned,
	 * otherwise null is returned.
     * @param clock The current time.
     */  
	public Process checkMemory(long clock) {
		if(!memoryQueue.isEmpty()) { 
			Process nextProcess = (Process)memoryQueue.getNext();
			if(nextProcess.getMemoryNeeded() <= freeMemory) {
				// Allocate memory to this process
				freeMemory -= nextProcess.getMemoryNeeded();
				nextProcess.leftMemoryQueue(clock);
				memoryQueue.removeNext();
				return nextProcess;
			}
		}
		return null;
	}

	/**
	 * This method is called when a discrete amount of time has passed.
	 * @param timePassed	The amount of time that has passed since the last call to this method.
	 */
	public void timePassed(long timePassed) {
		statistics.memoryQueueLengthTime += memoryQueue.getQueueLength()*timePassed;
		if (memoryQueue.getQueueLength() > statistics.memoryQueueLargestLength) {
			statistics.memoryQueueLargestLength = memoryQueue.getQueueLength(); 
		}
    }
    
	/**
	 * This method is called when a process is exiting the system.
	 * The memory allocated to this process is freed.
	 * @param p	The process that is leaving the system.
	 */
    public void processCompleted(Process p) {
		freeMemory += p.getMemoryNeeded();
    }
}

