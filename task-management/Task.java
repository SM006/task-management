class Task 
{
    protected String name;
    protected String description;
    protected String deadline;
    protected String status;
    protected String priority;

    // Constructor to initialize a task
    public Task(String name, String description, String deadline, String priority) {
        this.name = name;
        this.description = description;
        this.deadline = deadline;
        this.status = "Pending"; 
        this.priority = priority; // Initialize priority
    }

    // Common methods
    public String getName() 
    { 
        return name; 
    }

    public String getDescription() 
    { 
        return description; 
    }

    public String getDeadline()
    { 
        return deadline;
    }

    public String getStatus() 
    { 
        return status; 
    }

    public void setStatus(String status) 
    { 
        this.status = status; 
    }

    public void setDescription(String description) 
    { 
        this.description = description; 
    }

    public void setDeadline(String deadline)
    { 
        this.deadline = deadline; 
    }

    // Method to display task details (overridden in child classes)
    public void displayTask() 
    {
        System.out.println("Name: " + name);
        System.out.println("Description: " + description);
        System.out.println("Deadline: " + deadline);
        System.out.println("Status: " + status);
    }
    
}