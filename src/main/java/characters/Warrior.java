package main.java.characters;

import main.java.attributes.PrimaryAttribute;
import main.java.items.Armor;
import main.java.items.Weapon;
import main.java.items.itemexceptions.InvalidArmorException;
import main.java.items.itemexceptions.InvalidWeaponException;

public class Warrior extends Character {

    /**
     * Overloaded constructor for creating a new character with a name, starting attributes and dictionary for equipments
     *
     * @param name
     * @param startAttributes
     */
    public Warrior(String name, PrimaryAttribute startAttributes) {
        super(name, startAttributes);
    }

    @Override
    public void levelUp() {

    }

    @Override
    public void levelUp(int levels) {

    }

    @Override
    public void equipItem(Armor armor) throws InvalidArmorException {

    }

    @Override
    public void equipItem(Weapon weapon) throws InvalidWeaponException {

    }
}
