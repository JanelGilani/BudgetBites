package usecases;


import entities.Budget;
import entities.PastOrders;

public interface BudgetDAI {
    void updateAttributeByUsername(String username, String attribute, Object attValue);

    Budget getUserBudget(String username);

    Object getUserAttribute (String username, String attribute);

    boolean userExists (String username);

    PastOrders findPastOrders (String username);
}
