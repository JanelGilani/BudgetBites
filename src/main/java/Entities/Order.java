package Entities;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
    public ArrayList<foodItem> orderedItems;
    public LocalDateTime dateOrdered;
    public double totalCost;

    public Order (ArrayList<foodItem> orderedItems, LocalDateTime dateOrdered) {
        this.orderedItems = orderedItems;
        this.dateOrdered = dateOrdered;
        this.totalCost = 0;

        for (foodItem item: orderedItems) {
            totalCost += item.itemCost;
        }

    }

    public Order (LocalDateTime dateOrdered) {
        this.orderedItems = new ArrayList<>();
        this.dateOrdered = dateOrdered;
        this.totalCost = 0;
    }
    public void addFoodItem (foodItem item) {
        this.orderedItems.add(item);
        this.totalCost += item.getItemCost();
        }

}
