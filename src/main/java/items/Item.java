package main.java.items;

import main.java.characters.Character;

public abstract class Item {
    private String itemName;
    private int itemLevel;
    private Slot equippingSlot;

    /** Enum for every slot where character can have items */
    public enum Slot {
        Head,
        Body,
        Legs,
        Weapon
    }

    /** Default constructor with no parameters */
    public Item() { }

    /** Overloaded constructor with item name and level */
    public Item(String itemName, int itemLevel) {
        setItemName(itemName);
        setItemLevel(itemLevel);
    }

    /** Method that checks if the armor or weapon is not too high level */
    public abstract boolean checkItem(final Character character);

    // region Getters and setters
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemLevel() {
        return itemLevel;
    }

    public void setItemLevel(int itemLevel) {
        this.itemLevel = itemLevel;
    }

    public Slot getEquippingSlot() {
        return equippingSlot;
    }

    public void setEquippingSlot(Slot equippingSlot) {
        this.equippingSlot = equippingSlot;
    }
    // endregion
}
