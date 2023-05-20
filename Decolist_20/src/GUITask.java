import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
//import java.awt.event.ActionListener;
//import java.awt.event.ItemEvent;
//import java.awt.event.ItemListener;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import javax.swing.border.EmptyBorder;

public class GUITask extends JPanel implements Runnable{
    private int number;
    private String name, des, time, exp;
    private JPanel jpanelfirst,jpanelcenter, jPanellast;
    private JPanel DonePanel;
    private JLabel labelName, labelDes, labelTime, labelDate;
    private JButton btDone, btCancle;
    private long year_left,month_left,day_left,hr_left,min_lift,sec_left;
    private int due_year,due_month,due_day,due_hr,due_min,due_sec;
    private LocalDateTime dueDateTime;

    public GUITask(int number, String name, String des, String time, String exp) {

        due_day = Integer.parseInt(exp.substring(0, 2));
        due_month = Integer.parseInt(exp.substring(3, 5));
        due_year = Integer.parseInt(exp.substring(6, 10));
        due_hr = Integer.parseInt(time.substring(0, 2));
        due_min = Integer.parseInt(time.substring(3, 5));
        due_sec = Integer.parseInt(time.substring(6, 8));
        dueDateTime = LocalDateTime.of(due_year, due_month, due_day, due_hr, due_min, due_sec, 0);
        
        this.number = number;
        this.name = name;
        this.des = des;
        this.time = time;
        this.exp = exp;
        btDone = new JButton("<html>Mark as<center>Done</center></html>");
        btCancle = new JButton("Cancle");
        this.setMaximumSize(new Dimension(420,70));
        this.setLayout(new BorderLayout());
        this.setBorder(new EmptyBorder(3, 0, 3, 0));
        this.setOpaque(false);
        this.setBackground(Middle_View.BG_COLOR);
        DonePanel = new JPanel();
        jpanelfirst = new JPanel();
        jpanelcenter = new JPanel();
        jPanellast = new JPanel();
        labelName = new JLabel(name);
        labelDes = new JLabel(des);
        labelTime = new JLabel(time);
        labelDate = new JLabel(exp +" "+ time);
        
        jpanelfirst.setOpaque(false);
        jpanelcenter.setOpaque(false);
        jPanellast.setOpaque(false);
        labelName.setOpaque(false);
        labelDes.setOpaque(false);
        labelTime.setOpaque(false);
        labelDate.setOpaque(false);
        labelName.setFont(new Font("serif", Font.BOLD, 25));
        labelDes.setFont(new Font("serif", Font.PLAIN, 15));
        labelTime.setFont(new Font("serif", Font.BOLD, 25));
        labelDate.setFont(new Font("serif", Font.PLAIN, 10));
        labelName.setPreferredSize(new Dimension(140,35));
        labelDes.setPreferredSize(new Dimension(140,25));
        labelTime.setPreferredSize(new Dimension(100,48));
        labelDate.setPreferredSize(new Dimension(100,12));
        this.add(jpanelfirst, BorderLayout.WEST); 
        this.add(jpanelcenter, BorderLayout.CENTER); 
        this.add(jPanellast, BorderLayout.EAST);
        
        jpanelfirst.setLayout(new BorderLayout());
        jpanelfirst.setPreferredSize(new Dimension(70,70));
        jpanelfirst.add(btDone, BorderLayout.NORTH);
        jpanelfirst.add(btCancle, BorderLayout.SOUTH);
        btCancle.setVisible(false);

        //jpanelfirst.setBorder(BorderFactory.createLineBorder(Color.RED));
        jpanelcenter.setLayout(new BorderLayout());
        jpanelcenter.add(labelName, BorderLayout.NORTH);
        jpanelcenter.add(labelDes, BorderLayout.SOUTH);
        labelDes.setForeground(Color.gray);
        
        jPanellast.setLayout(new BorderLayout());
        jPanellast.setBorder(new EmptyBorder(4, 0, 2, 0));
        jPanellast.add(labelTime, BorderLayout.NORTH);
        jPanellast.add(labelDate, BorderLayout.SOUTH);
        
        //jpanelfirst.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        jpanelfirst.setBorder(new EmptyBorder(10, 6, 1, 6));
//        jpanelcenter.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
//        jPanellast.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        
        //.setOpaque(true);
        //labelName.setBackground(new Color(190, 255, 250));
        labelName.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.GRAY));
        Font font = labelName.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        labelName.setFont(font.deriveFont(attributes));
        //labelDes.setOpaque(true);
        //labelDes.setBackground(new Color(130, 230, 250));
        labelTime.setHorizontalAlignment(JLabel.CENTER);
        labelTime.setForeground(Color.RED);
        labelDate.setHorizontalAlignment(JLabel.CENTER);
        
        DonePanel.setLayout(new GridLayout(1,1));
        DonePanel.setOpaque(false);
        //DonePanel.setBackground(Color.black);
        DonePanel.setPreferredSize(new Dimension(140,60));
        DonePanel.setBorder(new EmptyBorder(10, 0, 0, 0));
        JLabel lDonenew = new JLabel("Done");
        lDonenew.setForeground(Color.BLACK);
        lDonenew.setHorizontalAlignment(JLabel.CENTER);
        lDonenew.setFont(new Font("Calibri", Font.BOLD, 40));
        DonePanel.add(lDonenew);
        
//        btDone.setAlignmentY(Component.CENTER_ALIGNMENT);
//        btDone.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        //btDone.setBounds(0, 0, 50, 50);
        btDone.setPreferredSize(new Dimension(50,40));
        btDone.setFont(new Font("Calibri", Font.PLAIN, 10));
        btDone.setBackground(new Color(20, 255, 99));
        btDone.setUI(new StyledButtonUI());
        //btCancle.setBounds(0, 0, 50, 30);
        btCancle.setPreferredSize(new Dimension(50,30));
        btCancle.setFont(new Font("Calibri", Font.PLAIN, 10));
        btCancle.setBackground(Color.PINK);
        btCancle.setUI(new StyledButtonUI());
        
//        btDone.addActionListener(this);
//        btCancle.addActionListener(this);
        repaint();
        revalidate();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Stroke oldStroke = g2d.getStroke();
        g2d.setColor(new Color(236, 236, 157));
        g2d.fillRoundRect(0, 3, this.getWidth(), 65, 25, 25);
        
        g2d.setStroke(new BasicStroke(3));
        g2d.setColor(new Color(180, 180, 100));
        g2d.drawRoundRect(0, 3, this.getWidth(), 65, 25, 25);
        g2d.setStroke(oldStroke);
    }
    @Override
    public void run(){
        while(true){
            //2023-05-20T00:16:09.804209200 format example
            //2023 5 20 0 22 21
            LocalDateTime dateAndTimeNow = LocalDateTime.now();
            year_left = dateAndTimeNow.until(dueDateTime, ChronoUnit.YEARS);
            month_left = dateAndTimeNow.until(dueDateTime, ChronoUnit.MONTHS);
            day_left = dateAndTimeNow.until(dueDateTime, ChronoUnit.DAYS);
            hr_left = dateAndTimeNow.until(dueDateTime, ChronoUnit.HOURS);
            min_lift = dateAndTimeNow.until(dueDateTime, ChronoUnit.MINUTES);
            sec_left = dateAndTimeNow.until(dueDateTime, ChronoUnit.SECONDS);
            
            if(year_left > 0){
                labelTime.setText(year_left + " year");
            }else if(month_left > 0){
                labelTime.setText(month_left + " month");
            }else if(day_left > 0){
                labelTime.setText(day_left + " day");
            }else if(hr_left > 0){
                labelTime.setText(hr_left + " hours");
            }else if(min_lift > 0){
                labelTime.setText(min_lift + " min");
            }else if(sec_left > 0){
                labelTime.setText(sec_left + " sec");
            }else{
                labelTime.setText("Timeout");
                break;
//                try {
//                    System.out.println("wait");
//                    this.wait();
//                } catch (InterruptedException ex) {
//                    ex.printStackTrace();
//                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
        System.out.println("end Run");
    }
//    public void actionPerformed(ActionEvent e){
//        if(e.getSource().equals(btDone)){
//            System.out.println("clicker");
//            //int jOptionSelect = JOptionPane.showConfirmDialog(this, "Aye you sure to complete this task");
//            int jOptionSelect = JOptionPane.showConfirmDialog(this, "Aye you sure to complete this task?\n["+name+"]", "Confirm action", JOptionPane.YES_NO_OPTION);
//            //yes0 no1 cancle2 exit-1
//            //System.out.println(JOptionPane.showConfirmDialog(this, "Aye you sure to complete this task"));
//            if(jOptionSelect == 0){
//                btDone.setVisible(false);
//                btCancle.setVisible(true);
//            }
//        }else if(e.getSource().equals(btCancle)){
//            btCancle.setVisible(false);
//            btDone.setVisible(true);
//        }
//    }
//    public void stageChageAction(boolean done){
//        if(done){
//            
//        }
//    }
//    public void refresh(){
//        
//    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public JPanel getJpanelfirst() {
        return jpanelfirst;
    }

    public void setJpanelfirst(JPanel jpanelfirst) {
        this.jpanelfirst = jpanelfirst;
    }

    public JPanel getJpanelcenter() {
        return jpanelcenter;
    }

    public void setJpanelcenter(JPanel jpanelcenter) {
        this.jpanelcenter = jpanelcenter;
    }

    public JPanel getjPanellast() {
        return jPanellast;
    }

    public void setjPanellast(JPanel jPanellast) {
        this.jPanellast = jPanellast;
    }

    public JPanel getDonePanel() {
        return DonePanel;
    }

    public void setDonePanel(JPanel DonePanel) {
        this.DonePanel = DonePanel;
    }

    public JLabel getLabelName() {
        return labelName;
    }

    public void setLabelName(JLabel labelName) {
        this.labelName = labelName;
    }

    public JLabel getLabelDes() {
        return labelDes;
    }

    public void setLabelDes(JLabel labelDes) {
        this.labelDes = labelDes;
    }

    public JLabel getLabelTime() {
        return labelTime;
    }

    public void setLabelTime(JLabel labelTime) {
        this.labelTime = labelTime;
    }

    public JLabel getLabelDate() {
        return labelDate;
    }

    public void setLabelDate(JLabel labelDate) {
        this.labelDate = labelDate;
    }

    public JButton getBtDone() {
        return btDone;
    }

    public void setBtDone(JButton btDone) {
        this.btDone = btDone;
    }

    public JButton getBtCancle() {
        return btCancle;
    }

    public void setBtCancle(JButton btCancle) {
        this.btCancle = btCancle;
    }

    public long getYear_left() {
        return year_left;
    }

    public void setYear_left(long year_left) {
        this.year_left = year_left;
    }

    public long getMonth_left() {
        return month_left;
    }

    public void setMonth_left(long month_left) {
        this.month_left = month_left;
    }

    public long getDay_left() {
        return day_left;
    }

    public void setDay_left(long day_left) {
        this.day_left = day_left;
    }

    public long getHr_left() {
        return hr_left;
    }

    public void setHr_left(long hr_left) {
        this.hr_left = hr_left;
    }

    public long getMin_lift() {
        return min_lift;
    }

    public void setMin_lift(long min_lift) {
        this.min_lift = min_lift;
    }

    public long getSec_left() {
        return sec_left;
    }

    public void setSec_left(long sec_left) {
        this.sec_left = sec_left;
    }

    public int getDue_year() {
        return due_year;
    }

    public void setDue_year(int due_year) {
        this.due_year = due_year;
    }

    public int getDue_month() {
        return due_month;
    }

    public void setDue_month(int due_month) {
        this.due_month = due_month;
    }

    public int getDue_day() {
        return due_day;
    }

    public void setDue_day(int due_day) {
        this.due_day = due_day;
    }

    public int getDue_hr() {
        return due_hr;
    }

    public void setDue_hr(int due_hr) {
        this.due_hr = due_hr;
    }

    public int getDue_min() {
        return due_min;
    }

    public void setDue_min(int due_min) {
        this.due_min = due_min;
    }

    public int getDue_sec() {
        return due_sec;
    }

    public void setDue_sec(int due_sec) {
        this.due_sec = due_sec;
    }

    public LocalDateTime getDueDateTime() {
        return dueDateTime;
    }

    public void setDueDateTime(LocalDateTime dueDateTime) {
        this.dueDateTime = dueDateTime;
    }
    
    
}
