import java.io.*;
import java.awt.*;
import javax.swing.*;
import javax.imageio.*;

public class BottomView extends JPanel {
    public Font thai;
    private JPanel areaZone, buttonZone, nonVisiblePanel, roomPanel, gachaPanel, blankPanel;
    private JLabel message;
    private JTextArea note;
    private JScrollPane scroll;
    private File file;
    private CircularButton roomButton, gachaButton;
    private JProgressBar progressBar;
    private int progressPercent;
    public BottomView () {
        setLayout(new GridLayout(1, 2));
        setOpaque(false);
        
        thai = new ThaiFont().thBold.deriveFont(20f);
        areaZone = new JPanel(new FlowLayout());
        buttonZone = new JPanel(new GridLayout(3, 1));
        nonVisiblePanel = new JPanel();
        roomPanel = new JPanel(new FlowLayout());
        gachaPanel = new JPanel(new FlowLayout());
        message = new JLabel("Message : 0 / 250 ");
        note = new JTextArea();
        scroll = new JScrollPane(note);
        roomButton = new CircularButton();
        progressBar = new JProgressBar();
        gachaButton = new CircularButton();
        blankPanel = new JPanel();
        
        areaZone.setPreferredSize(new Dimension(245, 230));
        areaZone.setOpaque(false);
        buttonZone.setPreferredSize(new Dimension(245, 200));
        buttonZone.setOpaque(false);
        message.setFont(thai);
        note.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        note.setFont(thai);
        note.setLineWrap(true);
        note.setWrapStyleWord(true);
        scroll.setPreferredSize(new Dimension(210, 170));
        try {
            file = new File("resource/img/room_icon.png");
            roomButton.setButtonImage(ImageIO.read(file));
            file = new File("resource/img/gacha.png");
            gachaButton.setButtonImage(ImageIO.read(file));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        nonVisiblePanel.setPreferredSize(new Dimension(progressBar.getPreferredSize().width, 14));
        nonVisiblePanel.setOpaque(false);
        roomButton.setButtonSize(65);
        roomButton.setBorder(BorderFactory.createLineBorder(Color.white));
        roomPanel.setOpaque(false);
        progressBar.setPreferredSize(new Dimension(progressBar.getPreferredSize().width, 14));
        progressBar.setMinimum(0);
        progressBar.setMaximum(100);
        progressBar.setStringPainted(true);
        progressBar.setForeground(new Color(63, 255, 89));
        gachaButton.setButtonSize(65);
        gachaButton.setBorder(BorderFactory.createLineBorder(Color.white));
        gachaButton.setEnabled(false);
        gachaPanel.setOpaque(false);
        blankPanel.setOpaque(false);
        
        add(areaZone);
        add(buttonZone);
        areaZone.add(message);
        areaZone.add(scroll);
        roomPanel.add(nonVisiblePanel);
        roomPanel.add(roomButton);
        buttonZone.add(blankPanel);
        buttonZone.add(roomPanel);
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
