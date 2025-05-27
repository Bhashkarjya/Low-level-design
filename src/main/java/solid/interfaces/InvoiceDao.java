package src.main.java.solid.interfaces;

import src.main.java.solid.model.InvoiceCalculator;

public interface InvoiceDao {
    public void save(InvoiceCalculator invoice);
}