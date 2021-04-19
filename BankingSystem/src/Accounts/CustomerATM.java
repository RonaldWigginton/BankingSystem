package Accounts;

public class CustomerATM extends User{
    
    public CustomerATM(int customerId, String address, String city,
                        String state, int zip, String first, String last
                        )
    {
        this.customerId = customerId;
        this.address = address;
        this.city=city;
        this.state=state;
        this.zip=zip;
        this.first=first;
        this.last=last;
        setStatus(0);
    }

    @Override
    public String[] accountToArray()
    {
        return new String[]
                {
                        Integer.toString(customerId),address,city,
                        state,Integer.toString(zip), first, last
                };
    }
    public void setType(String type){
        //0 my bank
        //1 gold
        this.type="user";
    }
}
