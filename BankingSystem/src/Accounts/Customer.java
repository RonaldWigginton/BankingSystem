package Accounts;

public class Customer {

 protected int customerId;
    
    protected String first;
    protected String last;
    protected String status;
    protected String type;
    protected String address;
    protected String city;
    protected String state;
    protected int zip;
    
    public void setStatus(int curOrbeh){
        if(curOrbeh==0) status = "Current";
        if(curOrbeh==1) status = "Behind";
    }

    public String getStatus(){
        return status;
    }
    public void setAddress(String address){
        this.address=address;
    }
    public String getAddress(){
        return address;
    }
    public void setCity(String city){
        this.city=city;
    }
    public String getCity(){
        return city;
    }
    public void setState(String state){
        this.state=state;
    }
    public String getState(){
        return state;
    }
    public void setZip(int zip){
        this.zip=zip;
    }
    public int getZip(){
        return zip;
    }
    public void setfirst(String first){
        this.first=first;
    }
    public String getFirst(){
        return first;
    }
    public void setLast(String last){
        this.last=last;
    }
    public String getLast(){
        return last;
    }
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String[] accountToArray() {
        return new String[0];
    }
    public void setType(int index){
        if(index==0)this.type="Normal";
    }
    public String getType(){
        return type;
    }
}
