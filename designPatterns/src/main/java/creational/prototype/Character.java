package creational.prototype;

public abstract class Character {
    //These are the attributes of a basic character.
    private String characterName;
    private int health;
    private int attackPower;
    public Character() {

    }

    public Character(Character ch) {
        this.characterName = ch.characterName;
        this.attackPower = ch.attackPower;
        this.health = ch.health;
    }

    public void setCharacterName(String name) {
        this.characterName = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public abstract Character clone();
}
