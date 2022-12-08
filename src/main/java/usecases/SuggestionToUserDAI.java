package usecases;

import entities.PastOrders;

public interface SuggestionToUserDAI {
    PastOrders findPastOrders (String username);
    Object getUserAttribute (String username, String attribute);
}
