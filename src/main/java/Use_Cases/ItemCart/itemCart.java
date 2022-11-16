package Use_Cases.ItemCart;

import Entities.Order;
import Entities.Restaurant;
import Entities.foodItem;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class itemCart {
    protected ArrayList<foodItem> currentOrder;

    public itemCart () {
        this.currentOrder = new ArrayList<foodItem>();
    }

    public void addToCart (foodItem item) {
        currentOrder.add(item);
    }

    public Order makeOrder (pastOrders userPastOrders) {
//        Get the restaurant of the order from the first item in current order
        Restaurant restaurant = this.currentOrder.get(0).getRestaurant();
//        Get the current date and time of when the order is being placed
        LocalDateTime dateTime = LocalDateTime.now();
//        Create the order with the dateTime and restaurant
        Order tempOrder = new Order(dateTime, restaurant);

        for (foodItem item: this.currentOrder) {
            item.addToOrder(tempOrder);
        }

        this.currentOrder.clear();

        userPastOrders.addOrder(tempOrder);
        return tempOrder;
    }

}
