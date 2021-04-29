package Accounts;

import java.sql.Date;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Account {
    protected int customerId;
    protected double currentBalance;
    protected String status;
    protected double interestRate;
    protected String type;//savings,cd, etc 
    protected int accountNumber;
    protected JTable recentDebits = new JTable(new DefaultTableModel(new Object[][] {}, new Object[] {"Type", "Amount", "Date"}));
    protected ArrayList<String> stoppedChecks = new ArrayList<>();
    protected int withdrawnToday;

    //Checks if account has been withdrawn from twice today already
    public boolean overWithdrawLimit() {
        if(withdrawnToday >= 2) {
            return false;
        }
        return true;
    }

    //Adds 1 to withdrawnToday
    public void addWithdrawnToday() {
        withdrawnToday++;
    }

    //Resets withdrawnToday
    public void newDay() {
        withdrawnToday = 0;
    }

    public void addStopPayment(String checkNumber) {
        stoppedChecks.add(checkNumber);
    }

    //Checks if check number is supposed to be stopped - true if it is, false if it isn't
    //Removes check number from array list now that they have check to be stopped
    public boolean checkStoppedChecks(String checkNumber) {
        for(int i = 0; i < stoppedChecks.size(); i++) {
            if(stoppedChecks.get(i).equals(checkNumber)) {
                stoppedChecks.remove(i);
                return true;
            }
        }
        return false;
    }

    public JTable getRecentDebits() {
        return recentDebits;
    }

    //Adds new row to recentDebits
    public void addRecentDebits(String type, String amount)
    {
        //Gets date
        Date todaysDate = new Date(System.currentTimeMillis());
        Format dateFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
        String date = dateFormat.format(todaysDate);

        //Adds new row
        if(currentBalance >= Double.parseDouble(amount)) {
        DefaultTableModel model = (DefaultTableModel) recentDebits.getModel();
        model.addRow(new Object[]{type, amount, date});
        }
    }
    
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
}
