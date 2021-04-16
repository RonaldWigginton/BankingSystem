package Accounts;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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