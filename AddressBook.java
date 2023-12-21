package addressbook;
import java.util.*;
import java.util.ArrayList;

public class AddressBook {

    ArrayList<Contact> contactList = new ArrayList<>();

    public void createContact(String first_name, String last_name, String address, String city, String state, String zip, String phone_number, String email) {

        Contact contact = new Contact(first_name, last_name, address, city, state, zip, phone_number, email);

        contactList.add(contact);
    }

    public void displayBook() {
        System.out.println(contactList);
    }
}