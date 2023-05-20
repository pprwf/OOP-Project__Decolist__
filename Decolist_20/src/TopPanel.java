import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TopPanel{
    private JPanel panel;
    private JButton table,addTask;
    private JTable Jtable;
    public TopPanel(){
        panel = new JPanel();
        table = new JButton("Table");
        addTask = new JButton("+Add Task");
        panel.setSize(750, 50);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        panel.setLayout(new GridLayout(1,4));
        panel.add(new JPanel());
        panel.add(new JPanel());
        panel.add(table);
        panel.add(addTask);
        
    }
    

    public JPanel getPanel() {
        return panel;
    }

    public JTable getJtable() {
        return Jtable;
    }

    public void setJtable(JTable Jtable) {
        this.Jtable = Jtable;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JButton getTable() {
        return table;
    }

    public void setTable(JButton table) {
        this.table = table;
    }

    public JButton getAddTask() {
        return addTask;
    }

    public void setAddTask(JButton addTask) {
        this.addTask = addTask;
    }
    
}
