package usecases;

import entities.PastOrders;

public interface PastOrdersDAI {
    PastOrders findPastOrders (String username);
}
