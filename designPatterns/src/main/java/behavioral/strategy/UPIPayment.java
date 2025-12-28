package behavioral.strategy;

public class UPIPayment implements PaymentStrategy {
    @Override
    public void initiateTransaction(int amount) {
        System.out.println("Record a UPI Payment of amount : " + amount);
    }
}
