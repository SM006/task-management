
class MediumPriorityTask extends Task 
{

    public MediumPriorityTask(String name, String description, String deadline) 
    {
        super(name, description, deadline, "Medium"); // Pass "High" as the priority to Task
    }

    public String getTaskType() 
    {
        return "Medium Priority Task";
    }
}
