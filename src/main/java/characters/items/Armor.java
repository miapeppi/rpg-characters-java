package main.java.characters.items;

import main.java.attributes.PrimaryAttribute;
import main.java.characters.*;
import main.java.characters.Character;

public class Armor extends Item {
    private ArmorType armorType;
    private PrimaryAttribute armorAttribute;

    /**
     * Enum for every armor type that can be equipped
     */
    public enum ArmorType {
        Cloth,
        Leather,
        Mail,
        Plate
    }

    /**
     * Default constructor
     */
    public Armor() {
        super();
    }

    /**
     * Overloaded constructor that creates new armor with name, level, armor type and equipping slot
     * @param itemName a name for the armor
     * @param itemLevel a level for the armor
     * @param armorType what kind of armor will be created
     * @param slot a slot where armor will be equipped
     */
    public Armor(String itemName, int itemLevel, ArmorType armorType, Slot slot) {
        super(itemName, itemLevel);
        setArmorType(armorType);
        setEquippingSlot(slot);
        setArmorAttribute(new PrimaryAttribute(1, 1,1)); // Setting default values
    }

    /**
     * Overloaded constructor that creates new armor with name, level, armor type and equipping slot
     * @param itemName a name for the armor
     * @param itemLevel a level for the armor
     * @param armorType what kind of armor will be created
     * @param slot a slot where armor will be equipped
     * @param armorAttribute attributes for the armor
     */
    public Armor(String itemName, int itemLevel, ArmorType armorType, Slot slot, PrimaryAttribute armorAttribute) {
        super(itemName, itemLevel);
        setArmorType(armorType);
        setEquippingSlot(slot);
        setArmorAttribute(new PrimaryAttribute(armorAttribute.getStrength(), armorAttribute.getDexterity(), armorAttribute.getIntelligence())); // Setting default values
    }

    @Override
    public boolean checkItem(Character character) {
        if(getItemLevel() > character.getCharacterLevel()) { // Checks if the item level is ok
            return false;
        } else {
            if(getEquippingSlot().equals(Slot.Weapon)) return false; // Check that armor is not at weapon slot
            if(character instanceof Mage) {
                // If the character type is mage and armor type is cloth, returns true
                return getArmorType().equals(ArmorType.Cloth);
            } else if(character instanceof Ranger) {
                // If the character type is ranger and armor type is leather or mail, returns true
                return (getArmorType().equals(ArmorType.Leather) || getArmorType().equals(ArmorType.Mail));
            } else if(character instanceof Rogue)
                // If the character type is rogue and armor type is leather or mail, returns true
                return (getArmorType().equals(ArmorType.Leather) || getArmorType().equals(ArmorType.Mail));
            else if(character instanceof Warrior) {
                // If the character type is warrior and armor type is mail or plate, returns true
                return (getArmorType().equals(ArmorType.Mail) || getArmorType().equals(ArmorType.Plate));
            }
        }
        return false;
    }

    // region Getters and setters
    public ArmorType getArmorType() {
        return armorType;
    }

    public void setArmorType(ArmorType armorType) {
        this.armorType = armorType;
    }

    public PrimaryAttribute getArmorAttribute() {
        return armorAttribute;
    }

    public void setArmorAttribute(PrimaryAttribute armorAttribute) {
        this.armorAttribute = armorAttribute;
    }
    // endregion
}
