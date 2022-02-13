package main.java.attributes;

public class PrimaryAttribute {
    private int strength = 0;
    private int dexterity = 0;
    private int intelligence = 0;

    /** Overloaded constructor */
    public PrimaryAttribute( int strength, int dexterity, int intelligence) {
        setStrength(strength);
        setDexterity(dexterity);
        setIntelligence(intelligence);
    }

    /** Method for adding up primary attributes */
    public PrimaryAttribute attributeLevelUp(PrimaryAttribute levelingUpAttributes) {
        int newStrength = getStrength() + levelingUpAttributes.getStrength();
        int newDexterity = getDexterity() + levelingUpAttributes.getDexterity();
        int newIntelligence = getIntelligence() + levelingUpAttributes.getIntelligence();
        return (new PrimaryAttribute(newStrength, newDexterity, newIntelligence));
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
