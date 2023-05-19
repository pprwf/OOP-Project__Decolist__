import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BottomController extends JPanel implements ActionListener, KeyListener {
    private BottomView bv;
    private RoomController rc;
    private int textCount, newLineCount, charCount;
    public BottomController () {
        setPreferredSize(new Dimension(495, 220));
        bv = new BottomView();
        rc = new RoomController();
        
        add(bv);

        bv.getMessage().addKeyListener(this);
        bv.getNote().addKeyListener(this);
        bv.getRoomButton().addActionListener(this);
        bv.getGachaButton().addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(bv.getRoomButton())) {
            if (bv.getProgressPercent() < 100) {
                bv.setProgressPercent(bv.getProgressPercent() + 20);
            }
            rc.getView().getFr().setVisible(true);
        }
        else if (ae.getSource().equals(bv.getGachaButton())) {
            bv.setProgressPercent((bv.getProgressPercent() - 100));
            new GachaView(rc);
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
            bv.getNote().setBorder(BorderFactory.createLineBorder(Color.black, 1));
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
            bv.getNote().setBorder(BorderFactory.createLineBorder(Color.black, 1));
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

    public BottomView getBv() {
        return bv;
    }
}
