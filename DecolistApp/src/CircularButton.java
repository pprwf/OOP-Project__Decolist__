import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class CircularButton extends JButton {
    private Dimension size;
    public CircularButton (Icon icon) {
        super(icon);
        size = getPreferredSize();
        size.width = size.height = Math.max(size.width, size.height);
        setPreferredSize(size);
        setContentAreaFilled(false);
    }
    protected void paintComponent (Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.gray);
        }
        else {
            g.setColor(getBackground());
        }
        g.fillOval(0, 0, getSize().width, getSize().height);
    }
    protected void paintBorder (Graphics g) {
        int diameter = Math.min(getWidth(), getHeight()) - 1;
        g.setColor(getForeground());
        g.fillOval((getWidth() - diameter) / 2, (getHeight()- diameter) / 2, diameter, diameter);
    }
}
