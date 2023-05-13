
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AddTaskController implements ActionListener{
    private AddTaskView view;
    private AddTaskModel model;
    private GUIMenu gui;
    
    public AddTaskController() {
        view = new AddTaskView();
        model = new AddTaskModel();
    }
    public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == gui.getBt_addTask());
                AddTaskView atv = new AddTaskView();
        }
    }

