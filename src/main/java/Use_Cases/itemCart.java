package Use_Cases;

import Entities.Order;
import Entities.foodItem;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class itemCart {
    public ArrayList<foodItem> currentOrder;

    public Order makeOrder () {
        LocalDateTime dateTime = LocalDateTime.now();
        Order tempOrder = new Order(dateTime);

        for (foodItem item: this.currentOrder) {
            item.addToOrder(tempOrder);
        }

        this.currentOrder.clear();
        return tempOrder;
    }

}
