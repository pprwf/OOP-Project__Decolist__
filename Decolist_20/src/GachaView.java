import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GachaView implements ActionListener {
    private Random rand;
    private JFrame fr;
    private JLabel item, message;
    private JButton bt;
    private LinkedList<String> furniture, furnitureColor;
    public GachaView (RoomController room) {
        fr = new JFrame();
        rand = new Random();
        item = new JLabel();
        message = new JLabel();
        bt = new JButton("Okay.");
        furniture = new LinkedList(Arrays.asList("bed", "curtain", "poster", "table"));
        furnitureColor = new LinkedList(Arrays.asList("red", "green", "blue", "yellow"));
        if (room.getModel().getTable().furAccess) {
            furniture.add("computer");
        }
        
        randItem(room, room.getModel(), message, item, furniture, furnitureColor, 1, -1);
        item.setHorizontalAlignment(JLabel.CENTER);
        item.setVerticalAlignment(JLabel.CENTER);
        message.setFont(new BottomView().thai);
        message.setHorizontalAlignment(JLabel.CENTER);
        message.setVerticalAlignment(JLabel.CENTER);
        
        fr.add(item, BorderLayout.NORTH);
        fr.add(new JPanel().add(message));
        fr.add(new JPanel(new FlowLayout()).add(bt), BorderLayout.SOUTH);
        
        bt.addActionListener(this);
        
        fr.setResizable(false);
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fr.setSize(new Dimension(400, 300));
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
    }
    private void randItem (RoomController rc, RoomModel rm, JLabel message, JLabel pics, LinkedList<String> fur, LinkedList<String> furColor, int count, int furCheck) {
        int randColor = rand.nextInt(furColor.size());
        String capital = Character.toUpperCase(furColor.get(randColor).charAt(0)) + furColor.get(randColor).substring(1);
        if (fur.isEmpty()) {
            message.setText("Congratulation!!! You got all item!");
        }
        else {
            if (furCheck == -1) {
                furCheck = rand.nextInt(fur.size());
            }
            switch (furCheck) {
                case 0:
                    if (rm.getBed().getColorAccess()[0] && rm.getBed().getColorAccess()[1] &&
                            rm.getBed().getColorAccess()[2] && rm.getBed().getColorAccess()[3]) {
                        randItem(rc, rm, message, pics, fur, furColor, count + 1, -1);
                    }
                    else if (rm.getBed().furAccess) {
                        if (rm.getBed().getColorAccess()[randColor]) {
                            fur.remove("bed");
                            randItem(rc, rm, message, pics, fur, furColor, count + 1, 0);
                        }
                        else {
                            dialogShow(rc, pics, "bed", furColor.get(randColor));
                            message.setText("You got " + capital + " color for your Bed!");
                            System.out.println(count + " Attempt: " + capital + "\n--------------------");
                            return;
                        }
                    }
                    else {
                        dialogShow(rc, pics, "bed", "red");
                        message.setText("You got your first Bed!!");
                        System.out.println(count + " Attempt: " + capital + "\n--------------------");
                    }
                    return;
                case 1:
                    if (rm.getBed().getColorAccess()[0] && rm.getCertain().getColorAccess()[1] &&
                            rm.getCertain().getColorAccess()[2] && rm.getCertain().getColorAccess()[3]) {
                        fur.remove("curtain");
                        randItem(rc, rm, message, pics, fur, furColor, count + 1, -1);
                    }
                    else if (rm.getCertain().furAccess) {
                        if (rm.getCertain().getColorAccess()[randColor]) {
                            randItem(rc, rm, message, pics, fur, furColor, count + 1, 1);
                        }
                        else {
                            dialogShow(rc, pics, "curtain", furColor.get(randColor));
                            message.setText("You got " + capital + " color for your Curtain!");
                            System.out.println(count + " Attempt: " + capital + "\n--------------------");
                            return;
                        }
                    }
                    else {
                        dialogShow(rc, pics, "curtain", "red");
                        message.setText("You got your first Curtain!!");
                        System.out.println(count + " Attempt: " + capital + "\n--------------------");
                    }
                    return;
                case 2:
                    if (rm.getBed().getColorAccess()[0] && rm.getPoster().getColorAccess()[1] &&
                            rm.getPoster().getColorAccess()[2] && rm.getPoster().getColorAccess()[3]) {
                        fur.remove("poster");
                        randItem(rc, rm, message, pics, fur, furColor, count + 1, -1);
                    }
                    else if (rm.getPoster().furAccess) {
                        if (rm.getPoster().getColorAccess()[randColor]) {
                            randItem(rc, rm, message, pics, fur, furColor, count + 1, 2);
                        }
                        else {
                            dialogShow(rc, pics, "poster", furColor.get(randColor));
                            message.setText("You got " + capital + " color for your Poster!");
                            System.out.println(count + " Attempt: " + capital + "\n--------------------");
                            return;
                        }
                    }
                    else {
                        dialogShow(rc, pics, "poster", "red");
                        message.setText("You got your first Poster!!");
                        System.out.println(count + " Attempt: " + capital + "\n--------------------");
                    }
                    return;
                case 3:
                    if (rm.getBed().getColorAccess()[0] && rm.getTable().getColorAccess()[1] &&
                            rm.getTable().getColorAccess()[2] && rm.getTable().getColorAccess()[3]) {
                        fur.remove("table");
                        randItem(rc, rm, message, pics, fur, furColor, count + 1, -1);
                    }
                    else if (rm.getTable().furAccess) {
                        if (rm.getTable().getColorAccess()[randColor]) {
                            randItem(rc, rm, message, pics, fur, furColor, count + 1, 3);
                        }
                        else {
                            dialogShow(rc, pics, "table", furColor.get(randColor));
                            message.setText("You got " + capital + " color for your Table!");
                            System.out.println(count + " Attempt: " + capital + "\n--------------------");
                            return;
                        }
                    }
                    else {
                        dialogShow(rc, pics, "table", "red");
                        message.setText("You got your first Table!!");
                        System.out.println(count + " Attempt: " + capital + "\n--------------------");
                    }
                    return;
                default:
                    if (!rm.getTable().furAccess) {
                        randItem(rc, rm, message, pics, fur, furColor, count + 1, -1);
                    }
                    else if (rm.getBed().getColorAccess()[0] && rm.getComputer().getColorAccess()[1] &&
                            rm.getComputer().getColorAccess()[2] && rm.getComputer().getColorAccess()[3]) {
                        fur.remove("computer");
                        randItem(rc, rm, message, pics, fur, furColor, count + 1, -1);
                    }
                    else if (rm.getComputer().furAccess) {
                        if (rm.getComputer().getColorAccess()[randColor]) {
                            randItem(rc, rm, message, pics, fur, furColor, count + 1, 4);
                        }
                        else {
                            dialogShow(rc, pics, "computer", furColor.get(randColor));
                            message.setText("You got " + capital + " color for your Computer!");
                            System.out.println(count + " Attempt: " + capital + "\n--------------------");
                            return;
                        }
                    }
                    else {
                        dialogShow(rc, pics, "computer", "red");
                        message.setText("You got your first Computer!!");
                        System.out.println(count + " Attempt: " + capital + "\n--------------------");
                    }
                    return;
            }
        }
        
//        String[] fur = {"bed", "curtain", "poster", "table"};
//        String[] furColor = {"green", "blue", "yellow"};
//        int furIndex = rand.nextInt(fur.length);
//        int colIndex = rand.nextInt(furColor.length);
//        String furniture = fur[furIndex];
//        String myColor = furColor[colIndex];
//        boolean isNewColor =
//        switch (furniture) {
//            case "bed":
//                if (rm.getBed().furAccess) {
//                    while (rm.getBed().getColorAccess()[colIndex]) {
//                        colIndex = rand.nextInt(furColor.length);
//                        myColor = furColor[colIndex];
//                    }
//                    dialogShow(rm, rc, pics, "bed", myColor);
//                    String capital = Character.toUpperCase(myColor.charAt(0)) + myColor.substring(1);
//                    message.setText("You got " + capital + " color for your Bed!");
//                    return;
//                }
//                dialogShow(rm, rc, pics, "bed", "red");
//                message.setText("You got your first Bed!!");
//                break;
//            case "curtain":
//                if (rm.getCertain().furAccess) {
//                    while (rm.getCertain().getColorAccess()[colIndex]) {
//                        colIndex = rand.nextInt(furColor.length);
//                        myColor = furColor[colIndex];
//                    }
//                    dialogShow(rm, rc, pics, "curtain", myColor);
//                    String capital = Character.toUpperCase(myColor.charAt(0)) + myColor.substring(1);
//                    message.setText("You got " + capital + " color for your Curtain!");
//                    return;
//                }
//                dialogShow(rm, rc, pics, "curtain", "red");
//                message.setText("You got your first Curtain!!");
//                break;
//            case "table":
//                if (rm.getTable().furAccess) {
//                    if (rand.nextInt(2) == 1) {
//                        if (rm.getComputer().furAccess) {
//                            while (rm.getComputer().getColorAccess()[colIndex]) {
//                                colIndex = rand.nextInt(furColor.length);
//                                    myColor = furColor[colIndex];
//                            }
//                            dialogShow(rm, rc, pics, "computer", myColor);
//                            String capital = Character.toUpperCase(myColor.charAt(0)) + myColor.substring(1);
//                            message.setText("You got " + capital + " color for your Computer!");
//                            return;
//                        }
//                        dialogShow(rm, rc, pics, "computer", "red");
//                        message.setText("You got your first Computer!!");
//                        message.setText(message.getText() + "\n" + "You can interact with this item by clicking on the display screen");
//                        return;
//                    }
//                    while (rm.getTable().getColorAccess()[colIndex]) {
//                        colIndex = rand.nextInt(furColor.length);
//                        myColor = furColor[colIndex];
//                    }
//                    dialogShow(rm, rc, pics, "table", myColor);
//                    String capital = Character.toUpperCase(myColor.charAt(0)) + myColor.substring(1);
//                    message.setText("You got " + capital + " color for your Table!");
//                    return;
//                }
//                dialogShow(rm, rc, pics, "table", "red");
//                message.setText("You got your first Table!!");
//                break;
//            default:
//                if (rm.getPoster().furAccess) {
//                    while (rm.getCertain().getColorAccess()[colIndex]) {
//                        colIndex = rand.nextInt(furColor.length);
//                        myColor = furColor[colIndex];
//                    }
//                    dialogShow(rm, rc, pics, "poster", myColor);
//                    String capital = Character.toUpperCase(myColor.charAt(0)) + myColor.substring(1);
//                    message.setText("You got " + capital + " color for your Poster!");
//                    return;
//                }
//                dialogShow(rm, rc, pics, "poster", "red");
//                message.setText("You got your first Poster!!");
//                break;
//        }
    }
    private void dialogShow (RoomController rc, JLabel pics, String furniture, String color) {
        rc.furAllowAccess(furniture, color);
        String capital = Character.toUpperCase(color.charAt(0)) + color.substring(1);
        pics.setIcon(new ImageIcon("img/"+ furniture + capital + "Icon.png"));
    }

    public JFrame getFr() {
        return fr;
    }

    public JButton getBt() {
        return bt;
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(bt)) {
            fr.dispose();
        }
    }
}
