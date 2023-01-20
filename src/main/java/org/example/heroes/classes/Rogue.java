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

public class Rogue extends Hero {
    //Initialize values for Rogue
    private HeroAttributes RogueAttributes = new HeroAttributes(2, 6, 1);
    private List<WeaponType> ValidWeaponTypesForRogue = new ArrayList<>(Arrays.asList(WeaponType.Dagger,WeaponType.Sword)); //Initialize with valid weapons for Rogue
    private List<ArmorType> ValidArmorTypesForRogue = new ArrayList<>(Arrays.asList(ArmorType.Leather,ArmorType.Mail));     //Initialize with valid armor for Rogue


    //Constructor for Rogue
    public Rogue(String name) {
        super(name);
        setLevelAttributes(RogueAttributes);             //setting level 1 hero attributes
        setValidArmorType(ValidArmorTypesForRogue);     //valid armor types
        setValidWeaponTypes(ValidWeaponTypesForRogue); //valid weapon types
    }
    @Override  // Get Class Name for Mage
    protected String getClassName() {
        return "Rogue";
    }
    @Override
    public double Damage() {
        float weaponDamage =0;
        Weapon weaponEquipped = (Weapon) getEquipment().get(Slot.Weapon);      //In order to calculate the hero damage we need first to get the weapon damage of the hero
        //(if there is no weapon)                                             //The damage of the weapon
        if(weaponEquipped == null){weaponDamage=1;}
        else{weaponDamage = weaponEquipped.getWeaponDamage();}
        float DamagingAttribute = getLevelAttributes().getDexterity();      //For Rogue DamagingAttribute is it's intelligence
        DecimalFormat df = new DecimalFormat("##.##");
        return Double.parseDouble(df.format(weaponDamage * (1 + DamagingAttribute / 100))); // for 2 decimals
    }
    @Override
    public void LevelUp() {                                          //Leveling up for Rogue
        setLevel(getLevel() + 1);
        RogueAttributes.setStrength(RogueAttributes.getStrength() + 1);
        RogueAttributes.setDexterity(RogueAttributes.getDexterity() + 4);
        RogueAttributes.setIntelligence(RogueAttributes.getIntelligence() + 1);
    }
}

