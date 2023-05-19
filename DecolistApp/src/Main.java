import java.awt.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame fr = new JFrame();
        BottomController bc = new BottomController();
        fr.add(new JPanel(), BorderLayout.NORTH);
        fr.add(new JPanel());
        fr.add(bc, BorderLayout.SOUTH);
        
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(500, 750);
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
    }
}
