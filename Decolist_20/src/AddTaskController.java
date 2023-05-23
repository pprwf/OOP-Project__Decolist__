
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Member;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AddTaskController implements  ActionListener{

    private AddTaskView view;
    //private AddTaskModel model;
    private LinkedList<Task> arrTask;
    Middle_Controll midControll;
    public AddTaskController(LinkedList<Task> arrTask, Middle_Controll midControll) {
        view = new AddTaskView();
        //model = new AddTaskModel();
        this.arrTask = arrTask;
        this.midControll = midControll;
        view.getSubmit().addActionListener(this);
    }
    
    @Override
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
            System.out.println("added task");
            midControll.refresh();
//            for(int i= 0; i<arrTask.length; i++){
//                //System.out.println(i);
//                if(arrTask[i] == null){
//                    arrTask[i] = task;
//                    System.out.println("added task");
//                    break;
//                }
//            }
        }
    }
    
}
