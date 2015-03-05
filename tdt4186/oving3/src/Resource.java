import java.util.*;
import javax.swing.*;
import java.awt.*;

/** 
 * Graphical component used to display a resource in a queuing network. The resource may
 * represent a CPU, memory, etc, and is displayed as a circle with a name. The resource
 * may also contain an active process.
 */
public class Resource extends JPanel {
	/** The name of the resource */
	private String name;
	/** The process that is currently using the resource */
	private Process activeProcess;
	/** The font used by all resources */
	private static Font font = new Font("Arial", Font.PLAIN, 18);

	/**
	 * Creates a new resource, with the given name.
	 * @param name	The name of the resource.
	 */
	public Resource(String name) {
		this.name = name;
		activeProcess = null;
		setBackground(Color.white);
	}

	/**
	 * Controls which process is being shown as currently using this resource.
	 * @param p	The process that is currently using the resource, or null if the resource is idle.
	 */
	public void setActiveProcess(Process p) {
		activeProcess = p;
		repaint();
	}

	/**
	 * Paints the resource as a circle with a name and a possible process inside.
	 * @param g	The graphics context to paint the resource in.
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int w = getWidth()-1;
		int h = getHeight()-1;
		g.setColor(Color.red);
		g.drawOval(0,0,w,h);
		g.setColor(Color.black);
		g.setFont(font);
		FontMetrics fm = g.getFontMetrics(font);
		g.drawString(name, w/2-fm.stringWidth(name)/2, h/2-10);
		if(activeProcess != null)
			activeProcess.draw(g, w/4, h/2, w/2, h/4);
		else
			g.drawString("(Idle)",w/2-fm.stringWidth("(Idle)")/2, 5*h/8+fm.getHeight()/2);
	}
}
