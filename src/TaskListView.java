//
//import javax.swing.*;
//import javax.swing.table.DefaultTableModel;
//import java.awt.*;
//import java.io.*;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.util.ArrayList;
//import java.util.List;
//
//public class TaskListView extends JFrame {
//
//    private JTable taskTable;
//
//    public TaskListView() {
//        setTitle("Task List");
//        setSize(400, 300);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        // Create table model
//        DefaultTableModel tableModel = new DefaultTableModel();
//        tableModel.addColumn("Task Name");
//        tableModel.addColumn("Task Description");
//        tableModel.addColumn("Expire Date");
//
//        // Create table
//        taskTable = new JTable(tableModel);
//
//        // Add table to scroll pane
//        JScrollPane scrollPane = new JScrollPane(taskTable);
//
//        // Set layout
//        setLayout(new BorderLayout());
//        add(scrollPane, BorderLayout.CENTER);
//
//        //setVisible(true);
//        //loadTasks();
//    }
//
//    public Task[] loadTasks() {
//        Task[] loadedtask = null;
//        File f = new File("tasks.obj");
//        if (f.exists()) {
//            try (FileInputStream fileIn = new FileInputStream(f); ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
//                loadedtask = (Task[]) objectIn.readObject();
//                DefaultTableModel tableModel = (DefaultTableModel) taskTable.getModel();
//                for (int i = 0; i < 200; i++) {
//                    if (loadedtask[i] != null) {
//                        Object[] rowData = {loadedtask[i].getTaskName(), loadedtask[i].getTaskDescription(), loadedtask[i].getExpireDateTime()};
//                        tableModel.addRow(rowData);
//                    }
//                }
//            } catch (IOException | ClassNotFoundException e) {
//                e.printStackTrace();
//                JOptionPane.showMessageDialog(this, "Error loading tasks!");
//            }
//        }else{
//            loadedtask = new Task[200];
//        }
//
//        return loadedtask;
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new TaskListView();
//            }
//        });
//    }
//}
