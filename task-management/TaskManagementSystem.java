import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Class for the graphical user interface of the Task Management System
public class TaskManagementSystem extends JFrame {
    private TaskManager taskManager; // Instance of TaskManager
    private JTextField nameField; // Input field for task name
    private JTextField descriptionField; // Input field for task description
    private JTextField deadlineField; // Input field for task deadline
    private JComboBox<String> priorityComboBox; // Dropdown for task priority
    private JTextField removeTaskField; // Input field for task removal
    private JTextField updateTaskField; // Input field for task status update
    private JTextField newStatusField; // Input field for new status
    private JTextArea taskDisplayArea; // Area to display tasks

    // Constructor to set up the GUI components
    public TaskManagementSystem() {
        taskManager = new TaskManager(); // Initialize TaskManager

        // Set up the frame
        setTitle("Task Manager");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Set a dark techie color scheme
        Color backgroundColor = new Color(26, 26, 26); // Dark gray background
        Color panelColor = new Color(26, 26, 26); // Same dark color for panels
        Color borderColor = new Color(42, 42, 42); // Slightly lighter gray border
        Color textColor = new Color(242, 242, 242); // Light gray text
        Color buttonColor = new Color(0, 212, 255); // Bright teal for buttons
        Color buttonTextColor = new Color(26, 26, 26); // Dark background for button text
        Color panelborderColor = new Color(255,255,255);

        // Main panel to hold everything
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBackground(backgroundColor);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Title Label
        JLabel titleLabel = new JLabel("Task Management System");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(buttonColor); // Teal text for the title
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        mainPanel.add(titleLabel, gbc);

        // Task input section
        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        inputPanel.setBackground(panelColor);
        inputPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(panelborderColor), "Add Task", 0, 0, null, textColor));

        inputPanel.add(createLabel("Name:", textColor));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(createLabel("Description:", textColor));
        descriptionField = new JTextField();
        inputPanel.add(descriptionField);

        inputPanel.add(createLabel("Deadline:", textColor));
        deadlineField = new JTextField();
        inputPanel.add(deadlineField);

        inputPanel.add(createLabel("Priority:", textColor)); // Label for priority selection
        String[] priorities = {"High", "Medium", "Low"}; // Priority options
        priorityComboBox = new JComboBox<>(priorities); // Dropdown for priority selection
        inputPanel.add(priorityComboBox);

        JButton addButton = createSmallButton("Add Task", buttonColor, buttonTextColor);
        inputPanel.add(addButton);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        mainPanel.add(inputPanel, gbc);

        // Task removal section
        JPanel removePanel = new JPanel(new GridLayout(2, 2));
        removePanel.setBackground(panelColor);
        removePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(panelborderColor), "Remove Task", 0, 0, null, textColor));

        removePanel.add(createLabel("Remove Task (Name):", textColor));
        removeTaskField = new JTextField();
        removePanel.add(removeTaskField);

        JButton removeButton = createSmallButton("Remove Task", buttonColor, buttonTextColor);
        removePanel.add(removeButton);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        mainPanel.add(removePanel, gbc);

        // Task update section
        JPanel updatePanel = new JPanel(new GridLayout(3, 2));
        updatePanel.setBackground(panelColor);
        updatePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(panelborderColor), "Update Task Status", 0, 0, null, textColor));

        updatePanel.add(createLabel("Update Task (Name):", textColor));
        updateTaskField = new JTextField();
        updatePanel.add(updateTaskField);

        updatePanel.add(createLabel("New Status:", textColor));
        newStatusField = new JTextField();
        updatePanel.add(newStatusField);

        JButton updateButton = createSmallButton("Update Status", buttonColor, buttonTextColor);
        updatePanel.add(updateButton);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        mainPanel.add(updatePanel, gbc);

        // Task display area
        taskDisplayArea = new JTextArea(10, 40); // Text area to display tasks
        taskDisplayArea.setEditable(false); // Make the display area non-editable
        taskDisplayArea.setBackground(Color.DARK_GRAY); // Dark gray background for the display area
        taskDisplayArea.setForeground(textColor); // Light gray text color
        JScrollPane scrollPane = new JScrollPane(taskDisplayArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(borderColor), "Task List", 0, 0, null, textColor));
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        mainPanel.add(scrollPane, gbc);

        // Add main panel to the frame
        add(mainPanel, BorderLayout.CENTER);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String description = descriptionField.getText();
                String deadline = deadlineField.getText();
                String priority = (String) priorityComboBox.getSelectedItem(); // Get selected priority
                Task newTask;
        
                // Create new task based on selected priority
                switch (priority) {
                    case "High":
                        newTask = new HighPriorityTask(name, description, deadline);
                        break;
                    case "Medium":
                        newTask = new MediumPriorityTask(name, description, deadline);
                        break;
                    case "Low":
                        newTask = new LowPriorityTask(name, description, deadline);
                        break;
                    default:
                        newTask = new MediumPriorityTask(name, description, deadline); // Default to Medium if none selected
                        break;
                }
        
                taskManager.addTask(newTask); // Add task to TaskManager
                updateTaskDisplay(); // Update task display area
                clearFields(); // Clear input fields
            }
        });
        

        // Button action to remove a task
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameToRemove = removeTaskField.getText();
                taskManager.removeTask(nameToRemove); // Remove task from TaskManager
                updateTaskDisplay(); // Update task display area
                removeTaskField.setText(""); // Clear input field
            }
        });

        // Button action to update task status
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String taskName = updateTaskField.getText();
                String newStatus = newStatusField.getText();
                taskManager.updateStatus(taskName, newStatus); // Update task status in TaskManager
                updateTaskDisplay(); // Update task display area
                updateTaskField.setText(""); // Clear input fields
                newStatusField.setText(""); // Clear input fields
            }
        });
    }

    // Method to create a small button
    private JButton createSmallButton(String text, Color bgColor, Color fgColor) {
        JButton button = new JButton(text);
        button.setBackground(bgColor);
        button.setForeground(fgColor);
        button.setOpaque(true); // Make sure the background color is visible
        button.setPreferredSize(new Dimension(100, 30)); // Set preferred size to make it smaller
        return button;
    }

    // Method to create a label with specific color
    private JLabel createLabel(String text, Color color) {
        JLabel label = new JLabel(text);
        label.setForeground(color); // Set the text color
        return label;
    }

    // Method to update the task display area
    private void updateTaskDisplay() {
        taskDisplayArea.setText(""); // Clear the display area
    
        // Create separate lists for each priority
        StringBuilder highPriorityTasks = new StringBuilder("High Priority Tasks:\n");
        StringBuilder mediumPriorityTasks = new StringBuilder("Medium Priority Tasks:\n");
        StringBuilder lowPriorityTasks = new StringBuilder("Low Priority Tasks:\n");
    
        for (Task task : taskManager.getTaskList()) { // Iterate through tasks
            String taskDetails = String.format("Name: %s\nDescription: %s\nDeadline: %s\nStatus: %s\n\n", 
                                                task.getName(), task.getDescription(), task.getDeadline(), task.getStatus());
            // Use the getter method to access priority
            if (task.getPriority().equals("High")) {
                highPriorityTasks.append(taskDetails);
            } else if (task.getPriority().equals("Medium")) {
                mediumPriorityTasks.append(taskDetails);
            } else if (task.getPriority().equals("Low")) {
                lowPriorityTasks.append(taskDetails);
            }
        }
    
        // Append each priority section to the display area
        taskDisplayArea.append(highPriorityTasks.toString());
        taskDisplayArea.append(mediumPriorityTasks.toString());
        taskDisplayArea.append(lowPriorityTasks.toString());
    }
    
    // Method to clear input fields
    private void clearFields() {
        nameField.setText("");
        descriptionField.setText("");
        deadlineField.setText("");
        priorityComboBox.setSelectedIndex(1); // Reset to Medium priority by default
    }

    // Main method to run the application
    public static void main(String[] args) {
        // Set Nimbus look and feel
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        TaskManagementSystem gui = new TaskManagementSystem();
        gui.setVisible(true);
    }
}
