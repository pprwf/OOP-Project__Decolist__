import java.awt.*;
import java.util.*;
import javax.swing.*;

public class GachaView {
    private Random rand;
    private JFrame fr;
    private JLabel item, message;
    private JOptionPane dialog;
    public GachaView (RoomController room) {
        fr = new JFrame();
        rand = new Random();
<<<<<<< HEAD
=======
        this.room = room;
        model = this.room.getModel();
>>>>>>> 2b67c472d06fd1f5ac71092676ccd4f56f48d433
        item = new JLabel();
        message = new JLabel();
        
        fr.setLayout(new FlowLayout());
        randItem(room, room.getModel(), message, item);
        item.setSize(new Dimension(200, 100));
        message.setFont(new BottomView().thai);
        message.setSize(new Dimension(500, 100));
        
        fr.add(item);
        fr.add(message);
        
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fr.setSize(new Dimension(500, 200));
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
    }
    private void randItem (RoomController rc, RoomModel rm, JLabel message, JLabel pics) {
        String myColor = randColor();
        String capital = Character.toUpperCase(myColor.charAt(0)) + myColor.substring(1);
        switch (rand.nextInt(4)) {
            case 0:
                if (rm.getBed().furAccess) {
                    rc.furAllowAccess("bed", myColor);
                    message.setText("You got " + capital + " color for your Bed!");
                }
                else {
                    rc.furAllowAccess("bed", "red");
                    pics.setIcon(new ImageIcon("img/bedRed.png"));
                    message.setText("You got your first Bed!!");
                }
                break;
            case 1:
                if (rm.getCertain().furAccess) {
                    rc.furAllowAccess("certain", myColor);
                    message.setText("You got " + capital + " color for your Curtain!");
                }
                else {
                    rc.furAllowAccess("certain", "red");
                    pics.setIcon(new ImageIcon("img/certainRed.png"));
                    message.setText("You got your first Curtain!!");
                }
                break;
            case 2:
                if (rm.getTable().furAccess) {
                    rc.furAllowAccess("table", myColor);
                    if (rand.nextInt(2) == 2) {
                        rc.furAllowAccess("computer", myColor);
                        if (rm.getComputer().furAccess) {
                            rc.furAllowAccess("computer", myColor);
                            message.setText("You got " + capital + " color for your Computer!");
                        }
                        else {
                            rc.furAllowAccess("computer", "red");
                            pics.setIcon(new ImageIcon("img/computerRed.png"));
                            message.setText("You got your first Computer!!");
                        }
                        return;
                    }
                    rc.furAllowAccess("table", myColor);
                    message.setText("You got " + capital + " color for your Table!");
                }
                else {
                    rc.furAllowAccess("table", "red");
                    pics.setIcon(new ImageIcon("img/tableRed.png"));
                    message.setText("You got your first Table!!");
                }
                break;
            default:
                if (rm.getPoster().furAccess) {
                    rc.furAllowAccess("poster", myColor);
                    message.setText("You got " + capital + " color for your Poster!");
                }
                else {
                    rc.furAllowAccess("poster", "red");
                    pics.setIcon(new ImageIcon("img/posterRed.png"));
                    message.setText("You got your first Poster!!");
                }
                break;
        }
    }
    private String randColor () {
        switch (rand.nextInt(4)) {
            case 0:
                return "red";
            case 1:
                return "green";
            case 2:
                return "blue";
            default:
                return "yellow";
        }
    }
}
