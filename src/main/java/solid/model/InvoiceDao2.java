package src.main.java.solid.model;


/*This class follows SRP
 If we want to add one more functionality of adding the invoice to filesystem, we would have to add another method saveToFile.
 By doing so, we would modify a tried and tested class in prod and it would violate the Open-closed principle.
 To avoid doing so, we would create an Interface InvoiceDao and make other classes implement it.
*/
public class InvoiceDao2 {
    private InvoiceCalculator invoice;

    public InvoiceDao2(InvoiceCalculator invoice) {
        this.invoice = invoice;
    }

    public void saveToDB() {
        System.out.println("Invoice saved to DB");
    }
}