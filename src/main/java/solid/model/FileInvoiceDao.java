package src.main.java.solid.model;

//Extending the save method from the interface InvoiceDao
public class FileInvoiceDao implements InvoiceDao {
    @Override
    public void save(InvoiceCalculator invoice){
        System.out.println("Invoice saved to File");
    }
}