import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class CreditCard extends LoanAccount{
    private double limit;

    public CreditCard(int customerId, double currentBalance, double interestRate, Date paymentDueDate, Date paymentNotificationDate, double paymentAmountDue, String loanType, boolean missedPayment, Date lastPaymentDate, double limit) {
        super(customerId, currentBalance, interestRate, paymentDueDate, paymentNotificationDate, paymentAmountDue, loanType, missedPayment, lastPaymentDate);
        this.limit = limit;
    }
@Override
    public void paymentMade(int amount){
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
