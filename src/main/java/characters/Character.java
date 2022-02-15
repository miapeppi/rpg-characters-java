package main.java.characters;

import java.util.HashMap;
import main.java.attributes.PrimaryAttribute;
import main.java.characters.items.Armor;
import main.java.characters.items.Item;
import main.java.characters.items.Item.Slot;
import main.java.characters.items.Weapon;
import main.java.characters.items.itemexceptions.InvalidArmorException;
import main.java.characters.items.itemexceptions.InvalidWeaponException;

public abstract class Character {
    private String characterName;
    private int characterLevel = 1; // Every character starts at level 1
    private double characterDps = 1;
    private double damageAttribute;
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
    public abstract void levelUp(int levels) throws Exception;

    /**
     * Method for equipping one piece of armor. Checks if armor is correct type and level for the character before equipping.
     * @param armor the armor to equip
     * @throws InvalidArmorException If character tries to equip armour too high level or wrong type
     */
    public abstract boolean equipItem(Armor armor) throws InvalidArmorException;

    /**
     * Method for equipping one piece of weapon. Checks if weapon is correct type and level for the character before equipping.
     * @param weapon the weapon to equip
     * @throws InvalidWeaponException If character tries to equip weapon too high level or wrong type
     */
    public  abstract boolean equipItem(Weapon weapon) throws InvalidWeaponException;

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
        stats.append("DPS: "+ getCharacterDps() + "\n");
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

    public double getCharacterDps() {
        return characterDps;
    }

    public void setCharacterDps() {
        if(getEquipments().get(Item.Slot.Weapon) == null) {
            this.characterDps = (1 * (1 + getDamageAttribute()/100));
        } else {
            Weapon currentWeapon = (Weapon) getEquipments().get(Item.Slot.Weapon);
            this.characterDps = (currentWeapon.getWeaponDps() * (1 + getDamageAttribute()/100));
        }
    }

    public double getDamageAttribute() {
        return damageAttribute;
    }

    public void setDamageAttribute(double damageAttribute) {
        this.damageAttribute = damageAttribute;
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
