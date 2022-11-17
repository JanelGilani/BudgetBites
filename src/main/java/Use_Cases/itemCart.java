package Use_Cases;

import Entities.Order;
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

        for (foodItem item: this.currentOrder) {
            item.addToOrder(tempOrder);
        }

        this.currentOrder.clear();

        userPastOrders.addOrder(tempOrder);
        return tempOrder;
    }

}
