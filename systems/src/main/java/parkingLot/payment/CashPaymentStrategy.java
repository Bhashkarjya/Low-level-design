package parkingLot.payment;

public class CashPaymentStrategy implements PaymentStrategy {
    @Override
    public boolean pay(double amount)  {
        return true;
    }
}
