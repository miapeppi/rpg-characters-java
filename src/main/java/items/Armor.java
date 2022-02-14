package main.java.items;

import main.java.attributes.PrimaryAttribute;
import main.java.characters.*;
import main.java.characters.Character;

public class Armor extends Item {
    private ArmorType armorType;
    private PrimaryAttribute armorAttribute;

    /** Enum for every armor type that can be equipped */
    public enum ArmorType {
        Cloth,
        Leather,
        Mail,
        Plate
    }

    /** Default constructor with no parameters */
    public Armor() {
        super();
    }

    /** Overloaded constructor that creates new armor with name, level, armor type and equipping slot */
    public Armor(String itemName, int itemLevel, ArmorType armorType, Slot slot) {
        super(itemName, itemLevel);
        setArmorType(armorType);
        setEquippingSlot(slot);
    }


    @Override
    public boolean checkItem(Character character) {
        if(getItemLevel() > character.getCharacterLevel()) { // Checks if the item level is ok
            return false;
        } else {
            if(getEquippingSlot().equals(Slot.Weapon)) return false; // Check that armor is not at weapon slot
            if(character instanceof Mage) {
                if(getArmorType().equals(ArmorType.Cloth)) { // If the character type is mage and armor type is cloth, returns true
                    return true;
                } else {
                    return false;
                }
            } else if(character instanceof Ranger) {
                if(getArmorType().equals(ArmorType.Leather) || getArmorType().equals(ArmorType.Mail)) { // If the character type is ranger and armor type is leather or mail, returns true
                    return true;
                } else {
                    return false;
                }
            } else if(character instanceof Rogue) {
                if(getArmorType().equals(ArmorType.Leather) || getArmorType().equals(ArmorType.Mail)) { // If the character type is rogue and armor type is leather or mail, returns true
                    return true;
                } else {
                    return false;
                }
            } else if(character instanceof Warrior) {
                if(getArmorType().equals(ArmorType.Mail) || getArmorType().equals(ArmorType.Plate)) { // If the character type is warrior and armor type is mail or plate, returns true
                    return true;
                } else {
                    return false;
                }
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
