
import java.awt.event.*;
import java.awt.event.ActionListener;
import javax.swing.*;


public class New_GUIController implements WindowListener, ActionListener{
    //New_GUIView view;
    New_GUIModel model;
    New_GUIView view;
    AddTaskController addTaskControll;
    BottomController bottomComtroll;
    TopPanel toppanel;
    Middle_Controll middle_Con;
    //AddTaskView test;

    public New_GUIController() {
        System.out.println("===================================== GUI Controll =====================================");
        model = new New_GUIModel();
        bottomComtroll = new BottomController();
        middle_Con = new Middle_Controll(this);
        toppanel = new TopPanel();
        view = new New_GUIView(toppanel.getPanel(), bottomComtroll, middle_Con.getView());
        
        toppanel.getAddTask().addActionListener(this);
        toppanel.getTable().addActionListener(this);
        view.getFrame1().addWindowListener(this);
//        boolean fff = (model.getArrTasks() == toppanel.getArrtask());
//            System.out.println("eeeee  "+fff);
    }
    public void addDataToJTable(){
        System.out.println("addDataToJTable");
        model.getDFJtable().setRowCount(0);
            for(int i=0;i<model.getArrTasks().size();i++){
//                if(model.getArrTasks().get(i)!= null & model.getDFJtable().getRowCount() <= i){ //if found data but theres not in jtable
//                    //System.out.println("no null");
//                    Object[] rowData = {model.getArrTasks().get(i).getNumber(),model.getArrTasks().get(i).getTaskName(), model.getArrTasks().get(i).getTaskDescription(),model.getArrTasks().get(i).getExpireTime(),model.getArrTasks().get(i).getExpireDate(),model.getArrTasks().get(i).isStatus()};
//                    model.getDFJtable().addRow(rowData);
//                }else if (model.getArrTasks().get(i) == null){
//                    break;
//                }
                if(model.getArrTasks().get(i)!= null){ //if found data but theres not in jtable
                    //System.out.println("no null");
                    Object[] rowData = {model.getArrTasks().get(i).getNumber(),model.getArrTasks().get(i).getTaskName(), model.getArrTasks().get(i).getTaskDescription(),model.getArrTasks().get(i).getExpireTime(),model.getArrTasks().get(i).getExpireDate(),model.getArrTasks().get(i).isStatus()};
                    model.getDFJtable().addRow(rowData);
                }else if (model.getArrTasks().get(i) == null){
                    break;
                }
            }
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource().equals(toppanel.getAddTask())){
            AddTaskController addTaskController = new AddTaskController(model.getArrTasks(), middle_Con);
        } else if(ae.getSource().equals(toppanel.getTable())) {
            addDataToJTable();
            New_JtableShow newjtable = new New_JtableShow(model.getJtable());
        }
    }
    public void windowClosing(WindowEvent e){
       if(e.getSource().equals(view.getFrame1())){
            //System.out.println("ffff"+ (model.getArrTasks() == toppanel.getArrtask()));
            model.saveData(model.getArrTasks());
//            System.out.println("ffff"+ (model.getArrTasks() == toppanel.getArrtask()));
        }
    } 
    public void windowOpened(WindowEvent e){
        if(e.getSource().equals(view.getFrame1())){
            model.loadData();
        }
    }
    public void windowDeactivated(WindowEvent e){}
    public void windowActivated(WindowEvent e){}
    
    public void windowIconified(WindowEvent e){}
    public void windowDeiconified(WindowEvent e){}
    public void windowClosed(WindowEvent e){}

    public New_GUIView getView() {
        return view;
    }

    public void setView(New_GUIView view) {
        this.view = view;
    }

    public New_GUIModel getModel() {
        return model;
    }

    public void setModel(New_GUIModel model) {
        this.model = model;
    }

    public AddTaskController getAddTaskControll() {
        return addTaskControll;
    }

    public void setAddTaskControll(AddTaskController addTaskControll) {
        this.addTaskControll = addTaskControll;
    }

    public BottomController getBottomView() {
        return bottomComtroll;
    }

    public void setBottomView(BottomController bottomView) {
        this.bottomComtroll = bottomView;
    }

    public TopPanel getToppanel() {
        return toppanel;
    }

    public void setToppanel(TopPanel toppanel) {
        this.toppanel = toppanel;
    }

    public Middle_Controll getMiddle_Con() {
        return middle_Con;
    }

    public void setMiddle_Con(Middle_Controll middle_Con) {
        this.middle_Con = middle_Con;
    }
    
    
}
   

