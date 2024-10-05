class MediumPriorityTask extends Task {
    private final int priority = 2; // 2 represents medium priority

    public MediumPriorityTask(String name, String description, String deadline) {
        super(name, description, deadline);
    }

    // Overridden method to display task details
    @Override
    public void displayTask() {
        System.out.println("Priority: Medium");
        super.displayTask();
    }
}
