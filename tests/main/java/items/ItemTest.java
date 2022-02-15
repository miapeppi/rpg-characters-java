package main.java.items;


import main.java.attributes.PrimaryAttribute;
import main.java.characters.Warrior;
import main.java.characters.items.Armor;
import main.java.characters.items.Item;
import main.java.characters.items.Weapon;
import main.java.characters.items.itemexceptions.InvalidArmorException;
import main.java.characters.items.itemexceptions.InvalidWeaponException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ItemTest {

    @Test
    public void equipItem_level1WarriorEquipsLevel2Axe_ShouldThrowInvalidWeaponException() {
        // Arrange
        String expected = "You are not worthy of this weapon (too high of a level requirement or wrong weapon type)";
        Warrior warrior = new Warrior("Boromir");
        Weapon axe = new Weapon("Common Axe", 2, Weapon.WeaponType.Axe);

        // Act & Assert
        Exception exception = assertThrows(InvalidWeaponException.class, () -> warrior.equipItem(axe));
        String actual = exception.getMessage();
        assertEquals(expected, actual);
    }

    @Test
    public void equipItem_level1WarriorEquipsLevel2ArmorPiece_ShouldThrowInvalidArmorException() {
        // Arrange
        String expected = "You are not worthy of this armor (too high of a level requirement or wrong armor type)";
        Warrior warrior = new Warrior("Boromir");
        Armor armor = new Armor("Common plate armor", 2, Armor.ArmorType.Plate, Item.Slot.Body);

        // Act & Assert
        Exception exception = assertThrows(InvalidArmorException.class, () -> warrior.equipItem(armor));
        String actual = exception.getMessage();
        assertEquals(expected, actual);
    }

    @Test
    public void equipItem_warriorEquipsBow_ShouldThrowInvalidWeaponException() {
        // Arrange
        String expected = "You are not worthy of this weapon (too high of a level requirement or wrong weapon type)";
        Warrior warrior = new Warrior("Boromir");
        Weapon bow = new Weapon("Common Bow", 1, Weapon.WeaponType.Bow);

        // Act & Assert
        Exception exception = assertThrows(InvalidWeaponException.class, () -> warrior.equipItem(bow));
        String actual = exception.getMessage();
        assertEquals(expected, actual);
    }

    @Test
    public void equipItem_warriorEquipsClothArmor_ShouldThrowInvalidArmorException() {
        // Arrange
        String expected = "You are not worthy of this armor (too high of a level requirement or wrong armor type)";
        Warrior warrior = new Warrior("Boromir");
        Armor armor = new Armor("Common cloth armor", 2, Armor.ArmorType.Cloth, Item.Slot.Body);

        // Act & Assert
        Exception exception = assertThrows(InvalidArmorException.class, () -> warrior.equipItem(armor));
        String actual = exception.getMessage();
        assertEquals(expected, actual);
    }

    @Test
    public void equipItem_level1WarriorEquipsLevel1Axe_ShouldReturnTrue() throws InvalidWeaponException {
        // Arrange
        boolean expected = true;
        Warrior warrior = new Warrior("Boromir");
        Weapon axe = new Weapon("Common Axe", 1, Weapon.WeaponType.Axe);

        // Act
        boolean actual = warrior.equipItem(axe);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void equipItem_level1WarriorEquipsLevel1PlateArmor_ShouldReturnTrue() throws InvalidArmorException {
        // Arrange
        boolean expected = true;
        Warrior warrior = new Warrior("Boromir");
        Armor armor = new Armor("Common plate armor", 1, Armor.ArmorType.Plate, Item.Slot.Body);

        // Act
        boolean actual = warrior.equipItem(armor);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getCharacterDPS_calculateDpsForLevel1Warrior_ShouldReturn105() {
        // Arrange
        double dps = 1.05; // (1 * (1 + 5/100))
        double expected = dps;

        // Act
        Warrior warrior = new Warrior("Boromir");
        double actual = warrior.getCharacterDps();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getCharacterDPS_calculateDpsForLevel1WarriorAndWeapon_ShouldReturn8085() throws InvalidWeaponException {
        // Arrange
        double dps = 8.085; //  (7 * 1.1) * (1 + (5 / 100))
        double expected = dps;

        // Act
        Warrior warrior = new Warrior("Boromir");
        Weapon axe = new Weapon("Common Axe", 1, Weapon.WeaponType.Axe, 7, 1.1);
        warrior.equipItem(axe);
        double actual = warrior.getCharacterDps();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getCharacterDPS_calculateDpsForLevel1WarriorWeaponAndArmor_ShouldReturn8162() throws InvalidWeaponException, InvalidArmorException {
        // Arrange
        double dps = 8.162; // (7 * 1.1) * (1 + ((5 + 1) / 100))
        double expected = dps;

        // Act
        Warrior warrior = new Warrior("Boromir");
        Weapon axe = new Weapon("Common Axe", 1, Weapon.WeaponType.Axe, 7, 1.1);
        Armor armor = new Armor("Common Plate Body Armor", 1, Armor.ArmorType.Plate, Item.Slot.Body, new PrimaryAttribute(1, 0, 0));
        warrior.equipItem(axe);
        warrior.equipItem(armor);
        double actual = warrior.getCharacterDps();

        // Assert
        assertEquals(expected, actual);
    }

}