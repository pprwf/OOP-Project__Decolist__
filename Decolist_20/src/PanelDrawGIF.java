import java.awt.*;
import java.awt.Graphics;
import javax.swing.*;


public class PanelDrawGIF extends JPanel{
    
    public PanelDrawGIF(){
        
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
    }
}
