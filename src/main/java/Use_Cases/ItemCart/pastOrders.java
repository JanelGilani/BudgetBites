package Use_Cases.ItemCart;

import Entities.Order;
import Entities.foodItem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class pastOrders {
    public HashMap<LocalDateTime, Order> pastOrders;
    public LocalDateTime lastOrdered;

    public pastOrders () {
        this.pastOrders = new HashMap<LocalDateTime, Order>();
        this.lastOrdered = null;
    }

    public ArrayList<foodItem> getOrderedItemsByDate (LocalDateTime dateTime) {
        return this.pastOrders.get(dateTime).getOrderedItems();
    }

    public Order getOrderByDate (LocalDateTime dateTime) {
        return this.pastOrders.get(dateTime);
    }

    public LocalDateTime getLastOrdered () {
        return this.lastOrdered;
    }

    public void addOrder (Order order) {
        this.pastOrders.put(order.dateOrdered, order);
        this.lastOrdered = order.dateOrdered;
    }

    public double getTotalCost () {
        double cost = 0;
        for (Order order: this.pastOrders.values()){
            cost += order.totalCost;
        }

        return cost;
    }

    public double getCostOfLastOrdered () {
        return this.getOrderByDate(this.lastOrdered).totalCost;
    }
}
