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
}