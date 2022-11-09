package Entities;

public class foodItem {
    public String itemName;
    public double itemCost;

    public foodItem (String itemName, double itemCost) {
        this.itemName = itemName;
        this.itemCost = itemCost;
    }

    public double getItemCost () {
        return this.itemCost;
    }

    public String getItemName () {
        return this.itemName;
    }
}
