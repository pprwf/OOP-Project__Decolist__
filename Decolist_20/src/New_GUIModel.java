
import java.io.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.*;


public class New_GUIModel {
    private JTable Jtable;
    DefaultTableModel DFJtable;
    LinkedList<Task> arrTasks;
    
    public New_GUIModel(){
        InitJTable();
        File f = new File("tasks.obj");
        if(f.exists()){
            loadData();
        }else{
            InitArrayTask();
        }
    }
    public void InitJTable(){
        DFJtable = new DefaultTableModel();
        DFJtable.addColumn("Task No.");
        DFJtable.addColumn("Task Name");
        DFJtable.addColumn("Task Description");
        DFJtable.addColumn("Expire Time");
        DFJtable.addColumn("Expire Date");
        DFJtable.addColumn("Status");
        
        Jtable = new JTable(DFJtable);
        System.out.println("Jtable");
    }
    public void InitArrayTask(){

        arrTasks = new LinkedList<Task>();
        System.out.println("init ArrayTask");
    }
    
    public void loadData() {
        File f = new File("tasks.obj");
        if (f.exists()) {
            try (FileInputStream fileIn = new FileInputStream(f); 
                ObjectInputStream objectIn = new ObjectInputStream(fileIn);) {
                arrTasks = (LinkedList<Task>) objectIn.readObject();
//                DefaultTableModel tableModel = (DefaultTableModel) Jtable.getModel();
//                for (int i = 0; i < 200; i++) {
//                    if (arrTasks[i] != null) {
//                        Object[] rowData = {arrTasks[i].getTaskName(), arrTasks[i].getTaskDescription(), arrTasks[i].getExpireTime(), arrTasks[i].getExpireDate(), arrTasks[i].isStatus()};
//                        DFJtable.addRow(rowData);
//                    }
//                }
                System.out.println("loaded tasks.obj");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                //JOptionPane.showMessageDialog(this, "Error loading tasks!");
            }
        }
    }
    
    public void saveData(LinkedList<Task> arrTasks){
        File f = new File("tasks.obj");
        for(int i=0;i<arrTasks.size();i++){
            if(arrTasks.get(i) == null){
                break;
            }else{
                System.out.println("save " +arrTasks.get(i).getTaskName());
            }
        }
        try (FileOutputStream fileOut = new FileOutputStream(f); 
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);) {
            objectOut.flush();
            objectOut.reset();
            objectOut.writeObject(arrTasks);
            System.out.println("saved tasks.obj");
        } catch (IOException IOe){
            IOe.printStackTrace();
            //JOptionPane.showMessageDialog(this, "Error loading tasks!");
        }
    }

    public JTable getJtable() {
        return Jtable;
    }

    public void setJtable(JTable Jtable) {
        this.Jtable = Jtable;
    }

    public DefaultTableModel getDFJtable() {
        return DFJtable;
    }

    public void setDFJtable(DefaultTableModel DFJtable) {
        this.DFJtable = DFJtable;
    }

    public LinkedList<Task> getArrTasks() {
        return arrTasks;
    }

    public void setArrTasks(LinkedList<Task> arrTasks) {
        this.arrTasks = arrTasks;
    }
    
    
}
