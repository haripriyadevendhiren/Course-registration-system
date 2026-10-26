
import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Scanner;

public class CourseRegistrationSystem {

    static ArrayList<String> courses = new ArrayList<>();
    static HashSet<String> registeredCourses = new HashSet<>();
    static HashMap<Integer, String> students = new HashMap<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        courses.add("Java Programming");
        courses.add("Python Programming");
        courses.add("Database Management");
        courses.add("Computer Networks");
        courses.add("Web Development");

        students.put(101, "Arun");
        students.put(102, "Priya");

        System.out.println("\nCOURSE REGISTRATION SYSTEM");
        System.out.print("Enter Student ID: ");

        int id = sc.nextInt();
        sc.nextLine();

        if (!students.containsKey(id)) {
            System.out.println("Student not found!");
            sc.close();
            return;
        }

        System.out.println("Welcome, " + students.get(id));

        int choice;

        do {
            System.out.println("\n1. View Available Courses");
            System.out.println("2. Register for a Course");
            System.out.println("3. Drop a Course");
            System.out.println("4. View Registered Courses");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("\nAvailable Courses:");
                    for (String course : courses) {
                        System.out.println(course);
                    }
                    break;

                case 2:
                    System.out.print("Enter course name: ");
                    String register = sc.nextLine();

                    if (!courses.contains(register)) {
                        System.out.println("Course not available!");
                    } else if (registeredCourses.add(register)) {
                        System.out.println("Registration successful!");
                    } else {
                        System.out.println("Already registered!");
                    }
                    break;

                case 3:
                    System.out.print("Enter course name to drop: ");
                    String drop = sc.nextLine();

                    if (registeredCourses.remove(drop)) {
                        System.out.println("Course dropped successfully!");
                    } else {
                        System.out.println("Course not registered!");
                    }
                    break;

                case 4:
                    System.out.println("\nRegistered Courses:");

                    if (registeredCourses.isEmpty()) {
                        System.out.println("No courses registered.");
                    } else {
                        for (String course : registeredCourses) {
                            System.out.println(course);
                        }
                    }
                    break;

                case 5:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}