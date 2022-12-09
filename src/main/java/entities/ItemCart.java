package entities;

import entities.designpatterns.CurrentOrderIterator;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ItemCart {
    public ArrayList<FoodItem> currentOrder;

    /**
     * Instantiating Item Cart
     */
    public ItemCart() {
        this.currentOrder = new ArrayList<>();
    }

    /**
     * Return an array list of food item
     * @return arraylist of the current order
     */
    public ArrayList<FoodItem> getCurrentOrder () {
        return this.currentOrder;
    }

    /**
     * Add to the cart
     * @param item food item name
     */
    public void addToCart (FoodItem item) {
        currentOrder.add(item);
    }

    /**
     * Remove item from the cart
     * @param item name of food item
     */
    public void removeFromCart (FoodItem item) {
        currentOrder.remove(item);
    }

    /**
     * Iterator for current order
     * @return new iterator design pattern for current order
     */
    public CurrentOrderIterator createIterator () {
        return new CurrentOrderIterator(this.getCurrentOrder());
    }

    /**
     * Return array list of food name by the iterator
     * @param currentOrderIterator current order iterator
     * @return array list of string with food names
     */
    public ArrayList<String> getFoodNamesByIterator(CurrentOrderIterator currentOrderIterator) {
        ArrayList<String> itemNames = new ArrayList<>();
        while (currentOrderIterator.hasNext()) {
            String name = currentOrderIterator.next().getItemName();
            itemNames.add(name);
        }

        return itemNames;
    }

    /**
     * Return the total cost of all food items in the current order list
     * @param currentOrderIterator Given current order iterator
     * @return total cost of all food item as double
     */
    public double getTotalCostByIterator (CurrentOrderIterator currentOrderIterator) {
        double totalCost = 0;
        while (currentOrderIterator.hasNext()) {
            double price = currentOrderIterator.next().getItemCost();
            totalCost += price;
        }

        return totalCost;
    }

    /**
     * Getter for all food name
     * @return An array list of food name
     */
    public ArrayList<String> getFoodNames() {
        CurrentOrderIterator currentOrderIterator = this.createIterator();
        return this.getFoodNamesByIterator(currentOrderIterator);
    }

    /**
     * Total Cost of all the current order
     * @return total cost in the form of double
     */
    public double getTotalCost() {
        CurrentOrderIterator currentOrderIterator = this.createIterator();
        return this.getTotalCostByIterator(currentOrderIterator);
    }

    /**
     * Make an order and put it into past orders
     * @param userPastOrders User's past order
     * @param restaurantName restaurant name for the order
     * @return Order
     */
    public Order makeOrder (PastOrders userPastOrders, String restaurantName) {
        String dateTime = LocalDateTime.now().toString();
        Order tempOrder = new Order(dateTime, restaurantName);
//        Get the current date and time of when the order is being placed
//        Create the order with the dateTime and restaurant

        for (FoodItem item: this.currentOrder) {
            item.addToOrder(tempOrder);
        }

        this.currentOrder.clear();

        userPastOrders.addOrder(tempOrder);
        return tempOrder;
    }

}
