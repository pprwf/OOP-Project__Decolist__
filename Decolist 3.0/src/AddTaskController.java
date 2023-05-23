import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.LinkedList;

public class AddTaskController implements  ActionListener{
    private AddTaskView view;
    private LinkedList<Task> arrTask;
    MiddleController midControll;
    public AddTaskController(LinkedList<Task> arrTask, MiddleController midControll) {
        view = new AddTaskView();
        this.arrTask = arrTask;
        this.midControll = midControll;
        view.getSubmit().addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource().equals(view.getSubmit())){
            String topic = view.getTxt1().getText();
            String des = view.getTxt2().getText();
            String time = view.getTimedate().getValue().toString();
            time = (String)time.subSequence(11, 19);
            DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            String date = df.format(view.getDateChooser().getDate());
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String str = dateFormat.format(view.getDateChooser().getDate());
            int number = arrTask.size() +1;
            Task task = new Task(number, topic, des, date, time, false);
            arrTask.add(task);
            view.getTxt1().setText("");
            view.getTxt2().setText("");
            midControll.refresh();
        }
    }
    
}
