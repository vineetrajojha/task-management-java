import java.util.ArrayList;
import java.util.Scanner;

class Task {
    private String name;
    private boolean isCompleted;

    public Task(String name) {
        this.name = name;
        this.isCompleted = false;
    }

    public String getName() {
        return name;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void markCompleted() {
        this.isCompleted = true;
    }
}

class TaskManager {
    private ArrayList<Task> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(String taskName) {
        Task newTask = new Task(taskName);
        tasks.add(newTask);
    }

    public void markTaskAsCompleted(int index) {
        Task task = tasks.get(index);
        task.markCompleted();
    }

    public void deleteTask(int index) {
        tasks.remove(index);
    }

    public void printAllTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                Task task = tasks.get(i);
                System.out.println((i + 1) + ". " + task.getName() + " - Completed: " + task.isCompleted());
            }
        }
    }
}

 class TaskManagementApp {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nTask Management App");
            System.out.println("1. Add Task");
            System.out.println("2. Mark Task as Completed");
            System.out.println("3. Delete Task");
            System.out.println("4. View All Tasks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter task name: ");
                    scanner.nextLine(); 
                    String taskName = scanner.nextLine();
                    taskManager.addTask(taskName);
                    System.out.println("Task added successfully.");
                    break;
                case 2:
                    System.out.print("Enter task index to mark as completed: ");
                    int indexToComplete = scanner.nextInt() - 1;
                    taskManager.markTaskAsCompleted(indexToComplete);
                    System.out.println("Task marked as completed.");
                    break;
                case 3:
                    System.out.print("Enter task index to delete: ");
                    int indexToDelete = scanner.nextInt() - 1;
                    taskManager.deleteTask(indexToDelete);
                    System.out.println("Task deleted successfully.");
                    break;
                case 4:
                    taskManager.printAllTasks();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0); 
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}