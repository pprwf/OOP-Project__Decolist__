import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        /*
        RoomController1 ct = new RoomController1();
        ct.furAllowAccess("bed", "red");
        ct.furAllowAccess("bed", "blue");
        ct.furAllowAccess("table", "red");
        ct.furAllowAccess("table", "blue");
        ct.furAllowAccess("table", "green");
        ct.furAllowAccess("table", "yellow");
        ct.furAllowAccess("computer", "red");
        ct.furAllowAccess("computer", "blue");
        ct.furAllowAccess("computer", "green");
        ct.furAllowAccess("computer", "yellow");
*/
        //new GUIMenu();
        //new BottomController();
        //new BottomView();
        //new AddTaskController();
        //TaskListModel model = new TaskListModel();
        //TaskTableView taskTableView = new TaskTableView(model);
        //new AddTaskView();
        //new TestController();
        
//        try{//UIManager.getSystemLookAndFeelClassName()  "javax.swing.plaf.nimbus.NimbusLookAndFeel"  
//            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        SwingUtilities.invokeLater(() -> { desktopPane = new JDesktopPane(); });
        try{
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        }catch(Exception e){
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> { New_GUIController frame = new New_GUIController(); });
        //new New_GUIController();
        //new TopPanel();
    }
}
