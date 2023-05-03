import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RoomView {
    private JFrame fr;
    private JPanel panelRoom, panelFurniture, panelFurniture_in1, panelFurniture_in2;
    private JButton btBed,btTable,btComputer,btCertain,btPoster;
    private JButton btcol1,btcol2,btcol3;
    
    public RoomView(JPanel panel){
        fr = new JFrame();
        panelRoom = panel;
        panelFurniture = new JPanel();
        panelFurniture_in1 = new JPanel();
        panelFurniture_in2 = new JPanel();
        btBed = new JButton("BT eiei");
        btTable = new JButton("BT eiei");
        btComputer = new JButton("BT eiei");
        btCertain = new JButton("BT eiei");
        btPoster = new JButton("BT eiei");
        btcol1 = new JButton("color1");
        btcol2 = new JButton("color1");
        btcol3 = new JButton("color1");
        
        fr.setLayout(new BorderLayout());
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.add(panelRoom, BorderLayout.NORTH);
        fr.add(panelFurniture, BorderLayout.CENTER);
        panelRoom.setPreferredSize(new Dimension(450, 450));
        panelRoom.setBorder(BorderFactory.createLineBorder(Color.red));
        //panelRoom.setBounds(25,0,400,500);
        panelFurniture.setLayout(new GridLayout(2,1));
        panelFurniture.add(panelFurniture_in1);
        panelFurniture.add(panelFurniture_in2);
        panelFurniture_in1.setBorder(BorderFactory.createLineBorder(Color.blue));
        panelFurniture_in2.setBorder(BorderFactory.createLineBorder(Color.green));
        panelFurniture_in1.add(btBed);
        panelFurniture_in1.add(btTable);
        panelFurniture_in1.add(btComputer);
        panelFurniture_in1.add(btCertain);
        panelFurniture_in1.add(btPoster);
        panelFurniture_in2.add(btcol1);
        panelFurniture_in2.add(btcol2);
        panelFurniture_in2.add(btcol3);
        
        
        
        
        fr.setSize(450,600);
        fr.setVisible(true);
    }

    public JPanel getPanelRoom() {
        return panelRoom;
    }

    public void setPanelRoom(JPanel panel) {
        this.panelRoom = panel;
    }

    public JFrame getFr() {
        return fr;
    }

    public void setFr(JFrame fr) {
        this.fr = fr;
    }

    public JPanel getPanelFurniture() {
        return panelFurniture;
    }

    public void setPanelFurniture(JPanel panelFurniture) {
        this.panelFurniture = panelFurniture;
    }

    public JButton getBtBed() {
        return btBed;
    }

    public void setBtBed(JButton btBed) {
        this.btBed = btBed;
    }
    
    
}
