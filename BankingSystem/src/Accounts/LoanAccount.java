package Accounts;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class LoanAccount extends Account{
    protected Date paymentDueDate;
    protected Date paymentNotificationDate;
    protected double paymentAmountDue;
    protected String accountType;//Long, Short, and Credit
    protected boolean missedPayment;
    protected Date lastPaymentDate;
    public int count= 0;

    public LoanAccount(int customerId, int accountNumber, double currentBalance, double interestRate, Date paymentDueDate,
                       Date paymentNotificationDate, double paymentAmountDue, String loanType, boolean missedPayment,
                       Date lastPaymentDate)
    {
        this.accountNumber = accountNumber;
        this.customerId = customerId;
        this.currentBalance = currentBalance;
        this.interestRate = interestRate;
        this.paymentDueDate = paymentDueDate;
        this.paymentNotificationDate = paymentNotificationDate;
        setPaymentAmountDue(paymentAmountDue);
        this.accountType = loanType;
        this.missedPayment = missedPayment;
        this.lastPaymentDate = lastPaymentDate;
        this.type = loanType;
        setStatus(0);
        pastDue();

    }

    @Override
    public String[] accountToArray()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        return new String[]
                {
                        Integer.toString(customerId), Integer.toString(accountNumber), Double.toString(currentBalance),
                        Double.toString(interestRate), formatter.format(paymentDueDate),
                        formatter.format(paymentNotificationDate), Double.toString(paymentAmountDue),
                        accountType, Integer.toString(missedPayment ? 1 : 0), formatter.format(lastPaymentDate)
                };
    }

    public Date getPaymentDueDate() {
        return paymentDueDate;
    }

    public void setPaymentDueDate(Date paymentDueDate) {
        this.paymentDueDate = paymentDueDate;
    }

    public Date getPaymentNotificationDate() {
        return paymentNotificationDate;
    }

    public void setPaymentNotificationDate(Date paymentNotificationDate) {
        this.paymentNotificationDate = paymentNotificationDate;
    }

    public double getPaymentAmountDue() {
        return paymentAmountDue;
    }

    public void setPaymentAmountDue(double paymentAmountDue) {
        double x= currentBalance;
        double m= currentBalance/paymentAmountDue;
        double y= m/12;
        double r =interestRate;
        this.paymentAmountDue=x/m+(x/2)*y*r/m;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setLoanType(String loanType) {
        this.accountType = loanType;
    }

    public boolean isMissedPayment() {
        return missedPayment;
    }

    public void setMissedPayment(boolean missedPayment) {
        this.missedPayment = missedPayment;
    }

    public Date getLastPaymentDate() {
        return lastPaymentDate;
    }

    public void setLastPaymentDate(Date lastPaymentDate) {
        this.lastPaymentDate = lastPaymentDate;
    }
    public void pastDue(){
        Date current =new Date();
        if((current.after(paymentDueDate))&&(lastPaymentDate.before(paymentDueDate))){
            missedPayment = true;
            if(accountType.equals("Long")){
                paymentAmountDue = paymentAmountDue + 75.0;
            }
        }
    }
    public void paymentMade(){
        Scanner a = new Scanner(System.in);
        String b = a.nextLine();
        int amount = Integer.parseInt(b);
        currentBalance = currentBalance - amount;
        lastPaymentDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, 30);
        paymentDueDate = c.getTime();
    }

    public void Notify(){//Used for initialization
        Date current =new Date();
        Calendar date= Calendar.getInstance();
        date.setTime(current);
        if(paymentDueDate.equals(current)){
            date.add(Calendar.DATE,90);
            paymentDueDate= date.getTime();
        }
        else if(paymentDueDate.compareTo(current) <= 30){
            System.out.println("Account Number: "+ this.accountNumber+" has a payment due: " + paymentDueDate);
            paymentNotificationDate = current;
        }
    }
    @Override
    public double withdraw(double amount){
        System.out.println("Cannot withdraw from loan account.");
        return currentBalance;
    }
}
