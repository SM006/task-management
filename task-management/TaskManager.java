import java.util.ArrayList;
import java.util.Scanner;

class TaskManager {
    private ArrayList<Task> taskList = new ArrayList<>();

    // Add a new task
    public void addTask(Task task) {
        taskList.add(task);
        System.out.println("Task added successfully!");
    }

    // Remove a task by name
    public void removeTask(String name) {
        for (Task task : taskList) {
            if (task.getName().equals(name)) {
                taskList.remove(task);
                System.out.println("Task removed successfully!");
                return;
            }
        }
        System.out.println("Task not found!");
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

    // Display all tasks
    public void displayTasks() {
        if (taskList.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            for (Task task : taskList) {
                task.displayTask();
                System.out.println("-------------------");
            }
        }
    }
}

