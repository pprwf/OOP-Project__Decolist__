import java.awt.event.*;

public class GUIController implements WindowListener, ActionListener{
    GUIModel model;
    GUIView view;
    AddTaskController addTaskControll;
    BottomController bottomComtroll;
    TopPanel toppanel;
    MiddleController middle_Con;
    public GUIController() {
        model = new GUIModel() {};
        bottomComtroll = new BottomController(this);
        middle_Con = new MiddleController(this, bottomComtroll.getBv());
        toppanel = new TopPanel();
        view = new GUIView(toppanel.getPanel(), bottomComtroll, middle_Con.getView()) {};
        
        toppanel.getAddTask().addActionListener(this);
        toppanel.getTable().addActionListener(this);
        view.getFrame1().addWindowListener(this);
    }
    public void addDataToJTable(){
        model.getDFJtable().setRowCount(0);
            for(int i=0;i<model.getArrTasks().size();i++){
                if(model.getArrTasks().get(i)!= null){ 
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
            JtableShow jtableShow = new JtableShow(model.getJtable());
        }
    }
    public void windowClosing(WindowEvent e){
       if(e.getSource().equals(view.getFrame1())){
            model.saveData(model.getArrTasks());
        }
        bottomComtroll.savePercent();
    } 
    public void windowOpened(WindowEvent e){
        if(e.getSource().equals(view.getFrame1())){
            model.loadData();
        }
        bottomComtroll.loadPercent();
    }
    public void windowDeactivated(WindowEvent e){}
    public void windowActivated(WindowEvent e){}
    
    public void windowIconified(WindowEvent e){}
    public void windowDeiconified(WindowEvent e){}
    public void windowClosed(WindowEvent e){}

    public GUIView getView() {
        return view;
    }

    public void setView(GUIView view) {
        this.view = view;
    }

    public GUIModel getModel() {
        return model;
    }

    public void setModel(GUIModel model) {
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

    public MiddleController getMiddle_Con() {
        return middle_Con;
    }

    public void setMiddle_Con(MiddleController middle_Con) {
        this.middle_Con = middle_Con;
    }
}
   

