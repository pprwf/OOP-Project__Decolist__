
import java.awt.event.*;
import java.awt.event.ActionListener;


public class New_GUIController{
    //New_GUIView view;
    New_GUIModel model;
    GUIMenutest view;
    AddTaskController addTaskControll;
    //TopPanel toppanel;
    //AddTaskView test;

    public New_GUIController() {
        //view = new New_GUIView();
        view = new GUIMenutest(model.getArrTasks());
        model = new New_GUIModel();
        //test = new AddTaskView();
        //toppanel = new TopPanel();
        //view.getBt_addTask().addActionListener(this);
    }

    
}
   

