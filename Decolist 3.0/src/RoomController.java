import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
public class RoomController extends JPanel implements ActionListener, WindowListener , MouseListener{
    private RoomView view;
    private RoomModel model;
    private Furniture fur_Choosen;
    private String color_Choosen;
    
    public RoomController(){
        view = new RoomView(this) {};
        model = new RoomModel() {};
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
        
        view.getFr().addWindowListener(this);
        
        this.addMouseListener(this);
        
        view.getBtBed().setVisible(model.getBed().isFurAccess());
        view.getBtCertain().setVisible(model.getCertain().isFurAccess());
        view.getBtComputer().setVisible(model.getComputer().isFurAccess());
        view.getBtPoster().setVisible(model.getPoster().isFurAccess());
        view.getBtTable().setVisible(model.getTable().isFurAccess());
        
    }
    
    private void displayClick (InteractAble i) {
        i.takeAction();
        repaint();
    }

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
    
    public void ChangeColor(Furniture fur, String color){
        fur.setPresentColor(color);
        repaint();
    }
    
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
            
        }catch(NullPointerException NPe){
            System.out.println("OH No" + NPe);
        }
    }
    
    public void furAllowAccess(String furName, String color){
        view.getBtBed().setVisible(model.getBed().isFurAccess());
        view.getBtCertain().setVisible(model.getCertain().isFurAccess());
        view.getBtComputer().setVisible(model.getComputer().isFurAccess());
        view.getBtPoster().setVisible(model.getPoster().isFurAccess());
        view.getBtTable().setVisible(model.getTable().isFurAccess());
        
        Furniture thatFur = null;
        switch(furName) {
            case "bed" -> {
                model.getBed().setFurAccess(true);
                view.getBtBed().setVisible(true);
                thatFur = model.getBed();
            }
            case "computer" -> {
                model.getComputer().setFurAccess(true);
                view.getBtComputer().setVisible(true);
                thatFur = model.getComputer();
            }
            case "table" -> {
                model.getTable().setFurAccess(true);
                view.getBtTable().setVisible(true);
                thatFur = model.getTable();
            }
            case "curtain" -> {
                model.getCertain().setFurAccess(true);
                view.getBtCertain().setVisible(true);
                thatFur = model.getCertain();
            }
            case "poster" -> {
                model.getPoster().setFurAccess(true);
                view.getBtPoster().setVisible(true);
                thatFur = model.getPoster();
            }
            default -> {
                System.out.println("Furniture name have only 'bed', 'table', 'computer', 'certain' and 'poster'");
            }
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
        File f = new File("resource/datFile/room.dat");
        try(FileOutputStream fout = new FileOutputStream(f);
            ObjectOutputStream oout = new ObjectOutputStream(fout);){
            oout.writeObject(model.getFurniture());
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
            if(me.getX() > middle_x+81 && me.getX() < middle_x+121){
                if(me.getY() > middle_y+188 && me.getY() < middle_y+225){
                    displayClick(model.getComputer());
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
    }

    public RoomView getView() {
        return view;
    }

    public void setView(RoomView view) {
        this.view = view;
    }

    public RoomModel getModel() {
        return model;
    }
    public void setModel(RoomModel model) {
        this.model = model;
    }
}
