
import java.time.*;

abstract class Event implements Comparable<Event> {
    String name;
    LocalDateTime dateTime;

    public String getName()
    {
        return name;
    }
    public LocalDateTime getDateTime()
    {
        return dateTime;
    }
    public void setDateTime(LocalDateTime dateTime)
    {
        this.dateTime = dateTime;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public int compareTo(Event e)
    {
        return this.dateTime.compareTo(e.dateTime);
    }
}
