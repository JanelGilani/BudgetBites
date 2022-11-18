package Use_Cases.ItemCart;

import Entities.Order;
import Entities.foodItem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class pastOrders {
<<<<<<< HEAD:src/main/java/Use_Cases/pastOrders.java
    private HashMap<String, Order> pastOrdersMap;
    private String lastOrdered;
=======
    protected HashMap<LocalDateTime, Order> pastOrders;
    protected LocalDateTime lastOrdered;
>>>>>>> ba837d9ef596f639fc25b433f4ea0f634f33bd10:src/main/java/Use_Cases/ItemCart/pastOrders.java

    public pastOrders () {
        this.pastOrdersMap = new HashMap<String, Order>();
        this.lastOrdered = null;
    }

    public pastOrders (HashMap<String, Order> pastOrdersMap, String lastOrdered) {
        this.pastOrdersMap = pastOrdersMap;
        this.lastOrdered = lastOrdered;
    }

    public ArrayList<foodItem> getOrderedItemsByDate (String dateTime) {
        return this.pastOrdersMap.get(dateTime).getOrderedItems();
    }

    public Order getOrderByDate (String dateTime) {
        return this.pastOrdersMap.get(dateTime);
    }

    public String getLastOrdered () {
        return this.lastOrdered;
    }

    public void addOrder (Order order) {
<<<<<<< HEAD:src/main/java/Use_Cases/pastOrders.java
        this.pastOrdersMap.put(order.dateOrdered.toString(), order);
        this.lastOrdered = order.dateOrdered;
=======
        this.pastOrders.put(order.getDateOrdered(), order);
        this.lastOrdered = order.getDateOrdered();
>>>>>>> ba837d9ef596f639fc25b433f4ea0f634f33bd10:src/main/java/Use_Cases/ItemCart/pastOrders.java
    }

    public double getTotalCost () {
        double cost = 0;
<<<<<<< HEAD:src/main/java/Use_Cases/pastOrders.java
        for (Order order: this.pastOrdersMap.values()){
            cost += order.totalCost;
=======
        for (Order order: this.pastOrders.values()){
            cost += order.getTotalCost();
>>>>>>> ba837d9ef596f639fc25b433f4ea0f634f33bd10:src/main/java/Use_Cases/ItemCart/pastOrders.java
        }

        return cost;
    }

<<<<<<< HEAD:src/main/java/Use_Cases/pastOrders.java
//    public double getCostOfLastOrdered () {
//        return this.getOrderByDate(this.lastOrdered).totalCost;
//    }
=======
    public double getCostOfLastOrdered () {
        return this.getOrderByDate(this.lastOrdered).getTotalCost();
    }
>>>>>>> ba837d9ef596f639fc25b433f4ea0f634f33bd10:src/main/java/Use_Cases/ItemCart/pastOrders.java
}
