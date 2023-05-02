import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
// class for controll room display space
public class RoomController1 extends JPanel{
    public static Image bedRed_icon;
    private RoomView view;
    private Image roomImg;
    private Image bedRed;
    //private int roomWide,roomHight;
    
    public RoomController1(){
//        roomWide = 400;
//        roomHight = 500;
//        this.setPreferredSize(new Dimension(roomWide, roomHight));
this.setPreferredSize(new Dimension(400, 500));
        view = new RoomView(this);
        try{
            roomImg = ImageIO.read(new File("room.png"));
            bedRed = ImageIO.read(new File("bedRed.png"));
            bedRed_icon = ImageIO.read(new File("bedRed icon.png"));
            System.out.println("loaded img");
        }catch(IOException IOe){
            System.out.println("Image read Exception" + IOe);
        }
//        roomImg = new ImageIcon("room.png").getImage();
        repaint();
        
        if(this == view.getPanelRoom()){
            System.out.println("True");
        }else if(view.getPanelRoom() == null) {
            System.out.println("null");
        }
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 400, 500);
        g.drawImage(roomImg, 0, 0, this);
        
        g.drawImage(bedRed, 0, 0, this);
        g.drawImage(bedRed_icon, 0, 0, this);
        System.out.println("draw done");

    }
    
}
