package main.java.characters;

import java.util.HashMap;
import main.java.attributes.PrimaryAttribute;
import main.java.items.Armor;
import main.java.items.Item;
import main.java.items.Item.Slot;
import main.java.items.Weapon;
import main.java.items.itemexceptions.InvalidArmorException;
import main.java.items.itemexceptions.InvalidWeaponException;

public abstract class Character {
    private String characterName;
    private int characterLevel = 1; // Every character starts at level 1
    private PrimaryAttribute basePrimaryAttribute;
    private PrimaryAttribute totalPrimaryAttribute;
    private HashMap<Slot, Item> equipments;

    /**
     * Constructor for creating a new character with a name, starting attributes and dictionary for equipments
     * @param name a name for character
     * @param startAttributes starting points for primary attributes
     */
    public Character(String name, PrimaryAttribute startAttributes) {
        setCharacterName(name);
        setBasePrimaryAttribute(startAttributes);
        setTotalPrimaryAttribute(startAttributes);
        initializeEquipments(); // Creating a dictionary for equipments
    }

    /**
     * Creating a dictionary with all four slots where items can be equipped
     */
    public void initializeEquipments() {
        HashMap<Slot, Item> equippingSlots = new HashMap<>();
        equippingSlots.put(Slot.Head, null);
        equippingSlots.put(Slot.Body, null);
        equippingSlots.put(Slot.Legs, null);
        equippingSlots.put(Slot.Weapon, null);
        setEquipments(equippingSlots);
    }

    /**
     * Method for leveling up the character by one level and increasing the primary attributes
     */
    public abstract void levelUp();

    /**
     * Method for leveling up the character precise amount of levels and increasing the primary attributes
     * @param levels an amount of levels character to level up
     */
    public abstract void levelUp(int levels);

    /**
     * Method for equipping one piece of armor. Checks if armor is correct type and level for the character before equipping.
     * @param armor the armor to equip
     * @throws InvalidArmorException If character tries to equip armour too high level or wrong type
     */
    public abstract void equipItem(Armor armor) throws InvalidArmorException;

    /**
     * Method for equipping one piece of weapon. Checks if weapon is correct type and level for the character before equipping.
     * @param weapon the weapon to equip
     * @throws InvalidWeaponException If character tries to equip weapon too high level or wrong type
     */
    public  abstract void equipItem(Weapon weapon) throws InvalidWeaponException;

    /**
     * For printing characters statistic sheet
     */
    public void printCharacterStats() {
        StringBuilder stats = new StringBuilder();
        stats.append(this.getClass().getSimpleName() + ": " +  getCharacterName() +  " (Level " + getCharacterLevel() + ")\n" );
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

    public HashMap<Slot, Item> getEquipments() {
        return equipments;
    }

    public void setEquipments(HashMap<Slot, Item> equipments) {
        this.equipments = equipments;
    }
    // endregion
}
