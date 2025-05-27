import src.main.java.solid.model.*;
import src.main.java.solid.interfaces.*;

public class Application {
    public static void main(String[] args) {
        Marker newMarker = new Marker("XYZ", "red", 1990, 12);
        int quantity = 10;
        
        // Single-responsibility principle
        InvoiceCalculator invoice = new InvoiceCalculator(newMarker, quantity);
        invoice.calculateTotal();

        InvoicePrinter printer = new InvoicePrinter(invoice);
        printer.printInvoice();

        InvoiceDao databaseInvoiceDao = new DatabaseInvoiceDao();
        InvoiceDao fileInvoiceDao = new FileInvoiceDao();

        // Open-closed principle
        databaseInvoiceDao.save(invoice);
        fileInvoiceDao.save(invoice);
    }
}