package Entities;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
    public ArrayList<foodItem> orderedItems;
    public String dateOrdered;
    public double totalCost;


    public Order () {
        this.dateOrdered = null;
        this.totalCost = 0;
        this.orderedItems = new ArrayList<>();
    }

    public Order (String dateOrdered) {
        this.dateOrdered = dateOrdered;
        this.totalCost = 0;
        this.orderedItems = new ArrayList<>();
    }

    public ArrayList<foodItem> getOrderedItems () {
        return this.orderedItems;
    }

    public double getTotalCost () {
        return this.totalCost;
    }

    public String getDateOrdered () {
        return this.dateOrdered;
    }


    public void addToOrder (foodItem item) {
        this.orderedItems.add(item);
        this.totalCost += item.getItemCost();
        }



}
