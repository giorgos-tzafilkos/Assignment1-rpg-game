package org.example.heroes;
import org.example.customExceptions.InvalidArmorException;
import org.example.customExceptions.InvalidWeaponException;
import org.example.items.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Hero {

    private String Name;
    private int Level;
    private HeroAttributes levelAttributes;
    private Map<Slot, Item> Equipment;
    private List<WeaponType> ValidWeaponTypes =new ArrayList<>();
    private List<ArmorType> ValidArmorType =new ArrayList<>();;

    //Constructor only with name --
    public Hero(String name) {
        this.Name = name;
        this.Level =1;
        this.Equipment = new HashMap<>();
        for (Slot slot : Slot.values()) {       //Initialize the equipment map to have 4 keys(No of slots
            Equipment.put(slot, null);         // with null values
        }
    }

    public String Display(){                            //String Builder for the display
       StringBuilder infoHero = new StringBuilder();
       infoHero.append("Name: "+getName());
       infoHero.append("\nClass: " +getClassName());
       infoHero.append("\nLevel: " +getLevel());
       infoHero.append("\nStrength: " +levelAttributes.getStrength());
       infoHero.append("\nIntelligent: " +levelAttributes.getIntelligence());
       infoHero.append("\nDexterity: " +levelAttributes.getDexterity());
       infoHero.append("\nDamage: " +Damage());
       return String.valueOf(infoHero);
    }

    //Equip method for all classes ..weapons only
    public void Equip(Weapon weapon) throws InvalidWeaponException {
        if(!ValidWeaponTypes.contains(weapon.getWeaponType())){throw new InvalidWeaponException("You can not equip this Weapon!. It is for as different class ");}
            else if(weapon.getRequiredLevel()>getLevel()){throw new InvalidWeaponException("You can not equip this weapon! Greater level required..");}
                else {
                    Equipment.put(weapon.getSlot(),weapon);}}

    //Overload method for equip ..armor only
    public void Equip(Armor armor) throws InvalidArmorException {

        if(!ValidArmorType.contains(armor.getArmorType())){throw new InvalidArmorException("Your class can not equip this Armor!");}
            else if(armor.getRequiredLevel()>getLevel()){throw new InvalidArmorException("You can not equip this Armor! Greater level required..");}
                else{

                    int previousAddedDext =0;                                      //Initialize to 0 attributes from already equipped armor in the same slot(if any)
                    int previousAddedStre =0;
                    int previousAddedIntel =0;
                    if(getEquipment().get(armor.getSlot())!=null){                               //Check if there is already object in the slot of the armor we want to add
                        Armor previousArmor = (Armor) getEquipment().get(armor.getSlot());      //if there is we set the previous added attributes
                        previousAddedDext = previousArmor.getArmorAttribute().getDexterity();
                        previousAddedIntel = previousArmor.getArmorAttribute().getIntelligence();
                        previousAddedStre = previousArmor.getArmorAttribute().getStrength();
                    }


                    Equipment.put(armor.getSlot(),armor);
                    levelAttributes.setStrength(levelAttributes.getStrength()+                                // in order to increase hero's attributes from equipment
                    +armor.getArmorAttribute().getStrength()- previousAddedStre);                            // we take the current attributes of the hero and increase them
                     levelAttributes.setIntelligence(levelAttributes.getIntelligence()+                     // according to the equipment also remove previous added attributes from
                    +armor.getArmorAttribute().getIntelligence() - previousAddedIntel);                    // replaced armor
                     levelAttributes.setDexterity(levelAttributes.getDexterity()+
                    +armor.getArmorAttribute().getDexterity() - previousAddedDext);}
    }



    //Abstract methods for all heroes
    public abstract void LevelUp();
    protected abstract String getClassName(); // we will use this method in Display() to get each character class
    public abstract double Damage();




    //Getters n Setters
    public String getName() {
        return Name;
    }
    public int getLevel() {
        return Level;
    }
    public void setLevel(int level) {
        Level = level;
    }
    public HeroAttributes getLevelAttributes() {
        return levelAttributes;
    }
    public void setLevelAttributes(HeroAttributes levelAttributes) {
        this.levelAttributes = levelAttributes;
    }
    public Map<Slot, Item> getEquipment() {
        return Equipment;
    }
    public void setValidWeaponTypes(List<WeaponType> validWeaponTypes) {
        ValidWeaponTypes = validWeaponTypes;
    }
    public void setValidArmorType(List<ArmorType> validArmorType) {
        ValidArmorType = validArmorType;
    }
}
