import javax.swing.*;
import java.awt.*;
import java.time.*;
import java.awt.event.ActionEvent;


public class EventPanel extends JPanel{
    Event event;
    JButton completeButton;

    public EventPanel (Event event)
    {
        this.event = event;

        if(event instanceof Completable)
        {
            completeButton = new JButton("Complete");
            completeButton.addActionListener((ActionEvent e)->{
                ((Completable)event).complete();
            });
            add(completeButton, BorderLayout.WEST);
        }
        JLabel eventLabel = new JLabel("Event:" + event.getName());
        add(eventLabel, BorderLayout.CENTER);
        JLabel dateTimeLabel = new JLabel(event.getDateTime().toString());
        add(dateTimeLabel, BorderLayout.SOUTH);

        if(event instanceof Meeting){
            Meeting meeting = (Meeting)event;

            add(new JLabel("Location: " + meeting.getLocation()));
            add(new JLabel("Duration: " + meeting.getDuration().toHours()));

        }
        if (event instanceof Completable){
            Completable correctEvent = (Completable)event;
            add(new JLabel("Completion - " + (correctEvent.isComplete() ? "Complete" : "Incomplete") + "\n"));
        }

    }


}
