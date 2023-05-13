
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;


public class NewFrameAddTask extends GUIMenu {
    private JInternalFrame inf;
    private JDesktopPane dp;
    
    public NewFrameAddTask() {
        dp = new JDesktopPane();
        inf = new JInternalFrame("Add To do List",true,true,true,true);
        inf.setSize(300,300);
        inf.setDefaultCloseOperation(JInternalFrame.EXIT_ON_CLOSE);
        inf.setLocation(100, 100);
        inf.setVisible(true);
        frame1.setSize(500, 500);
        dp.add(inf);
        frame1.add(dp);
        frame1.setVisible(true);
    }
}
