import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;

public class AddEventModal extends JDialog {
    JTextField eventNameField;
    JTextField eventDateField;
    JTextField endEventField;
    JTextField locationField;
    JTextField eventLocationField;
    JButton addButton;
    JComboBox<String> eventTypeDropDown;

    public AddEventModal(EventListPanel eventListPanel) {
        setTitle("Add Event");
        setSize(400, 300);
        setLayout(new GridLayout(7, 2));

        add(new JLabel("Event Name:"));
        eventNameField = new JTextField();
        add(eventNameField);

        add(new JLabel("Start Date/Time:"));
        eventDateField = new JTextField();
        add(eventDateField);

        add(new JLabel("End Date/Time (Not for Deadline):"));
        endEventField = new JTextField();
        add(endEventField);

        add(new JLabel("Location (Not for Deadline):"));
        eventLocationField = new JTextField();
        add(eventLocationField);

        add(new JLabel("Event Type:"));
        eventTypeDropDown = new JComboBox(new String[]{"Deadline", "Meeting"});
        add(eventTypeDropDown);

        JButton addButton = new JButton("Add Event");
        add(addButton);

        addButton.addActionListener(e -> {
            String name = eventNameField.getText();
            LocalDateTime dateTime = LocalDateTime.parse(eventDateField.getText());
            String menuOption = (String) eventTypeDropDown.getSelectedItem();

            if (menuOption.equals("Deadline")) {
                eventListPanel.addEvent(new Deadline(name, dateTime));
            }
            else if (menuOption.equals("Meeting")) {
                LocalDateTime endTime = LocalDateTime.parse(endEventField.getText());
                String location = eventLocationField.getText();
                eventListPanel.addEvent(new Meeting(name, dateTime, endTime, location));
            }
            dispose();
        });
        pack();
        setVisible(true);
    }
}
