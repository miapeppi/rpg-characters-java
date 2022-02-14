package main.java.items;

import main.java.characters.*;
import main.java.characters.Character;

public class Weapon extends Item {
    private WeaponType weaponType;
    private int weaponDamage = 1;
    private double weaponAttackSpeed = 1;
    private double weaponDps = (weaponDamage * weaponAttackSpeed);

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

    /** Default constructor with no parameters */
    public Weapon() {
        super();
    }

    /** Overloaded constructor that creates new weapon with name, level and weapon type and put the equipping slot as a weapon */
    public Weapon(String itemName, int itemLevel, WeaponType weaponType) {
        super(itemName, itemLevel);
        setWeaponType(weaponType);
        setEquippingSlot(Slot.Weapon);
    }

    /** Overloaded constructor that creates new weapon with name, level, weapon type and attributes and put the equipping slot as a weapon */
    public Weapon(String itemName, int itemLevel, WeaponType weaponType, int damage, double attackSpeed) {
        super(itemName, itemLevel);
        setWeaponType(weaponType);
        setEquippingSlot(Slot.Weapon);
        setWeaponDamage(damage);
        setWeaponAttackSpeed(attackSpeed);
        setWeaponDps(damage * attackSpeed);
    }

    @Override
    public boolean checkItem(Character character) {
        if(getItemLevel() > character.getCharacterLevel()) { // Checks if the item level is ok
            return false;
        } else {
            if(!getEquippingSlot().equals(Slot.Weapon)) return false; // Check that weapon is equipped in weapon slot
            if(character instanceof Mage) {
                if(getWeaponType().equals(WeaponType.Staff) || getWeaponType().equals(WeaponType.Wand)) { // If the character type is mage and weapon type is staff or wand, returns true
                    return true;
                } else {
                    return false;
                }
            } else if(character instanceof Ranger) {
                if(getWeaponType().equals(WeaponType.Bow)) { // If the character type is ranger and weapon type is bow, returns true
                    return true;
                } else {
                    return false;
                }
            } else if(character instanceof Rogue) {
                if(getWeaponType().equals(WeaponType.Dagger) || getWeaponType().equals(WeaponType.Sword)) { // If the character type is rogue and weapon type is dagger or sword, returns true
                    return true;
                } else {
                    return false;
                }
            } else if(character instanceof Warrior) {
                if(getWeaponType().equals(WeaponType.Axe) || getWeaponType().equals(WeaponType.Hammer) || getWeaponType().equals(WeaponType.Sword)) { // If the character type is warrior and weapon type is axe, hammer or sword, returns true
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    // region Getters and setters
    public WeaponType getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(int damage) {
        this.weaponDamage = weaponDamage;
    }

    public double getWeaponAttackSpeed() {
        return weaponAttackSpeed;
    }

    public void setWeaponAttackSpeed(double attackSpeed) {
        this.weaponAttackSpeed = attackSpeed;
    }

    public double getWeaponDps() {
        return weaponDps;
    }

    public void setWeaponDps(double dps) {
        this.weaponDps = dps;
    }
    // endregion
}
