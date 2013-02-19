import java.awt.*;
import java.awt.geom.Line2D;
import javax.swing.*;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class Grid extends JPanel {

    JTextField[][] cells;
    int[][] values;

    public Grid(int[][] values) {
        this.values = values;
        initComponent();
    }

    public void initComponent() {

        GridBagConstraints c = new GridBagConstraints();
        GridLayout layout = new GridLayout(9,9);
        cells = new JTextField[9][9];
        layout.setHgap(0);
        layout.setVgap(0);

        this.setBackground(Color.LIGHT_GRAY);
        this.setPreferredSize(new Dimension(450, 450));
        this.setLayout(layout);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                String s = String.valueOf(values[i][j]);
                cells[i][j] = new JTextField(s);
                cells[i][j].setEditable(false);
                cells[i][j].setOpaque(false);
                this.add(cells[i][j], c);
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {

        //parent component must always be called.
        super.paintComponent(g);
        //casting so that swing packages can be utilized as well.
        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(7));

        g2.drawLine(142, 0, 142, 409);
        g2.drawLine(289,0,289,409);
        g2.drawLine(0,142,437,142);  //horizontal
        g2.drawLine(0,280,437,280);  //horizontal

        g2.setStroke(new BasicStroke(1));
    }
}