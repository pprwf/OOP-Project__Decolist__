import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class GUITask extends JPanel {
    private String name, des, time, exp;

    JPanel jpanelfirst,jpanelcenter, jPanellast,freepanel,freepanel2;
    JLabel panelname, paneldes, paneltime, panelexp;
    private JCheckBox Check;
    private ImageIcon checkedIcon;
    private ImageIcon uncheckedIcon;

    public GUITask(String name, String des, String time, String exp) {
        Check = new JCheckBox();

        checkedIcon = new ImageIcon("C:/Users/User/Downloads/test.jpg");
        uncheckedIcon = new ImageIcon("C:/Users/User/Downloads/new.png");

        // Resize the icons
        Image checkedImage = checkedIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        Image uncheckedImage = uncheckedIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);

        checkedIcon.setImage(checkedImage);
        uncheckedIcon.setImage(uncheckedImage);

        Check.setIcon(uncheckedIcon);
        Check.setBorder(new LineBorder(Color.GREEN,5,true));
        Check.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (Check.isSelected()) {
                    Check.setIcon(checkedIcon);
                } else {
                    Check.setIcon(uncheckedIcon);
                }
            }
        });


        jpanelfirst = new JPanel();
        jpanelcenter = new JPanel();
        jPanellast = new JPanel();
        panelname = new JLabel(name);
        paneldes = new JLabel(des);
        paneltime = new JLabel(time);
        panelexp = new JLabel(exp);
        freepanel = new JPanel();
        freepanel2 = new JPanel();
        
        this.setLayout(new GridLayout(1, 3));
        this.add(jpanelfirst);

        
        jpanelfirst.setLayout(new GridLayout(1,3));
        jpanelfirst.add(freepanel);
        freepanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jpanelfirst.add(Check);
        
        jpanelfirst.add(freepanel2);
        freepanel2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        this.add(jpanelcenter);
        jpanelcenter.setLayout(new GridLayout(2, 1));

        this.add(jPanellast);
        jPanellast.setLayout(new GridLayout(2, 1));

        jpanelcenter.add(panelname);
        jpanelcenter.add(paneldes);
        jPanellast.add(paneltime);
        jPanellast.add(panelexp);

        panelname.setFont(new Font("serif", Font.BOLD, 25));
        paneldes.setFont(new Font("serif", Font.BOLD, 15));
        paneltime.setFont(new Font("serif", Font.BOLD, 25));
        panelexp.setFont(new Font("serif", Font.BOLD, 15));
        
        Check.setBorder(BorderFactory.createLineBorder(Color.darkGray));

        this.setBorder(BorderFactory.createLineBorder(Color.ORANGE));
        jpanelfirst.setBorder(BorderFactory.createLineBorder(Color.RED));
        jpanelcenter.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        jPanellast.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        panelname.setBorder(BorderFactory.createLineBorder(Color.RED));
        paneldes.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        paneltime.setBorder(BorderFactory.createLineBorder(Color.PINK));
        panelexp.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
