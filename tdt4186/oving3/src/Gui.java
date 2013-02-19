/**
 * The GUI methods that are publicly available to other parts of the program.
 */
public interface Gui 
{
	/**
	 * Controls which process is being shown as the process active in the CPU.
	 * @param p		The process that is currently active, or null if the CPU is idle.
	 */
	public void setCpuActive(Process p);

	/**
	 * Controls which process is being shown as the process active in the I/O device.
	 * @param p		The process that is currently active, or null if the I/O device is idle.
	 */
	public void setIoActive(Process p);

	/**
	 * Lets the GUI know that a discrete amount of time has passed.
	 * @param time	The (simulated) time that has passed since the last call to this method.
	 */
	public void timePassed(long time);
}
