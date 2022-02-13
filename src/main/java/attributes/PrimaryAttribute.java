package main.java.attributes;

public class PrimaryAttribute {
    private int strength = 0;
    private int dexterity = 0;
    private int intelligence = 0;

    // Default constructor
    public PrimaryAttribute() {
    }

    // Overloaded constructor
    public PrimaryAttribute( int strength, int dexterity, int intelligence) {
        setStrength(strength);
        setDexterity(dexterity);
        setIntelligence(intelligence);
    }

    // region Getters and setters
    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
    //endregion
}
