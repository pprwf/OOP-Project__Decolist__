import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;

public class BottomView {
    private Font thai;
    private JFrame fr;
    private JPanel p_split, p_area, p_button, p_room, p_gacha;
    private JLabel message;
    private JTextArea note;
    private CircularButton b_room, gacha;
    private ImageIcon rm, gc;
    public BottomView () {
        thai = new Font("PK Samut Sakhon Medium", Font.PLAIN, 16);
        fr = new JFrame();
        p_split = new JPanel(new GridLayout(1, 2));
        p_area = new JPanel(new BorderLayout());
        p_button = new JPanel(new GridLayout(2, 1));
        p_room = new JPanel(new BorderLayout());
        p_gacha = new JPanel(new BorderLayout());
        message = new JLabel(" Message : 0/250");
        note = new JTextArea();
        rm = new ImageIcon(getClass().getResource("room.png"));
        b_room = new CircularButton(new ImageIcon(rm.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
//        gacha = new JButton("Gacha");
        
        message.setFont(thai);
        p_split.setPreferredSize(new Dimension(100, 250));
        note.setBorder(BorderFactory.createLineBorder(Color.black));
        note.setFont(thai);
        note.setLineWrap(true);
        note.setWrapStyleWord(true);
//        b_room.setPreferredSize(new Dimension(50, 5));
        
        fr.add(p_split, BorderLayout.SOUTH);
        p_split.add(p_area);
        p_split.add(p_button);
        p_area.add(message, BorderLayout.NORTH);
        p_area.add(new JScrollPane(note));
        p_room.add(b_room, BorderLayout.EAST);
//        p_gacha.add(gacha, BorderLayout.EAST);
        p_button.add(p_room);
        p_button.add(p_gacha);
        
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(500, 750);
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
    }

    public JTextArea getNote() {
        return note;
    }

    public JLabel getMessage() {
        return message;
    }
}
