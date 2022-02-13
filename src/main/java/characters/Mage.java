package main.java.characters;

import main.java.attributes.PrimaryAttribute;

public class Mage extends Character {
    private PrimaryAttribute levelingUpAttributes;

    public Mage(String name) {
        super(name, new PrimaryAttribute(1, 1, 8));
    }

}
