package addressbook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Struct;
import java.util.Arrays;
import java.util.Scanner;
import java.util.HashMap;

public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Management!");

        HashMap<String, AddressBook> addressBooksDict = new HashMap<>();

        int new_addr_book = 1;

        do{

            AddressBook addressBook = new AddressBook();

            Scanner readName = new Scanner(System.in);
            System.out.println("Enter the Address Book Name: ");
            String bookName = readName.nextLine();

            while(addressBooksDict.containsKey(bookName))
            {
                System.out.println("Name already exists, add a unique name: ");
                bookName = readName.nextLine();
            }

            System.out.println("Welcome to " + bookName);
            System.out.println(" ");

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

                System.out.println("Enter the entry: ");

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
                System.out.println(" ");
        
            }while(done==0);

            //Display the book
            addressBook.displayBook();

            //Create and save to file
            String filepath = "Book2.txt";
            createFile(filepath);
            
            for(Contact contact: addressBook.contactList)
            {
                writeToFile(filepath, "Name: "+ first_name + " " + last_name);
                writeToFile(filepath, "Email: " + email);
                writeToFile(filepath, "Number: " + phone_number);
                writeToFile(filepath, "Address: " + address);
                writeToFile(filepath, "City: " + city);
                writeToFile(filepath, "State: " + state);
                writeToFile(filepath, "ZIP: " + zip);
            }

            addressBooksDict.put(bookName, addressBook); //Add the new address book to the Dictionary

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

            System.out.println("Add a new Address Book? Y/N");
            String check = sc1.nextLine();

            if(check.equals("Y"))
                new_addr_book = 1;
            else if (check.equals("N"))
                new_addr_book = 0;

        } while(new_addr_book==1);

        System.out.println("Address Book Dictionary: ");
        System.out.println(addressBooksDict);    

    }

    public static void createFile(String filepath)
    {
        try {
            Path path = Path.of(filepath);
            if(!Files.exists(path)){
                Files.createFile(path);
                System.out.println("Files created: " +filepath);
            } else {
                System.out.println("File Already Exists: " + filepath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToFile(String filepath, String data)
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath,true))){
            writer.write(data);
            writer.newLine();
            System.out.println("Data Added");
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void readFromFile(String filepath)
    {
        String line;
        try(BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            while((line = reader.readLine())!=null)
            {
                System.out.println(line);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    
}