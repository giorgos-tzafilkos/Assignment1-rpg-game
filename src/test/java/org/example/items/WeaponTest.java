package org.example.items;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeaponTest {

    @Test
    void WeaponCreated(){
        Weapon weapon = new Weapon("CommonAxe",1,WeaponType.Axe,2);
        assertEquals(2,weapon.getWeaponDamage());
        assertEquals(1,weapon.getRequiredLevel());
        assertEquals("CommonAxe",weapon.getName());
        assertEquals(2,weapon.getWeaponDamage());
        assertEquals(Slot.Weapon,weapon.getSlot());

    }

}