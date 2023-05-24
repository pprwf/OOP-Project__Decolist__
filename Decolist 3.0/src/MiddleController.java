import java.awt.*;
import java.awt.font.TextAttribute;
import java.awt.event.*;
import java.net.URL;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

public class MiddleController implements ActionListener, MouseListener, InternalFrameListener{
    private MiddleView view;
    private BottomView bv;
    private LinkedList<Task> arrTasks;
    private HashMap<Integer, JPanel> mapPanel;
    private GUIController GUIControll;
    private URL url;
    private Icon icon;
    private JLabel ltorielGIF;
    private Font mainText, confirmText;
    public MiddleController(GUIController GUIControll, BottomView botView) {
        mainText = new ThaiFont().thBold.deriveFont(25f);
        confirmText = new ThaiFont().thBold.deriveFont(18f);
        view = new MiddleView() {};
        bv = botView;
        this.GUIControll = GUIControll;
        this.arrTasks = GUIControll.getModel().getArrTasks();
        mapPanel = new HashMap<Integer, JPanel>();
        url = getClass().getResource("toriel_sleep2.gif");
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
            if(arrTasks.get(i) != null && !arrTasks.get(i).isStatus()){
                mapPanel.put(i, new GUITask(arrTasks.get(i).getNumber(),arrTasks.get(i).getTaskName(),arrTasks.get(i).getTaskDescription(),arrTasks.get(i).getExpireTime(),arrTasks.get(i).getExpireDate()));
                ((GUITask)mapPanel.get(i)).getBtDone().addActionListener(this);
                ((GUITask)mapPanel.get(i)).getBtCancle().addActionListener(this);
                ((GUITask)mapPanel.get(i)).getLabelName().addMouseListener(this);
                Thread thread = new Thread((GUITask)mapPanel.get(i));
                thread.start();
            }else if(arrTasks.get(i) == null){
                break;
            }
        }
        
        LinkedList<Integer> SortedList = new LinkedList<>();
        Set<Integer> setkey = new HashSet();
        setkey = mapPanel.keySet();
        int temp = mapPanel.size();
        for(int j=0; j<temp ;j++){
            Iterator ite = setkey.iterator();
            long min = Long.MAX_VALUE;
            int minkey = 0;
            for(int k=0; k<mapPanel.size();k++){
                int key = (int)ite.next();
                if(((GUITask)mapPanel.get(key)).getSec_left()<min){
                    min = ((GUITask)mapPanel.get(key)).getSec_left();
                    minkey = key;
                }
            }
            view.add(mapPanel.get(minkey));
            setkey.remove(minkey);
        }
        view.revalidate();
        view.repaint();
    }

    public void actionPerformed(ActionEvent e){
        JButton bte = (JButton)e.getSource();
        GUITask thatpanel = (GUITask)bte.getParent().getParent();
        int Panelnumber = thatpanel.getNumber();
        if(e.getSource().equals(thatpanel.getBtDone())){
            JLabel taskName = new JLabel(thatpanel.getName());
            taskName.setFont(mainText);
            JLabel label = new JLabel("Are you sure that you complete <"+ thatpanel.getName() +"> task?");
            label.setFont(mainText);
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
            if(GUIControll.getToppanel().getInternalFrame() != null){
                GUIControll.getToppanel().getInternalFrame().dispose();
            }
            GUIControll.getToppanel().setInternalFrame(new JInternalFrame("Task info", false, true));
            JInternalFrame internalFrame = GUIControll.getToppanel().getInternalFrame();
            JDesktopPane desktopPane = GUIControll.getToppanel().getDesktopPane();
            JPanel paneldraw = GUIControll.getToppanel().getPaneldraw();
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

            panel_timeAdate.setBorder(new EmptyBorder(10, 0, 0, 0));
            
            lTitle.setFont(mainText);
            lDes.setFont(confirmText);
            lDate.setFont(confirmText);
            lTime.setFont(confirmText);
            
            Font font = lTitle.getFont();
            Map attributes = font.getAttributes();
            attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
            lTitle.setFont(font.deriveFont(attributes));
            lTitle.setText("Title: "+ thatpanel.getName());
            lDes.setText("Description: "+thatpanel.getDes());
            lDate.setText("Expire: ");
            lTime.setText(thatpanel.getExp() +" "+thatpanel.getTime());
            panel_big.setMaximumSize(new Dimension(200 , 4000));
            internalFrame.add(sc);
            paneldraw.setVisible(true);
            paneldraw.add(ltorielGIF);
            
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
    
    public MiddleView getView() {
        return view;
    }

    public void setView(MiddleView view) {
        this.view = view;
    }

    public void mousePressed(MouseEvent me){}
    public void mouseReleased(MouseEvent me){}	
    public void internalFrameClosing(InternalFrameEvent e) {
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
