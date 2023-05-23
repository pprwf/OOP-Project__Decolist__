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
        item = new JLabel();
        message = new JLabel();
        
        randItem(room, room.getModel(), message, item);
        item.setHorizontalAlignment(JLabel.CENTER);
        item.setVerticalAlignment(JLabel.CENTER);
        //message.setFont(new BottomView().thai);
        message.setHorizontalAlignment(JLabel.CENTER);
        message.setVerticalAlignment(JLabel.CENTER);
        
        fr.add(item, BorderLayout.NORTH);
        fr.add(new JPanel().add(message));
        
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fr.setSize(new Dimension(400, 250));
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
    }
    private void randItem (RoomController rc, RoomModel rm, JLabel message, JLabel pics) {
        String myColor = randColor();
        String capital = Character.toUpperCase(myColor.charAt(0)) + myColor.substring(1);
        switch (rand.nextInt(4)) {
            case 0:
                if (rm.getBed().furAccess) {
                    dialogShow(rm, rc, pics, "bed", myColor);
                    message.setText("You got " + capital + " color for your Bed!");
                }
                else {
                    dialogShow(rm, rc, pics, "bed", "red");
                    message.setText("You got your first Bed!!");
                }
                break;
            case 1:
                if (rm.getCertain().furAccess) {
                    dialogShow(rm, rc, pics, "certain", myColor);
                    message.setText("You got " + capital + " color for your Curtain!");
                }
                else {
                    dialogShow(rm, rc, pics, "certain", "red");
                    message.setText("You got your first Curtain!!");
                }
                break;
            case 2:
                if (rm.getTable().furAccess) {
                    if (rand.nextInt(2) == 0) {
                        if (rm.getComputer().furAccess) {
                            dialogShow(rm, rc, pics, "computer", myColor);
                            message.setText("You got " + capital + " color for your Computer!");
                        }
                        else {
                            dialogShow(rm, rc, pics, "computer", "first");
                            message.setText("You got your first Computer!!");
                        }
                        return;
                    }
                    dialogShow(rm, rc, pics, "table", myColor);
                    message.setText("You got " + capital + " color for your Table!");
                }
                else {
                    dialogShow(rm, rc, pics, "table", "red");
                    message.setText("You got your first Table!!");
                }
                break;
            default:
                if (rm.getPoster().furAccess) {
                    dialogShow(rm, rc, pics, "poster", myColor);
                    message.setText("You got " + capital + " color for your Poster!");
                }
                else {
                    dialogShow(rm, rc, pics, "poster", "red");
                    message.setText("You got your first Poster!!");
                }
        }
    }
    private String randColor () {
        switch (rand.nextInt(3)) {
            case 1:
                return "green";
            case 2:
                return "blue";
            default:
                return "yellow";
        }
    }
    private void dialogShow (RoomModel rm, RoomController rc, JLabel pics, String furniture, String color) {
        Furniture fur;
        fur = null;
        boolean gCol = fur.getColorAccess()[1];
        boolean bCol = fur.getColorAccess()[2];
        boolean yCol = fur.getColorAccess()[3];
        switch (furniture) {
            case "bed":
                fur = rm.getBed();
                if (gCol && bCol && yCol) {
                    randItem(rc, rm, message, item);
                }
                else {
                    switch (color) {
                        case "green":
                            color = randColor();
                            break;
                        default:
                            throw new AssertionError();
                    }
                }
                break;
            case "certain":
                break;
            case "computer":
                break;
            case "table":
                break;
            default:
                break;
        }
        String capital = Character.toUpperCase(color.charAt(0)) + color.substring(1);
        rc.furAllowAccess(furniture, color);
        if (color == "first") {
            color = "red";
        }
        else if (furniture == "certain") {
            furniture = "curtain";
        }
        pics.setIcon(new ImageIcon("img/"+ furniture + capital + "Icon.png"));
    }
}
