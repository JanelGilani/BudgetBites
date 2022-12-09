package entities;

public class FoodItem {
    public String itemName;
    public double itemCost;

    /**
     * Instantiating foodItem
     * @param itemName food item name
     * @param itemCost food item cost
     */
    public FoodItem(String itemName, double itemCost) {
        this.itemName = itemName;
        this.itemCost = itemCost;
    }


    public FoodItem() {

    }

    /**
     * Getter for item cost
     * @return return item cost as double
     */
    public double getItemCost () {
        return this.itemCost;
    }

    /**
     * Getter for item name
     * @return return item name as string
     */
    public String getItemName () {
        return this.itemName;
    }

    /**
     * Order creator
     */
    public void addToOrder (Order order) {
        order.addToOrder(this);
    }
}
