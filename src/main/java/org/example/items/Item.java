package org.example.items;

public abstract class Item {

    protected String Name;
    protected int RequiredLevel;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setRequiredLevel(int requiredLevel) {
        RequiredLevel = requiredLevel;
    }

    protected Slot slot;

    //Constructor for Item
    public Item(String name, int requiredLevel, Slot slot) {
        Name = name;
        RequiredLevel = requiredLevel;
        this.slot = slot;
    }

    //Getters n Setters
    public int getRequiredLevel() {
        return RequiredLevel;
    }
    public Slot getSlot() {
        return slot;
    }
    public void setSlot(Slot slot) {
        this.slot = slot;
    }
}
