
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Member;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

public class AddTaskController implements ActionListener{

    private AddTaskView view;
    private AddTaskModel model;
    private TaskListModel modell;
    private TaskTableView taskTableView;
    
    //private GUIMenu gui;

    public AddTaskController() {
        view = new AddTaskView();
        model = new AddTaskModel();
        modell = new TaskListModel();
        taskTableView = new TaskTableView(modell);
        
        view.getSubmit().addActionListener(this); 
            
    
//            if (ae.getSource() == gui.getBt_addTask()){
//                AddTaskView atv = new AddTaskView();
//            }
/*
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String theDate = dateFormat.format(view.getjDateChooser1().getDate());

                Task task = new Task(view.getTxt1().getText(), view.getTxt2().getText(), view.getjDateChooser1(), true);
                modell.addTask(task);
                System.out.println("Yeah");

            }
        });
*/
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==view.getSubmit()){
            System.out.println(view.getTxt1().getText());
            System.out.println(view.getTxt2().getText());
            System.out.println(view.getTimedate().getValue());
            
            DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            System.out.println(df.format(view.getDateChooser().getDate()));
            
            System.out.println(view.getCheckbox().isSelected());
            
            Task task = new Task(view.getTxt1().getText(), view.getTxt2().getText(), df.format(view.getDateChooser().getDate()), view.getCheckbox().isSelected());
            taskTableView.taskAdded(task);
        }
        
    }
    public void addDataToJTable(String name, String description, String expireDate, boolean status){
        //TaskTableView taskview = new TaskTableView(modell);
        
    }
    
    
}
