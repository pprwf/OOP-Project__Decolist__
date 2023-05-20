//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.time.LocalDateTime;
//import javax.swing.JOptionPane;
//import javax.swing.table.DefaultTableModel;
//
//
//public class AddTaskModel {
//    private AddTaskView view;
//    //private Task task;
//    
//    private void saveTask() {
//        view = new AddTaskView();
//        
//        String taskName = view.getTxt1().getText();
//        String taskDescription = view.getTxt2().getText();
//        String expireDate = view.getDateChooser().getDateFormatString() ;
//        String expireTime = view.getTimemodel().toString();
//        
//
//        //LocalDateTime expireDateTime = LocalDateTime.parse(expireDate + "T" + expireTime);
//
//        Task task = new Task(taskName, taskDescription, expireDate, expireTime, false);
//        Task[] arrTask = new Task[200];
//        arrTask = lview.loadTasks();
//        
//        for(int i= 0; i<arrTask.length; i++){
//            if(arrTask[i] == null){
//                arrTask[i] = task;
//                break;
//            }
//        }
//        
//        
//        try ( FileOutputStream fileOut = new FileOutputStream("tasks.obj");  ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
//
//            objectOut.writeObject(arrTask);
//            JOptionPane.showMessageDialog(this, "Task saved successfully!");
//        } catch (IOException e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(this, "Error saving task!");
//        }
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
//}
