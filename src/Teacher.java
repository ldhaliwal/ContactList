/**
 * A class that represents a Teacher
 *
 * Created for Menlo School CS2
 *
 * @author: Liliana Dhaliwal
 * @version: 2022-2023
 */
public class Teacher extends Person{
    private String subject;
    private String roomNumber;

    public Teacher(String firstName, String lastName, String phoneNumber, String subject, String roomNumber) {
        super(firstName, lastName, phoneNumber);
        this.subject = subject;
        this.roomNumber = roomNumber;
    }

    public String getSubject() {
        return subject;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    @Override
    public String toString() {
        return super.toString() + " Teaches " + subject + " in room " + roomNumber;
    }
}
