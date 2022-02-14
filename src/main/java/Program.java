package main.java;

import java.util.Scanner;
import main.java.characters.Mage;
import main.java.items.Armor;
import main.java.items.Item;
import main.java.items.Weapon;
import main.java.items.itemexceptions.InvalidArmorException;

public class Program {
    public static void main(String[] args) throws InvalidArmorException {
        Scanner reader = new Scanner(System.in);
        System.out.println("Hey, you. You're finally awake.");
        System.out.println("What's your name? ");
        String name = reader.nextLine();
        System.out.println("Tell me " + name + ", are you a Mage, a Ranger, a Rogue or a Warrior? ");
        String characterType = reader.nextLine();

        Mage mage = new Mage(name);

        // Logic for character choosing
        // if(characterType.equalsIgnoreCase("mage")) {
        //    System.out.println("Mage it is.");
        //    Mage mage = new Mage();
        //    mage.mageHello();
        //    mage.printCharacterStats();
        //} else if(characterType.equalsIgnoreCase("ranger")) {
        //    System.out.println("Ranger it is.");
        //} else if(characterType.equalsIgnoreCase("rogue")) {
        //    System.out.println("Rogue it is.");
        //} else if(characterType.equalsIgnoreCase("warrior")) {
        //    System.out.println("warrior it is.");
        //}

        System.out.println("A " + characterType + " you say, eh? Well let's have a look at your stats: ");
        mage.printCharacterStats();

        mage.levelUp();
        mage.levelUp(2);
        Weapon superStaff = new Weapon("Super staff", 23, Weapon.WeaponType.Staff, 3, 4.5);
        Armor superCloth = new Armor("Super cloth", 2, Armor.ArmorType.Plate, Item.Slot.Body);
        mage.equipItem(superCloth);

        mage.printCharacterStats();
    }
}
