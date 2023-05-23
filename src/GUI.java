import java.awt.*;
import javax.swing.*;

public class GUI {
    private JFrame fr;
    private JDesktopPane desk;
    private JInternalFrame in;
    public GUI () {
        fr = new JFrame("Decolist");
        desk = new JDesktopPane();
        
        desk.setBackground(new Color(255, 253, 244));
        fr.add(desk);
        
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setBounds(500, 60, 500, 750);
        fr.setVisible(true);
    }
}
