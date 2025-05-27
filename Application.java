import src.main.java.solid.model.*;

public class Application {
    public static void main(String[] args) {
        Marker newMarker = new Marker("XYZ", "red", 1990, 12);
        int quantity = 10;

        InvoiceCalculator invoice = new InvoiceCalculator(newMarker, quantity);
        invoice.calculateTotal();

        InvoicePrinter printer = new InvoicePrinter(invoice);
        printer.printInvoice();

        InvoiceDao invoiceDao = new InvoiceDao(invoice);
        invoiceDao.saveToDB();
    }
}