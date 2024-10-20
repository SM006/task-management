public abstract class Task {
    private String name;
    private String description;
    private String deadline;
    private String status; // Status of the task
    private String priority; // Priority of the task

    public Task(String name, String description, String deadline, String priority) {
        this.name = name;
        this.description = description;
        this.deadline = deadline;
        this.priority = priority;
        this.status = "Pending"; // Default status
    }

    public String getTaskType() {
        return "Generic Task";
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDeadline() {
        return deadline;
    }

    public String getStatus() {
        return status;
    }

    public String getPriority() {
        return priority; // Getter for priority
    }

    public void setStatus(String status) {
        this.status = status;
    }
}