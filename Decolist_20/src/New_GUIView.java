import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class New_GUIView {
    private JFrame frame1;
    private JPanel panel_head,panel_middle,panel_bottom;
    private JTextArea txtArea1;
    private JScrollPane ScrollP1;
    private JButton bt_history,bt_addTask;
    
    public New_GUIView(JPanel head_panel, JPanel bottom_panel, JPanel middle_panel){
        System.out.println("===================================== GUI VIEW =====================================");
        frame1 = new JFrame("To Do List");
        panel_head = head_panel;
        panel_middle = middle_panel;
        panel_bottom = bottom_panel;
        txtArea1 = new JTextArea();
        ScrollP1 = new JScrollPane(panel_middle);
        
        frame1.setLayout(new BorderLayout());
        frame1.add(panel_head, BorderLayout.NORTH);
        frame1.add(ScrollP1, BorderLayout.CENTER);
        frame1.add(panel_bottom, BorderLayout.SOUTH);
        //panel_middle.setPreferredSize(new Dimension(300,300));
        //panel_middle.setBorder(BorderFactory.createLineBorder(Color.red));
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame1.setSize(500, 750);
        frame1.setLocationRelativeTo(null);
        //frame1.setMaximumSize(new Dimension(420, 700));
        frame1.setResizable(false);
        frame1.setVisible(true);
    }
    public JFrame getFrame1() {
        return frame1;
    }

    public void setFrame1(JFrame frame1) {
        this.frame1 = frame1;
    }

    public JPanel getPanel_head() {
        return panel_head;
    }

    public void setPanel_head(JPanel panel_head) {
        this.panel_head = panel_head;
    }

    public JPanel getPanel_bottom() {
        return panel_bottom;
    }

    public void setPanel_bottom(JPanel panel_bottom) {
        this.panel_bottom = panel_bottom;
    }

    public JTextArea getTxtArea1() {
        return txtArea1;
    }

    public void setTxtArea1(JTextArea txtArea1) {
        this.txtArea1 = txtArea1;
    }

    public JScrollPane getScrollP1() {
        return ScrollP1;
    }

    public void setScrollP1(JScrollPane ScrollP1) {
        this.ScrollP1 = ScrollP1;
    }

    public JButton getBt_history() {
        return bt_history;
    }

    public void setBt_history(JButton bt_history) {
        this.bt_history = bt_history;
    }

    public JButton getBt_addTask() {
        return bt_addTask;
    }

    public JPanel getPanel_middle() {
        return panel_middle;
    }

    public void setPanel_middle(JPanel panel_middle) {
        this.panel_middle = panel_middle;
    }

    public void setBt_addTask(JButton bt_addTask) {
        this.bt_addTask = bt_addTask;
    }
    
    
    
}
