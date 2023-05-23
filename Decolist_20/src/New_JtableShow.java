
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class New_JtableShow extends JFrame{
    private Font thai;
    public New_JtableShow(JTable Jtable){
        thai = new Font("TH Sarabun New", Font.PLAIN, 16);
        setTitle("Task List");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        Jtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//        Jtable.getColumnModel().getColumn(0).setPreferredWidth(60);
//        Jtable.getColumnModel().getColumn(1).setPreferredWidth(120);
//        Jtable.getColumnModel().getColumn(2).setPreferredWidth(120);
        Jtable.setFont(thai);
        Jtable.getColumnModel().getColumn(0).setMaxWidth(60);
        Jtable.getColumnModel().getColumn(5).setMaxWidth(60);
        Jtable.getColumnModel().getColumn(4).setMaxWidth(100);
        Jtable.getColumnModel().getColumn(3).setMaxWidth(100);
        JScrollPane scrollPane = new JScrollPane(Jtable);
        
        
        // Set layout
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        
        setVisible(true);
        System.out.println("show New_JtableShow");
    }
}

