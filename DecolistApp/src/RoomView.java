import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class RoomView {
    private JFrame fr;
    private JPanel panelRoom, panelFurniture;
    private JButton btBed;
    public RoomView(JPanel panel){
        fr = new JFrame();
        btBed = new JButton();
        panelRoom = panel;
        panelFurniture = new JPanel();
        
        fr.setLayout(new BorderLayout());
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.add(panelRoom, BorderLayout.NORTH);
        fr.add(panelFurniture, BorderLayout.CENTER);
        panelFurniture.add(btBed);
        
        fr.setSize(500,700);
        fr.setVisible(true);
    }

    public JPanel getPanelRoom() {
        return panelRoom;
    }

    public void setPanelRoom(JPanel panel) {
        this.panelRoom = panel;
    }
    
    
}
