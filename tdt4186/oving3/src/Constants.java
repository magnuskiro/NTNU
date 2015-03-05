public interface Constants 
{
	/** Event type describing the arrival of a new process */
    public static final int NEW_PROCESS = 1;
	/** Event type describing the completion of the active process */
    public static final int END_PROCESS = 2;
	/** Event type describing a process switch due to the completion of a RR time quant */
    public static final int SWITCH_PROCESS = 3;
	/** Event type describing the need for the active process to perform I/O */
    public static final int IO_REQUEST = 4;
	/** Event type describing the end of the current I/O operation */
    public static final int END_IO = 5;
	/** The orientation SOUTH */
	public final static int SOUTH = 0;
	/** The orientation WEST */
	public final static int WEST = 1;
	/** The orientation NORTH */
	public final static int NORTH = 2;
	/** The orientation EAST */
	public final static int EAST = 3;
}
