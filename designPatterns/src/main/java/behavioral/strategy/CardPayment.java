package behavioral.strategy;

public class CardPayment implements PaymentStrategy {
    @Override
    public void initiateTransaction(int amount) {
        System.out.println("Record a Card Payment of amount : " + amount);
    }
}
