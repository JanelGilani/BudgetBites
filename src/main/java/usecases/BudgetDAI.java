package usecases;


import entities.PastOrders;

public interface BudgetDAI {
    void updateAttributeByUsername(String username, String attribute, Object attValue);

    Object getUserAttribute(String username, String attribute);

    boolean userExists (String username);

    PastOrders findPastOrders (String username);
}
