import java.util.ArrayList;
import java.util.*;

class TaskManager {
    ArrayList<Task> taskList = new ArrayList<>();

    // Add a new task
    public void addTask(Task task) {
        taskList.add(task);
        System.out.println("Task added successfully!");
    }

    // Remove a task by name
    public void removeTask(String taskName) {
        // Iterate over the task list and remove the task that matches the name
        for (Iterator<Task> iterator = taskList.iterator(); iterator.hasNext();) {
            Task task = iterator.next();
            if (task.getName().equals(taskName)) { // Compare names using equals
                iterator.remove(); // Remove task from the list
                break; // Stop once the task is found and removed
            }
        }
    }
    
    

    // Update task status by name
    public void updateStatus(String name, String newStatus) {
        for (Task task : taskList) {
            if (task.getName().equals(name)) {
                task.setStatus(newStatus);
                System.out.println("Status updated to " + newStatus + "!");
                return;
            }
        }
        System.out.println("Task not found!");
    }

    // Getter method for taskList
    public ArrayList<Task> getTaskList() {
        return taskList; // Return the list of tasks
    }
}