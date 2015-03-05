import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This class provides a GUI displaying the queueing network used
 * to simulate our system.
 */
public class SimulationGui extends JFrame implements Constants, ActionListener, Runnable, Gui
{
	/** Queue components shown in the GUI */
	private Queue memoryQueue, cpuQueue, ioQueue;
	/** Resources components shown in the GUI */
	private Resource memory, cpu, io;
	/** Panel containing the background picture */
	private PicturePanel backgroundPanel;
	/** Button used to start and rush the simulation */
	private JButton startButton;
	/** The background picture */
	private Image background;
	/** Slider controlling the speed of the simulation */
	private JSlider simulationSpeedSlider;
	/** Label showing how much simulated time has elapsed */
	private JLabel timeElapsedLabel;
	/** The scheduling simulator */
	private Simulator simulator;
	/** How much simulated time has elapsed */
	private long timeElapsed;
	/** Whether or not the simulation has been started */
	private boolean running = false;
	/** Whether or not the simulation is being slowed down to be observable */
	private boolean sleep = true;

	/**
	 * Constructs and shows a new GUI.
	 * @param memorySize			The size of the memory unit.
	 * @param maxCpuTime			The maximum time quant used by the Round Robin algorithm.
	 * @param avgIoTime				The average duration of I/O operations.
	 * @param simulationLength		The length of time to simulate.
	 * @param avgArrivalInterval	The average time between new process arrivals.
	 */
	public SimulationGui(long memorySize, long maxCpuTime, long avgIoTime, long simulationLength, long avgArrivalInterval) {
		super("Process scheduling simulator");
		memoryQueue = new Queue("memory queue", 10, EAST);
		cpuQueue = new Queue("CPU queue", 10, WEST);
		ioQueue = new Queue("I/O queue", 10, EAST);
		timeElapsed = 0;
		simulator = new Simulator(memoryQueue, cpuQueue, ioQueue, memorySize, maxCpuTime, avgIoTime,
			simulationLength, avgArrivalInterval, this);
		placeComponents();
		setSize(500,500);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}

	/**
	 * Creates an places the components used by the GUI.
	 */
	private void placeComponents() {
		memory = new Resource("Memory");
		cpu = new Resource("CPU");
		io = new Resource("I/O");
		loadImages();
		
		backgroundPanel = new PicturePanel(background);
		getContentPane().setLayout(null);
		getContentPane().add(backgroundPanel);
		backgroundPanel.setBounds(0,0,494,374);
		backgroundPanel.setLayout(null);
		backgroundPanel.add(memoryQueue);
		backgroundPanel.add(cpuQueue);
		backgroundPanel.add(ioQueue);
		backgroundPanel.add(memory);
		backgroundPanel.add(cpu);
		backgroundPanel.add(io);
		memoryQueue.setBounds(110,20,200,50);
		memory.setBounds(310,10,90,90);
		cpuQueue.setBounds(200,120,200,50);
		cpu.setBounds(110,110,90,90);
		ioQueue.setBounds(110,220,200,50);
		io.setBounds(310,210,90,90);

		JPanel lowerPanel = new JPanel();
		lowerPanel.setLayout(null);
		getContentPane().add(lowerPanel);
		lowerPanel.setBounds(0,374,494,100);
		simulationSpeedSlider = new JSlider(0, 10000, 8000);
		lowerPanel.add(simulationSpeedSlider);
		addSliderLabels(lowerPanel,10,10,474,20,"Slow","Fast","Simulation speed");
		simulationSpeedSlider.setBounds(10,30,474,20);
		timeElapsedLabel = new JLabel("Simulated time elapsed: "+timeElapsed+" ms.");
		lowerPanel.add(timeElapsedLabel);
		timeElapsedLabel.setBounds(10,60,300,20);
		startButton = new JButton("Start simulation");
		lowerPanel.add(startButton);
		startButton.setBounds(320,60,154,20);
		startButton.addActionListener(this);
	}

	/**
	 * Method running as a separate thread when the "Start simulation"
	 * button is pressed. Starts the main simulation loop.
	 */
	public void run() {
		running = true;
		simulator.simulate();
	}

	/**
	 * Listener method called when a button has been clicked.
	 * @ae	The action event.
	 */
	public void actionPerformed(ActionEvent ae) {
		if(!running) {
			startButton.setText("Complete simulation");
			 // The simulation must be run in a separate thread,
			// we can't "hijack" the GUI's event handling thread.
			Thread t = new Thread(this);
			t.start();
		}
		else {
			sleep = false;
		}
	}

	/**
	 * Creates, adds and positions labels above a slider.
	 * @param p			The panel to add the labels to.
	 * @param x			The x position of the leftmost label.
	 * @param y			The y position of the topmost label.
	 * @param w			The width from leftmost label to rightmost pixel of the rightmost label
	 * @param h			The height of the labels.
	 * @param leftText	The text to be displayed in the left label.
	 * @param rightText	The text to be displayed in the right label.
	 * @param text		The text to be displayed in the central label.
	 */
	private void addSliderLabels(JPanel p, int x, int y, int w, int h, String leftText, String rightText, String text) {
		JLabel left, middle, right;
		left = new JLabel(leftText);
		left.setHorizontalAlignment(JLabel.LEFT);
		left.setOpaque(false);
		p.add(left);
		left.setBounds(x,y,w,h);
		middle = new JLabel(text);
		middle.setHorizontalAlignment(JLabel.CENTER);
		middle.setOpaque(false);
		p.add(middle);
		middle.setBounds(x,y,w,h);
		right = new JLabel(rightText);
		right.setHorizontalAlignment(JLabel.RIGHT);
		right.setOpaque(false);
		p.add(right);
		right.setBounds(x,y,w,h);
	}

	/**
	 * Controls which process is being shown as the process active in the CPU.
	 * @param p		The process that is currently active, or null if the CPU is idle.
	 */
	public void setCpuActive(Process p) {
		cpu.setActiveProcess(p);
	}

	/**
	 * Controls which process is being shown as the process active in the I/O device.
	 * @param p		The process that is currently active, or null if the I/O device is idle.
	 */
	public void setIoActive(Process p) {
		io.setActiveProcess(p);
	}

	/**
	 * Lets the GUI know that a discrete amount of time has passed.
	 * @param time	The (simulated) time that has passed since the last call to this method.
	 */
	public void timePassed(long time) {
		timeElapsed += time;
		timeElapsedLabel.setText("Simulated time elapsed: "+timeElapsed+" ms.");
		timeElapsedLabel.repaint();
		try	{
			if(sleep && isShowing())
				Thread.sleep((10000-simulationSpeedSlider.getValue())*time/3000);
		} catch (InterruptedException ie) {}
	}

	/**
	 * Loads an image from a file.
	 * @param tk		The toolkit to be used to load the image.
	 * @param file		The name of the file containing the image.
	 * @param tracker	The media tracker tracking the progress of the load.
	 * @return			The image that was loaded, as an Image object.
	 */
	private Image loadImage(Toolkit tk, String file, MediaTracker tracker) {
		Image result = tk.createImage(file);
		tracker.addImage(result, 0);
		return result;
	}

	/**
	 * Loads all images to be used by the GUI, and waits for them to
	 * be fully loaded before returning.
	 */
	private void loadImages() {
		MediaTracker tracker = new MediaTracker(this);
		Toolkit tk = Toolkit.getDefaultToolkit();
		background = loadImage(tk, "images/background.gif", tracker);
		try {
			tracker.waitForID(0);
	    } catch (InterruptedException ie) {}
	}
}
