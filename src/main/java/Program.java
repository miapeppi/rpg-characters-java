package main.java;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Hey, you. You're finally awake.");
        System.out.println("What's your name? ");
        String name = reader.nextLine();
        System.out.println("Tell me " + name + ", are you a Mage, a Ranger, a Rogue or a Warrior? ");
        String characterType = reader.nextLine();

        // Logic for character choosing

        System.out.println("A " + characterType + " you say, eh? Well let's have a look at your stats: ");
    }
}
