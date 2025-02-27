import java.time.LocalDateTime;

public class Deadline extends Event implements Completable{
    boolean complete;
    public Deadline(String name, LocalDateTime dateTime)
    {
        this.name = name;
        this.dateTime = dateTime;
    }

    @Override
    public void complete()
    {
        complete = true;
    }
    @Override
    public boolean isComplete() {
        return complete;
    }

}
