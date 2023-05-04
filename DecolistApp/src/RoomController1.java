import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
// class for controll room display space
public class RoomController1 extends JPanel{
    
    private RoomView view;
    private RoomModel model;
    //private final Image room,bed[],icon[];
    
    public RoomController1(){
        view = new RoomView(this);
        model = new RoomModel();
        if(this.model != null){
                System.out.println("WTF model is still here");
            }else{
                System.out.println("Nooooooo It's Error");
            }
        
        //System.out.println(""+view.getFr().getWidth()+this.getWidth());
        init();
//        this.setBounds((view.getFr().getWidth()-this.getWidth()), 0, 400, 500);
//        room = model.getRoom();
//        bed = model.getBed();
//        icon = model.getIcon();
        repaint();
    }
    public void init(){
        model.addContactView(view);
        model.addIconToView();
    }
    @Override
    public void paintComponent(Graphics g) {
        try{
            int middle_x = view.getPanelRoom().getWidth()/2 - 400/2;
            int middle_y = view.getPanelRoom().getHeight()/2 - 400/2;
            g.setColor(Color.BLACK);
            g.fillRect(middle_x-(10/2), middle_y-(10/2), 410, 410);
            g.drawImage(model.getRoom(), middle_x, middle_y, this);
            g.drawImage(model.getBed().getImage("Blue"), middle_x, middle_y, this);
            g.drawImage(model.getTable().getImage("Red"), middle_x, middle_y, this);
            g.drawImage(model.getComputer().getImage("Yellow"), middle_x, middle_y, this);
            g.drawImage(model.getCertain().getImage("Red"), middle_x, middle_y, this);
            g.drawImage(model.getPoster().getImage("Red"), middle_x, middle_y, this);
        System.out.println("draw done");
        }catch(NullPointerException NPe){
            System.out.println("OH No" + NPe);
            if(this.model == null){
                System.out.println("Is this after first line? Haiyaaa You call model before you make him watdafuq what wrong with you paintComponent");
            }
        }

    }
    
}
