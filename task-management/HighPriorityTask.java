// Derived class for High Priority Task
class HighPriorityTask extends Task 
{

    public HighPriorityTask(String name, String description, String deadline) 
    {
        super(name, description, deadline, "High"); // Pass "High" as the priority to Task
    }

    public String getTaskType() 
    {
        return "High Priority Task";
    }
}
