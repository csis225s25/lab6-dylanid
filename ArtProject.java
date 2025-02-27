import java.awt.*;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

import org.w3c.dom.css.Rect;

/**
 * Art project
 * 
 * @author Jim Teresco
 * @author Ira Goldstein
 * @author Dylan I, Max W
 * @version Spring 2025
 */

// a class that extends JPanel to override the paintComponent method,
// allowing us to interact with Java's graphics system
class GraphicsPanels extends JPanel {

    @Override
    public void paintComponent(Graphics g) {

        // first, we should call the paintComponent method we are
        // overriding in JPanel
        super.paintComponent(g);

        int widthCenter = + super.getWidth()/2;
        int heightCenter = + super.getHeight()/2;

        int[] xPointsRoof = {widthCenter - 100, widthCenter, widthCenter + 100};
        int[] yPointsRoof = {heightCenter, heightCenter - 100, heightCenter};
        Polygon polygon = new Polygon(xPointsRoof, yPointsRoof, 3);
        g.setColor(new Color(255,0,0));
        g.fillPolygon(polygon);
        g.setColor(new Color(0,0,0));
        g.drawPolygon(polygon);
        

        int[] xPointsBase = {widthCenter - 100, widthCenter + 100, widthCenter + 100, widthCenter - 100};
        int[] yPointsBase = {heightCenter,  heightCenter, heightCenter + 100, heightCenter + 100};
        polygon = new Polygon(xPointsBase, yPointsBase, 4);
        g.setColor(Color.YELLOW);
        g.fillPolygon(polygon);

        g.setColor(new Color(0,0,0));
        g.drawRect(widthCenter - 100, heightCenter, 200, 100);

        int[] xPointsDoor = {widthCenter - 20, widthCenter + 20, widthCenter + 20, widthCenter - 20};
        int[] yPointsDoor = {heightCenter + 100,  heightCenter + 100, heightCenter + 40, heightCenter + 40};
        polygon = new Polygon(xPointsDoor, yPointsDoor, 4);
        g.setColor(new Color(139,69,19));
        g.fillPolygon(polygon);

        g.setColor(new Color(0,0,0));
        g.drawPolygon(polygon);

        g.drawOval(widthCenter + 3, heightCenter + 72, 10, 10);
        g.fillOval(widthCenter + 3, heightCenter + 72, 10, 10);

        


    }
}

public class ArtProject implements Runnable {

    /**
     * The run method to set up the graphical user interface
     */
    @Override
    public void run() {

        // the usual JFrame setup steps
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("HelloGraphics");
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // construct JPanel with a custom paintComponent method
        JPanel panel = new GraphicsPanels();
        frame.add(panel);

        // display the window we've created
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        javax.swing.SwingUtilities.invokeLater(new ArtProject());
    }
}
