import Entities.Budget;
import Use_Cases.Budgeting.budgetManager;
import Use_Cases.ItemCart.pastOrders;
import Use_Cases.mainMongoDB;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;


public class budgetManagerTest {

    @Test
    public void orderedMealsBudgetTest() {

        Budget budget = new Budget();
        budgetManager budgetManager = new budgetManager();
        budget.setCurrentBudget(200);
        pastOrders order = mainMongoDB.findPastOrders("aryangoel24");
        double price = order.getCostOfLastOrdered();
        budgetManager.orderedMealsBudget(budget, order);
        double currBudget = 200 - price;

        Assertions.assertEquals(currBudget, budget.getCurrentBudget());
    }

    @Test
    public void orderedMealsAryanBudgetTest() {

        Budget budget = (Budget) mainMongoDB.getUserAttribute("aryangoel24", "budget");
        budgetManager budgetManager = new budgetManager();
        pastOrders order = mainMongoDB.findPastOrders("aryangoel24");
        double price = order.getCostOfLastOrdered();
        budgetManager.orderedMealsBudget(budget, order);
        double currBudget = 15 - price;

        Assertions.assertEquals(currBudget, budget.getCurrentBudget());
    }

    @Test
    public void orderedMealsVandanBudgetTest() {

        Budget budget = (Budget) mainMongoDB.getUserAttribute("vandanpatel", "budget");
        budgetManager budgetManager = new budgetManager();
        pastOrders order = mainMongoDB.findPastOrders("vandanpatel");
        double price = order.getCostOfLastOrdered();
        double cBudget= 50 - price;
        budgetManager.orderedMealsBudget(budget, order);

        Assertions.assertEquals(cBudget, budget.getCurrentBudget());
    }

    @Test
    public void adjustBudgetDecreaseTest() {

        Budget budget = (Budget) mainMongoDB.getUserAttribute("aryangoel24", "budget");
        budgetManager budgetManager = new budgetManager();
        double b = budget.getInitialBudget();
        System.out.println(b);
        budgetManager.adjustMonthlyBudget(budget,800);

        Assertions.assertEquals(800.0, budget.getInitialBudget());
        Assertions.assertEquals(-185.0, budget.getCurrentBudget());
    }

    @Test
    public void adjustBudgetIncreaseTest() {

        Budget budget = (Budget) mainMongoDB.getUserAttribute("aryangoel24", "budget");
        budgetManager budgetManager = new budgetManager();
        double b = budget.getInitialBudget();
        System.out.println(b);
        budgetManager.adjustMonthlyBudget(budget,1200);

        Assertions.assertEquals(1200.0, budget.getInitialBudget());
        Assertions.assertEquals(215.0, budget.getCurrentBudget());
    }
}