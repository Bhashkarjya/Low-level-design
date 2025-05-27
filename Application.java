import src.main.java.solid.model.*;
import src.main.java.solid.model.interfaceSegmented.*;

public class Application {
    public static void main(String[] args) {
        Marker newMarker = new Marker("XYZ", "red", 1990, 12);
        int quantity = 10;
        
        // Single-responsibility principle
        InvoiceCalculator invoice = new InvoiceCalculator(newMarker, quantity);
        invoice.calculateTotal();

        System.out.println("Single Responsibility Principle");

        InvoicePrinter printer = new InvoicePrinter(invoice);
        printer.printInvoice();

        InvoiceDao databaseInvoiceDao = new DatabaseInvoiceDao();
        InvoiceDao fileInvoiceDao = new FileInvoiceDao();

        System.out.println("Open Closed Principle");

        // Open-closed principle
        databaseInvoiceDao.save(invoice);
        fileInvoiceDao.save(invoice);

        // Interface Segmented Principle
        System.out.println("Interface Segmented Principle");
        Cook cook = new Cook();
        Waiter waiter = new Waiter();

        cook.cookFood();
        cook.washDishes();

        waiter.takeOrder();
        waiter.serveFood();
    }
}