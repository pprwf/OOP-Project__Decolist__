

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.TimeZone;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class AddTaskView extends JFrame {

    private JTextField nameField;
    private JTextArea descriptionArea;
    private JDateChooser expireDateChooser;
    private JCheckBox statusCheckBox;
    private JButton addButton;
    private TaskListModel model;

    public AddTaskView(TaskListModel model) {
        this.model = model;

        nameField = new JTextField(20);
        descriptionArea = new JTextArea(5, 20);
        expireDateChooser = new JDateChooser();
        statusCheckBox = new JCheckBox("Complete?");
        addButton = new JButton("Add Task");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String description = descriptionArea.getText();

                // Get the selected date from the JDateChooser as a Calendar object
                Calendar calendar = expireDateChooser.getCalendar();
                // Convert the Calendar object to a LocalDate object using the default time zone
                LocalDate expireDate = calendar.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

                boolean status = statusCheckBox.isSelected();

                Task task = new Task(name, description, expireDate, status);
                model.addTask(task);

                nameField.setText("");
                descriptionArea.setText("");
                expireDateChooser.setDate(null);
                statusCheckBox.setSelected(false);
            }
        });

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.add(new JLabel("Name:"), BorderLayout.NORTH);
        contentPanel.add(nameField, BorderLayout.CENTER);
        contentPanel.add(new JLabel("Description:"), BorderLayout.SOUTH);
        contentPanel.add(descriptionArea, BorderLayout.SOUTH);
        contentPanel.add(new JLabel("Expire Date:"), BorderLayout.SOUTH);
        contentPanel.add(expireDateChooser, BorderLayout.SOUTH);
        contentPanel.add(statusCheckBox, BorderLayout.SOUTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);

        add(contentPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setTitle("Add Task");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}
