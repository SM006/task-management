class LowPriorityTask extends Task {
    private final int priority = 3; // 3 represents low priority

    public LowPriorityTask(String name, String description, String deadline) {
        super(name, description, deadline);
    }

    // Overridden method to display task details
    @Override
    public void displayTask() {
        System.out.println("Priority: Low");
        super.displayTask();
    }
}
