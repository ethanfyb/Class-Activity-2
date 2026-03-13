import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        try {
            System.out.println("Enter Student Details");
            System.out.print("ID: ");
            String sId = scanner.nextLine();
            System.out.print("Name: ");
            String sName = scanner.nextLine();
            System.out.print("Email: ");
            String sEmail = scanner.nextLine();
            System.out.print("Course: ");
            String sCourse = scanner.nextLine();

            Student s = new Student(sId, sName, sEmail, sCourse);

            System.out.println("\nEnter Lecturer Details");
            System.out.print("ID: ");
            String lId = scanner.nextLine();
            System.out.print("Name: ");
            String lName = scanner.nextLine();
            System.out.print("Email (must contain @): ");
            String lEmail = scanner.nextLine();
            System.out.print("Department: ");
            String lDept = scanner.nextLine();

            Lecturer l = new Lecturer(lId, lName, lEmail, lDept);

            System.out.println("\nEnter Course Details");
            System.out.print("Course Code: ");
            String cCode = scanner.nextLine();
            System.out.print("Course Title: ");
            String cTitle = scanner.nextLine();

            Course c = new SimpleCourse(cCode, cTitle);

            System.out.println("\nOutputing Details");
            Person personRef = s;
            personRef.displayDetails();
            l.displayDetails();
            c.displayDetails();

        }
        catch (IllegalArgumentException e) {
            System.out.println("\n[ERROR] Invalid Data: " + e.getMessage());
            System.out.println("Please run the program again and provide valid details.");
        }
        catch (Exception e) {
            System.out.println("\n[ERROR] An unexpected error occurred: " + e.getMessage());
        }
        finally {
            System.out.println("\n[SYSTEM] Closing scanner");
            scanner.close();
        }
    }
}