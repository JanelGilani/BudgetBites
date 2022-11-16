package Use_Cases;

import Entities.Order;
import Entities.foodItem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class pastOrders {
    public HashMap<String, Order> pastOrdersMap;
    public LocalDateTime lastOrdered;

    public pastOrders () {
        this.pastOrdersMap = new HashMap<String, Order>();
        this.lastOrdered = null;
    }

    public ArrayList<foodItem> getOrderedItemsByDate (LocalDateTime dateTime) {
        return this.pastOrdersMap.get(dateTime).getOrderedItems();
    }

    public Order getOrderByDate (LocalDateTime dateTime) {
        return this.pastOrdersMap.get(dateTime);
    }

    public LocalDateTime getLastOrdered () {
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
