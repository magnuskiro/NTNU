import java.util.*;
import javax.swing.*;
import java.awt.*;

/**
 * A queue in a queuing network. This class both offers ordinary queue
 * functionality, as well as serving as a graphical component. This means
 * that updates to the queue will be automatically displayed in the GUI.
 */
public class Queue extends JPanel implements Constants {
	/** The content of the queue */
	private ArrayList content;
	/** The name of the queue */
	private String name;
	/** The maximum number of elements of the queue that will be visible in the GUI */
	private int maxVisibleLength;
	/** The direction in which the queue is drawn, either EAST or WEST */
	private int direction;
	/** The font used by all queues */
	private static Font font = new Font("Arial", Font.PLAIN, 12);

	/**
	 * Creates a new queue with the given parameters.
	 * @param name				The name of the queue, which will be shown in the GUI.
	 * @param maxVisibleLength	The maximum number of elements of the queue that will be visible in the GUI.
	 * @param direction			The direction in which the queue will be drawn, either EAST or WEST.
	 */
	public Queue(String name, int maxVisibleLength, int direction) {
		this.name = name;
		this.maxVisibleLength = maxVisibleLength;
		this.direction = direction;
		content = new ArrayList();
		setBackground(Color.white);
	}

	/**
	 * Inserts a new element to the tail of the queue.
	 * @param o	The object to be added to the queue.
	 */
	public void insert(Object o) {
		content.add(o);
		repaint();
	}

	/**
	 * Returns the first element in the queue, but does not remove it from the queue.
	 * @return	The first object in the queue.
	 */
	public Object getNext() {
		return content.get(0);
	}

	/**
	 * Returns the first element in the queue, and removes it from the queue.
	 * @return	The object that was the first one in the queue.
	 */
	public Object removeNext() {
		Object result = content.remove(0);
		repaint();
		return result;
	}

	/**
	 * Checks whether the queue is empty or not.
	 * @return	Whether or not the queue is empty.
	 */
	public boolean isEmpty() {
		return content.size() == 0;
	}

	/**
	 * Returns the number of elements in the queue.
	 * @return	The length of the queue.
	 */
	public int getQueueLength() {
		return content.size();
	}

	/**
	 * Paints the queue as a horizontal row of slots containing processes.
	 * This method assumes that the elements of the queue are Process objects.
	 * @param g	The graphics context to paint the queue in.
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int w = getWidth()-1;
		int h = getHeight()-1;
		g.setFont(font);
		FontMetrics fm = g.getFontMetrics(font);
		String heading = "Items in "+name+": "+content.size();
		switch(direction) {
		case EAST:
			g.setColor(Color.black);
			g.drawString(heading, w/2-fm.stringWidth(heading)/2, 15);
			for(int i = 0; i < maxVisibleLength; i++) {
				if(i < content.size()) {
					Process p = (Process)content.get(i);
					p.draw(g, w-(i+1)*w/(maxVisibleLength+1), 20, w/(maxVisibleLength+1), h-20);
				}
				else {
					g.setColor(Color.black);
					g.drawRect(w-(i+1)*w/(maxVisibleLength+1), 20, w/(maxVisibleLength+1), h-20);
				}
			}
			g.setColor(Color.red);
			g.drawLine(0,20,w,20);
			g.drawLine(w,20,w,h);
			g.drawLine(0,h,w,h);
			break;
		case WEST:
			g.setColor(Color.black);
			g.drawString(heading, w/2-fm.stringWidth(heading)/2, 15);
			for(int i = 0; i < maxVisibleLength; i++) {
				if(i < content.size()) {
					Process p = (Process)content.get(i);
					p.draw(g, i*w/(maxVisibleLength+1), 20, w/(maxVisibleLength+1), h-20);
				}
				else {
					g.setColor(Color.black);
					g.drawRect(i*w/(maxVisibleLength+1), 20, w/(maxVisibleLength+1), h-20);
				}
			}
			g.setColor(Color.red);
			g.drawLine(0,20,w,20);
			g.drawLine(0,20,0,h);
			g.drawLine(0,h,w,h);
			break;
		}
	}

    public ArrayList getList(){
        return this.content;
    }
}
