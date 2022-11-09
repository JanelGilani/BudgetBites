package Entities;

public class Order {
    private foodItem[] orderedItems;
    private String dateOrdered;
    private double totalCost;

    public Order (foodItem[] orderedItems, String dateOrdered) {
        this.orderedItems = orderedItems;
        this.dateOrdered = dateOrdered;
        this.totalCost = 0;

        for (foodItem item: orderedItems) {
            totalCost += item.itemCost;
        }

    }

}
