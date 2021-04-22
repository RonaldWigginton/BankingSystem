package Accounts;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LoanAccount extends Account{
    protected Date paymentDueDate;
    protected Date paymentNotificationDate;
    protected double paymentAmountDue;
    protected String loanType;//Long, Short, and Credit
    protected boolean missedPayment;
    protected Date lastPaymentDate;

    public LoanAccount(int customerId, double currentBalance, double interestRate, Date paymentDueDate,
                       Date paymentNotificationDate, double paymentAmountDue, String loanType, boolean missedPayment,
                       Date lastPaymentDate)
    {
        this.customerId = customerId;
        this.currentBalance = currentBalance;
        this.interestRate = interestRate;
        this.paymentDueDate = paymentDueDate;
        this.paymentNotificationDate = paymentNotificationDate;
        this.paymentAmountDue = paymentAmountDue;
        this.loanType = loanType;
        this.missedPayment = missedPayment;
        this.lastPaymentDate = lastPaymentDate;
        setStatus(0);
        pastDue();
        Notify();
    }

    @Override
    public String[] accountToArray()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        return new String[]
                {
                        Integer.toString(customerId), Double.toString(currentBalance),
                        Double.toString(interestRate), formatter.format(paymentDueDate),
                        formatter.format(paymentNotificationDate), Double.toString(paymentAmountDue),
                        loanType, Integer.toString(missedPayment ? 1 : 0), formatter.format(lastPaymentDate)
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
        this.paymentAmountDue = paymentAmountDue;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
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
            if(loanType.equals("Long")){
                paymentAmountDue = paymentAmountDue + 75.0;
            }
        }
    }
    public void paymentMade(int amount){
        currentBalance = currentBalance - amount;
        lastPaymentDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, 30);
        paymentDueDate = c.getTime();
    }

    public void Notify (List <Account> list){//For calls in other files us LoanAccounts.notify(list);
        Date current =new Date();
        Calendar date= Calendar.getInstance();
        date.setTime(current);
        for(int i = 0; i < list.size(); i++){
            LoanAccount a = list.get(i);
            if(a.paymentDueDate.equals(current)){
                date.add(Calendar.DATE,90);
                a.paymentDueDate= date.getTime();
                list.set(i,a);
            }
            else if(a.paymentDueDate.compareTo(current) <= 30){
                System.out.println("Account Number: "+ a.accountNumber+" has a payment due: " + a.paymentDueDate);
                a.paymentNotificationDate = current;
                list.set(i,a);
            }
        }

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
            System.out.println("Account Number: "+ accountNumber+" has a payment due: " + paymentDueDate);
            paymentNotificationDate = current;
        }
    }
}
