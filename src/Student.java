/**
 * A subclass of Person that represents a Student
 *
 * Created for Menlo School CS2
 *
 * Base code by: Ms. Namasivayam & Mr. Blick
 * Final code by: Liliana Dhaliwal
 * Year: 2022-2023
 */

public class Student extends Person {

    private int grade;

    public Student(String firstName, String lastName, String phoneNumber, int grade) {
        super(firstName, lastName, phoneNumber);
        this.grade = grade;
    }

    //getter method for instance variable
    public int getGrade() {
        return grade;
    }

    //toString method that builds on the Person toString method
    @Override
    public String toString() {
        return super.toString() + " Grade: " + grade;
    }
}
