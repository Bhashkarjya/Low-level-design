package behavioral.strategy;

import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static PaymentService service = new PaymentService();
    public static void main(String[] args) throws Exception{
        System.out.println("Please choose your mode of payment \n" +
                "1 - UPI \n" +
                "2 - Cash \n" +
                "3 - Card\n");
        int paymentMethod = sc.nextInt();
        if(paymentMethod == 1) {
            service.setStrategy(new UPIPayment());
        }
        else if(paymentMethod == 2) {
            service.setStrategy(new CashPayment());
        }
        else if (paymentMethod == 3) {
            service.setStrategy(new CardPayment());
        }
        else {
            throw new IllegalArgumentException("Illegal Argument");
        }

        service.makePayment(30);
    }
}
