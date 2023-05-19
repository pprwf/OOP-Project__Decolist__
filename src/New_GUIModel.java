
import java.io.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class New_GUIModel {
    private JTable Jtable;
    DefaultTableModel DFJtable;
    Task[] arrTasks;
    
    public New_GUIModel(){
        File f = new File("tasks.obj");
        if(f.exists()){
            loadData();
        }else{
            InitJtable();
        }
    }
    
    public void InitJtable(){
        DFJtable = new DefaultTableModel();
        
        DFJtable.addColumn("Task Name");
        DFJtable.addColumn("Task Description");
        DFJtable.addColumn("Expire Time");
        DFJtable.addColumn("Expire Date");
        DFJtable.addColumn("Status");
        
        Jtable = new JTable(DFJtable);
        arrTasks = new Task[200];
    }
    
    public void loadData() {
        File f = new File("tasks.obj");
        if (f.exists()) {
            try (FileInputStream fileIn = new FileInputStream(f); 
                ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
                arrTasks = (Task[]) objectIn.readObject();
                //DefaultTableModel tableModel = (DefaultTableModel) Jtable.getModel();
                for (int i = 0; i < 200; i++) {
                    if (arrTasks[i] != null) {
                        Object[] rowData = {arrTasks[i].getTaskName(), arrTasks[i].getTaskDescription(), arrTasks[i].getExpireTime(), arrTasks[i].getExpireDate(), arrTasks[i].isStatus()};
                        DFJtable.addRow(rowData);
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                //JOptionPane.showMessageDialog(this, "Error loading tasks!");
            }
        }
    }
    
    public void saveData(){
        File f = new File("tasks.obj");
        try (FileOutputStream fileOut = new FileOutputStream(f); 
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(arrTasks);
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

    public Task[] getArrTasks() {
        return arrTasks;
    }

    public void setArrTasks(Task[] arrTasks) {
        this.arrTasks = arrTasks;
    }
    
    
}
