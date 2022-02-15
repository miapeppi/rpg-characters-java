package main.java.attributes;

public class PrimaryAttribute {
    private int strength = 0;
    private int dexterity = 0;
    private int intelligence = 0;

    /**
     * Overloaded constructor
     * @param strength the amount of strength
     * @param dexterity the amount of dexterity
     * @param intelligence the amount of intelligence
     */
    public PrimaryAttribute( int strength, int dexterity, int intelligence) {
        setStrength(strength);
        setDexterity(dexterity);
        setIntelligence(intelligence);
    }

    /**
     * Method for adding up primary attributes
     * @param levelingUpAttributes the amount to increase the attributes
     * @return increased attributes
     */
    public PrimaryAttribute addAttribute(PrimaryAttribute levelingUpAttributes) {
        int newStrength = getStrength() + levelingUpAttributes.getStrength();
        int newDexterity = getDexterity() + levelingUpAttributes.getDexterity();
        int newIntelligence = getIntelligence() + levelingUpAttributes.getIntelligence();
        return (new PrimaryAttribute(newStrength, newDexterity, newIntelligence));
    }

    /**
     * Method for adding up primary attributes for precise amount of levels
     * @param levelingUpAttributes the amount to increase the attributes
     * @param levels the amount of levels to increase the attributes
     * @return increased attributes
     */
    public PrimaryAttribute addAttribute(PrimaryAttribute levelingUpAttributes, int levels) {
        int newStrength = getStrength() + levelingUpAttributes.getStrength() * levels;
        int newDexterity = getDexterity() + levelingUpAttributes.getDexterity() * levels;
        int newIntelligence = getIntelligence() + levelingUpAttributes.getIntelligence() * levels;
        return (new PrimaryAttribute(newStrength, newDexterity, newIntelligence));
    }

    /**
     * Method for subtracting the primary attributes
     * @param subtractAttributes tha amount to subtract the attributes
     * @return subtracted amount of attributes
     */
    public PrimaryAttribute subtractAttribute(PrimaryAttribute subtractAttributes) {
        int newStrength = getStrength() - subtractAttributes.getStrength();
        int newDexterity = getDexterity() - subtractAttributes.getDexterity();
        int newIntelligence = getIntelligence() - subtractAttributes.getIntelligence();
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
