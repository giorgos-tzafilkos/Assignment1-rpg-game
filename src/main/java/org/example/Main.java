package org.example;
import org.example.heroes.HeroAttributes;
import org.example.customExceptions.InvalidArmorException;
import org.example.customExceptions.InvalidWeaponException;
import org.example.heroes.classes.Mage;
import org.example.items.*;

public class Main {
    public static void main(String[] args) throws InvalidArmorException, InvalidWeaponException {
        Mage Yann = new Mage("Yann");
        Yann.LevelUp();


        Weapon weapon = new Weapon("ThunderSword",1, WeaponType.Staff,4);
        Weapon weapon2 = new Weapon("ThunderSword2",1, WeaponType.Staff,3);
        Weapon weapon3 = new Weapon("ThunderSword2",1, WeaponType.Staff,100);
        Armor armor =new Armor("helmet",0, Slot.Head, ArmorType.Cloth,new HeroAttributes(3,2,3));
        Armor armor2 =new Armor("helmet",1, Slot.Head, ArmorType.Cloth,new HeroAttributes(4,1,4));
        Armor armor3 =new Armor("helmet",1, Slot.Head, ArmorType.Cloth,new HeroAttributes(4,1,4));


        Yann.Equip(armor);
        System.out.println(Yann.Display());

        Yann.Equip(armor2);
        //Yann.Equip(armor3);

        System.out.println(Yann.Display());
        System.out.println(Yann.getLevelAttributes());

    }
}