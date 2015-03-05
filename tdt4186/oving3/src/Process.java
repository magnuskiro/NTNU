import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.awt.*;
import java.util.*;

/**
 * This class contains data associated with processes,
 * and methods for manipulating this data as well as
 * methods for displaying a process in the GUI.
 *
 * You will probably want to add more methods to this class.
 */
public class Process implements Constants
{
	/** The ID of the next process to be created */
	private static long nextProcessId = 1;
	/** The font used by all processes */
	private static Font font = new Font("Arial", Font.PLAIN, 10);
	/** The ID of this process */
	private long processId;
	/** The color of this process */
	private Color color;
	/** The amount of memory needed by this process */
    private long memoryNeeded;
	/** The amount of cpu time still needed by this process */
    private long cpuTimeNeeded;
	/** The average time between the need for I/O operations for this process */
    private long avgIoInterval;
	/** The time left until the next time this process needs I/O */
    private long timeToNextIoOperation = 0;

	/** The time that this process has spent waiting in the memory queue */
	private long timeSpentWaitingForMemory = 0;
	/** The time that this process has spent waiting in the CPU queue */
	private long timeSpentInReadyQueue = 0;
	/** The time that this process has spent processing */
    private long timeSpentInCpu = 0;
	/** The time that this process has spent waiting in the I/O queue */
    private long timeSpentWaitingForIo = 0;
	/** The time that this process has spent performing I/O */
	private long timeSpentInIo = 0;

	/** The number of times that this process has been placed in the CPU queue */
	private long nofTimesInReadyQueue = 0;
	/** The number of times that this process has been placed in the I/O queue */
	private long nofTimesInIoQueue = 0;

	/** The global time of the last event involving this process */
	private long timeOfLastEvent;

    private long ioTime;
    private long enteredCpuTime;

	/**
	 * Creates a new process with given parameters. Other parameters are randomly
	 * determined.
	 * @param memorySize	The size of the memory unit.
	 * @param creationTime	The global time when this process is created.
	 */
	public Process(long memorySize, long creationTime) {
		// Memory need varies from 100 kB to 25% of memory size
		memoryNeeded = 100 + (long)(Math.random()*(memorySize/4-100));
		// CPU time needed varies from 100 to 10000 milliseconds
        //TODO: revert to 9900
		cpuTimeNeeded = 100 + (long)(Math.random()*99);
		// Average interval between I/O requests varies from 1% to 25% of CPU time needed
		avgIoInterval = (1 + (long)(Math.random()*25))*cpuTimeNeeded/100;
		// The first and latest event involving this process is its creation
		timeOfLastEvent = creationTime;
		// Assign a process ID
		processId = nextProcessId++;
		// Assign a pseudo-random color used by the GUI
		int red = 64+(int)((processId*101)%128);
		int green = 64+(int)((processId*47)%128);
		int blue = 64+(int)((processId*53)%128);
		color = new Color(red, green, blue);
        this.timeToNextIoOperation = 1;
	}

	/**
	 * Draws this process as a colored box with a process ID inside.
	 * @param g	The graphics context.
	 * @param x	The leftmost x-coordinate of the box.
	 * @param y	The topmost y-coordinate of the box.
	 * @param w	The width of the box.
	 * @param h	The height of the box.
	 */
	public void draw(Graphics g, int x, int y, int w, int h) {
		g.setColor(color);
		g.fillRect(x, y, w, h);
		g.setColor(Color.black);
		g.drawRect(x, y, w, h);
		g.setFont(font);
		FontMetrics fm = g.getFontMetrics(font);
		g.drawString(""+processId, x+w/2-fm.stringWidth(""+processId)/2, y+h/2+fm.getHeight()/2);
	}

	/**
	 * This method is called when the process leaves the memory queue (and
	 * enters the cpu queue).
     * @param clock The time when the process leaves the memory queue.
     */
    public void leftMemoryQueue(long clock) {
		  timeSpentWaitingForMemory += clock - timeOfLastEvent;
		  timeOfLastEvent = clock;
    }

    /**
	 * Returns the amount of memory needed by this process.
     * @return	The amount of memory needed by this process.
     */
	public long getMemoryNeeded() {
		return memoryNeeded;
	}

    /**
	 * Updates the statistics collected by the given Statistic object, adding
	 * data collected by this process. This method is called when the process
	 * leaves the system.
     * @param statistics	The Statistics object to be updated.
     */
	public void updateStatistics(Statistics statistics) {
		statistics.totalTimeSpentWaitingForMemory += timeSpentWaitingForMemory;
		statistics.nofCompletedProcesses++;
        //TODO: update the statistics fields and output.
	}

    public void setTimeToNextIoOperation(){
        this.timeToNextIoOperation = (long)((Math.random()*avgIoInterval)*2+1);
    }

    public long getTimeToNextIoOperation(){
        return timeToNextIoOperation;
    }

    public void leftCPU(long clock){
        System.out.println("clock: " +clock + "timeLAst:"+enteredCpuTime);
        long time = (clock - this.enteredCpuTime);
        this.timeToNextIoOperation -= time;
        this.cpuTimeNeeded -= time;
        this.timeSpentInCpu += time;
        System.out.println("time: " + time);
        System.out.println("process: "+ processId +"Left CPU, time to run left:"+cpuTimeNeeded+" time to IO: "+timeToNextIoOperation);

    }

    public long getCpuTimeRemaining(){
        return cpuTimeNeeded;
    }

    public void leftReadyQueue(long clock){
        this.timeSpentInReadyQueue += (clock - this.timeOfLastEvent);
    }

    public void enteredIOQueue(long clock){
        this.timeOfLastEvent = clock;
    }

    public void leftIOQueue(long clock){
        this.timeSpentWaitingForIo += (clock - this.timeOfLastEvent);
    }

    public void enteredReadyQueue(long clock){
        this.timeOfLastEvent = clock;
    }

    public void enteredCpu(long clock){
        this.enteredCpuTime = clock;
        System.out.println("event time: " + timeOfLastEvent);
    }

    public void generateIoTime(long time){
        this.ioTime =  (long)((Math.random()*time)*2+1);
    }

    public long getIoTime(){
        return this.ioTime;
    }
}
