import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import javax.swing.*;

public class CircularButton extends JButton {
    private BufferedImage img;
    public CircularButton () {
        super();
        setBackground(Color.lightGray);
        Dimension size = getPreferredSize();
        size.width = size.height = Math.max(size.width, size.height);
        setPreferredSize(size);
        setContentAreaFilled(false);
    }
    protected void paintComponent (Graphics g) {
        g.setClip(new Ellipse2D.Double(0, 0, getWidth(), getHeight()));
        g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
        if (getModel().isArmed()) {
            g.setColor(new Color(127, 127, 127, 70));
            g.fillOval(0, 0, getWidth() - 1, getHeight() - 1);
        }
        super.paintComponent(g);
    }
    public void setButtonImage (BufferedImage bimg) {
        img = bimg;
        repaint();
    }
    public void setButtonSize(int size) {
        setPreferredSize(new Dimension(size, size));
        revalidate();
    }
}
