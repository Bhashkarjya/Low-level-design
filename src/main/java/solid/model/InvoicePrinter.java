package src.main.java.solid.model;


//This class follows SRP
public class InvoicePrinter {
    private InvoiceCalculator invoice;

    public InvoicePrinter(InvoiceCalculator invoice) {
        this.invoice = invoice;
    }

    public void printInvoice() {
        int totalPrice = invoice.calculateTotal();
        System.out.println("Total Price : " + totalPrice);
    }
}