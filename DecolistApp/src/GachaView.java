import java.awt.*;
import java.util.*;
import javax.swing.*;

public class GachaView {
    private Random rand;
    private RoomModel model;
    private RoomController room;
    private JFrame fr;
    private JLabel item;
    private JOptionPane dialog;
    public GachaView () {
        fr = new JFrame();
        rand = new Random();
        model = new RoomModel();
        room = new RoomController();
        item = new JLabel();
        
        randItem(room, model, item);
        item.setFont(new BottomView().thai);
        
        fr.add(item);
        
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fr.pack();
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
    }
    private void randItem (RoomController rc, RoomModel rm, JLabel message) {
        String myColor = randColor();
        switch (rand.nextInt(4)) {
            case 0:
                if (rm.getBed().furAccess) {
                    rc.furAllowAccess("bed", myColor);
                    message.setText("You got " + Character.toUpperCase(myColor.charAt(0)) + myColor.substring(1) +
                            " color for your Bed!");
                }
                else {
                    rc.furAllowAccess("bed", "red");
                    message.setText("You got your first Bed!!");
                }
                break;
            case 1:
                if (rm.getCertain().furAccess) {
                    rc.furAllowAccess("certain", myColor);
                    message.setText("You got " + Character.toUpperCase(myColor.charAt(0)) + myColor.substring(1) +
                            " color for your Curtain!");
                }
                else {
                    rc.furAllowAccess("certain", "red");
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
                            message.setText("You got " + Character.toUpperCase(myColor.charAt(0)) + myColor.substring(1) +
                                    " color for your Computer!");
                        }
                        else {
                            rc.furAllowAccess("computer", "red");
                            message.setText("You got your first Computer!!");
                        }
                        return;
                    }
                    rc.furAllowAccess("table", myColor);
                    message.setText("You got " + Character.toUpperCase(myColor.charAt(0)) + myColor.substring(1) +
                            " color for your Table!");
                }
                else {
                    rc.furAllowAccess("table", "red");
                    message.setText("You got your first Table!!");
                }
                break;
            default:
                if (rm.getPoster().furAccess) {
                    rc.furAllowAccess("poster", myColor);
                    message.setText("You got " + Character.toUpperCase(myColor.charAt(0)) + myColor.substring(1) +
                            " color for your Poster!");
                }
                else {
                    rc.furAllowAccess("poster", "red");
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
