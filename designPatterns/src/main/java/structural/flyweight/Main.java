package structural.flyweight;

public class Main {
    public static void main(String[] args) {
        Character c1 = CharacterFactory.createCharacter('a', "Arial", 10);
        Character c2 = CharacterFactory.createCharacter('a', "Arial", 10);

        //Test if c1 and c2 are equal
        System.out.println(c1 == c2);

        Character c3 = CharacterFactory.createCharacter('c', "Arial", 10);
        c1.render(0,10);
        c2.render(4,12);
        c3.render(2,5);

    }
}
