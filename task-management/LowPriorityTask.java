
class LowPriorityTask extends Task 
{

    public LowPriorityTask(String name, String description, String deadline) 
    {
        super(name, description, deadline, "Low"); // Pass "High" as the priority to Task
    }

    public String getTaskType() 
    {
        return "Low Priority Task";
    }
}
