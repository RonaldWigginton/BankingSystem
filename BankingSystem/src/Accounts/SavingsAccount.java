package Accounts;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SavingsAccount extends Account {
    private int accountNumber;
    private Date dateOpened;

    public SavingsAccount(int customerId, int accountNumber, double currentBalance,
                          double interestRate, Date dateOpened)
    {
        this.customerId = customerId;
        this.accountNumber = accountNumber;
        this.currentBalance = currentBalance;
        this.interestRate = interestRate;
        this.dateOpened=dateOpened;
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
                        formatter.format(dateOpened)
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
}