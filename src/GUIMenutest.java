import java.awt.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;

public class GUIMenutest {

    JFrame frame1;
    JPanel panel_head, panel_showTask, panel_bottom;
    JScrollPane JScrollBar;

    //private JButton addTask ,   showTable;
    private TopPanel toppanel;
    private Task[] task;
    public GUIMenutest(Task[] task) {
        frame1 = new JFrame("To Do List");
        panel_head = new JPanel();
        panel_showTask = new JPanel();
        panel_bottom = new JPanel();
        JScrollBar = new JScrollPane(panel_showTask);
        this.task = task;
        toppanel = new TopPanel(task);
        
        frame1.setLayout(new BorderLayout());
        frame1.add(toppanel.getPanel(), BorderLayout.NORTH);

        panel_showTask.setLayout(new GridLayout(30, 1));

        //panel_showTask.add(new GUITask("ss", "ss", "ss", "ss"));

        frame1.add(JScrollBar, BorderLayout.CENTER);
        frame1.add(new BottomView(), BorderLayout.SOUTH);

        panel_head.setLayout(new BorderLayout());
        //panel_head.add(addTask, BorderLayout.EAST);
        //panel_head.add(showTable, BorderLayout.WEST);
        //panel_head.add(toppanel.getPanel());
;        panel_head.setPreferredSize(new Dimension(200, 50));

        panel_showTask.setPreferredSize(new Dimension(300, 1800));
        panel_showTask.setBorder(new LineBorder(Color.darkGray, 4, true));
        panel_bottom.setBorder(BorderFactory.createLineBorder(Color.RED));

        ImageIcon addIcon = new ImageIcon("C:/Users/User/Downloads/test.jpg"); 
        Image image = addIcon.getImage().getScaledInstance(100, 50, Image.SCALE_SMOOTH);
        //addTask.setIcon(new ImageIcon(image));

        //addTask.setPreferredSize(new Dimension(100, 50));

        frame1.setSize(420, 700);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setVisible(true);

    }

//    public JButton getShowTable() {
//        return showTable;
//    }
//
//    public void setShowTable(JButton showTable) {
//        this.showTable = showTable;
//    }
//
//    public JFrame getFrame1() {
//        return frame1;
//    }

    public void setFrame1(JFrame frame1) {
        this.frame1 = frame1;
    }

    public JPanel getPanel_head() {
        return panel_head;
    }

    public void setPanel_head(JPanel panel_head) {
        this.panel_head = panel_head;
    }

    public JPanel getPanel_showTask() {
        return panel_showTask;
    }

    public void setPanel_showTask(JPanel panel_showTask) {
        this.panel_showTask = panel_showTask;
    }

    public JPanel getPanel_bottom() {
        return panel_bottom;
    }

    public void setPanel_bottom(JPanel panel_bottom) {
        this.panel_bottom = panel_bottom;
    }

    public JScrollPane getJScrollBar() {
        return JScrollBar;
    }

    public void setJScrollBar(JScrollPane JScrollBar) {
        this.JScrollBar = JScrollBar;
    }

//    public JButton getAddTask() {
//        return addTask;
//    }
//
//    public void setAddTask(JButton addTask) {
//        this.addTask = addTask;
//    }
    

}