import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;
public class AddTaskView {
    private JFrame f1;
    private JButton b1;
    private JPanel p1,p2,p3;
    private JTextField txt1,txt2,txt3,txt4;
    private JCheckBox cb1;
    private JLabel l1,l2,l3,l4,l5;
    
    public AddTaskView(){
        f1 = new JFrame("Add To Do List");
        b1 = new JButton("Submit");
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        txt1 = new JTextField();
        txt2 = new JTextField();
        txt3 = new JTextField();
        txt4 = new JTextField();
        cb1 = new JCheckBox("No Expire");
        l1 = new JLabel("Add Task");
        l2 = new JLabel("Description");
        l3 = new JLabel("Expire Time");
        l4 = new JLabel("Expire Date");
        l5 = new JLabel("Add To Do List");
        
        f1.setSize(300,300);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setLayout(new BorderLayout());
        
        p1.setLayout(new FlowLayout());
        p1.add(l5);
        
        p2.setLayout(new GridLayout(4,4));
        p2.add(l1); p2.add(txt1);
        p2.add(l2); p2.add(txt2);
        p2.add(l3); p2.add(txt3);
        p2.add(l4);p2.add(txt4);
        
        p3.setLayout(new GridLayout(2,0));
        p3.add(cb1);
        p3.add(b1);
        
        f1.add(p1,BorderLayout.NORTH);
        f1.add(p2,BorderLayout.CENTER);
        f1.add(p3,BorderLayout.SOUTH);
        f1.pack();
        f1.setVisible(true);
        
        
    }

    public JFrame getF1() {
        return f1;
    }

    public void setF1(JFrame f1) {
        this.f1 = f1;
    }

    public JButton getB1() {
        return b1;
    }

    public void setB1(JButton b1) {
        this.b1 = b1;
    }

    public JPanel getP1() {
        return p1;
    }

    public void setP1(JPanel p1) {
        this.p1 = p1;
    }

    public JPanel getP2() {
        return p2;
    }

    public void setP2(JPanel p2) {
        this.p2 = p2;
    }

    public JPanel getP3() {
        return p3;
    }

    public void setP3(JPanel p3) {
        this.p3 = p3;
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

    public JTextField getTxt3() {
        return txt3;
    }

    public void setTxt3(JTextField txt3) {
        this.txt3 = txt3;
    }

    public JTextField getTxt4() {
        return txt4;
    }

    public void setTxt4(JTextField txt4) {
        this.txt4 = txt4;
    }

    public JCheckBox getCb1() {
        return cb1;
    }

    public void setCb1(JCheckBox cb1) {
        this.cb1 = cb1;
    }

    public JLabel getL1() {
        return l1;
    }

    public void setL1(JLabel l1) {
        this.l1 = l1;
    }

    public JLabel getL2() {
        return l2;
    }

    public void setL2(JLabel l2) {
        this.l2 = l2;
    }

    public JLabel getL3() {
        return l3;
    }

    public void setL3(JLabel l3) {
        this.l3 = l3;
    }

    public JLabel getL4() {
        return l4;
    }

    public void setL4(JLabel l4) {
        this.l4 = l4;
    }

    public JLabel getL5() {
        return l5;
    }

    public void setL5(JLabel l5) {
        this.l5 = l5;
    }
}
