import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
// class for controll room display space
public class RoomController1 extends JPanel implements ActionListener{
    
    private RoomView view;
    private RoomModel model;
    private Furniture fur_Choosen;
    private String color_Choosen;
    //private final Image room,bed[],icon[];
    
    public RoomController1(){
        view = new RoomView(this);
        model = new RoomModel();
        if(this.model != null){
                System.out.println("WTF model is still here");
            }else{
                System.out.println("Nooooooo It's Error");
            }
        init();
        repaint();
    }
    public void init(){
        model.addContactView(view);
        model.addIconToView();
        
        view.getBtBed().addActionListener(this);
        view.getBtTable().addActionListener(this);
        view.getBtComputer().addActionListener(this);
        view.getBtCertain().addActionListener(this);
        view.getBtPoster().addActionListener(this);
        
        view.getBtcol1().addActionListener(this);
        view.getBtcol2().addActionListener(this);
        view.getBtcol3().addActionListener(this);
        view.getBtcol4().addActionListener(this);
        
        if(fur_Choosen == null){
            
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource().equals(view.getBtBed()) || ae.getSource().equals(view.getBtTable())  || ae.getSource().equals(view.getBtComputer())  || ae.getSource().equals(view.getBtCertain())  || ae.getSource().equals(view.getBtPoster()))
        {
            view.getBtBed().setBorder(BorderFactory.createRaisedBevelBorder());
            view.getBtTable().setBorder(BorderFactory.createRaisedBevelBorder());
            view.getBtComputer().setBorder(BorderFactory.createRaisedBevelBorder());
            view.getBtCertain().setBorder(BorderFactory.createRaisedBevelBorder());
            view.getBtPoster().setBorder(BorderFactory.createRaisedBevelBorder());
            view.getPanelFurniture_in2().setVisible(true);
            
            view.getBtcol1().setBorder(BorderFactory.createRaisedBevelBorder());
            view.getBtcol2().setBorder(BorderFactory.createRaisedBevelBorder());
            view.getBtcol3().setBorder(BorderFactory.createRaisedBevelBorder());
            view.getBtcol4().setBorder(BorderFactory.createRaisedBevelBorder());
            
            ((JButton)ae.getSource()).setBorder(BorderFactory.createLoweredBevelBorder());
        }else if(ae.getSource().equals(view.getBtcol1()) || ae.getSource().equals(view.getBtcol2())  || ae.getSource().equals(view.getBtcol3())  || ae.getSource().equals(view.getBtcol4()))
        {
            view.getBtcol1().setBorder(BorderFactory.createRaisedBevelBorder());
            view.getBtcol2().setBorder(BorderFactory.createRaisedBevelBorder());
            view.getBtcol3().setBorder(BorderFactory.createRaisedBevelBorder());
            view.getBtcol4().setBorder(BorderFactory.createRaisedBevelBorder());
            
            ((JButton)ae.getSource()).setBorder(BorderFactory.createLoweredBevelBorder());
        }
        
        if(ae.getSource().equals(view.getBtBed())){
            fur_Choosen = model.getBed();
        }else if(ae.getSource().equals(view.getBtTable())){
            fur_Choosen = model.getTable();
        }else if(ae.getSource().equals(view.getBtComputer())){
            fur_Choosen = model.getComputer();
        }else if(ae.getSource().equals(view.getBtCertain())){
            fur_Choosen = model.getCertain();
        }else if(ae.getSource().equals(view.getBtPoster())){
            fur_Choosen = model.getPoster();
        }
        
        if(ae.getSource().equals(view.getBtcol1())){
            ChangeColor(fur_Choosen, "Red");
        }else if(ae.getSource().equals(view.getBtcol2())){
            ChangeColor(fur_Choosen, "Green");
        }else if(ae.getSource().equals(view.getBtcol3())){
            ChangeColor(fur_Choosen, "Blue");
        }else if(ae.getSource().equals(view.getBtcol4())){
            ChangeColor(fur_Choosen, "Yellow");
        }
        
    }
    
    public void ChangeColor(Furniture fur, String color){// abstract input method
        fur.setPresentColor(color);
        repaint();
    }
    
    public void makeupView(){
        
    }
    
    
    @Override
    public void paintComponent(Graphics g) {
        try{
            int middle_x = view.getPanelRoom().getWidth()/2 - 400/2;
            int middle_y = view.getPanelRoom().getHeight()/2 - 400/2;
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            g.setColor(Color.BLACK);
            g.fillRect(middle_x-(10/2), middle_y-(10/2), 410, 410);
            g.drawImage(model.getRoom(), middle_x, middle_y, this);
            g.drawImage(model.getBed().getImage(model.getBed().getPresentColor()), middle_x, middle_y, this);
            g.drawImage(model.getTable().getImage(model.getTable().getPresentColor()), middle_x, middle_y, this);
            g.drawImage(model.getComputer().getImage(model.getComputer().getPresentColor()), middle_x, middle_y, this);
            g.drawImage(model.getCertain().getImage(model.getCertain().getPresentColor()), middle_x, middle_y, this);
            g.drawImage(model.getPoster().getImage(model.getPoster().getPresentColor()), middle_x, middle_y, this);
        System.out.println("draw done");
        }catch(NullPointerException NPe){
            System.out.println("OH No" + NPe);
            if(this.model == null){
                System.out.println("Is this after first line? Haiyaaa You call model before you make him watdafuq what wrong with you paintComponent");
            }
        }

    }
    
}
