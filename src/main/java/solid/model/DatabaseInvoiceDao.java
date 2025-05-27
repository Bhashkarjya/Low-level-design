package src.main.java.solid.model;

//Extending the save method from the interface
public class DatabaseInvoiceDao implements InvoiceDao {

    @Override
    public void save(InvoiceCalculator invoice) {
        System.out.println("Invoice saved to Database");
    }
}