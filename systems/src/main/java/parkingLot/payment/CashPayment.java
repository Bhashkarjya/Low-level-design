package parkingLot.payment;

public class CashPayment extends Payment{
    private PaymentStrategy strategy;

    public CashPayment(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public boolean initiateTransaction() {
        boolean success = strategy.pay(amount);
        status = success ? PaymentStatus.COMPLETED : PaymentStatus.FAILED;
        return success;
    }
}
