
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AddTaskController implements ActionListener{
    private AddTaskView view;
    private AddTaskModel model;
    
    public AddTaskController() {
        view = new AddTaskView();
        model = new AddTaskModel();
    }
    public void actionPerformed(ActionEvent ae) {
        
    }
}
