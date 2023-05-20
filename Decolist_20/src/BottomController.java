import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class BottomController implements ActionListener, KeyListener {
    private BottomView_1 bv;
    private int textCount, newLineCount, charCount;
    public BottomController () {
        bv = new BottomView_1();

        bv.getMessage().addKeyListener(this);
        bv.getNote().addKeyListener(this);
        bv.getRoomButton().addActionListener(this);
        bv.getGachaButton().addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(bv.getRoomButton())) {
            bv.setProgressPercent(bv.getProgressPercent() + 20);
        }
        else if (ae.getSource().equals(bv.getGachaButton())) {
            bv.setProgressPercent((bv.getProgressPercent() - 100));
        }
        bv.getProgressBar().setValue(bv.getProgressPercent());
    }

    public void keyTyped(KeyEvent ke) {
        if (ke.getKeyChar() == '\b') {
            if (newLineCount <= 0 || charCount > 0) {
                textCount --;
                if (charCount > 0) {
                    charCount --;
                }
            }
            else {
                newLineCount --;
            }
            if (textCount < 0) {
                textCount ++;
            }
            bv.getNote().setBorder(BorderFactory.createLineBorder(Color.black, 2));
            bv.getMessage().setForeground(Color.black);
        }
        else if (textCount >= 250) {
            bv.getNote().setBorder(BorderFactory.createLineBorder(Color.red, 2));
            bv.getMessage().setForeground(Color.red);
            ke.consume();
            return;
        }
        else if (ke.getKeyChar() == '\n' || ke.getKeyChar() == '\r') {
            newLineCount ++;
        }
        else {
            textCount ++;
            bv.getNote().setBorder(BorderFactory.createLineBorder(Color.black, 2));
            bv.getMessage().setForeground(Color.black);
            if (newLineCount > 0) {
                charCount ++;
            }
        }
        bv.getMessage().setText(" Message : " + textCount + "/250");
    }

    public void keyPressed(KeyEvent ke) {
        bv.getNote().setEditable(ke.getKeyCode() != KeyEvent.VK_ENTER || textCount < 250);
    }

    public void keyReleased(KeyEvent ke) {}
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {new BottomController();});
    }
}
