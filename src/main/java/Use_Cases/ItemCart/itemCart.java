package Use_Cases.ItemCart;

import Entities.Order;
import Entities.Restaurant;
import Entities.foodItem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class itemCart {
    public ArrayList<foodItem> currentOrder;

    public itemCart () {
        this.currentOrder = new ArrayList<foodItem>();
    }

    public void addToCart (foodItem item) {
        currentOrder.add(item);
    }

    public Order makeOrder (pastOrders userPastOrders) {
        String dateTime = LocalDateTime.now().toString();
        Order tempOrder = new Order(dateTime);
//        Get the current date and time of when the order is being placed
//        Create the order with the dateTime and restaurant

        for (foodItem item: this.currentOrder) {
            item.addToOrder(tempOrder);
        }

        this.currentOrder.clear();

        userPastOrders.addOrder(tempOrder);
        return tempOrder;
    }

}
