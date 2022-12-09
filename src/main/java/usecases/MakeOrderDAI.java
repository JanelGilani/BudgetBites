package usecases;

import entities.Order;
import entities.PastOrders;
@SuppressWarnings({"ALL", "unused"})
public interface MakeOrderDAI {
    PastOrders findPastOrders (String username);
    boolean addToPastOrders (String username, Order order);
}