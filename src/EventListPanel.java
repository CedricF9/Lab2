import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.*;

public class EventListPanel extends JPanel{
    ArrayList<Event> events;
    JPanel controlPanel;
    JPanel displayPanel;
    JComboBox sortDropdown;
    JCheckBox filterDisplay;
    JButton addEventButton;
    JCheckBox deadlineFilter;
    JCheckBox meetingFilter;

    public EventListPanel(){
        events = new ArrayList<>();
        controlPanel = new JPanel();
        displayPanel = new JPanel();

        setLayout(new BorderLayout());

        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));
        sortDropdown = new JComboBox<>(new String[]{"Sort by date", "Sort by name", "Sort by name (reverse)", "Sort by date (reverse)"});
        filterDisplay = new JCheckBox("Filter Completed");
        deadlineFilter = new JCheckBox("Deadline Filter");
        meetingFilter = new JCheckBox("Meeting Filter");
        addEventButton = new JButton("Add Event");

        setLayout(new BorderLayout());
        add(controlPanel, BorderLayout.NORTH);
        controlPanel.add(addEventButton);
        controlPanel.add(filterDisplay);
        controlPanel.add(deadlineFilter);
        controlPanel.add(meetingFilter);
        controlPanel.add(sortDropdown);

        filterDisplay.addActionListener(e->changeDisplay());
        deadlineFilter.addActionListener(e->changeDisplay());
        meetingFilter.addActionListener(e->changeDisplay());

        sortDropdown.addActionListener(e -> {
            String item = (String) sortDropdown.getSelectedItem();
            if (item == "Name")
            {
                events.sort((e1,e2) -> e1.getName().compareTo(e2.getName()));

            }
            else if (item == "Sort by name (reverse)")
            {
                events.sort((e1, e2) -> e2.getName().compareTo(e1.getName()));

            }
            else if (item == "Sort by date")
            {
                events.sort((e1, e2) -> e1.compareTo(e2));
            }
            else if (item == "Sort by date (reverse)")
            {
                events.sort((e1,e2) -> e2.compareTo(e1));
            }

            displayPanel.removeAll();
            for (Event event : events)
            {
                if (!filterDisplay.isSelected() || (event instanceof Completable && !((Completable) event).isComplete()))
                {
                    displayPanel.add(new EventPanel(event));
                }
            }
            displayPanel.revalidate();
            displayPanel.repaint();
        });

        addEventButton.addActionListener(e-> new AddEventModal(this));
        add(displayPanel, BorderLayout.CENTER);
    }
    public void addEvent(Event event)
    {
        events.add(event);
        changeDisplay();
    }

    public void changeDisplay()
    {
        displayPanel.removeAll();
        for (Event event : events)
        {
            boolean option = true;
            if(filterDisplay.isSelected() && (event instanceof Completable && ((Completable) event).isComplete()))
            {
                option = false;
            }
            if(meetingFilter.isSelected() && !(event instanceof Meeting))
            {
                option = false;
            }
            if(deadlineFilter.isSelected() && !(event instanceof Deadline))
            {
                option = false;
            }
        }
        displayPanel.revalidate();
        displayPanel.repaint();
    }

}
