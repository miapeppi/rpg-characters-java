package main.java.characters;

import main.java.attributes.PrimaryAttribute;
import main.java.items.Armor;
import main.java.items.Armor.ArmorType;
import main.java.items.Item;
import main.java.items.Weapon;
import main.java.items.itemexceptions.InvalidArmorException;
import main.java.items.itemexceptions.InvalidWeaponException;

public class Mage extends Character {
    private PrimaryAttribute levelingUpAttribute;
    private double damageAttribute = getTotalPrimaryAttribute().getIntelligence(); // Mages damage attribute is intelligence

    /** Overloaded constructor creating a hero with name. Passing the level 1 primary attribute statistic and value of the damage attribute.
     * Also setting the levelUpAttribute, with values that character gains when leveling up. */
    public Mage(String name) {
        super(name, new PrimaryAttribute(1, 1, 8));
        setLevelingUpAttribute(new PrimaryAttribute(1, 1, 5));
    }

    @Override
    public void levelUp() {
        setCharacterLevel(getCharacterLevel() + 1);
        setBasePrimaryAttribute(getBasePrimaryAttribute().attributeLevelUp(getLevelingUpAttribute()));
        setTotalPrimaryAttribute(getTotalPrimaryAttribute().attributeLevelUp(getLevelingUpAttribute()));
        // DPS
        System.out.println("You leveled up!");
    }

    @Override
    public void levelUp(int levels) {
        if(levels > 0) { // Checking that the amount of levels is more than zero
            setCharacterLevel(getCharacterLevel() + levels);
            setBasePrimaryAttribute(getBasePrimaryAttribute().attributeLevelUp(getLevelingUpAttribute(), levels));
            setTotalPrimaryAttribute(getTotalPrimaryAttribute().attributeLevelUp(getLevelingUpAttribute(), levels));
            // DPS
            System.out.println("You leveled up " + levels + " levels!");
        } else { // If the level is zero or negative exception will be thrown

            // throw exception "Can't level up 0 or fewer levels."
        }
    }

    @Override
    public void equipItem(Armor armor) throws InvalidArmorException {
        if(armor.checkItemLevel(getCharacterLevel())) { // Checking that the armor is not too high level
            if(armor.getArmorType().equals(ArmorType.Cloth)) { // Checking that the armor is correct type
                if(!armor.getEquippingSlot().equals(Item.Slot.Weapon)) { // Checking that the armor is not equipped in weapon slot
                    //
                    System.out.println(armor.getItemName() + " is now equipped at " + armor.getEquippingSlot());
                } else {
                    throw new InvalidArmorException("You can't equip armor to weapon slot");
                }
            } else {
                throw new InvalidArmorException("Shame on you, you can't wear that! (wrong armor type)");
            }
        } else {
            throw new InvalidArmorException("You are not yet worthy of this armor (too high of a level requirement)");
        }
    }

    @Override
    public void equipItem(Weapon weapon) throws InvalidWeaponException {
        if(weapon.checkItemLevel(getCharacterLevel())) {

        } else {
            throw new InvalidWeaponException("You are not yet worthy of this weapon (Too high of a level requirement)");
        }
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
