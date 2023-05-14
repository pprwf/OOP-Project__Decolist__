import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class GUIMenu {
    private JFrame frame1;
    private JPanel panel_head,panel_showTask,panel_bottom;
    private JTextArea txtArea1;
    private JScrollPane ScrollP1;
    private JButton bt_history,bt_addTask;
    
    public GUIMenu(){
        frame1 = new JFrame("To Do List");
        panel_head = new JPanel();
        panel_showTask = new JPanel();
        panel_bottom = new JPanel();
        txtArea1 = new JTextArea();
        ScrollP1 = new JScrollPane(panel_showTask);
        bt_history = new JButton("History");
        bt_addTask = new JButton("+Add Task");
        
        frame1.setLayout(new BorderLayout());
        frame1.add(panel_head, BorderLayout.NORTH);
        frame1.add(ScrollP1, BorderLayout.CENTER);
        frame1.add(panel_bottom, BorderLayout.SOUTH);
        panel_head.setLayout(new FlowLayout());
        panel_head.add(bt_history);
        panel_head.add(bt_addTask);
        panel_showTask.setPreferredSize(new Dimension(300,1800));
        panel_showTask.setBorder(BorderFactory.createLineBorder(Color.red));
        
        
        frame1.setSize(420, 700);
        frame1.setVisible(true);
    }
}
