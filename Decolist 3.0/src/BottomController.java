import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BottomController extends JPanel implements ActionListener, KeyListener {
    private BottomView bv;
    private RoomController rc;
    GUIController gCon;
    private int textCount, newLineCount, charCount;
    public BottomController (GUIController gui) {
        setPreferredSize(new Dimension(500, 230));
        setBackground(new Color(250, 229, 172));
        setOpaque(true);
        
        bv = new BottomView() {};
        rc = new RoomController();
        gCon = gui;
        
        add(bv);

        bv.getMessage().addKeyListener(this);
        bv.getNote().addKeyListener(this);
        bv.getRoomButton().addActionListener(this);
        bv.getGachaButton().addActionListener(this);
    }
    public void saveBottomValue () {
        int num = bv.getProgressPercent();
        try (FileOutputStream fw = new FileOutputStream(new File("resource/datFile/percent.dat"));) {
            fw.write(num);
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        try (FileOutputStream fw = new FileOutputStream(new File("resource/datFile/note.dat"));) {
            for (int st = 0; st < bv.getNote().getText().length(); st++) {
                fw.write(bv.getNote().getText().charAt(st));
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void loadBottomValue(){
        int num = 0;
        File f = new File("resource/datFile/percent.dat");
        if (f.exists()) {
            try(FileInputStream fin = new FileInputStream(f);){
                num = fin.read();
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
        f = new File("resource/datFile/note.dat");
        if (f.exists()) {
            try(FileInputStream fr = new FileInputStream(f);){
                int st = fr.read();
                while (st != -1) {
                    bv.getNote().setText(bv.getNote().getText() + (char) st);
                    st = fr.read();
                }
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
        bv.setProgressPercent(num);
        bv.getProgressBar().setValue(num);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(bv.getRoomButton())) {
            rc.getView().getFr().setVisible(true);
        }
        else if (ae.getSource().equals(bv.getGachaButton())) {
            bv.setProgressPercent((bv.getProgressPercent() - 100));
            gCon.getMiddle_Con().refresh();
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
        bv.getMessage().setText(" Message : " + textCount + " / 250 ");
    }

    public void keyPressed(KeyEvent ke) {
        bv.getNote().setEditable(ke.getKeyCode() != KeyEvent.VK_ENTER || textCount < 250);
    }

    public void keyReleased(KeyEvent ke) {}

    public BottomView getBv() {
        return bv;
    }
}
