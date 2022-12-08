package usecases;

import entities.PastOrders;

public interface PastOrdersDAI {
    public PastOrders findPastOrders (String username);
}
