# Assignment1-rpg-game
# Overview

This  application represents some functions and structures of an RPG game(based in Diablo3). 
The program offers the ability to create Heroes of different classes. Εach class has its unique attributes. Also you can create items(weapons and armor) and equip heroes with them adding values to their attributes and damage.

## Hero Classes
There are four Hero classes available to create with their own unique attributes. When a hero is created starts at level 1

### Mage
Initial attributes:
Strength:1	Dexterity:1	Intelligence:8

### Ranger
Initial attributes:
Strength:1	Dexterity:1	Intelligence:8

### Rogue
Initial attributes:
Strength:1	Dexterity:1	Intelligence:8

### Warrior
Initial attributes:
Strength:1	Dexterity:1	Intelligence:8


## Items
You can create either armor or weapons

### Armor
There are four types of armor(Cloth, Leather, Mail, Plate). 
Each Hero class can equip only some types of armor.
Armor increases Heroes Attributes.
Each armor is stored in one of three slots(Head Body Leg).
Heroes can carry only one armor in each slot.
All armor have a required Hero level to be equipped.

### Weapon
There are seven types of weapons(Axes, Bows, Daggers, Hammers, Staffs, Swords, Wands). 
Each Hero class can equip only some types of weapons.
Weapon increases Heroes Damage.
Each weapon is stored in one weapon slot.
A hero can only carry on weapon
All weapons have a required Hero level to be equipped.

## Functions

### LevelUp()
Increases hero’s level by 1. Also increases the hero's attributes. 
Each Hero class has different attributes increased by leveling up

### Equip()
Equip hero with armor or weapon

### Damage()
Hero damage = WeaponDamage * (1 + DamagingAttribute/100)
DamagingAttribute for
Mage: intelligence
Ranger: dexterity
Rogue: dexterity
Warrior: strength

### Display()
Displays Hero’s name, class, attributes, level, and damage
