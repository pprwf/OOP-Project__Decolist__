import java.awt.event.*;
import javax.swing.SwingUtilities;

public class BottomController implements ActionListener, KeyListener {
    private BottomView bv;
    
    public BottomController () {
        bv = new BottomView();
        
        bv.getNote().addKeyListener(this);
        bv.getMessage().addKeyListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        
    }

    public void keyTyped(KeyEvent ke) {
        bv.getMessage().setText(" Message : " + (bv.getNote().getText().length()) + "/250");
        if (bv.getNote().getText().length() >= 250) {
            ke.consume();
        }
    }

    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent ke) {}
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {new BottomController();});
    }
}
