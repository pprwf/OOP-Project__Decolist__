import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GachaView implements ActionListener {
    private Random rand;
    private JFrame fr;
    private JLabel item, message;
    private LinkedList<String> fur, furColor;
    private JButton bt;
    private int count;
    private Font font;
    public GachaView (RoomController room) {
        fr = new JFrame();
        rand = new Random();
        item = new JLabel();
        message = new JLabel();
        count = 0;
        fur = new LinkedList(Arrays.asList("bed", "curtain", "poster", "table"));
        furColor = new LinkedList(Arrays.asList("green", "blue", "yellow"));
        if (room.getModel().getTable().furAccess) {
            fur.add("computer");
        }
        bt = new JButton("Okay.");
        font = new ThaiFont().thBold.deriveFont(20f);
        
        randItem(room, room.getModel(), message, item, fur, furColor, count, -1);
        item.setHorizontalAlignment(JLabel.CENTER);
        item.setVerticalAlignment(JLabel.CENTER);
        message.setHorizontalAlignment(JLabel.CENTER);
        message.setVerticalAlignment(JLabel.CENTER);
        message.setFont(font);
        
        fr.add(item, BorderLayout.NORTH);
        fr.add(new JPanel().add(message));
        fr.add(bt, BorderLayout.SOUTH);
        
        bt.addActionListener(this);
        
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fr.setSize(new Dimension(400, 300));
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
    }
    private void randItem (RoomController rc, RoomModel rm, JLabel message, JLabel pics,
            LinkedList<String> fur, LinkedList<String> furColor, int counting, int furCheck) {
        Furniture furItem;
        int randColor = rand.nextInt(furColor.size());
        String capital = Character.toUpperCase(furColor.get(randColor).charAt(0)) + furColor.get(randColor).substring(1);
        boolean con1,con2,con3,con4,con5;
        con1 = (rm.getBed().getColorAccess()[0]& rm.getBed().getColorAccess()[1]& rm.getBed().getColorAccess()[2]& rm.getBed().getColorAccess()[3]);
        con2 = (rm.getTable().getColorAccess()[0]& rm.getTable().getColorAccess()[1]& rm.getTable().getColorAccess()[2]& rm.getTable().getColorAccess()[3]);
        con3 = (rm.getComputer().getColorAccess()[0]& rm.getComputer().getColorAccess()[1]& rm.getComputer().getColorAccess()[2]& rm.getComputer().getColorAccess()[3]);
        con4 = (rm.getCertain().getColorAccess()[0]& rm.getCertain().getColorAccess()[1]& rm.getCertain().getColorAccess()[2]& rm.getCertain().getColorAccess()[3]);
        con5 = (rm.getPoster().getColorAccess()[0]& rm.getPoster().getColorAccess()[1]& rm.getPoster().getColorAccess()[2]& rm.getPoster().getColorAccess()[3]);
        if (counting >= 5 && con1 && con2 && con3 && con4 && con5) {
            message.setText("Congratulation!! You got all Item!");
        }
        else {
            if (furCheck == -1) {
                furCheck = rand.nextInt(fur.size());
            }
            switch (furCheck) {
                case 0 -> {
                    furItem = rm.getBed();
                    if (furItem.getColorAccess()[0] && furItem.getColorAccess()[1] && furItem.getColorAccess()[2] && furItem.getColorAccess()[3]) {
                        count += 1;
                        randItem(rc, rm, message, pics, fur, furColor, count,  -1);
                    }
                    else if (furItem.furAccess) {
                        if (furItem.getColorAccess()[randColor + 1]) {
                            randItem(rc, rm, message, pics, fur, furColor, count, 0);
                        }
                        else {
                            dialogShow(rc, pics, "bed", furColor.get(randColor));
                            message.setText("You got " + capital + " color for your Bed!");
                        }
                    }
                    else {
                        dialogShow(rc, pics, "bed", "red");
                        message.setText("You got your first Bed!!");
                    }
                }
                case 1 -> {
                    furItem = rm.getCertain();
                    if (furItem.getColorAccess()[0] && furItem.getColorAccess()[1] && furItem.getColorAccess()[2] && furItem.getColorAccess()[3]) {
                        count += 1;
                        randItem(rc, rm, message, pics, fur, furColor, count, -1);
                    }
                    else if (furItem.furAccess) {
                        if (furItem.getColorAccess()[randColor + 1]) {
                            randItem(rc, rm, message, pics, fur, furColor, count, 1);
                        }
                        else {
                            dialogShow(rc, pics, "curtain", furColor.get(randColor));
                            message.setText("You got " + capital + " color for your Curtain!");
                        }
                    }
                    else {
                        dialogShow(rc, pics, "curtain", "red");
                        message.setText("You got your first Curtain!!");
                    }
                }
                case 2 -> {
                    furItem = rm.getPoster();
                    if (furItem.getColorAccess()[0] && furItem.getColorAccess()[1] && furItem.getColorAccess()[2] && furItem.getColorAccess()[3]) {
                        count += 1;
                        randItem(rc, rm, message, pics, fur, furColor, count, -1);
                    }
                    else if (furItem.furAccess) {
                        if (furItem.getColorAccess()[randColor + 1]) {
                            randItem(rc, rm, message, pics, fur, furColor, count, 2);
                        }
                        else {
                            dialogShow(rc, pics, "poster", furColor.get(randColor));
                            message.setText("You got " + capital + " color for your Poster!");
                        }
                    }
                    else {
                        dialogShow(rc, pics, "poster", "red");
                        message.setText("You got your first Poster!!");
                    }
                }
                case 3 -> {
                    furItem = rm.getTable();
                    if (furItem.getColorAccess()[0] && furItem.getColorAccess()[1] && furItem.getColorAccess()[2] && furItem.getColorAccess()[3]) {
                        count += 1;
                        randItem(rc, rm, message, pics, fur, furColor, count, -1);
                    }
                    else if (furItem.furAccess) {
                        if (furItem.getColorAccess()[randColor + 1]) {
                            randItem(rc, rm, message, pics, fur, furColor, count, 3);
                        }
                        else {
                            dialogShow(rc, pics, "table", furColor.get(randColor));
                            message.setText("You got " + capital + " color for your Table!");
                        }
                    }
                    else {
                        dialogShow(rc, pics, "table", "red");
                        message.setText("You got your first Table!!");
                    }
                }
                case 4 -> {
                    furItem = rm.getComputer();
                    if (!rm.getTable().furAccess) {
                        randItem(rc, rm, message, pics, fur, furColor, count, -1);
                    }   if (furItem.getColorAccess()[0] && furItem.getColorAccess()[1] &&
                            furItem.getColorAccess()[2] && furItem.getColorAccess()[3]) {
                        count += 1;
                        randItem(rc, rm, message, pics, fur, furColor, count, -1);
                    }
                    else if (furItem.furAccess) {
                        if (furItem.getColorAccess()[randColor + 1]) {
                            randItem(rc, rm, message, pics, fur, furColor, count, 4);
                        }
                        else {
                            dialogShow(rc, pics, "computer", furColor.get(randColor));
                            message.setText("You got " + capital + " color for your Computer!");
                        }
                    }
                    else {
                        dialogShow(rc, pics, "computer", "red");
                        message.setText("You got your first Computer!!");
                    }
                }
                default -> {
                }
            }
        }
    }
    private void dialogShow (RoomController rc, JLabel pics, String furniture, String color) {
        String capital = Character.toUpperCase(color.charAt(0)) + color.substring(1);
        rc.furAllowAccess(furniture, color);
        pics.setIcon(new ImageIcon("resource/img/"+ furniture + capital + "Icon.png"));
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(bt)) {
            fr.dispose();
        }
    }
}
