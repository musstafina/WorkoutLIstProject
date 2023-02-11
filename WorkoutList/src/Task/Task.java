package Task;

public class Task {
    private int id;
    private String task_name;
    private String urgency;
    private boolean isDone;
    private String description;

    public Task() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTask_name() {
        return this.task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public String getUrgency() {
        return this.urgency;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    public boolean isDone() {
        return this.isDone;
    }

    public void setDone(boolean done) {
        this.isDone = done;
    }
}

