import java.io.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.*;


public class GUIModel {
    private JTable Jtable;
    DefaultTableModel DFJtable;
    LinkedList<Task> arrTasks;
    
    public GUIModel(){
        InitJTable();
        File f = new File("resource/datFile/tasks.obj");
        if(f.exists()){
            loadData();
        }else{
            InitArrayTask();
        }
    }
    private void InitJTable(){
        DFJtable = new DefaultTableModel();
        DFJtable.addColumn("Task No.");
        DFJtable.addColumn("Task Name");
        DFJtable.addColumn("Task Description");
        DFJtable.addColumn("Expire Time");
        DFJtable.addColumn("Expire Date");
        DFJtable.addColumn("Status");
        
        Jtable = new JTable(DFJtable);
    }
    public void InitArrayTask(){
        arrTasks = new LinkedList<Task>();
    }
    
    public void loadData() {
        File f = new File("resource/datFile/tasks.obj");
        if (f.exists()) {
            try (FileInputStream fileIn = new FileInputStream(f); 
                ObjectInputStream objectIn = new ObjectInputStream(fileIn);) {
                arrTasks = (LinkedList<Task>) objectIn.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void saveData(LinkedList<Task> arrTasks){
        File f = new File("resource/datFile/tasks.obj");
        for(int i=0;i<arrTasks.size();i++){
            if(arrTasks.get(i) == null){
                break;
            }
        }
        try (FileOutputStream fileOut = new FileOutputStream(f); 
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);) {
            objectOut.flush();
            objectOut.reset();
            objectOut.writeObject(arrTasks);
        } catch (IOException IOe){
            IOe.printStackTrace();
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
