import Entities.Budget;
import Use_Cases.Budgeting.budgetManager;
import Use_Cases.ItemCart.pastOrders;
import Use_Cases.mainMongoDB;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tutorial.HelloWorld;

import static org.junit.Assert.assertEquals;


public class BudgetManagerTest {
    @Test
    public void orderedMealsBudgetTest() {

        Budget budget = new Budget();
        pastOrders pastorder = mainMongoDB.findPastOrders("aryangoel24");
        budget.setInitialBudget(1000);
        budget.setCurrentBudget(200);
        pastOrders order = mainMongoDB.findPastOrders("aryangoel24");
        double price = order.getCostOfLastOrdered();
        budget.setCurrentBudget(budgetManager.orderedMealsBudget(pastorder));

        Assertions.assertEquals(200 - price, budget.getCurrentBudget());
    }
}