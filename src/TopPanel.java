import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TopPanel implements ActionListener{
    private JPanel panel;
    private JButton table,addTask;
    private Task[] task;
    private JTable jtable;
    public TopPanel(Task[] task){
        panel = new JPanel();
        table = new JButton("Table");
        addTask = new JButton("+Add Task");
        panel.setSize(750, 50);
        panel.setLayout(new GridLayout(1,4));
        panel.add(new JPanel());
        panel.add(new JPanel());
        panel.add(table);
        panel.add(addTask);
        this.task = task;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(addTask)){
            AddTaskController addTaskController = new AddTaskController(task);
        } else if(ae.getSource().equals(table)) {
            New_JtableShow newjtable = new New_JtableShow(jtable);
        }
    }

    public JPanel getPanel() {
        return panel;
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
