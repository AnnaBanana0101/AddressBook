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

        for(int j=0; j<contactList.size(); j++)
        {
            Contact a = contactList.get(j);

            System.out.println("Contact " + j + " Details");
            System.out.println("Name: " + a.first_name+ " "+ a.last_name);
            System.out.println("Address: " + a.address);
            System.out.println("City: " + a.city);
            System.out.println("State: "+ a.state );
            System.out.println("ZIP Code: " + a.zip);
            System.out.println("Phone Number: " + a.phone_number);
            System.out.println("Email ID: " + a.email);
            System.out.println(" ");
        }
    }

    public void editContact(String name, String newName)
    {

        for(int i=0; i<contactList.size(); i++)
        {
            Contact c = contactList.get(i);

            if(c.first_name.equals(name))
            {
                c.first_name = newName;
                break;
            }

        }

    }

    public void deleteContact(String name)
    {
        for(int i=0; i<contactList.size(); i++)
        {
            Contact c = contactList.get(i);

            if(c.first_name.equals(name))
            {
                contactList.remove(i);
                break;
            }

        }
    }
}