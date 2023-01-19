import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class that stores subclasses of Person as a contact list.
 * The user is presented with a menu of options and may add, sort,
 * search, or list the contacts.
 *
 * Created for Menlo School CS2
 *
 * Base code by: Ms. Namasivayam & Mr. Blick
 * Final code by: Liliana Dhaliwal
 * Year: 2022-2023
 */

public class ContactList
{
    // TODO: Create your array contacts
    ArrayList<Person> contacts;

    //initialize scanner
    Scanner s = new Scanner(System.in);

    public ContactList(){
        contacts = new ArrayList<>();
    }

    //prints all menu options
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
        Scanner s = new Scanner(System.in);

        int contactType;

        //checks what type of contact the user wants to add
        System.out.println("Select a type of contact to add: ");
        System.out.println("1. Student");
        System.out.println("2. Teacher");
        contactType = s.nextInt();
        s.nextLine();

        //gathers information from user about the new contact
        System.out.println("Please fill out the following information.");
        System.out.println("First Name: ");
        String firstName = s.nextLine();
        System.out.println("Last Name: ");
        String lastName = s.nextLine();
        System.out.println("Phone Number: ");
        String phoneNumber = s.nextLine();

        //if the new contact is a student, get the grade and add the student to the list
        if(contactType == 1){
            System.out.println("Grade: ");
            int grade = s.nextInt();

            contacts.add(new Student(firstName, lastName, phoneNumber, grade));
        }
        //if the new contact is a teacher, get their subject and room number and add the student to the list
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
        //loops through arraylist of contacts and prints each person object inside
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
        int n = contacts.size();

        //Sort by first name
        if(sortBy == 0){
            for (int pass = 1; pass < n; pass++) {
                for (int comp = 0; comp < n - pass; comp++) {
                    //compares the first names of two people
                    int nameCompare = contacts.get(comp).getFirstName().compareToIgnoreCase(contacts.get(comp + 1).getFirstName());
                    //Switches the indexes of the people if the value of the first string is greater than the second
                    if (nameCompare > 0){
                        Person temp = contacts.get(comp);
                        contacts.set(comp, contacts.get(comp + 1));
                        contacts.set(comp + 1, temp);
                    }
                }
            }
        }
        //Sort by last name
        else if(sortBy == 1){
            for (int pass = 1; pass < n; pass++) {
                for (int comp = 0; comp < n - pass; comp++) {
                    //compares the last names of two people
                    int nameCompare = contacts.get(comp).getLastName().compareToIgnoreCase(contacts.get(comp + 1).getLastName());
                    //Switches the indexes of the people if the value of the first string is greater than the second
                    if (nameCompare > 0){
                        Person temp = contacts.get(comp);
                        contacts.set(comp, contacts.get(comp + 1));
                        contacts.set(comp + 1, temp);
                    }
                }
            }
        }
        //Sorts all contacts by phone number
        else if(sortBy == 2){
            //loops over all contacts
            for (int pass = 1; pass < n; pass++) {
                for (int comp = 0; comp < n - pass; comp++) {
                    //compares the phone numbers of two people
                    int numCompare = contacts.get(comp).getPhoneNumber().compareTo(contacts.get(comp + 1).getPhoneNumber());
                    //Switches the indexes of the people if the value of the first string is greater than the second
                    if (numCompare > 0){
                        Person temp = contacts.get(comp);
                        contacts.set(comp, contacts.get(comp + 1));
                        contacts.set(comp + 1, temp);
                    }
                }
            }
        }
    }

    public Person searchByFirstName(String firstName){
        //Searches through all contacts and prints the first Person who matches the inputted first name
        for(Person c : contacts){
            if(c.getFirstName().equals(firstName)){
                return c;
            }
        }
        //Returns null if no match is found
        return null;
    }

    public Person searchByLastName(String lastName){
        //Searches through all contacts and prints the first Person who matches the inputted last name
        for(Person c : contacts){
            if(c.getLastName().equals(lastName)){
                return c;
            }
        }
        //Returns null if no match is found
        return null;
    }

    public Person searchByPhoneNumber(String phoneNumber){
        //Searches through all contacts and prints the first Person who matches the inputted phone number
        for(Person c : contacts){
            if(c.getPhoneNumber().equals(phoneNumber)){
                return c;
            }
        }
        //Returns null if no match is found
        return null;
    }

    /**
     * Lists just the Student objects in the Contact List
     */
    public void listStudents() {
        //Searches through all contacts and prints any Person that is a Student
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
        System.out.println("Welcome to your Contacts List");
        System.out.println("Please pick from the following menu options");

        //Continues to allow user input until the user exits the program
        while(true){
            printMenuOptions();

            int userChoice = s.nextInt();
            s.nextLine();

            //Calls the method to add a contact
            if(userChoice == 1){
                addContact();
            }
            //Calls the method to sort contacts according to user input and prints the sorted result
            else if (userChoice > 1 && userChoice < 5) {
                sort(userChoice - 2);
                printContacts();
            }
            //Calls method to list all student in the user's contacts
            else if (userChoice == 5) {
                listStudents();
            }
            else if (userChoice == 6) {
                System.out.println("Enter a name: ");
                String name = s.nextLine();

                Person p = searchByFirstName(name);

                //Prints Person if they are in the list, gives an error message if not
                if(p != null){
                    System.out.println(p);
                }
                else{
                    System.out.println(name + " is not in the list");
                }
            }
            else if (userChoice == 7) {
                System.out.println("Enter a name: ");
                String name = s.nextLine();

                Person p = searchByLastName(name);

                //Prints Person if they are in the list, gives an error message if not
                if(p != null){
                    System.out.println(p);
                }
                else{
                    System.out.println(name + " is not in the list");
                }
            }
            else if (userChoice == 8) {
                System.out.println("Enter a phone number: ");
                String number = s.nextLine();

                Person p = searchByPhoneNumber(number);

                //Prints Person if they are in the list, gives an error message if not
                if(p != null){
                    System.out.println(p);
                }
                else{
                    System.out.println(number + " is not in the list");
                }
            }
            //Exits the program if User inputs 0
            else if (userChoice == 0) {
                return;
            }
        }
    }

    public static void main(String[] args)
    {
        //Runs program
        ContactList cl = new ContactList();
        cl.run();
    }
}
