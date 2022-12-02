import usecases.budgeting.BudgetManager;
import entities.Budget;
import entities.PastOrders;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import usecases.MainMongoDB;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class budgetManagerTest {

//    @Test
//    public void orderedMealsBudgetTest() {
//
//        Budget budget = new Budget();
//        BudgetManager budgetManager = new BudgetManager();
//        budget.setCurrentBudget(200);
//        PastOrders order = MainMongoDB.findPastOrders("aryangoel24");
//        double price = order.getCostOfLastOrdered();
//        budgetManager.orderedMealsBudget(budget, order);
//        double currBudget = 200 - price;
//
//        Assertions.assertEquals(currBudget, budget.getCurrentBudget());
//    }
//
//    @Test
//    public void orderedMealsAryanBudgetTest() {
//
//        Budget budget = (Budget) MainMongoDB.getUserAttribute("aryangoel24", "budget");
//        BudgetManager budgetManager = new BudgetManager();
//        PastOrders order = MainMongoDB.findPastOrders("aryangoel24");
//        double price = order.getCostOfLastOrdered();
//        budgetManager.orderedMealsBudget(budget, order);
//        double currBudget = 15 - price;
//
//        Assertions.assertEquals(currBudget, budget.getCurrentBudget());
//    }
//
//    @Test
//    public void orderedMealsVandanBudgetTest() {
//
//        Budget budget = (Budget) MainMongoDB.getUserAttribute("vandanpatel", "budget");
//        BudgetManager budgetManager = new BudgetManager();
//        PastOrders order = MainMongoDB.findPastOrders("vandanpatel");
//        double price = order.getCostOfLastOrdered();
//        double cBudget= 50 - price;
//        budgetManager.orderedMealsBudget(budget, order);
//
//        Assertions.assertEquals(cBudget, budget.getCurrentBudget());
//    }
//
//    @Test
//    public void adjustBudgetNegativeErrorCaseTest() {
//        boolean thrown = false;
//
//        try {
//            Budget budget = (Budget) MainMongoDB.getUserAttribute("aryangoel24", "budget");
//            BudgetManager budgetManager = new BudgetManager();
//            budgetManager.adjustMonthlyBudget(budget,-120);
//        } catch (IllegalArgumentException e) {
//            thrown = true;
//        }
//            assertTrue(thrown);
//    }
//    @Test
//    public void adjustBudgetSameErrorCaseTest() {
//        boolean thrown = false;
//
//        try {
//            Budget budget = (Budget) MainMongoDB.getUserAttribute("vandanpatel", "budget");
//            BudgetManager budgetManager = new BudgetManager();
//            budgetManager.adjustMonthlyBudget(budget,50);
//        } catch (IllegalArgumentException e) {
//            thrown = true;
//        }
//        assertTrue(thrown);
//    }
//
//    @Test
//    public void adjustBudgetDecreaseTest() {
//
//        Budget budget = (Budget) MainMongoDB.getUserAttribute("aryangoel24", "budget");
//        BudgetManager budgetManager = new BudgetManager();
//        budgetManager.adjustMonthlyBudget(budget,800);
//
//        Assertions.assertEquals(800.0, budget.getInitialBudget());
//        Assertions.assertEquals(-185.0, budget.getCurrentBudget());
//    }
//
//    @Test
//    public void adjustBudgetIncreaseTest() {
//
//        Budget budget = (Budget) MainMongoDB.getUserAttribute("aryangoel24", "budget");
//        BudgetManager budgetManager = new BudgetManager();
//        budgetManager.adjustMonthlyBudget(budget,1200);
//
//        Assertions.assertEquals(1200.0, budget.getInitialBudget());
//        Assertions.assertEquals(215.0, budget.getCurrentBudget());
//    }
}