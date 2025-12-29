package structural.flyweight;

import java.util.HashMap;
import java.util.Map;
public class CharacterFactory {
    private static final Map<String, Character> cache = new HashMap<>();

    public static Character createCharacter(char value, String font, int size) {
        String key = value + font + size;
        if(!cache.containsKey(key)) {
            cache.put(key, new Character(value, font, size));
        }

        return cache.get(key);
    }
}
