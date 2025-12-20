package parkingLot.payment;

public class CardPayment extends Payment {
    private String cardNumber;
    private PaymentStrategy strategy;

    public CardPayment(String cardNumber, PaymentStrategy strategy) {
        this.cardNumber = cardNumber;
        this.strategy = strategy;
    }

    @Override
    public boolean initiateTransaction() {
        boolean success = strategy.pay(amount);
        status = success ? PaymentStatus.COMPLETED : PaymentStatus.FAILED;
        return success;
    }
}
