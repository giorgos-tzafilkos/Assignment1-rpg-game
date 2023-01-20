package org.example.heroes.classes;

import org.example.customExceptions.InvalidArmorException;
import org.example.customExceptions.InvalidWeaponException;
import org.example.heroes.HeroAttributes;
import org.example.items.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MageTest {
    Mage Merlin = new Mage("Merlin");
    Weapon weapon = new Weapon("CommonStaff",1, WeaponType.Staff,2);
    Weapon weapon2 = new Weapon("RareStaff",1, WeaponType.Staff,5);
    Armor armor = new Armor("Common Cloth",1,Slot.Body, ArmorType.Cloth,new HeroAttributes(0,1,0));
    Armor armor2 = new Armor("Rare Cloth",1,Slot.Body, ArmorType.Cloth,new HeroAttributes(1,2,0));
    Armor armor3 = new Armor("Magic Cloth",4,Slot.Body, ArmorType.Cloth,new HeroAttributes(2,4,2));
    Armor armor4 = new Armor("Simple Helmet",1,Slot.Head, ArmorType.Leather,new HeroAttributes(2,0,0));

    @Test
    void MageCreated(){
        assertEquals("Merlin",Merlin.getName());
        assertEquals(1,Merlin.getLevelAttributes().getStrength());
        assertEquals(1,Merlin.getLevelAttributes().getDexterity());
        assertEquals(8,Merlin.getLevelAttributes().getIntelligence());
        assertEquals(1,Merlin.getLevel());
    }

    @Test
    void levelUp() {
        Mage Merlin = new Mage("Merlin");
        Merlin.LevelUp();
        assertEquals(2,Merlin.getLevel());
        assertEquals(2,Merlin.getLevelAttributes().getStrength());
        assertEquals(2,Merlin.getLevelAttributes().getDexterity());
        assertEquals(13,Merlin.getLevelAttributes().getIntelligence());
    }

    @Test
    void equipWeapon() throws InvalidWeaponException {
        Mage Merlin = new Mage("Merlin");
        Merlin.Equip(weapon);
        assertEquals("CommonStaff",Merlin.getEquipment().get(Slot.Weapon).getName());
    }
    @Test
    void equipArmor() throws InvalidArmorException {
        Merlin.Equip(armor);
        assertEquals("Common Cloth",Merlin.getEquipment().get(Slot.Body).getName());
    }

    @Test
    void testDamageNoWeapon() {
        assertEquals(1.08,Merlin.Damage());
    }

    @Test
    void testDamageWeapon() throws InvalidWeaponException {
        Merlin.Equip(weapon);
        assertEquals(2.16,Merlin.Damage());
    }
    @Test
    void testDamageWeaponChange() throws InvalidWeaponException {
        Merlin.Equip(weapon);
        Merlin.Equip(weapon2);
        assertEquals(5.4,Merlin.Damage());
    }

    @Test
    void testDamageWeaponAndArmor() throws InvalidWeaponException, InvalidArmorException {
        Merlin.Equip(weapon);
        Merlin.Equip(armor);
        assertEquals(2.16,Merlin.Damage());
    }

    @Test
    void testAttributesWithArmor() throws InvalidArmorException {
        Merlin.Equip(armor);
        assertEquals(1,Merlin.getLevelAttributes().getStrength());
        assertEquals(2,Merlin.getLevelAttributes().getDexterity());
        assertEquals(8,Merlin.getLevelAttributes().getIntelligence());
    }

    @Test
    void testAttributesWithReplacedArmorInSameSlot() throws InvalidArmorException {
        Merlin.Equip(armor);
        Merlin.Equip(armor2);
        assertEquals(2,Merlin.getLevelAttributes().getStrength());
        assertEquals(3,Merlin.getLevelAttributes().getDexterity());
        assertEquals(8,Merlin.getLevelAttributes().getIntelligence());
    }

    @Test
    void testDisplay(){
        String excepted = "Name: Merlin\n" +
                "Class: Mage\n" +
                "Level: 1\n" +
                "Strength: 1\n" +
                "Intelligent: 8\n" +
                "Dexterity: 1\n" +
                "Damage: 1.08";
        assertEquals(excepted,Merlin.Display());
    }

    @Test
    void invalidArmorLevel() throws InvalidArmorException {

        try {
            Merlin.Equip(armor3);
            Assertions.fail("Expected Invalid Armor exception");
        } catch (InvalidArmorException e) {
            Assertions.assertEquals("You can not equip this Armor! Greater level required..", e.getMessage());
        }
    }


    @Test
    void invalidArmorType() throws InvalidArmorException {

        try {
            Merlin.Equip(armor4);
            Assertions.fail("Expected Invalid Armor exception");
        } catch (InvalidArmorException e) {
            Assertions.assertEquals("Your class can not equip this Armor!", e.getMessage());
        }
    }




}