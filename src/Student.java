public class Student extends Person {
    private String course;

    public Student(String id, String name, String email, String course) {
        super(id, name, email); // super usage
        this.course = course;     // this usage
    }

    public String getCourse() { return course; }
    public void setMajor(String major) { this.course = course; }

    @Override
    public void displayDetails() {
        System.out.println("Student: " + getId() + "  " + getName() +
                "  " + getEmail() + "  Course: " + course);
    }
}