package org.example.items;

import org.example.heroes.HeroAttributes;

public class Armor extends Item {

    private ArmorType ArmorType;
    private HeroAttributes ArmorAttribute;


    public Armor(String name, int requiredLevel, Slot slot, ArmorType ArmorType, HeroAttributes ArmorAttribute) {
        super(name, requiredLevel, slot);
        this.ArmorType=ArmorType;
        this.ArmorAttribute = ArmorAttribute;
    }


    //Getters n Setters
    public org.example.items.ArmorType getArmorType() {
        return ArmorType;
    }

    public void setArmorType(org.example.items.ArmorType armorType) {
        ArmorType = armorType;
    }

    public HeroAttributes getArmorAttribute() {
        return ArmorAttribute;
    }

    public void setArmorAttribute(HeroAttributes armorAttribute) {
        ArmorAttribute = armorAttribute;
    }
}
