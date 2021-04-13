import java.io.Serializable;

public class Customer implements Serializable{

    /* // Described in DOC may want to switch to these instead;
        Char 9 SSN
        Char 15 Street Address
        Char 15 City
        Char 2 State
        Char 5 Zip   
        Char IO First Name
        Char 10 Last Name
    */
    private static final long serialVersionUID = 1L;
    private String fname;
    private String lname;
    private String streetAddress;
    private String city;
    private String state;
    private String zip;
    private int phoneNumber;
    private int id;
    private int SSN;
    
    
    Customer(String fname,String lname,int id,int SSN,String streetAddress,String city,String state,String zip,int phoneNumber){
        this.SSN = SSN;
        this.fname = fname;
        this.lname = lname;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.streetAddress = streetAddress;
        this.state = state;
        this.zip = zip;
        this.city = city;
    }
    public int getId() {
        return id;
    }
    public int getSSN() {
        return SSN;
    }
    public String getFname() {
        return fname;
    }
    public String getLname() {
        return lname;
    }
    public String getStreetAddress() {
        return streetAddress;
    }
    public String getCity() {
        return city;
    }
    public String getState() {
        return state;
    }
    public String getZip() {
        return zip;
    }
    public int getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.id + this.fname + this.lname + this.streetAddress + this.city + this.state + this.zip + this.phoneNumber;
    }
}
