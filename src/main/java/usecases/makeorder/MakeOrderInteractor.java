package usecases.makeorder;

import entities.FoodItem;
import entities.ItemCart;
import entities.Order;
import entities.PastOrders;

import java.time.LocalDateTime;

public class MakeOrderInteractor {
    public Order makeNewOrder (PastOrders userPastOrders, String restaurantName, ItemCart itemCart) {
        return itemCart.makeOrder(userPastOrders, restaurantName);
    }
}