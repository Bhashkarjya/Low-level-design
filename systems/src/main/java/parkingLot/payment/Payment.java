package parkingLot.payment;

import java.util.Date;
public abstract class Payment {
    protected String transactionId;
    protected double amount;
    protected PaymentStatus status;
    protected Date timestamp;
    public abstract boolean initiateTransaction();
}
