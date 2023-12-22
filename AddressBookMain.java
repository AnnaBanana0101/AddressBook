package addressbook;

import java.sql.Struct;
import java.util.Arrays;
import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Management!");

        
        AddressBook addressBook = new AddressBook();


        String first_name;
        String last_name;
        String address;
        String city;
        String state;
        String zip;
        String phone_number;
        String email;
        int done = 0;

        do
        {

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
            
            //Create/add a contact to address book
            addressBook.createContact(first_name, last_name, address, city, state, zip, phone_number, email);

            System.out.println("Are you done? 0 for no, 1 for yes: ");
            done = sc.nextInt();
    
        }while(done==0);

        //Display the book
        addressBook.displayBook();

        Scanner sc1 = new Scanner(System.in);
        String find_name;
        String new_name;
        //Edit contact
        System.out.println("Enter the Contact name to change: ");
        find_name = sc1.nextLine();
        System.out.println(find_name);
        
        System.out.println("Enter the new name: ");
        new_name = sc1.nextLine();
        System.out.println(new_name);

        addressBook.editContact(find_name, new_name);
        addressBook.displayBook();

        //Delete contact 
        System.out.println("Enter the name of the contact to delete: ");
        String del_name = sc1.nextLine();

        addressBook.deleteContact(del_name);
        addressBook.displayBook();
        

    }
}