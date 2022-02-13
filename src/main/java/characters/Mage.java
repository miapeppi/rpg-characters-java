package main.java.characters;

import main.java.attributes.PrimaryAttribute;

public class Mage extends Character {
    private PrimaryAttribute levelingUpAttribute;

    public Mage(String name) {
        super(name, new PrimaryAttribute(1, 1, 8));
        setLevelingUpAttributes(new PrimaryAttribute(1, 1, 5));
    }

    @Override
    public void levelUp() {
        setCharacterLevel(getCharacterLevel() + 1);
        setBasePrimaryAttribute(getBasePrimaryAttribute().attributeLevelUp(getLevelingUpAttribute()));
        setTotalPrimaryAttribute(getTotalPrimaryAttribute().attributeLevelUp(getLevelingUpAttribute()));
        // DPS
        System.out.println("You leveled up!");
    }

    // region Getters and setters
    public PrimaryAttribute getLevelingUpAttribute() {
        return levelingUpAttribute;
    }

    public void setLevelingUpAttributes(PrimaryAttribute levelingUpAttribute) {
        this.levelingUpAttribute = levelingUpAttribute;
    }
    // endregion

}
