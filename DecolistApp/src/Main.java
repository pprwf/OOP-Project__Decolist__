import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
//    public void windowOpened(WindowEvent we) {
//        if (new File ("ProgressStatus.dat").exists()) {
//            System.out.println("Exist");
//            try (FileInputStream fr = new FileInputStream("ProgressStatus.dat");) {
//                int st = fr.read();
//                bv.setProgressPercent(st);
//                System.out.println("Load");
//            }
//            catch (Exception e) {
//                System.out.println(e);
//            }
//        }
//    }
//
//    public void windowClosing(WindowEvent we) {
//        try (FileOutputStream fw = new FileOutputStream("ProgressStatus.dat");) {
//            fw.write(bc.getProgressPercent());
//            System.out.println("Saving");
//        }
//        catch (Exception e) {
//            System.out.println(e);
//        }
//    }

    public void windowClosed(WindowEvent e) {}

    public void windowIconified(WindowEvent e) {}

    public void windowDeiconified(WindowEvent e) {}

    public void windowActivated(WindowEvent e) {}

    public void windowDeactivated(WindowEvent e) {}
}
