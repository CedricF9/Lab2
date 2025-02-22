import java.time.*;

public class Meeting extends Event implements Completable{
    LocalDateTime endDateTime;
    String location;
    boolean complete;

    public Meeting(String name, LocalDateTime dateTime, LocalDateTime endDateTime, String location)
    {
        this.name = name;
        this.endDateTime = endDateTime;
        this.location = location;
        this.dateTime = dateTime;
    }

    @Override
    public void complete() {
        complete = true;
    }
    public boolean isComplete() {
        return complete;
    }
    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }
    public Duration getDuration() {
        return Duration.between(dateTime, endDateTime);
    }
    public String getLocation() {
        return location;
    }
    public void setEndTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }
    public void setLocation(String location) {
        this.location = location;
    }
}
