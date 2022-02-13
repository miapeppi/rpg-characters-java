package main.java.items;

import main.java.attributes.WeaponAttribute;
import main.java.characters.Mage;

public class Weapon extends Item {
    private WeaponType weaponType;
    private WeaponAttribute weaponAttribute;

    /** Enum for every weapon type that can be equipped */
    public enum WeaponType {
        Axe,
        Bow,
        Dagger,
        Hammer,
        Staff,
        Sword,
        Wand
    }

    /** Constructor that creates new weapon attributes and put the equipping slot as a weapon */
    public Weapon() {
        //weaponAttribute = new WeaponAttribute();
        setEquippingSlot(Slot.Weapon);
    }
}
