package src.main.java.solid.model;

//This class follows SRP
public class InvoiceDao {
    private InvoiceCalculator invoice;

    public InvoiceDao(InvoiceCalculator invoice) {
        this.invoice = invoice;
    }

    public void saveToDB() {
        System.out.println("saved to database");
    }
}