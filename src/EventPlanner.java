import java.awt.*;
import java.time.LocalDateTime;
import javax.swing.*;

public class EventPlanner extends JPanel {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Event Planner");
        frame.setPreferredSize(new Dimension(700, 60));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(new Color(150, 150, 50));

        EventListPanel eventListPanel = new EventListPanel();
        addDefaultEvents(eventListPanel);
        frame.add(eventListPanel);
        frame.pack();
        frame.setVisible(true);
    }
    public static void addDefaultEvents(EventListPanel eventListPanel)
    {
        LocalDateTime deadline = LocalDateTime.of(2025, 2, 21, 11, 45);
        Deadline firstDeadline = new Deadline("First Deadline", deadline.minusDays(20));
        LocalDateTime start = LocalDateTime.of(2025, 1, 21, 11, 45);
        LocalDateTime end = LocalDateTime.of(2025, 2, 21, 11, 45);
        String location = "MCS 339";

        Meeting firstMeeting = new Meeting ("First Meeting", start, end, location);

        eventListPanel.addEvent(firstDeadline);
        eventListPanel.addEvent(firstMeeting);
    }

}
