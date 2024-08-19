import java.util.UUID;

public class Task {
    private String id;
    private String description;
    private Status status;

    public Task(String description){
        this.id = UUID.randomUUID().toString();
        this.description = description;
        this.status = Status.NOT_DONE;
    }

    public void markInProgress(){
        this.status = Status.IN_PROGRESS;
    }

    public void markDone(){
        this.status = Status.DONE;
    }

    public void updateDescription(String description){
        this.description = description;
    }
}
