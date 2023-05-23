import java.awt.*;
import javax.swing.*;

public class JtableShow extends JFrame{
    private Font thai;
    public JtableShow(JTable Jtable){
        thai = new ThaiFont().thBold.deriveFont(20f);
        setTitle("Task List");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Jtable.setFont(thai);
        Jtable.getColumnModel().getColumn(0).setMaxWidth(60);
        Jtable.getColumnModel().getColumn(5).setMaxWidth(60);
        Jtable.getColumnModel().getColumn(4).setMaxWidth(100);
        Jtable.getColumnModel().getColumn(3).setMaxWidth(100);
        JScrollPane scrollPane = new JScrollPane(Jtable);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        
        setVisible(true);
    }
}

