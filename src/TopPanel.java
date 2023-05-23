import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class TopPanel{
    public static final Dimension DMS_SMALL = new Dimension(420, 40), DMS_EXPAND = new Dimension(420, 240);
    private JPanel panel,paneltable,paneladdTask,panelInfo,panelleft,panelright,paneldraw;
    private JButton table,addTask;
    private JTable Jtable;
    private JDesktopPane desktopPane;
    private JInternalFrame internalFrame;
    public TopPanel(){
        panel = new JPanel();
        table = new JButton("Table");
        addTask = new JButton("+Add Task");
        paneltable = new JPanel();
        paneladdTask = new JPanel();
        panelInfo = new JPanel();
        panelleft = new JPanel();
        panelright = new JPanel();
        paneldraw = new PanelDrawGIF();
        paneltable.setBorder(new EmptyBorder(0, 20, 0, 0));
        paneladdTask.setBorder(new EmptyBorder(0, 0, 0, 20));
        //panelInfo.setBorder(BorderFactory.createLineBorder(Color.red));
        panelInfo.setPreferredSize(new Dimension(220,240));
        desktopPane = new JDesktopPane();
        
        //internalFrame = new JInternalFrame("Task info", false, true);
//        panelleft.setLayout(Bo);
//        panelleft.add(panelInfo);
        panelright.setLayout(new BorderLayout());
        panelright.setOpaque(false);
        paneldraw.setOpaque(false);
        paneldraw.setVisible(true);
        paneldraw.setPreferredSize(new Dimension(200,200));
        paneldraw.setVisible(false);
        paneldraw.setBorder(new EmptyBorder(45, 0, 0, 0));
//        paneldraw.setBorder(BorderFactory.createLineBorder(Color.RED));
//        paneltable.setBorder(BorderFactory.createLineBorder(Color.RED));
//        paneladdTask.setBorder(BorderFactory.createLineBorder(Color.RED));
        panelright.add(paneltable, BorderLayout.CENTER);
        panelright.add(paneladdTask,  BorderLayout.EAST);
        panelright.add(paneldraw,  BorderLayout.SOUTH);
        
        panel.setBorder(new EmptyBorder(6, 6, 6, 6));
        panel.setPreferredSize(DMS_SMALL);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        paneltable.add(table);
        paneladdTask.add(addTask);
        panel.add(panelInfo);
        panel.add(panelright);
//        panel.add(paneltable);
//        panel.add(paneladdTask);
        panel.setOpaque(true);
        panel.setBackground(new Color(250, 229, 172));
        paneltable.setOpaque(false);
        paneladdTask.setOpaque(false);
        
        table.setOpaque(true);
        table.setBackground(new Color(240, 192, 103));
        addTask.setBackground(new Color(240, 192, 103));
        table.setUI(new StyledButtonUI());
        addTask.setUI(new StyledButtonUI());
        
        panelInfo.setLayout(new BorderLayout());
        //desktopPane.add(internalFrame);
        panelInfo.add(desktopPane);
//        panelInfo.setBackground(Color.red);
//        desktopPane.setBackground(Color.green);
        //internalFrame.setBackground(Color.yellow);
        
        desktopPane.setSize(DMS_SMALL);
        desktopPane.setLayout(new FlowLayout(FlowLayout.CENTER));
        //internalFrame.setPreferredSize(new Dimension(220,220));
        System.out.println(desktopPane.getLayout());
        
        //internalFrame.setVisible(false);
        
    }
    public void refresh(Dimension dimen){
        panel.setPreferredSize(dimen);
        panel.revalidate();
        panel.repaint();
    }

    public JPanel getPanelleft() {
        return panelleft;
    }

    public void setPanelleft(JPanel panelleft) {
        this.panelleft = panelleft;
    }

    public JPanel getPanelright() {
        return panelright;
    }

    public void setPanelright(JPanel panelright) {
        this.panelright = panelright;
    }

    public JPanel getPaneldraw() {
        return paneldraw;
    }

    public void setPaneldraw(JPanel paneldraw) {
        this.paneldraw = paneldraw;
    }

    public JPanel getPaneltable() {
        return paneltable;
    }

    public void setPaneltable(JPanel paneltable) {
        this.paneltable = paneltable;
    }

    public JPanel getPaneladdTask() {
        return paneladdTask;
    }

    public void setPaneladdTask(JPanel paneladdTask) {
        this.paneladdTask = paneladdTask;
    }

    public JPanel getPanelInfo() {
        return panelInfo;
    }

    public void setPanelInfo(JPanel panelInfo) {
        this.panelInfo = panelInfo;
    }

    public JDesktopPane getDesktopPane() {
        return desktopPane;
    }

    public void setDesktopPane(JDesktopPane desktopPane) {
        this.desktopPane = desktopPane;
    }

    public JInternalFrame getInternalFrame() {
        return internalFrame;
    }

    public void setInternalFrame(JInternalFrame internalFrame) {
        this.internalFrame = internalFrame;
    }

    public JPanel getPanel() {
        return panel;
    }

    public JTable getJtable() {
        return Jtable;
    }

    public void setJtable(JTable Jtable) {
        this.Jtable = Jtable;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JButton getTable() {
        return table;
    }

    public void setTable(JButton table) {
        this.table = table;
    }

    public JButton getAddTask() {
        return addTask;
    }

    public void setAddTask(JButton addTask) {
        this.addTask = addTask;
    }
    
}
