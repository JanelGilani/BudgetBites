import entities.Order;
import usecases.budgeting.BudgetManager;
import entities.Budget;
import entities.PastOrders;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import usecases.MainMongoDB;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class budgetManagerTest {

    /*@Test
    public void orderedMealsBudgetTest() {

        Budget budget = new Budget();
        BudgetManager budgetManager = new BudgetManager();
        budget.setCurrentBudget(200);
        HashMap<String, Order> pastOrdersMap = new HashMap<>();
        PastOrders order = new PastOrders(pastOrdersMap, "Pizza");
        String b = order.getLastOrdered();
        double price = order.getCostOfLastOrdered();
        budgetManager.orderedMealsBudget(budget, order);
        double currBudget = 200 - price;

        Assertions.assertEquals(currBudget, budget.getCurrentBudget());
    }*/

    @Test
    public void adjustBudgetNegativeErrorCaseTest() {
        boolean thrown = false;

        try {
            Budget budget = new Budget(500);
            BudgetManager budgetManager = new BudgetManager();
            budgetManager.adjustMonthlyBudget(budget,-120);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }
            assertTrue(thrown);
    }
    @Test
    public void adjustBudgetSameErrorCaseTest() {
        boolean thrown = false;

        try {
            Budget budget = new Budget(750);
            BudgetManager budgetManager = new BudgetManager();
            budgetManager.adjustMonthlyBudget(budget,750);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    @Test
    public void adjustBudgetDecreaseTest() {

        Budget budget = new Budget(1000);
        budget.setCurrentBudget(15);
        BudgetManager budgetManager = new BudgetManager();
        budgetManager.adjustMonthlyBudget(budget,800);

        Assertions.assertEquals(800.0, budget.getInitialBudget());
        Assertions.assertEquals(-185.0, budget.getCurrentBudget());
    }

    @Test
    public void adjustBudgetIncreaseTest() {

        Budget budget = new Budget(1000);
        budget.setCurrentBudget(15);
        BudgetManager budgetManager = new BudgetManager();
        budgetManager.adjustMonthlyBudget(budget,1200);

        Assertions.assertEquals(1200.0, budget.getInitialBudget());
        Assertions.assertEquals(215.0, budget.getCurrentBudget());
    }
}