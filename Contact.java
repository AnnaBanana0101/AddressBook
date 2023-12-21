package addressbook;

public class Contact {

    public String first_name;
    public String last_name;
    public String address;
    public String city;
    public String state;
    public String zip;
    public String phone_number;
    public String email;

    public Contact(String fn, String ln, String addr, String city, String state, String zip, String pn, String email) {

        first_name = fn;
        last_name = ln;
        address = addr;
        this.city = city;
        this.state = state;
        this.zip = zip;
        phone_number = pn;
        this.email = email;

    }

}