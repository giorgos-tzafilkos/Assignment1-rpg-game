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


public class Warrior extends Hero {
    //Initialize values for Warrior
    private HeroAttributes WarriorAttributes = new HeroAttributes(5, 2, 1);
    private List<WeaponType> ValidWeaponTypesForWarrior = new ArrayList<>(Arrays.asList(WeaponType.Dagger,WeaponType.Sword)); //Initialize with valid weapons for Warrior
    private List<ArmorType> ValidArmorTypesForWarrior = new ArrayList<>(Arrays.asList(ArmorType.Leather,ArmorType.Mail));     //Initialize with valid armor for Warrior


    //Constructor for Warrior
    public Warrior(String name) {
        super(name);
        setLevelAttributes(WarriorAttributes);             //setting level 1 hero attributes
        setValidArmorType(ValidArmorTypesForWarrior);     //valid armor types
        setValidWeaponTypes(ValidWeaponTypesForWarrior); //valid weapon types
    }
    @Override  // Get Class Name for Warrior
    protected String getClassName() {
        return "Warrior";
    }
    @Override
    public double Damage() {
        float weaponDamage =0;
        Weapon weaponEquipped = (Weapon) getEquipment().get(Slot.Weapon);      //In order to calculate the hero damage we need first to get the weapon damage of the hero
        //(if there is no weapon)                                             //The damage of the weapon
        if(weaponEquipped == null){weaponDamage=1;}
        else{weaponDamage = weaponEquipped.getWeaponDamage();}
        float DamagingAttribute = getLevelAttributes().getStrength();      //For Warrior DamagingAttribute is it's Strength
        DecimalFormat df = new DecimalFormat("##.##");
        return Double.parseDouble(df.format(weaponDamage * (1 + DamagingAttribute / 100))); // for 2 decimals
    }
    @Override
    public void LevelUp() {                                          //Leveling up for Warrior
        setLevel(getLevel() + 1);
        WarriorAttributes.setStrength(WarriorAttributes.getStrength() + 3);
        WarriorAttributes.setDexterity(WarriorAttributes.getDexterity() + 2);
        WarriorAttributes.setIntelligence(WarriorAttributes.getIntelligence() + 1);
    }
}

