package creational.prototype;

import java.util.logging.Level;

public class LevelOneCharacter extends Character {
    private String specialPowers;
    public LevelOneCharacter (LevelOneCharacter character) {
        super(character);
        this.specialPowers = character.specialPowers;
    }

    public Character clone() {
        return new LevelOneCharacter(this);
    }
}
