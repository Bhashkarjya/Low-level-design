package src.main.java.solid.model.interfaceSegmented;

public class Cook implements CookInterface{
    @Override
    public void cookFood() {
        System.out.println("Cooking food");
    }

    @Override
    public void washDishes() {
        System.out.println("Washing dishes");
    }
}
