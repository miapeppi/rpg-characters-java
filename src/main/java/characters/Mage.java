package main.java.characters;

import main.java.attributes.PrimaryAttribute;
import main.java.items.Armor;
import main.java.items.Item;
import main.java.items.Weapon;
import main.java.items.itemexceptions.InvalidArmorException;
import main.java.items.itemexceptions.InvalidWeaponException;

public class Mage extends Character {
    private PrimaryAttribute levelingUpAttribute;

    /**
     * Overloaded constructor for creating a new character with a name, starting attributes and dictionary for equipments.
     * Also setting the levelUpAttribute, with values that character gains when leveling up.
     * @param name a name for the character
     */
    public Mage(String name) {
        super(name, new PrimaryAttribute(1, 1, 8));
        setLevelingUpAttribute(new PrimaryAttribute(1, 1, 5));
        setDamageAttribute(getTotalPrimaryAttribute().getIntelligence());
        setCharacterDps();
    }

    @Override
    public void levelUp() {
        setCharacterLevel(getCharacterLevel() + 1);
        setBasePrimaryAttribute(getBasePrimaryAttribute().addAttribute(getLevelingUpAttribute()));
        setTotalPrimaryAttribute(getTotalPrimaryAttribute().addAttribute(getLevelingUpAttribute()));
        setDamageAttribute(getTotalPrimaryAttribute().getIntelligence());
        setCharacterDps();
        System.out.println("You leveled up!");
        printCharacterStats();
    }

    @Override
    public void levelUp(int levels) throws Exception{
        if(levels > 0) { // Checking that the amount of levels is more than zero
            setCharacterLevel(getCharacterLevel() + levels);
            setBasePrimaryAttribute(getBasePrimaryAttribute().addAttribute(getLevelingUpAttribute(), levels));
            setTotalPrimaryAttribute(getTotalPrimaryAttribute().addAttribute(getLevelingUpAttribute(), levels));
            setDamageAttribute(getTotalPrimaryAttribute().getIntelligence());
            setCharacterDps();
            System.out.println("You leveled up " + levels + " levels!");
            printCharacterStats();
        } else throw new Exception ("Can't level up 0 or fewer levels."); // If the level is zero or negative exception will be thrown
    }

    @Override
    public void equipItem(Armor armor) throws InvalidArmorException {
        if(armor.checkItem(this)) {
            if(getEquipments().get(armor.getEquippingSlot()) == null) { // Check if the equipping slot is empty
                getEquipments().put(armor.getEquippingSlot(), armor);
            } else {
                // Removes current armor from total attributes
                Armor currentArmor = (Armor) getEquipments().get(armor.getEquippingSlot());
                setTotalPrimaryAttribute(getTotalPrimaryAttribute().subtractAttribute(currentArmor.getArmorAttribute()));
                getEquipments().put(armor.getEquippingSlot(), armor);
            }
            setTotalPrimaryAttribute(getTotalPrimaryAttribute().addAttribute(armor.getArmorAttribute()));
            setDamageAttribute(getTotalPrimaryAttribute().getIntelligence());
            setCharacterDps();
            System.out.println(armor.getItemName() + " is now equipped at " + armor.getEquippingSlot());
            printCharacterStats();
        } else throw new InvalidArmorException("You are not worthy of this armor (too high of a level requirement or wrong armor type)");
    }

    @Override
    public void equipItem(Weapon weapon) throws InvalidWeaponException {
        if(weapon.checkItem(this)) {
            getEquipments().put(Item.Slot.Weapon, weapon);
            setCharacterDps();
            System.out.println(weapon.getItemName() + " is now equipped at " + weapon.getEquippingSlot());
            printCharacterStats();
        } else throw new InvalidWeaponException("You are not worthy of this weapon (too high of a level requirement or wrong weapon type)");
    }

    // region Getters and setters
    public PrimaryAttribute getLevelingUpAttribute() {
        return levelingUpAttribute;
    }

    public void setLevelingUpAttribute(PrimaryAttribute levelingUpAttribute) {
        this.levelingUpAttribute = levelingUpAttribute;
    }
    // endregion
}
