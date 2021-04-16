package Accounts;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Account {
    protected int customerId;
    protected double currentBalance;
    protected String status;
    protected double interestRate;
    
    public void setStatus(int cOb){
        if(cOb==0) status = "current";
        if(cOb==1) status = "behind";
    }

    public String getStatus(){
        return status;
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

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
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
}
