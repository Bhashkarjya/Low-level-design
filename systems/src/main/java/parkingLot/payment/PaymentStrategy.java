package parkingLot.payment;

import java.util.Date;
public interface PaymentStrategy {
    public boolean pay(double amount);
}
