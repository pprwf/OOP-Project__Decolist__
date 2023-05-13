
import javax.swing.*;
//import java.awt.*;

public class AddTask {
    private JFrame frame1;
    private JDesktopPane d;
    private JInternalFrame nf;
    private JButton bt1;
    
    public AddTask() {
        bt1 = new JButton("+Add Task");
        d = new JDesktopPane();
        nf = new JInternalFrame("Add To do List",true,true,true,true);
        nf.setSize(300,300);
        nf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        nf.setLocation(100, 100);
        nf.setVisible(true);
        frame1.setSize(300, 300);
        d.add(nf);
        frame1.add(d);
        frame1.setVisible(true);
    }
}


	

