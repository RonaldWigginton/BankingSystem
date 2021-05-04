package Accounts;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class CreditCard extends LoanAccount {
    private double limit;

    public CreditCard(int customerId, int accountNumber, double currentBalance, double interestRate, Date paymentDueDate, Date paymentNotificationDate, double paymentAmountDue, String loanType, boolean missedPayment, Date lastPaymentDate, double limit) {
        super(customerId, accountNumber,currentBalance, interestRate, paymentDueDate, paymentNotificationDate, paymentAmountDue, loanType, missedPayment, lastPaymentDate);
        this.limit = limit;
    }
@Override
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
        double charges = creditCharges();
        if((charges + currentBalance)<= limit){
            currentBalance = currentBalance + charges;
        }
        else {
            System.out.println("Customer has reached credit limit.");
        }
    }
    public double creditCharges(){//Random spending for Credit card user
        Random r = new Random();
        int low = 1;
        int high = 1000;
        double result = r.nextInt(high-low) + low;
        return result;
    }
}
