
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class New_JtableShow extends JFrame{
    
    public New_JtableShow(JTable Jtable){
        setTitle("Task List");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JScrollPane scrollPane = new JScrollPane(Jtable);

        // Set layout
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        
        setVisible(true);
        System.out.println("show New_JtableShow");
    }
}

