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

public class Ranger extends Hero {
    //Initialize values for Ranger
    private HeroAttributes RangerAttributes = new HeroAttributes(1, 7, 1);
    private List<WeaponType> ValidWeaponTypesForRanger = new ArrayList<>(Arrays.asList(WeaponType.Bow));                        //Initialize with valid weapons for Ranger
    private List<ArmorType> ValidArmorTypesForRanger = new ArrayList<>(Arrays.asList(ArmorType.Leather,ArmorType.Mail));       //Initialize with valid armor for Ranger


    //Constructor for Ranger
    public Ranger(String name) {
        super(name);
        setLevelAttributes(RangerAttributes);             //setting level 1 hero attributes
        setValidArmorType(ValidArmorTypesForRanger);     //valid armor types
        setValidWeaponTypes(ValidWeaponTypesForRanger); //valid weapon types
    }
    @Override  // Get Class Name for Ranger
    protected String getClassName() {
        return "Ranger";
    }
    @Override
    public double Damage() {
        float weaponDamage =0;
        Weapon weaponEquipped = (Weapon) getEquipment().get(Slot.Weapon);      //In order to calculate the hero damage we need first to get the weapon damage of the hero
        //(if there is no weapon)                                             //The damage of the weapon
        if(weaponEquipped == null){weaponDamage=1;}
        else{weaponDamage = weaponEquipped.getWeaponDamage();}
        float DamagingAttribute = getLevelAttributes().getDexterity();      //For Ranger DamagingAttribute is it's Dexterity
        DecimalFormat df = new DecimalFormat("##.##");
        return Double.parseDouble(df.format(weaponDamage * (1 + DamagingAttribute / 100))); // for 2 decimals
    }
    @Override
    public void LevelUp() {                                          //Leveling up for Ranger
        setLevel(getLevel() + 1);
        RangerAttributes.setStrength(RangerAttributes.getStrength() + 1);
        RangerAttributes.setDexterity(RangerAttributes.getDexterity() + 5);
        RangerAttributes.setIntelligence(RangerAttributes.getIntelligence() + 1);
    }
}

