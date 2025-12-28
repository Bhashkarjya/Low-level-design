package behavioral.strategy;

public class CashPayment implements PaymentStrategy {
    @Override
    public void initiateTransaction(int amount) {
        System.out.println("Record a Cash Payment of amount : " + amount);
    }
}
