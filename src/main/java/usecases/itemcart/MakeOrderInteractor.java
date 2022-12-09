package usecases.itemcart;

import entities.ItemCart;
import entities.Order;
import entities.PastOrders;
import gateways.MainMongoDB;
import usecases.MakeOrderDAI;


public class MakeOrderInteractor {
    private final MakeOrderDAI makeOrderDAI = new MainMongoDB();

    /**
     * Makes a new order using the item cart, username and restaurant name
     * @param restaurantName string (name of the restaurant)
     * @param itemCart Item cart in the form of entity
     * @param username username as string for it to access the MongoDB user
     */
    public void makeNewOrder (String restaurantName, ItemCart itemCart, String username) {
        PastOrders pastOrders = makeOrderDAI.findPastOrders(username);
        Order order = itemCart.makeOrder(pastOrders, restaurantName);
        makeOrderDAI.addToPastOrders(username, order);
    }
}