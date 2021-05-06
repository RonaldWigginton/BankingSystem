package Accounts;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SavingsAccount extends Account {
    private int accountNumber;
    private Date dateOpened;
    private String isCD;
    private Date CD;

    public SavingsAccount(int customerId, int accountNumber, double currentBalance,
                          double interestRate, Date dateOpened, String isCD)
    {
        this.customerId = customerId;
        this.accountNumber = accountNumber;
        this.currentBalance = currentBalance;
        this.interestRate = interestRate;
        this.dateOpened=dateOpened;
        this.isCD=isCD;
        if(isCD.equals("yes")){
            Calendar date= Calendar.getInstance();
            date.setTime(dateOpened);
            date.add(Calendar.DATE,90);
            this.CD= date.getTime();
        }
        setStatus(0);
    }
    @Override
    public String[] accountToArray()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        return new String[]
                {
                        Integer.toString(customerId), Integer.toString(accountNumber),
                        Double.toString(currentBalance), Double.toString(interestRate),
                        formatter.format(dateOpened), isCD
                };
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Date getDateOpened() {
        return dateOpened;
    }

    public void setDateOpened(Date dateOpened) {
        this.dateOpened = dateOpened;
    }
    public String getAccountType() {
        return "Savings";

    }
    @Override
    public double withdraw(double amount) {
        Date d = new Date();
        //withdraw money
        if (currentBalance >= amount) {
            currentBalance -= amount;
        }
        if(isCD.equals("yes")){
            if(d.before(CD)){
                Calendar date= Calendar.getInstance();
                date.setTime(CD);
                date.add(Calendar.DATE,90);
                System.out.println("Customer: "+customerId+" has withdrawn money from their CD too early.");
                CD = date.getTime();
            }
        }
        return currentBalance;
    }
}
