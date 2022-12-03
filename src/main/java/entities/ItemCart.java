package entities;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ItemCart {
    public ArrayList<FoodItem> currentOrder;

    public ItemCart() {
        this.currentOrder = new ArrayList<FoodItem>();
    }

    public ArrayList<FoodItem> getCurrentOrder () {
        return this.currentOrder;
    }

    public void addToCart (FoodItem item) {
        currentOrder.add(item);
    }

    public CurrentOrderIterator createIterator () {
        return new CurrentOrderIterator(this.getCurrentOrder());
    }

    public ArrayList<String> checkInByIterator (CurrentOrderIterator currentOrderIterator) {
        ArrayList<String> itemNames = new ArrayList<>();
        while (currentOrderIterator.hasNext()) {
            String name = currentOrderIterator.next().getItemName();
            itemNames.add(name);
        }

        return itemNames;
    }

    public ArrayList<String> checkIn () {
        CurrentOrderIterator currentOrderIterator = this.createIterator();
        return this.checkInByIterator(currentOrderIterator);
    }

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
