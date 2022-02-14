package main.java.items;

import main.java.attributes.PrimaryAttribute;

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
