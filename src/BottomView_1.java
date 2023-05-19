import java.io.*;
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import javax.imageio.*;
import javax.swing.border.Border;

public class BottomView_1 {
    private Font thai;
    private JFrame fr;
    private JPanel split, areaZone, buttonZone, roomPanel, gachaPanel;
    private JLabel message;
    private JTextArea note;
    private File file;
    private CircularButton roomButton, gachaButton;
    private JProgressBar progressBar;
    private int progressPercent;
    public BottomView_1 () {
        thai = new Font("PK Samut Sakhon Medium", Font.PLAIN, 16);
        fr = new JFrame();
        split = new JPanel(new GridLayout(1, 2));
        areaZone = new JPanel(new BorderLayout());
        buttonZone = new JPanel(new GridLayout(5, 1));
        roomPanel = new JPanel(new GridLayout(1, 2));
        gachaPanel = new JPanel(new FlowLayout());
        message = new JLabel(" Message : 0/250");
        note = new JTextArea();
        roomButton = new CircularButton();
        progressBar = new JProgressBar();
        gachaButton = new CircularButton();

        message.setFont(thai);
        split.setPreferredSize(new Dimension(100, 250));
        note.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        note.setFont(thai);
        note.setLineWrap(true);
        note.setWrapStyleWord(true);
        try {
            file = new File("DecolistApp\\src\\room.png");
            roomButton.setButtonImage(ImageIO.read(file));
            file = new File("DecolistApp\\src\\gacha.png");
            gachaButton.setButtonImage(ImageIO.read(file));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        roomButton.setButtonSize(45);
        roomButton.setBorder(BorderFactory.createLineBorder(Color.white));
        progressBar.setMinimum(0);
        progressBar.setMaximum(100);
        progressBar.setStringPainted(true);
        gachaButton.setButtonSize(45);
        gachaButton.setBorder(BorderFactory.createLineBorder(Color.white));
        gachaButton.setEnabled(false);
        
        fr.add(split, BorderLayout.SOUTH);
        split.add(areaZone);
        split.add(buttonZone);
        areaZone.add(message, BorderLayout.NORTH);
        areaZone.add(new JScrollPane(note));
        roomPanel.add(new JPanel());
        JPanel newRoom = new JPanel(new FlowLayout());
        newRoom.add(roomButton);
        roomPanel.add(newRoom);
        buttonZone.add(new JPanel());
        buttonZone.add(roomPanel);
        buttonZone.add(new JPanel());
        gachaPanel.add(progressBar);
        gachaPanel.add(gachaButton);
        buttonZone.add(gachaPanel);

        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(500, 750);
        fr.setResizable(false);
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
    }

    public JLabel getMessage() {
        return message;
    }

    public JTextArea getNote() {
        return note;
    }

    public CircularButton getRoomButton() {
        return roomButton;
    }

    public CircularButton getGachaButton() {
        return gachaButton;
    }

    public void setProgressPercent(int progressPercent) {
        this.progressPercent = progressPercent;
        gachaButton.setEnabled(progressPercent >= 100);
    }

    public int getProgressPercent() {
        return progressPercent;
    }

    public JProgressBar getProgressBar() {
        return progressBar;
    }
}
