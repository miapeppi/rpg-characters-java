package main.java.characters;

import main.java.attributes.PrimaryAttribute;

public abstract class Character {
    private String characterName;
    private int characterLevel = 1; // Every character starts at level 1
    private PrimaryAttribute basePrimaryAttribute;
    private PrimaryAttribute totalPrimaryAttribute;
    // Equipments

    // Overloaded constructor for creating a new character with a name, starting attributes and creating a dictionary for equipments
    public Character(String name, PrimaryAttribute startAttributes) {
        setCharacterName(name);
        setBasePrimaryAttribute(startAttributes);
        setTotalPrimaryAttribute(startAttributes);
    }

    // For printing characters statistic sheet
    public void printCharacterStats() {
        StringBuilder stats = new StringBuilder();
        stats.append(getCharacterName() +  " (Level " + getCharacterLevel() + ")\n" );
        stats.append("=========================\n");
        stats.append("Strength: " + getTotalPrimaryAttribute().getStrength() + "\n");
        stats.append("Dexterity: " + getTotalPrimaryAttribute().getDexterity() + "\n");
        stats.append("Intelligence: " + getTotalPrimaryAttribute().getIntelligence() + "\n");
        stats.append("DPS: \n");
        System.out.println(stats);
    }

    // region Getters and setters
    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public int getCharacterLevel() {
        return characterLevel;
    }

    public void setCharacterLevel(int characterLevel) {
        this.characterLevel = characterLevel;
    }

    public PrimaryAttribute getBasePrimaryAttribute() {
        return basePrimaryAttribute;
    }

    public void setBasePrimaryAttribute(PrimaryAttribute basePrimaryAttribute) {
        this.basePrimaryAttribute = basePrimaryAttribute;
    }

    public PrimaryAttribute getTotalPrimaryAttribute() {
        return totalPrimaryAttribute;
    }

    public void setTotalPrimaryAttribute(PrimaryAttribute totalPrimaryAttribute) {
        this.totalPrimaryAttribute = totalPrimaryAttribute;
    }
    // endregion
}
