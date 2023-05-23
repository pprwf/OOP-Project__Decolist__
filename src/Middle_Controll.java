import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.net.URL;
import java.util.*;
import java.util.LinkedList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;


public class Middle_Controll implements ActionListener, MouseListener, InternalFrameListener{
    Middle_View view;
    BottomView bv;
    LinkedList<Task> arrTasks;
    HashMap<Integer, JPanel> mapPanel;
    New_GUIController GUIControll;
    URL url;
    Icon icon;
    JLabel ltorielGIF;
    
    public Middle_Controll(New_GUIController GUIControll, BottomView botView) {
        view = new Middle_View();
        bv = botView;
        this.GUIControll = GUIControll;
        this.arrTasks = GUIControll.getModel().getArrTasks();
        mapPanel = new HashMap<Integer, JPanel>();
        url = getClass().getResource("toriel_sleep2.gif");//animegirl_sleep.gif  toriel_sleep.gif
        icon = new ImageIcon(url);
        ltorielGIF = new JLabel(icon);
        ltorielGIF.setMaximumSize(new Dimension(150, 150));
        ltorielGIF.setOpaque(false);
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
                ((GUITask)mapPanel.get(i)).getLabelName().addMouseListener(this);
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
            JLabel label = new JLabel("<html>Aye you sure to complete this task? <br>["+thatpanel.getName()+"]</html>");
            label.setFont(new Font("TH Sarabun New", Font.PLAIN, 20));
            int jOptionSelect = JOptionPane.showConfirmDialog(thatpanel, label, "Confirm action", JOptionPane.YES_NO_OPTION);
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
                if (bv.getProgressPercent() < 100) {
                    bv.setProgressPercent(bv.getProgressPercent() + 20);
                }
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
            if (bv.getProgressPercent() <= 100) {
                    bv.setProgressPercent(bv.getProgressPercent() - 20);
            }
        }
        bv.getProgressBar().setValue(bv.getProgressPercent());
    }
    
    public void mouseClicked(MouseEvent me){
        JLabel label = (JLabel)me.getSource();
        GUITask thatpanel = (GUITask)label.getParent().getParent();
        if(me.getSource().equals(thatpanel.getLabelName())){
            System.out.println(thatpanel.getLabelName().getText());
            if(GUIControll.getToppanel().getInternalFrame() != null){
                GUIControll.getToppanel().getInternalFrame().dispose();
            }
            GUIControll.getToppanel().setInternalFrame(new JInternalFrame("Task info", false, true));
            JInternalFrame internalFrame = GUIControll.getToppanel().getInternalFrame();
            JDesktopPane desktopPane = GUIControll.getToppanel().getDesktopPane();
            JPanel paneldraw = GUIControll.getToppanel().getPaneldraw();
            //internalFrame = new JInternalFrame("Task info", false, true);
            internalFrame.setLayout(new BorderLayout());
            internalFrame.setPreferredSize(new Dimension(200,200));
            JPanel panel_big = new JPanel();
            JScrollPane sc = new JScrollPane(panel_big);
            JPanel panel_3zone = new JPanel();
            JPanel panel_timeAdate = new JPanel();
            JLabel lTitle = new JLabel(), lDes = new JLabel(), lTime = new JLabel(), lDate = new JLabel();
            
            panel_3zone.setLayout(new BorderLayout());
            panel_timeAdate.setLayout(new BorderLayout());
            
            panel_big.add(panel_3zone);
            panel_3zone.add(lTitle, BorderLayout.NORTH);
            panel_3zone.add(lDes, BorderLayout.CENTER);
            panel_3zone.add(panel_timeAdate, BorderLayout.SOUTH);
            panel_timeAdate.add(lDate, BorderLayout.WEST);
            panel_timeAdate.add(lTime, BorderLayout.CENTER);
//            panel_timeAdate.setPreferredSize(new Dimension(200,10));
            panel_timeAdate.setBorder(new EmptyBorder(10, 0, 0, 0));
            
            lTitle.setFont(new Font("TH Sarabun New", Font.BOLD, 20));
            lDes.setFont(new Font("TH Sarabun New", Font.PLAIN, 15));
            lDate.setFont(new Font("TH Sarabun New", Font.PLAIN, 15));
            lTime.setFont(new Font("TH Sarabun New", Font.PLAIN, 15));
            
            Font font = lTitle.getFont();
            Map attributes = font.getAttributes();
            attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
            lTitle.setFont(font.deriveFont(attributes));
            lTitle.setText("<html>" + "Title: "+thatpanel.getName()+ "</html>");
            lDes.setText("Description: "+thatpanel.getDes());
            lDate.setText("Expire: ");
            lTime.setText(thatpanel.getExp() +" "+thatpanel.getTime());
            panel_big.setMaximumSize(new Dimension(200 , 4000));
            internalFrame.add(sc);
            //ltorielGIF.setBorder(BorderFactory.createLineBorder(Color.BLUE));
            paneldraw.setVisible(true);
            paneldraw.add(ltorielGIF);
            
//            ltorielGIF.revalidate();
//            ltorielGIF.repaint();
            
            desktopPane.add(internalFrame);
            internalFrame.setVisible(true);
            internalFrame.addInternalFrameListener(this);
            
            GUIControll.getToppanel().getPanel().setPreferredSize(TopPanel.DMS_EXPAND);
            GUIControll.getToppanel().getPanel().revalidate();
            GUIControll.getToppanel().getPanel().repaint();
            
        }
    }
    public void mouseEntered(MouseEvent me){}
    public void mouseExited(MouseEvent me){}
    
    public Middle_View getView() {
        return view;
    }

    public void setView(Middle_View view) {
        this.view = view;
    }

    public void mousePressed(MouseEvent me){}
    public void mouseReleased(MouseEvent me){}	
    public void internalFrameClosing(InternalFrameEvent e) {
        System.out.println(e.getSource().equals(GUIControll.getToppanel().getInternalFrame())+"444444444");
        System.out.println(e.getSource().toString());
        if(e.getSource().equals(GUIControll.getToppanel().getInternalFrame())){
            JPanel paneldraw = GUIControll.getToppanel().getPaneldraw();
            paneldraw.setVisible(false);
            paneldraw.removeAll();
            GUIControll.getToppanel().getPanel().setPreferredSize(TopPanel.DMS_SMALL);
            GUIControll.getToppanel().getPanel().revalidate();
            GUIControll.getToppanel().getPanel().repaint();
        }
    }
    public void internalFrameClosed(InternalFrameEvent e) {}
    public void internalFrameOpened(InternalFrameEvent e) {}
    public void internalFrameIconified(InternalFrameEvent e) {}
    public void internalFrameDeiconified(InternalFrameEvent e) {}
    public void internalFrameActivated(InternalFrameEvent e) {}
    public void internalFrameDeactivated(InternalFrameEvent e) {}
}
