package org.example.heroes.classes;

import org.example.heroes.Hero;
import org.example.heroes.HeroAttributes;
import org.example.items.ArmorType;
import org.example.items.Slot;
import org.example.items.Weapon;
import org.example.items.WeaponType;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mage extends Hero {
    //Initialize values for Mage
    private HeroAttributes MageAttributes = new HeroAttributes(1, 1, 8);
    private List<WeaponType> ValidWeaponTypesForMage = new ArrayList<>(Arrays.asList(WeaponType.Staff, WeaponType.Wand)); //Initialize with valid weapons for Mage
    private List<ArmorType> ValidArmorTypesForMage = new ArrayList<>(Arrays.asList(ArmorType.Cloth));                   //Initialize with valid armor for Mage


    //Constructor for Mage
    public Mage(String name) {
        super(name);
        setLevelAttributes(MageAttributes);             //setting level 1 hero attributes
        setValidArmorType(ValidArmorTypesForMage);     //valid armor types
        setValidWeaponTypes(ValidWeaponTypesForMage); //valid weapon types
    }
    @Override  // Get Class Name for Mage
    protected String getClassName() {
        return "Mage";
    }
    @Override
    public double Damage() {
        float weaponDamage =0;
        Weapon weaponEquipped = (Weapon) getEquipment().get(Slot.Weapon);      //In order to calculate the hero damage we need first to get the weapon damage
        //(if there is no weapon)                                             //The damage of the weapon
        if(weaponEquipped == null){weaponDamage=1;}
        else{weaponDamage = weaponEquipped.getWeaponDamage();}
        float DamagingAttribute = getLevelAttributes().getIntelligence();   //For mage DamagingAttribute is it's intelligence
        DecimalFormat df = new DecimalFormat("##.##");                                        //for 2 decimals
        return Double.parseDouble(df.format(weaponDamage * (1 + DamagingAttribute / 100))); // for 2 decimals
    }
    @Override
    public void LevelUp() {                                          //Leveling up for Mage
        setLevel(getLevel() + 1);
        MageAttributes.setStrength(MageAttributes.getStrength() + 1);
        MageAttributes.setDexterity(MageAttributes.getDexterity() + 1);
        MageAttributes.setIntelligence(MageAttributes.getIntelligence() + 5);
    }
}

