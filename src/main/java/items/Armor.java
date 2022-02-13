package main.java.items;

import main.java.attributes.PrimaryAttribute;

public class Armor extends Item {
    private ArmorType armorType;
    private PrimaryAttribute armorAttribute;

    // Enum for every armor type that can be equipped
    public enum ArmorType {
        Cloth,
        Leather,
        Mail,
        Plate
    }
}
