import java.sql.SQLException;
import java.util.Scanner;
import Security.SecuritySystem;
import Workout.WorkoutList;

public class Main {
    public Main() {
    }

    public static void main(String[] args) throws SQLException {
        SecuritySystem system = new SecuritySystem();
        WorkoutList manager = new WorkoutList();
        Scanner input = new Scanner(System.in);
        boolean isTrue = true;

        Scanner forTaskName;
        Scanner forDescription;
        Scanner forTaskNameEdit;
        Scanner forDescriptionEdit;
        while(isTrue) {
            System.out.println("WELCOME TO WORKOUT LIST");
            System.out.println("1. Sign In");
            System.out.println("2. Account Registration");
            int chooseIn = input.nextInt();
            switch (chooseIn) {
                case 1:
                    Scanner log = new Scanner(System.in);
                    System.out.print("LOGIN: ");
                    String login = log.nextLine();
                    forTaskName = new Scanner(System.in);
                    System.out.print("PASSWORD: ");
                    String password = forTaskName.nextLine();
                    isTrue = system.checkLoginAndPass(login, password);
                    break;
                case 2:
                    forDescription = new Scanner(System.in);
                    System.out.print("ID: ");
                    Long regId = forDescription.nextLong();
                    forTaskNameEdit = new Scanner(System.in);
                    System.out.print("LOGIN: ");
                    String regLogin = forTaskNameEdit.nextLine();
                    forDescriptionEdit = new Scanner(System.in);
                    System.out.print("PASSWORD: ");
                    String regPassword = forDescriptionEdit.nextLine();
                    system.setLoginAndPass(regId, regLogin, regPassword);
                    System.out.println("Successful Registration!");
                    isTrue = false;
                    break;
                default:
                    return;
            }
        }

        System.out.println("WELCOME TO WORKOUT LIST");
        Scanner scanner = new Scanner(System.in);
        System.out.println("What We Train Today?");

        while(true) {
            System.out.println("1. Show My WORKOUT LIST");
            System.out.println("2. Add Task");
            System.out.println("3. Edit Task Item");
            System.out.println("4. Confirm 'Is Done'");
            System.out.println("5. Delete Task");
            System.out.println("6. Exit");
            int command = scanner.nextInt();
            switch (command) {
                case 1:
                    System.out.println("Your Workout List:");
                    manager.findAllTasks();
                    System.out.println();
                    break;
                case 2:
                    Scanner forId = new Scanner(System.in);
                    forTaskName = new Scanner(System.in);
                    Scanner forUrgency = new Scanner(System.in);
                    forDescription = new Scanner(System.in);
                    System.out.println("New Task: ");
                    System.out.println("1: Task ID, 2: Task Name, 3: Task Urgency, 4: Task Description");
                    manager.setTask(forId.nextInt(), forTaskName.nextLine(), forUrgency.nextLine(), forDescription.nextLine());
                    System.out.println("Task was created!");
                    System.out.println("________________________________________________________________________________");
                    System.out.println();
                    break;
                case 3:
                    Scanner forIdEdit = new Scanner(System.in);
                    forTaskNameEdit = new Scanner(System.in);
                    Scanner forUrgencyEdit = new Scanner(System.in);
                    forDescriptionEdit = new Scanner(System.in);
                    System.out.println("Editing Task Arguments: ");
                    System.out.println("1: Task ID, 2: Task Name, 3: Task Urgency, 4: Task Description");
                    manager.editTask(forIdEdit.nextInt(), forTaskNameEdit.nextLine(), forUrgencyEdit.nextLine(), forDescriptionEdit.nextLine());
                    System.out.println("Task was edited!");
                    System.out.println("________________________________________________________________________________");
                    System.out.println();
                    break;
                case 4:
                    Scanner forIdConfirm = new Scanner(System.in);
                    System.out.println("Task ID: ");
                    manager.confirm(forIdConfirm.nextInt());
                    System.out.println("Task was confirmed!");
                    System.out.println("________________________________________________________________________________");
                    System.out.println();
                    break;
                case 5:
                    Scanner forIdDelete = new Scanner(System.in);
                    System.out.println("Task ID: ");
                    manager.deleteTask(forIdDelete.nextInt());
                    System.out.println("Task was removed!");
                    System.out.println("________________________________________________________________________________");
                    System.out.println();
                    break;
                case 6:
                    System.out.println("See u again ;3");
                    return;
                default:
                    System.out.println("There is no such command");
            }
        }
    }
}