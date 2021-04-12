public class Customer {
    private String fname;
    private String lname;
    private int accountNum;
    private String streetAddress;
    private String city;
    private String state;
    private String zip;
    private int phoneNumber;
    private int id;
    private int SSN;
    
    
    Customer(String fname,String lname,int accountNum,int id,int SSN,String streetAddress,String city,String state,String zip,int phoneNumber){
        this.SSN = SSN;
        this.accountNum = accountNum;
        this.fname = fname;
        this.lname = lname;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.streetAddress = streetAddress;
        this.state = state;
        this.zip = zip;
        this.city = city;
    }

    public int getAccountNum() {
        return accountNum;
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
}
