import java.util.*;

public class TaskManagementSystem 
{
    public static void main(String[] args)
     {
        Scanner sc = new Scanner(System.in);
        TaskManager manager = new TaskManager();

        while(true) 
        {
            System.out.println("\nTask Management System");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. Update Task Status");
            System.out.println("4. View All Tasks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 
            System.out.println();

            switch (choice) 
            {
                case 1:
                    System.out.print("Enter Task Name: ");
                    String name = sc.nextLine();
                    System.out.println();

                    System.out.print("Enter Task Description: ");
                    String description = sc.nextLine();
                    System.out.println();

                    System.out.print("Enter Task Deadline: ");
                    String deadline = sc.nextLine();
                    System.out.println();

                    System.out.println("Select Priority: 1. High, 2. Medium, 3. Low");
                    int priority = sc.nextInt();
                    System.out.println();
                    sc.nextLine();
                    
                    Task task;
                    if (priority == 1) 
                    {
                        task = new HighPriorityTask(name, description, deadline);
                    } 
                    else if (priority == 2) 
                    {
                        task = new MediumPriorityTask(name, description, deadline);
                    } 
                    else 
                    {
                        task = new LowPriorityTask(name, description, deadline);
                    }

                    manager.addTask(task);
                    break;

                case 2:
                    System.out.print("Enter Task Name to Remove: ");
                    String removeName = sc.nextLine();
                    manager.removeTask(removeName);
                    break;

                case 3:
                    System.out.print("Enter Task Name to Update: ");
                    String updateName = sc.nextLine();
                    System.out.print("Enter New Status (Pending/Completed): ");
                    String newStatus = sc.nextLine();
                    manager.updateStatus(updateName, newStatus);
                    break;

                case 4:
                    manager.displayTasks();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
