import java.util.ArrayList;
import java.util.Scanner;

public class StudentCourseRegistration {

    public static void main(String[] args) {

        ArrayList<String> courses = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\nStudent Course Registration System");
            System.out.println("1. Add Course");
            System.out.println("2. Remove Course");
            System.out.println("3. View Registered Courses");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {

                case 1:

                    System.out.print("Enter Course Name: ");
                    String course = sc.nextLine();

                    courses.add(course);

                    System.out.println("Course Registered Successfully!");
                    break;

                case 2:

                    if (courses.isEmpty()) {
                        System.out.println("No courses registered.");
                    } else {

                        System.out.println("\nRegistered Courses:");

                        for (int i = 0; i < courses.size(); i++) {
                            System.out.println((i + 1) + ". " + courses.get(i));
                        }

                        System.out.print("Enter Course Number to Remove: ");
                        int num = sc.nextInt();

                        if (num >= 1 && num <= courses.size()) {

                            String removedCourse = courses.remove(num - 1);
                            System.out.println(removedCourse + " removed successfully!");

                        } else {

                            System.out.println("Invalid Course Number!");

                        }
                    }
                    break;

                case 3:

                    if (courses.isEmpty()) {

                        System.out.println("No courses registered.");

                    } else {

                        StringBuffer sb = new StringBuffer();

                        sb.append("\nRegistered Courses\n");

                        for (int i = 0; i < courses.size(); i++) {

                            sb.append(i + 1)
                              .append(". ")
                              .append(courses.get(i))
                              .append("\n");

                        }

                        System.out.println(sb.toString());
                    }

                    break;

                case 4:

                    System.out.println("Thank You!");
                    break;

                default:

                    System.out.println("Invalid Choice!");

            }

        } while (choice != 4);

        sc.close();
    }
}