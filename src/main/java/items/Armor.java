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
