package org.example.items;

public class Weapon extends Item{
    private WeaponType weaponType;
    private int WeaponDamage;

    //Constructor for Weapon
    public Weapon(String name, int requiredLevel,WeaponType weaponType, int weaponDamage ) {
        super(name, requiredLevel, Slot.Weapon); //weapons will always be in Slot.weapon
        this.weaponType=weaponType;
        this.WeaponDamage=weaponDamage;
    }


    //Getters n Setters
    public WeaponType getWeaponType() {
        return weaponType;
    }
    public int getWeaponDamage() {
        return WeaponDamage;
    }



}
