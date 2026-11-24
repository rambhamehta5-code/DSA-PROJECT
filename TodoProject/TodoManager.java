import java.util.*;

class Task {
    int id;
    String name;
    boolean done;

    Task(int id, String name) {
        this.id = id;
        this.name = name;
        this.done = false;
    }
}

public class TodoManager {
    static LinkedList<Task> tasks = new LinkedList<>();
    static ArrayList<Integer> results = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int id = 1;

    static void add() {
        System.out.print("Enter task: ");
        tasks.add(new Task(id++, sc.nextLine()));
        System.out.println("Task added!");
    }

    static void view() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found!");
            return;
        }
        for (Task t : tasks)
            System.out.println(t.id + ". " + t.name +
                    " [" + (t.done ? "Completed" : "Pending") + "]");
    }

    static void search() {
        System.out.print("Enter task name: ");
        String s = sc.nextLine().toLowerCase();
        results.clear();

        for (Task t : tasks)
            if (t.name.toLowerCase().contains(s))
                results.add(t.id);

        if (results.isEmpty()) System.out.println("Task not found!");
        else System.out.println("Found Task IDs: " + results);
    }

    static void delete() {
        System.out.print("Enter task ID to delete: ");
        int n = Integer.parseInt(sc.nextLine());

        if (tasks.removeIf(t -> t.id == n))
            System.out.println("Task deleted!");
        else System.out.println("Task not found!");
    }

    static void complete() {
        System.out.print("Enter task ID: ");
        int n = Integer.parseInt(sc.nextLine());

        for (Task t : tasks)
            if (t.id == n) {
                t.done = true;
                System.out.println("Task completed!");
                return;
            }
        System.out.println("Task not found!");
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- TO-DO LIST MANAGER ---");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Search Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Complete Task");
            System.out.println("6. Exit");
            System.out.print("Choice: ");

            int ch = Integer.parseInt(sc.nextLine());

            switch (ch) {
                case 1: add(); break;
                case 2: view(); break;
                case 3: search(); break;
                case 4: delete(); break;
                case 5: complete(); break;
                case 6: System.out.println("Goodbye!"); return;
                default: System.out.println("Invalid choice!");
            }
        }
    }
}