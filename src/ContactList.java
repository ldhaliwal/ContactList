import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class that stores subclasses of Person as a contact list.
 * The user is presented with a menu of options and may add, sort,
 * search, or list the contacts.
 *
 * Created for Menlo School CS2
 *
 * @author: Ms. Namasivayam & Mr. Blick
 * @version: 2022-2023
 */

public class ContactList
{
    // TODO: Create your array contacts
    ArrayList<Person> contacts;

    // TODO: Write a Constructor
    public ContactList(){
        contacts = new ArrayList<>();
    }

    public void printMenuOptions() {
        System.out.println("Menu: ");
        System.out.println("1. Add Contact");
        System.out.println("2. List All Contacts By First Name");
        System.out.println("3. List All Contacts By Last Name");
        System.out.println("4. List All Contacts By Phone Number");
        System.out.println("5. List All Students");
        System.out.println("6. Search By First Name");
        System.out.println("7. Search By Last Name");
        System.out.println("8. Search by Phone Number");
        System.out.println("0. Exit");
    }

    /**
     * Asks user for input to create and add a new Person
     * to the contact list
     */
    public void addContact() {
        // TODO: Complete the addContact method
        Scanner s = new Scanner(System.in);

        int contactType;

        System.out.println("Select a type of contact to add: ");
        System.out.println("1. Student");
        System.out.println("2. Teacher");
        contactType = s.nextInt();
        s.nextLine();

        //gathers information from user about the person
        System.out.println("Please fill out the following information.");
        System.out.println("First Name: ");
        String firstName = s.nextLine();

        System.out.println("Last Name: ");
        String lastName = s.nextLine();

        System.out.println("Phone Number: ");
        String phoneNumber = s.nextLine();

        if(contactType == 1){
            System.out.println("Grade: ");
            int grade = s.nextInt();

            contacts.add(new Student(firstName, lastName, phoneNumber, grade));
        }
        else{
            System.out.println("Subject: ");
            String subject = s.nextLine();

            System.out.println("Room Number: ");
            String roomNumber = s.nextLine();

            contacts.add(new Teacher(firstName, lastName, phoneNumber, subject, roomNumber));
        }

    }

    /**
     * Loops through and prints all contacts
     */
    public void printContacts() {
        // TODO: Complete the printContacts method
        for(Person p : contacts) {
            System.out.println(p);
        }
    }

    /**
     * Bubble sorts the contacts in the list by firstName,
     * lastName, or phoneNumber
     * @param sortBy: 0=firstName, 1=lastName, 2=phoneNumber
     */
    public void sort(int sortBy) {
        // TODO: Complete the sort method
        int n = contacts.size();

        //Sort by first name
        if(sortBy == 0){
            for (int pass = 1; pass < n; pass++) {
                for (int comp = 0; comp < n - pass; comp++) {
                    if () {
                        //swap two values
                    }
                }
            }
        }
        //Sort by last name
        else if(sortBy == 1){
            for (int pass = 1; pass < n; pass++) {
                for (int comp = 0; comp < n - pass; comp++) {
                    if () {
                        //swap two values
                    }
                }
            }
        }
        //Sort by phone number
        else if(sortBy == 2){
            for (int pass = 1; pass < n; pass++) {
                for (int comp = 0; comp < n - pass; comp++) {
                    if () {
                        //swap two values
                    }
                }
            }
        }

    }

    // TODO: Write searchByFirstName
    public Person searchByFirstName(String firstName){
        for(Person c : contacts){
            if(c.getFirstName().equals(firstName)){
                return c;
            }
        }
        return null;
    }

    // TODO: Write searchByLastName
    public Person searchByLastName(String lastName){
        for(Person c : contacts){
            if(c.getLastName().equals(lastName)){
                return c;
            }
        }
        return null;
    }

    // TODO: Write searchByPhoneNumber
    public Person searchByPhoneNumber(String phoneNumber){
        for(Person c : contacts){
            if(c.getPhoneNumber().equals(phoneNumber)){
                return c;
            }
        }
        return null;
    }

    /**
     * Lists just the Student objects in the Contact List
     */
    public void listStudents() {

        //Searches through all contacts and prints any students that is a student
        for(Person c: contacts){
            if(c instanceof Student){
                System.out.println(c);
            }
        }
    }

    /**
     * Loops providing menu options to the user
     * until the user exits
     */
    public void run() {
        Scanner s = new Scanner(System.in);

        System.out.println("Welcome to your Contacts List");
        System.out.println("Please pick from the following menu options");
        printMenuOptions();

        int userChoice = s.nextInt();
        s.nextLine();

        if(userChoice == 1){
            addContact();
        }
        else if (userChoice > 1 && userChoice < 5) {
            sort(userChoice - 2);
        }
        else if (userChoice == 5) {
            listStudents();
        }
        else if (userChoice == 6) {
            System.out.println("Enter a name: ");
            String name = s.nextLine();

            searchByFirstName(name);
        }
        else if (userChoice == 7) {
            System.out.println("Enter a name: ");
            String name = s.nextLine();

            searchByLastName(name);
        }
        else if (userChoice == 8) {
            System.out.println("Enter a phone number: ");
            String number = s.nextLine();

            searchByPhoneNumber(number);
        }
    }


    public static void main(String[] args)
    {
        ContactList cl = new ContactList();
        cl.run();
    }
}
