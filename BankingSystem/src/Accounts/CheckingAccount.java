package Accounts;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;


public class CheckingAccount extends Account {
    private int accountNumber;
    private String accountType;
    private int backupAccount;
    private int backupAccountNumber;
    private int overdrafts;
    private Date dateOpened;
    private double interestRate;

    public CheckingAccount(int customerId, int accountNumber, String accountType, double currentBalance,
                           int backupAccount, int backupAccountNumber, int overDrafts, Date dateOpened)
    {
        this.customerId = customerId;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.currentBalance = currentBalance;
        this.backupAccount = backupAccount;
        this.backupAccountNumber = backupAccountNumber;
        this.overdrafts = overDrafts;
        this.dateOpened = dateOpened;

        setStatus(0);
    }

    public String[] accountToArray()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        return new String[]
                            {
                                 Integer.toString(customerId), Integer.toString(accountNumber),
                                 accountType, Double.toString(currentBalance),
                                 Integer.toString(backupAccount), Integer.toString(backupAccountNumber),
                                 Integer.toString(overdrafts), formatter.format(dateOpened)
                            };

    }

    public double withdraw(double amount){
        //withdraw money
        if(accountType.equals("Gold/Diamond") && currentBalance >= amount + 1000) {
            currentBalance-=amount;
            return currentBalance;
        } else {
            JOptionPane.showMessageDialog(null, "You cannot withdraw more than the minimum balance", "Minimum Balance", JOptionPane.ERROR_MESSAGE);
            return currentBalance;
        }
    }
    
    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public int getBackupAccount() {
        return backupAccount;
    }

    public void setBackupAccount(int backupAccount) {
        this.backupAccount = backupAccount;
    }

    public int getBackupAccountNumber() {
        return backupAccountNumber;
    }

    public void setBackupAccountNumber(int backupAccountNumber) {
        this.backupAccountNumber = backupAccountNumber;
    }

    public int getOverdrafts() {
        return overdrafts;
    }

    public void setOverdrafts(int overdrafts) {
        this.overdrafts = overdrafts;
    }

    public Date getDateOpened() {
        return dateOpened;
    }

    public void setDateOpened(Date dateOpened) {
        this.dateOpened = dateOpened;
    }
}