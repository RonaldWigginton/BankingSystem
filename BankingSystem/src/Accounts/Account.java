package Accounts;

public class Account {
    protected int customerId;
    protected double currentBalance;
    protected String status;
    protected double interestRate;
    protected String type;//savings,cd, etc 
    protected int accountNumber;
    
    public void setStatus(int curOrbeh){
        if(curOrbeh==0) status = "Current";
        if(curOrbeh==1) status = "Behind";
    }

     public String getStatus(){
        return status;
    }
    public int getAccountNumber(){
        return accountNumber;
    }
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }
    public double withdraw(double amount){
        //withdraw money
        if(currentBalance>=amount)
            currentBalance-=amount;
        return currentBalance;
    }
    public double deposit(double amount){
        currentBalance+=amount;
        return currentBalance;
    }
    public void setCurrentBalance(double newBalance) {
        this.currentBalance = newBalance;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public String[] accountToArray() {
        return new String[0];
    }
    public void setType(String type){
        this.type=type;
    }
    public String getAccountType() {
        return type;
    }
    public static void delete (List <Account> list, int num, String type){
        for(int i = 0; i < list.size(); i++){
            Account a = list.get(i);
            if((a.accountNumber == num)&&(type.equals(a.type) == true)){
                list.remove(i);
            }
        }
    }
}
