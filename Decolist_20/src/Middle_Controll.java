import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.LinkedList;
import javax.swing.*;


public class Middle_Controll implements ActionListener{
    Middle_View view;
    LinkedList<Task> arrTasks;
    HashMap<Integer, JPanel> mapPanel;
    New_GUIController GUIControll;
    public Middle_Controll(New_GUIController GUIControll) {
        view = new Middle_View();
        this.GUIControll = GUIControll;
        this.arrTasks = GUIControll.getModel().getArrTasks();
        mapPanel = new HashMap<Integer, JPanel>();
        refresh();
    }
    public void refresh(){
        this.arrTasks = GUIControll.getModel().getArrTasks();
        view.removeAll();
        mapPanel.clear();
        for(int i=0;i<arrTasks.size();i++){
            System.out.println(arrTasks.get(i).isStatus());
            if(arrTasks.get(i) != null && !arrTasks.get(i).isStatus()){
                mapPanel.put(i, new GUITask(arrTasks.get(i).getNumber(),arrTasks.get(i).getTaskName(),arrTasks.get(i).getTaskDescription(),arrTasks.get(i).getExpireTime(),arrTasks.get(i).getExpireDate()));
                ((GUITask)mapPanel.get(i)).getBtDone().addActionListener(this);
                ((GUITask)mapPanel.get(i)).getBtCancle().addActionListener(this);
                Thread thread = new Thread((GUITask)mapPanel.get(i));
                thread.start();
                //view.add(mapPanel.get(i));
            }else if(arrTasks.get(i) == null){
                break;
            }
        }
        
        LinkedList<Integer> SortedList = new LinkedList<>();
        Set<Integer> setkey = new HashSet();
        setkey = mapPanel.keySet();
        int temp = mapPanel.size();
        for(int j=0; j<temp ;j++){//times to do
            System.out.println(mapPanel.size()+"MPZZZZZZ");
            System.out.print("j" + j);
            //System.out.println("j = " + j);
            Iterator ite = setkey.iterator();
            long min = Long.MAX_VALUE;
            int minkey = 0;
            for(int k=0; k<mapPanel.size();k++){//find min
                System.out.print("k" + k);
                //System.out.println("k = " + k);
                int key = (int)ite.next();
                if(((GUITask)mapPanel.get(key)).getSec_left()<min){
                    min = ((GUITask)mapPanel.get(key)).getSec_left();
                    minkey = key;
                }
            }
            System.out.println(minkey +", " + min);
            System.out.println(mapPanel.keySet());
            view.add(mapPanel.get(minkey));
            System.out.println(setkey);
            setkey.remove(minkey);
        }
        view.revalidate();
        view.repaint();
        System.out.println("refresh middle panel");
    }
    
//    public void startThread(){
//    }
    public void actionPerformed(ActionEvent e){
        JButton bte = (JButton)e.getSource();
        GUITask thatpanel = (GUITask)bte.getParent().getParent();
        int Panelnumber = thatpanel.getNumber();
        if(e.getSource().equals(thatpanel.getBtDone())){
            System.out.println("clicker");
            int jOptionSelect = JOptionPane.showConfirmDialog(thatpanel, "Aye you sure to complete this task?\n["+thatpanel.getName()+"]", "Confirm action", JOptionPane.YES_NO_OPTION);
            if(jOptionSelect == 0){
                thatpanel.getBtDone().setVisible(false);
                thatpanel.getBtCancle().setVisible(true);
                thatpanel.removeAll();
                thatpanel.add(thatpanel.getJpanelfirst(), BorderLayout.WEST);
                thatpanel.add(thatpanel.getJpanelcenter(), BorderLayout.CENTER);
                thatpanel.add(thatpanel.getDonePanel(), BorderLayout.EAST);
                thatpanel.revalidate();
                thatpanel.repaint();
                this.arrTasks = GUIControll.getModel().getArrTasks();
                arrTasks.get(Panelnumber-1).setStatus(true);
                System.out.println(arrTasks.get(Panelnumber-1).isStatus()+"eeeeeeeee");
            }
        }else if(e.getSource().equals(thatpanel.getBtCancle())){
            thatpanel.getBtDone().setVisible(true);
            thatpanel.getBtCancle().setVisible(false);
            thatpanel.removeAll();
            thatpanel.add(thatpanel.getJpanelfirst(), BorderLayout.WEST);
            thatpanel.add(thatpanel.getJpanelcenter(), BorderLayout.CENTER);
            thatpanel.add(thatpanel.getjPanellast(), BorderLayout.EAST);
            thatpanel.revalidate();
            thatpanel.repaint();
            GUIControll.getModel().getArrTasks().get(Panelnumber-1).setStatus(false);
        }
    }
    public Middle_View getView() {
        return view;
    }

    public void setView(Middle_View view) {
        this.view = view;
    }
    
}
