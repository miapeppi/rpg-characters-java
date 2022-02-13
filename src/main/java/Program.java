package main.java;

import java.util.Scanner;
import main.java.characters.Mage;

public class Program {
    public static void main(String[] args) {
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
        mage.levelUp();

        mage.printCharacterStats();
    }
}
