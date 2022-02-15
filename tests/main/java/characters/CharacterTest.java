package main.java.characters;

import main.java.attributes.PrimaryAttribute;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {

    @Test
    public void ConstructorMage_InitializeMage_ShouldCreateLevel1Mage() {
        // Arrange
        int startingLevel = 1;
        int expected = startingLevel;

        // Act
        Mage mage = new Mage("Gandalf");
        int actual = mage.getCharacterLevel();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void LevelUpMage_MageGainsLevel_ShouldLevelUpToLevel2() {
        // Arrange
        int leveledUplevel = 2;
        int expected = leveledUplevel;

        // Act
        Mage mage = new Mage("Gandalf");
        mage.levelUp();
        int actual = mage.getCharacterLevel();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void ConstructorMage_InitializeMage_ShouldCreateMageWithStrength1Dexterity1Intelligence8() {
        // Arrange
        int expectedStrength = 1;
        int expectedDexterity = 1;
        int expectedIntelligence = 8;

        // Act
        Mage mage = new Mage("Gandalf");
        PrimaryAttribute actual = mage.getTotalPrimaryAttribute();
        int actualStrength = actual.getStrength();
        int actualDexterity = actual.getDexterity();
        int actualIntelligence = actual.getIntelligence();

        // Assert
        assertEquals(expectedStrength, actualStrength);
        assertEquals(expectedDexterity, actualDexterity);
        assertEquals(expectedIntelligence, actualIntelligence);
    }

    @Test
    public void ConstructorRanger_InitializeRanger_ShouldCreateRangerWithStrength1Dexterity7Intelligence1() {
        // Arrange
        int expectedStrength = 1;
        int expectedDexterity = 7;
        int expectedIntelligence = 1;

        // Act
        Ranger ranger = new Ranger("Legolas");
        PrimaryAttribute actual = ranger.getTotalPrimaryAttribute();
        int actualStrength = actual.getStrength();
        int actualDexterity = actual.getDexterity();
        int actualIntelligence = actual.getIntelligence();

        // Assert
        assertEquals(expectedStrength, actualStrength);
        assertEquals(expectedDexterity, actualDexterity);
        assertEquals(expectedIntelligence, actualIntelligence);
    }

    @Test
    public void ConstructorRogue_InitializeRogue_ShouldCreateRogueWithStrength2Dexterity6Intelligence1() {
        // Arrange
        int expectedStrength = 2;
        int expectedDexterity = 6;
        int expectedIntelligence = 1;

        // Act
        Rogue rogue = new Rogue("Aragorn");
        PrimaryAttribute actual = rogue.getTotalPrimaryAttribute();
        int actualStrength = actual.getStrength();
        int actualDexterity = actual.getDexterity();
        int actualIntelligence = actual.getIntelligence();

        // Assert
        assertEquals(expectedStrength, actualStrength);
        assertEquals(expectedDexterity, actualDexterity);
        assertEquals(expectedIntelligence, actualIntelligence);
    }

    @Test
    public void ConstructorWarrior_InitializeWarrior_ShouldCreateWarriorWithStrength5Dexterity2Intelligence1() {
        // Arrange
        int expectedStrength = 5;
        int expectedDexterity = 2;
        int expectedIntelligence = 1;

        // Act
        Warrior warrior = new Warrior("Boromir");
        PrimaryAttribute actual = warrior.getTotalPrimaryAttribute();
        int actualStrength = actual.getStrength();
        int actualDexterity = actual.getDexterity();
        int actualIntelligence = actual.getIntelligence();

        // Assert
        assertEquals(expectedStrength, actualStrength);
        assertEquals(expectedDexterity, actualDexterity);
        assertEquals(expectedIntelligence, actualIntelligence);
    }

    @Test
    public void LevelUpMage_MageGainsLevel_ShouldHaveMageWithStrength2Dexterity2Intelligence13() {
        // Arrange
        int expectedStrength = 2;
        int expectedDexterity = 2;
        int expectedIntelligence = 13;

        // Act
        Mage mage = new Mage("Gandalf");
        mage.levelUp();
        PrimaryAttribute actual = mage.getTotalPrimaryAttribute();
        int actualStrength = actual.getStrength();
        int actualDexterity = actual.getDexterity();
        int actualIntelligence = actual.getIntelligence();

        // Assert
        assertEquals(expectedStrength, actualStrength);
        assertEquals(expectedDexterity, actualDexterity);
        assertEquals(expectedIntelligence, actualIntelligence);
    }


    @Test
    public void LevelUpRanger_RangerGainsLevel_ShouldHaveRangerWithStrength2Dexterity12Intelligence2() {
        // Arrange
        int expectedStrength = 2;
        int expectedDexterity = 12;
        int expectedIntelligence = 2;

        // Act
        Ranger ranger = new Ranger("Legolas");
        ranger.levelUp();
        PrimaryAttribute actual = ranger.getTotalPrimaryAttribute();
        int actualStrength = actual.getStrength();
        int actualDexterity = actual.getDexterity();
        int actualIntelligence = actual.getIntelligence();

        // Assert
        assertEquals(expectedStrength, actualStrength);
        assertEquals(expectedDexterity, actualDexterity);
        assertEquals(expectedIntelligence, actualIntelligence);
    }

    @Test
    public void LevelUpRogue_RogueGainsLevel_ShouldHaveRogueWithStrength3Dexterity10Intelligence2() {
        // Arrange
        int expectedStrength = 3;
        int expectedDexterity = 10;
        int expectedIntelligence = 2;

        // Act
        Rogue rogue = new Rogue("Aragorn");
        rogue.levelUp();
        PrimaryAttribute actual = rogue.getTotalPrimaryAttribute();
        int actualStrength = actual.getStrength();
        int actualDexterity = actual.getDexterity();
        int actualIntelligence = actual.getIntelligence();

        // Assert
        assertEquals(expectedStrength, actualStrength);
        assertEquals(expectedDexterity, actualDexterity);
        assertEquals(expectedIntelligence, actualIntelligence);
    }

    @Test
    public void LevelUpWarrior_WarriorGainsLevel_ShouldHaveWarriorWithStrength8Dexterity4Intelligence2() {
        // Arrange
        int expectedStrength = 8;
        int expectedDexterity = 4;
        int expectedIntelligence = 2;

        // Act
        Warrior warrior = new Warrior("Boromir");
        warrior.levelUp();
        PrimaryAttribute actual = warrior.getTotalPrimaryAttribute();
        int actualStrength = actual.getStrength();
        int actualDexterity = actual.getDexterity();
        int actualIntelligence = actual.getIntelligence();

        // Assert
        assertEquals(expectedStrength, actualStrength);
        assertEquals(expectedDexterity, actualDexterity);
        assertEquals(expectedIntelligence, actualIntelligence);
    }
}