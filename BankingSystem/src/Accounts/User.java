package Accounts;

public class User {
    protected int customerId;
    protected String status;
    protected String type;//subtypes; here so it can be compared
    protected String address;
    protected String city;
    protected String state;
    protected int zip;
    protected String first;
    protected String last;
    
    public void setStatus(int cOb){
        if(cOb==0) status = "current";
        if(cOb==1) status = "behind";
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
        if(index==0)this.type="normal";
    }
    public String getType(){
        return type;
    }
}
