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
    public PrimaryAttribute addAttribute(PrimaryAttribute levelingUpAttributes) {
        int newStrength = getStrength() + levelingUpAttributes.getStrength();
        int newDexterity = getDexterity() + levelingUpAttributes.getDexterity();
        int newIntelligence = getIntelligence() + levelingUpAttributes.getIntelligence();
        return (new PrimaryAttribute(newStrength, newDexterity, newIntelligence));
    }

    /** Method for adding up primary attributes for precise amount of levels */
    public PrimaryAttribute addAttribute(PrimaryAttribute levelingUpAttributes, int levels) {
        int newStrength = getStrength() + levelingUpAttributes.getStrength() * levels;
        int newDexterity = getDexterity() + levelingUpAttributes.getDexterity() * levels;
        int newIntelligence = getIntelligence() + levelingUpAttributes.getIntelligence() * levels;
        return (new PrimaryAttribute(newStrength, newDexterity, newIntelligence));
    }

    public PrimaryAttribute subtractAttribute(PrimaryAttribute subtracAttributes) {
        int newStrength = getStrength() - subtracAttributes.getStrength();
        int newDexterity = getDexterity() - subtracAttributes.getDexterity();
        int newIntelligence = getIntelligence() - subtracAttributes.getIntelligence();
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
