/**
 * A class that represents a Teacher
 *
 * Created for Menlo School CS2
 *
 * Code by: Liliana Dhaliwal
 * Year: 2022-2023
 */
public class Teacher extends Person{
    private String subject;
    private String roomNumber;

    public Teacher(String firstName, String lastName, String phoneNumber, String subject, String roomNumber) {
        super(firstName, lastName, phoneNumber);
        this.subject = subject;
        this.roomNumber = roomNumber;
    }

    //getter methods for instance variables
    public String getSubject() {
        return subject;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    //toString method that builds on the Person toString method
    @Override
    public String toString() {
        return super.toString() + " Teaches " + subject + " in room " + roomNumber;
    }
}
