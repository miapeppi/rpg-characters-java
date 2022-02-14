package main.java.items;

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
