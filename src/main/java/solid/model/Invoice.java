package src.main.java.solid.model;

/*
This class doesn't follow Single Responsibility Principle. There are many reasons for this class to change.
Few reasons for this class to change :
    a. Modify the way to calculate the total price
    b. Save the information to a different DB.
*/

public class Invoice {
    private Marker marker;
    private int quantity;

    public Invoice(Marker marker, int quantity) {
        this.marker = marker;
        this.quantity = quantity;
    }

    public int calculateTotal() {
        int price = marker.price * this.quantity;
        return price;
    }

    public void printInvoice() {
        System.out.println("Marker : " + this.marker.name + " Quantity : " + this.quantity + " price : " + calculateTotal());
    }

    public void saveToDB() {
        System.out.println("Saved to Database");
    }
}