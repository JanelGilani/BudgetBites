package entities;

public class FoodItem {
    public String itemName;
    public double itemCost;

    public FoodItem(String itemName, double itemCost) {
        this.itemName = itemName;
        this.itemCost = itemCost;
    }

    public FoodItem() {

    }

    public double getItemCost () {
        return this.itemCost;
    }

    public String getItemName () {
        return this.itemName;
    }

    public void addToOrder (Order order) {
        order.addToOrder(this);
    }
}
