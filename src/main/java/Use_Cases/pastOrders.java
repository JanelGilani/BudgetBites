package Use_Cases;

import Entities.Order;
import Entities.foodItem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class pastOrders {
    private HashMap<String, Order> pastOrdersMap;
    private String lastOrdered;

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
        this.pastOrdersMap.put(order.dateOrdered.toString(), order);
        this.lastOrdered = order.dateOrdered;
    }

    public double getTotalCost () {
        double cost = 0;
        for (Order order: this.pastOrdersMap.values()){
            cost += order.totalCost;
        }

        return cost;
    }

//    public double getCostOfLastOrdered () {
//        return this.getOrderByDate(this.lastOrdered).totalCost;
//    }
}
