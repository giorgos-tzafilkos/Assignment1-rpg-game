package org.example.items;

import org.example.heroes.HeroAttributes;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArmorTest {

    @Test
    void ArmorCreation(){
        Armor armor = new Armor("Common PLate Chest",1,Slot.Body,ArmorType.Plate,new HeroAttributes(1,0,0));
        assertEquals("Common PLate Chest",armor.getName());
        assertEquals(1,armor.getRequiredLevel());
        assertEquals(Slot.Body,armor.getSlot());
        assertEquals(ArmorType.Plate,armor.getArmorType());
        assertEquals(1,armor.getArmorAttribute().getStrength());
        assertEquals(0,armor.getArmorAttribute().getDexterity());
        assertEquals(0,armor.getArmorAttribute().getIntelligence());

    }

}