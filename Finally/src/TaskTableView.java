

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TaskTableView extends JFrame implements TaskListener {

    private TaskListModel model;
    private JTable table;

    public TaskTableView(TaskListModel model) {
        this.model = model;
        model.addListener(this);

        String[] columnNames = {"Name", "Description", "Expire Date", "Status"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(500, 300));
        add(scrollPane, BorderLayout.CENTER);

        setTitle("Task Table");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    @Override
    public void taskAdded(Task task) {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        Object[] rowData = {task.getName(), task.getDescription(), task.getExpireDate(), task.isStatus()};
        tableModel.addRow(rowData);
    }
}
