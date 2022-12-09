package entities;

import java.util.ArrayList;
import java.util.HashMap;

public class PastOrders {
    public HashMap<String, Order> pastOrdersMap;
    public String lastOrdered;

    public PastOrders() {
        this.pastOrdersMap = new HashMap<>();
        this.lastOrdered = null;
    }

    /**
     * Instantiating Past order
     * @param pastOrdersMap past Orders map of all the past orders hashmap
     * @param lastOrdered last order date time string
     */
    public PastOrders(HashMap<String, Order> pastOrdersMap, String lastOrdered) {
        this.pastOrdersMap = pastOrdersMap;
        this.lastOrdered = lastOrdered;
    }

    /**
     * Getter for past order map
     * @return Hashmap of past orders
     */
    public HashMap<String, Order> getPastOrdersMap () {
        return this.pastOrdersMap;
    }

    /**
     * Getter for last ordered item
     * @return String of date time of the last order placed
     */
    public String getLastOrdered () {
        return this.lastOrdered;
    }

    /**
     * Getter method for last order
     * @param dateTime datetime of the last order
     * @return Order by datetime
     */
    public Order getOrderByDate (String dateTime) {
        return this.pastOrdersMap.get(dateTime);
    }

    /**
     * Getter for food item based on the order and date
     * @param dateTime date time of the last order
     * @return Food Item ordered on that date
     */
    public ArrayList<FoodItem> getOrderedItemsByDate (String dateTime) {
        return this.pastOrdersMap.get(dateTime).getOrderedItems();
    }

    /**
     * Getter for total by calculating item and its cost from the order
     * @return total order cost
     */
    public double getTotalCost () {
        double cost = 0;
        for (Order order: this.pastOrdersMap.values()){
            cost += order.getTotalCost();
        }

        return cost;
    }

    /**
     * Getter for total cost for last order
     * @return double of the total cost
     */
    public double getCostOfLastOrdered () {
        if (this.getPastOrdersMap().isEmpty()){
            return 0;
        }
        return this.getOrderByDate(this.lastOrdered).getTotalCost();
    }

    /**
     * Adding the order into pastOrder map
     * @param order order of the user 
     */
    public void addOrder (Order order) {
        this.pastOrdersMap.put(order.getDateOrdered(), order);
        this.lastOrdered = order.getDateOrdered();
    }
}
