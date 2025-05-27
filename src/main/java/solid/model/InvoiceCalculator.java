package src.main.java.solid.model;

//This class follows SRP
public class InvoiceCalculator {
    private Marker marker;
    private int quantity;

    public InvoiceCalculator(Marker marker, int quantity) {
        this.marker = marker;
        this.quantity = quantity;
    }

    public int calculateTotal() {
        int totalPrice = this.marker.price * this.quantity;
        return totalPrice;
    }
}