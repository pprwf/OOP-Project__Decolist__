import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class Middle_View extends JPanel{
    public static final Color BG_COLOR = new Color(254, 255, 210);
    public Middle_View() {
//        setLayout(new GridLayout(10, 1));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setOpaque(true);
        this.setBackground(BG_COLOR);
        this.setBorder(new EmptyBorder(5, 15, 5, 15));
    }
    
}
