package usecases.itemcart;

import entities.ItemCart;
import entities.Order;
import entities.PastOrders;
import gateways.MainMongoDB;
import usecases.MakeOrderDAI;


public class MakeOrderInteractor {
    private final MakeOrderDAI makeOrderDAI = new MainMongoDB();
    public void makeNewOrder (String restaurantName, ItemCart itemCart, String username) {
        PastOrders pastOrders = makeOrderDAI.findPastOrders(username);
        Order order = itemCart.makeOrder(pastOrders, restaurantName);
        makeOrderDAI.addToPastOrders(username, order);
    }
}