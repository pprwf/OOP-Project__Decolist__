import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.util.Calendar;
import java.awt.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.*;
import java.util.Date;
import java.util.GregorianCalendar;

public abstract class AddTaskView {
    private Font thai;
    private JFrame frame;
    private JButton submit;
    private JPanel panel1,panel2,panel3;
    private JTextField txt1,txt2;
    private JLabel addtask,Des,extime,exdate,topic;
    private JDateChooser DateChooser;
    private JCalendar calendar;
    private JSpinner timedate;
    private SpinnerDateModel timemodel;
    private JSpinner.DateEditor timeedit;

    public AddTaskView(){
        thai = new ThaiFont().thBold.deriveFont(20f);
        frame = new JFrame("Add To Do List");
        submit = new JButton("Submit");
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        txt1 = new JTextField();
        txt2 = new JTextField();
        addtask = new JLabel("Add Task");
        Des = new JLabel("Description");
        extime = new JLabel("Expire Time");
        exdate = new JLabel("Expire Date");
        topic = new JLabel("Add To Do List");
        timemodel = new SpinnerDateModel();
        timedate = new JSpinner(timemodel);
        timeedit = new JSpinner.DateEditor(timedate, "HH:mm");
        DateChooser = new com.toedter.calendar.JDateChooser();
        calendar = new JCalendar();
        calendar.setLocale(new Locale("en", "US"));

        Calendar maxDate = Calendar.getInstance();
        maxDate.set(3000, Calendar.DECEMBER, 31);
        Date maxSelectableDate = maxDate.getTime();
        Calendar minDate = Calendar.getInstance();
        minDate.setTime(new Date());
        Date minSelectableDate = minDate.getTime();
        
        Date dateToday = calendar.getDate();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String str = dateFormat.format(dateToday);
        int year = Integer.parseInt(str.substring(0, 4));
        if(year > 2500){
            year -= 543;
        }
        str = year + str.substring(4, 10);
        try{
            DateChooser.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(str));
        }
        catch(ParseException Pe){
            Pe.printStackTrace();
        }
        
        DateChooser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        DateChooser.setToolTipText("");
        DateChooser.setDateFormatString("dd-MM-yyyy");
        DateChooser.setMaxSelectableDate(maxSelectableDate);
        DateChooser.setMinSelectableDate(minSelectableDate);
        
        timedate.setEditor(timeedit);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        timemodel.setValue(calendar.getTime());
        
        
        frame.setPreferredSize(new Dimension(300,240));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        
        panel1.setLayout(new FlowLayout());
        panel1.add(topic);
        
        panel2.setLayout(new GridLayout(4,4));
        txt1.setFont(thai);
        panel2.add(addtask); 
        panel2.add(txt1);
        txt2.setFont(thai);
        panel2.add(Des); 
        panel2.add(txt2);
        panel2.add(extime); 
        panel2.add(timedate);
        panel2.add(exdate);
        panel2.add(DateChooser);
        
        panel3.setLayout(new GridLayout(1,0));
        panel3.add(submit);
        frame.setLocationRelativeTo(null);
        frame.add(panel1,BorderLayout.NORTH);
        frame.add(panel2,BorderLayout.CENTER);
        frame.add(panel3,BorderLayout.SOUTH);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        
    }   

    public JDateChooser getDateChooser() {
        return DateChooser;
    }

    public void setDateChooser(JDateChooser DateChooser) {
        this.DateChooser = DateChooser;
    }

    public JCalendar getCalendar() {
        return calendar;
    }

    public void setCalendar(JCalendar calendar) {
        this.calendar = calendar;
    }

    public JButton getSubmit() {
        return submit;
    }

    public void setSubmit(JButton submit) {
        this.submit = submit;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public void setPanel2(JPanel panel2) {
        this.panel2 = panel2;
    }

    public JPanel getPanel3() {
        return panel3;
    }

    public void setPanel3(JPanel panel3) {
        this.panel3 = panel3;
    }

    public JTextField getTxt1() {
        return txt1;
    }

    public void setTxt1(JTextField txt1) {
        this.txt1 = txt1;
    }

    public JTextField getTxt2() {
        return txt2;
    }

    public void setTxt2(JTextField txt2) {
        this.txt2 = txt2;
    }

    public JLabel getAddtask() {
        return addtask;
    }

    public void setAddtask(JLabel addtask) {
        this.addtask = addtask;
    }

    public JLabel getDes() {
        return Des;
    }

    public void setDes(JLabel Des) {
        this.Des = Des;
    }

    public JLabel getExtime() {
        return extime;
    }

    public void setExtime(JLabel extime) {
        this.extime = extime;
    }

    public JLabel getExdate() {
        return exdate;
    }

    public void setExdate(JLabel exdate) {
        this.exdate = exdate;
    }

    public JLabel getTopic() {
        return topic;
    }

    public void setTopic(JLabel topic) {
        this.topic = topic;
    }

    public JSpinner getTimedate() {
        return timedate;
    }

    public void setTimedate(JSpinner timedate) {
        this.timedate = timedate;
    }

    public SpinnerDateModel getTimemodel() {
        return timemodel;
    }

    public void setTimemodel(SpinnerDateModel timemodel) {
        this.timemodel = timemodel;
    }

    public JSpinner.DateEditor getTimeedit() {
        return timeedit;
    }

    public void setTimeedit(JSpinner.DateEditor timeedit) {
        this.timeedit = timeedit;
    }
    
}
