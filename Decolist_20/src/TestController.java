
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JTextField;


public class TestController implements ActionListener{
    private AddTaskView view;
    public TestController() {
        view = new AddTaskView();
        view.getSubmit().addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==view.getSubmit()){
            System.out.println(view.getTxt1().getText());
            System.out.println(view.getTxt2().getText());
            System.out.println(view.getTimedate().getValue());
            
            DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            System.out.println(df.format(view.getDateChooser().getDate()));
            //System.out.println(view.getCheckbox().isSelected());
            System.out.println("Hello");
        }
    //    public void actionPerformed(ActionEvent ae){
//        System.out.println("11111111111");
////        if(ae.getSource().equals(view.getBt_addTask())){
////            addTaskControll = new AddTaskController();
////        }
//        if(ae.getSource().equals(view.getAddTask())){
//            System.out.println("add task");
//            System.out.println("eiew");
//            addTaskControll = new AddTaskController(model.getArrTasks());   
//        }else if(ae.getSource().equals(view.getShowTable())){
//            System.out.println("show table");
//            for( int i = 0;i<200;i++){
//                if(model.getArrTasks()[i]!= null & model.getDFJtable().getRowCount() <= i){
//                    System.out.println("no null");
//                    Object[] rowData = {model.getArrTasks()[i].getTaskName(), model.getArrTasks()[i].getTaskDescription(),model.getArrTasks()[i].getExpireTime(),model.getArrTasks()[i].getExpireDate(),model.getArrTasks()[i].isStatus()};
//                    model.getDFJtable().addRow(rowData);
//                }else if (model.getArrTasks()[i]== null){
//                    break;
//                }
//            }
//            new New_JtableShow(model.getJtable());
    }
}
