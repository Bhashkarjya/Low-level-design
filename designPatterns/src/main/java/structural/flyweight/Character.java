package structural.flyweight;

//Character flyweight class which contains only the intrinsic data
public class Character implements ICharacter {
    private final char value;
    private final String font;
    private final int size;

    public Character(char value, String font, int size) {
        this.value = value;
        this.font = font;
        this.size = size;
    }

    @Override
    public void render(int x, int y) {
        System.out.println("Rendering character : " + this.value + " with font : " + this.font + " and size : " + this.size
        + " in X coordinate : " + x + " and Y coordinate : " + y);
    }
}
