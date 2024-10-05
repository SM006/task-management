// Derived class for High Priority Task
class HighPriorityTask extends Task {
    private final int priority = 1; // 1 represents high priority

    public HighPriorityTask(String name, String description, String deadline) {
        super(name, description, deadline);
    }

    // Overridden method to display task details
    @Override
    public void displayTask() {
        System.out.println("Priority: Highhhhhhhhh");
        super.displayTask();
    }
}