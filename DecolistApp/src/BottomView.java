import java.io.*;
import java.awt.*;
import javax.swing.*;
import javax.imageio.*;

public class BottomView extends JPanel {
    public Font thai;
    private JPanel areaZone, buttonZone, nonVisiblePanel, roomPanel, gachaPanel;
    private JLabel message;
    private JTextArea note;
    private JScrollPane scroll;
    private File file;
    private CircularButton roomButton, gachaButton;
    private JProgressBar progressBar;
    private int progressPercent;
    public BottomView () {
        setLayout(new GridLayout(1, 2));
        
        thai = new Font("Bai Jamjuree", Font.PLAIN, 16);
        areaZone = new JPanel(new FlowLayout());
        buttonZone = new JPanel(new GridLayout(5, 1));
        nonVisiblePanel = new JPanel();
        roomPanel = new JPanel(new FlowLayout());
        gachaPanel = new JPanel(new FlowLayout());
        message = new JLabel("Message : 0/250");
        note = new JTextArea();
        scroll = new JScrollPane(note);
        roomButton = new CircularButton();
        progressBar = new JProgressBar();
        gachaButton = new CircularButton();
        
        areaZone.setPreferredSize(new Dimension(245, 220));
        buttonZone.setPreferredSize(new Dimension(245, 220));
        message.setFont(thai);
        note.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        note.setFont(thai);
        note.setLineWrap(true);
        note.setWrapStyleWord(true);
        scroll.setPreferredSize(new Dimension(220, 175));
        try {
            file = new File("img/room_icon.png");
            roomButton.setButtonImage(ImageIO.read(file));
            file = new File("img/gacha.png");
            gachaButton.setButtonImage(ImageIO.read(file));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        nonVisiblePanel.setPreferredSize(new Dimension(progressBar.getPreferredSize().width, 14));
        roomButton.setButtonSize(65);
        roomButton.setBorder(BorderFactory.createLineBorder(Color.white));
        progressBar.setPreferredSize(new Dimension(progressBar.getPreferredSize().width, 14));
        progressBar.setMinimum(0);
        progressBar.setMaximum(100);
        progressBar.setStringPainted(true);
        gachaButton.setButtonSize(65);
        gachaButton.setBorder(BorderFactory.createLineBorder(Color.white));
        gachaButton.setEnabled(false);
        
        add(areaZone);
        add(buttonZone);
        areaZone.add(message);
        areaZone.add(scroll);
        roomPanel.add(nonVisiblePanel);
        roomPanel.add(roomButton);
        buttonZone.add(new JPanel());
        buttonZone.add(roomPanel);
        buttonZone.add(new JPanel());
        gachaPanel.add(progressBar);
        gachaPanel.add(gachaButton);
        buttonZone.add(gachaPanel);
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
