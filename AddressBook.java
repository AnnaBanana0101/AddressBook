package addressbook;

import java.util.Scanner;
import java.util.ArrayList;

public class AddressBook {

    ArrayList<Contact> contactList = new ArrayList<>();

    public void createContact()
    {

        String first_name;
        String last_name;
        String address;
        String city;
        String state;
        String zip;
        String phone_number;
        String email;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter First Name: ");
        first_name = sc.nextLine();

        System.out.println("Enter Last Name: ");
        last_name = sc.nextLine();

        System.out.println("Enter Address: ");
        address = sc.nextLine();

        System.out.println("Enter City: ");
        city = sc.nextLine();

        System.out.println("Enter State: ");
        state = sc.nextLine();

        System.out.println("Enter ZIP Code: ");
        zip = sc.nextLine();

        System.out.println("Enter Phone Number: ");
        phone_number = sc.nextLine();

        System.out.println("Enter Email ID: ");
        email = sc.nextLine();

        Contact contact = new Contact(first_name, last_name, address, city, state, zip, phone_number, email);

        contactList.add(contact);
    }
}