package Entities;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
    protected ArrayList<foodItem> orderedItems;
    protected LocalDateTime dateOrdered;
    protected double totalCost;
    protected Restaurant restaurant;


    public Order (ArrayList<foodItem> orderedItems, LocalDateTime dateOrdered, Restaurant restaurant) {
        this.orderedItems = orderedItems;
        this.dateOrdered = dateOrdered;
        this.restaurant = restaurant;
        this.totalCost = 0;

        for (foodItem item: orderedItems) {
            totalCost += item.itemCost;
        }

    }

    public Order (LocalDateTime dateOrdered, Restaurant restaurant) {
        this.orderedItems = new ArrayList<foodItem>();
        this.dateOrdered = dateOrdered;
        this.restaurant = restaurant;
        this.totalCost = 0;
    }

    public ArrayList<foodItem> getOrderedItems () {
        return this.orderedItems;
    }

    public double getTotalCost () {
        return this.totalCost;
    }

    public LocalDateTime getDateOrdered () {
        return this.dateOrdered;
    }


    public void addToOrder (foodItem item) {
        this.orderedItems.add(item);
        this.totalCost += item.getItemCost();
        }



}
