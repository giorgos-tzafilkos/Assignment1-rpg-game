package org.example.heroes.classes;

import org.example.customExceptions.InvalidArmorException;
import org.example.heroes.Hero;
import org.example.heroes.HeroAttributes;
import org.example.items.Armor;
import org.example.items.ArmorType;
import org.example.items.Slot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RangerTest {

    Hero Ranger = new Ranger("Krurrec");
    Armor armor = new Armor("Common Leather",1, Slot.Body, ArmorType.Leather,new HeroAttributes(1,1,0));
    Armor armor2 = new Armor("Common Mail",1,Slot.Legs, ArmorType.Mail,new HeroAttributes(2,1,0));

    @Test
    void MageCreated(){
        assertEquals("Krurrec",Ranger.getName());
        assertEquals(1,Ranger.getLevelAttributes().getStrength());
        assertEquals(7,Ranger.getLevelAttributes().getDexterity());
        assertEquals(1,Ranger.getLevelAttributes().getIntelligence());
        assertEquals(1,Ranger.getLevel());
    }

    @Test
    void testAttributesWithArmor() throws InvalidArmorException {
        Ranger.Equip(armor);
        Ranger.Equip(armor2);

        assertEquals(1+1+2,Ranger.getLevelAttributes().getStrength());
        assertEquals(7+1+1,Ranger.getLevelAttributes().getDexterity());
        assertEquals(1+0+0,Ranger.getLevelAttributes().getIntelligence());
    }

}