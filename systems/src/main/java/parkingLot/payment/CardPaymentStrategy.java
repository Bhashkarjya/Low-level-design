package parkingLot.payment;

public class CardPaymentStrategy implements PaymentStrategy {
    private String bankAccountNumber;
    private String accountOwner;
    @Override
    public boolean pay(double amount)  {
        return true;
    }
}
