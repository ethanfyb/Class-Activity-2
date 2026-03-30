import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    private static final String DATA_FILE = "university_data.txt";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Student> students = new ArrayList<>();
        List<Lecturer> lecturers = new ArrayList<>();
        List<Course> courses = new ArrayList<>();

        System.out.println(" University Management System ");


        readDataFromFile();

        try {
            boolean addMorestuff = true;

       // Loop allows users to add multiple objects to the Collections (students Lecturers Courses)

            while (addMorestuff) {
                System.out.println(" Enter New Records ");

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
                students.add(s);

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
                lecturers.add(l);

                System.out.println("\nEnter Course Details");
                System.out.print("Course Code: ");
                String cCode = scanner.nextLine();
                System.out.print("Course Title: ");
                String cTitle = scanner.nextLine();

                Course c = new SimpleCourse(cCode, cTitle);
                courses.add(c);

                System.out.print("\nDo you want to add another set of records? (yes/no): ");
                String response = scanner.nextLine();
                if (!response.equalsIgnoreCase("yes")) {
                    addMorestuff = false;
                }
            }

            System.out.println(" Outputing Current Session Details ");


            for (Student student : students) {
                Person personRef = student;
                personRef.displayDetails();
            }

            for (Lecturer lecturer : lecturers) {
                lecturer.displayDetails();
            }

            for (Course course : courses) {
                course.displayDetails();
            }


            saveDataToFile(students, lecturers, courses);

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

    private static void saveDataToFile(List<Student> students, List<Lecturer> lecturers, List<Course> courses) {

        try (FileWriter writer = new FileWriter(DATA_FILE, true)) {

            for (Student s : students) {
                writer.write("STUDENT | " + s.toString() + "\n");
            }
            for (Lecturer l : lecturers) {
                writer.write("LECTURER | " + l.toString() + "\n");
            }
            for (Course c : courses) {
                writer.write("COURSE | " + c.toString() + "\n");
            }

            System.out.println("[SYSTEM] Session data successfully saved to " + DATA_FILE);

        } catch (Exception e) {
            System.out.println("[ERROR] Failed to save data to file: " + e.getMessage());
        }
    }

    private static void readDataFromFile() {
        File file = new File(DATA_FILE);

        if (file.exists()) {
            System.out.println("[SYSTEM] Loading previous records from " + DATA_FILE + ":");

            try (Scanner fileScanner = new Scanner(file)) {
                while (fileScanner.hasNextLine()) {
                    System.out.println("  > " + fileScanner.nextLine());
                }
            } catch (Exception e) {
                System.out.println("[ERROR] Failed to read from file: " + e.getMessage());
            }
        } else {
            System.out.println("[SYSTEM] No previous data file found. A new one will be created upon saving.");
        }
    }
}
