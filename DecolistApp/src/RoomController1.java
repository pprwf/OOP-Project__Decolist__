import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
// class for controll room display space
public class RoomController1 extends JPanel implements ActionListener, WindowListener , MouseListener{
    
    private RoomView view;
    private RoomModel model;
    private Furniture fur_Choosen;
    private String color_Choosen;
    //private final Image room,bed[],icon[];
    
    public RoomController1(){
        view = new RoomView(this);
        model = new RoomModel();
        if(this.model != null){
                System.out.println("model is still here");
            }else{
                System.out.println("Nooooooo It's Error");
            }
        init();
        //hitBoxSet();
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
        
        view.getFr().addWindowListener(this);
        
        this.addMouseListener(this);
        
        view.getBtBed().setVisible(false);
        view.getBtCertain().setVisible(false);
        view.getBtComputer().setVisible(false);
        view.getBtPoster().setVisible(false);
        view.getBtTable().setVisible(false);
        
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
            
            view.getBtcol1().setVisible(false);
            view.getBtcol2().setVisible(false);
            view.getBtcol3().setVisible(false);
            view.getBtcol4().setVisible(false);
            
            ((JButton)ae.getSource()).setBorder(BorderFactory.createLoweredBevelBorder());
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
            
//            System.out.print(fur_Choosen.getColorAccess()[0]+ " ");
//            System.out.print(fur_Choosen.getColorAccess()[1]+ " ");
//            System.out.print(fur_Choosen.getColorAccess()[2]+ " ");
//            System.out.println(fur_Choosen.getColorAccess()[3]+ " ");
            view.getBtcol1().setVisible(fur_Choosen.getColorAccess()[0]);
            view.getBtcol2().setVisible(fur_Choosen.getColorAccess()[1]);
            view.getBtcol3().setVisible(fur_Choosen.getColorAccess()[2]);
            view.getBtcol4().setVisible(fur_Choosen.getColorAccess()[3]);
            
        }else if(ae.getSource().equals(view.getBtcol1()) || ae.getSource().equals(view.getBtcol2())  || ae.getSource().equals(view.getBtcol3())  || ae.getSource().equals(view.getBtcol4()))
        {
            view.getBtcol1().setBorder(BorderFactory.createRaisedBevelBorder());
            view.getBtcol2().setBorder(BorderFactory.createRaisedBevelBorder());
            view.getBtcol3().setBorder(BorderFactory.createRaisedBevelBorder());
            view.getBtcol4().setBorder(BorderFactory.createRaisedBevelBorder());
            
            ((JButton)ae.getSource()).setBorder(BorderFactory.createLoweredBevelBorder());
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
            
            if(model.getBed().isFurAccess()){
                g.drawImage(model.getBed().getImage(model.getBed().getPresentColor()), middle_x, middle_y, this);
            }
            if(model.getTable().isFurAccess()){
                g.drawImage(model.getTable().getImage(model.getTable().getPresentColor()), middle_x, middle_y, this);
            }
            if(model.getComputer().isFurAccess()){
                if(model.getComputer().isPower()){
                    g.drawImage(model.getComputer().getImage(model.getComputer().getPresentColor()), middle_x, middle_y, this);
                }else{
                    g.drawImage(model.getComputer().getComOffImage(), middle_x, middle_y, this);
                }
            }
            if(model.getCertain().isFurAccess()){
                g.drawImage(model.getCertain().getImage(model.getCertain().getPresentColor()), middle_x, middle_y, this);
            }
            if(model.getPoster().isFurAccess()){
                g.drawImage(model.getPoster().getImage(model.getPoster().getPresentColor()), middle_x, middle_y, this);
            }
            
        //System.out.println("draw done");
        }catch(NullPointerException NPe){
            System.out.println("OH No" + NPe);
//            if(this.model == null){
//                System.out.println("Is this after first line? Haiyaaa You call model before you make him watdafuq what wrong with you paintComponent");
//            }
        }
    }
    
    public void furAllowAccess(String furName, String color){
        Furniture thatFur = null;
        switch(furName) {
            case "bed":
                model.getBed().setFurAccess(true);
                view.getBtBed().setVisible(true);
                thatFur = model.getBed();
                break;
            case "computer":
                model.getComputer().setFurAccess(true);
                view.getBtComputer().setVisible(true);
                thatFur = model.getComputer();
                break;
            case "table":
                model.getTable().setFurAccess(true);
                view.getBtTable().setVisible(true);
                thatFur = model.getTable();
                break;
            case "certain":
                model.getCertain().setFurAccess(true);
                view.getBtCertain().setVisible(true);
                thatFur = model.getCertain();
                break;
            case "poster":
                model.getCertain().setFurAccess(true);
                view.getBtPoster().setVisible(true);
                thatFur = model.getPoster();
                break;
            default:
                System.out.println("Furniture name have only 'bed', 'table', 'computer', 'certain' and 'poster'");;
        }
        
        if(thatFur != null){
            switch (color){
                case "red":
                    thatFur.getColorAccess()[0] = true;
                    break;
                case "green":
                    thatFur.getColorAccess()[1] = true;
                    break;
                case "blue":
                    thatFur.getColorAccess()[2] = true;
                    break;
                case "yellow":
                    thatFur.getColorAccess()[3] = true;
                    break;
                default:
                    System.out.println("color have only 'red', 'green', 'blue' and 'yellow'");;
            }
        }
    }
    
    public void windowOpened(WindowEvent we){}
    public void windowClosed(WindowEvent we){}
    public void windowClosing(WindowEvent we){
        File f = new File("data.dat");
        try(FileOutputStream fout = new FileOutputStream(f);
            ObjectOutputStream oout = new ObjectOutputStream(fout);){
            oout.writeObject(model.getFurniture());
            System.out.printf("Serialized data is saved");
        }catch(IOException IOe){
            IOe.printStackTrace();
        }
    }
    public void windowIconified(WindowEvent we){}
    public void windowDeiconified(WindowEvent we){}
    public void windowActivated(WindowEvent we){}
    public void windowDeactivated(WindowEvent we){}
    
    public void mouseClicked(MouseEvent me){
        if(me.getSource().equals(this)){
            int middle_x = view.getPanelRoom().getWidth()/2 - 400/2;
            int middle_y = view.getPanelRoom().getHeight()/2 - 400/2;
            //System.out.println(me.getPoint()+"midx= "+middle_x+" midy= "+ middle_y+ "so "+ (me.getX()-middle_x) + "," + (me.getY()-middle_y));
            
            if(me.getX() > middle_x+81 && me.getX() < middle_x+121){
                if(me.getY() > middle_y+188 && me.getY() < middle_y+225){
                    model.getComputer().takeAction();
                    repaint();
                }
            }
        }
    }
    public void mouseEntered(MouseEvent me){}
    public void mouseExited(MouseEvent me){}
    public void mousePressed(MouseEvent me){}
    public void mouseReleased(MouseEvent me){}
    
    public void hitBoxSet(){
        int middle_x = view.getPanelRoom().getWidth()/2 - 400/2;
        int middle_y = view.getPanelRoom().getHeight()/2 - 400/2;
        
        //view.getComhitbox().setLocation(middle_x+80,middle_y+192);
//        view.getComhitbox().setPreferredSize(new Dimension(100,100));
//        view.getComhitbox().setOpaque(true);
//        view.getComhitbox().setBackground(Color.red);
//        view.getComhitbox().setBounds(new Rectangle(new Point(middle_x+80, middle_y+192), view.getComhitbox().getPreferredSize()));
        //view.getComhitbox().setText("qp[wqke[wpqkep[qw");
        System.out.println("qwewqeqwe");
    }
}
