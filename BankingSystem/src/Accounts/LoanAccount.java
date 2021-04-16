package Accounts;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LoanAccount extends Account{
    private Date paymentDueDate;
    private Date paymentNotificationDate;
    private double paymentAmountDue;
    private String loanType;
    private boolean missedPayment;
    private Date lastPaymentDate;

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
}