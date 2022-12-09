import entities.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import usecases.budgeting.BudgetingInteractor;

import java.time.LocalDateTime;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
@SuppressWarnings({"ALL"})
public class BudgetingInteractorTest {

    private PastOrders p1;
    private Order o1;
    private Order o2;
    private FoodItem f1;
    private FoodItem f2;
    private FoodItem f3;
    private FoodItem f4;
    private FoodItem f5;
    private Budget b1;
    private User user;

    @Before
    public void init() {
        b1 = new Budget(1000);
        p1 = new PastOrders();
        user = new User("Akshayan", "Jeyakumar", "akshayan28", "akshayan", p1, b1);

        o1 = new Order(LocalDateTime.now().minusDays(2).toString(), "Food from East");
        o2 = new Order(LocalDateTime.now().minusDays(1).toString(), "Food from East");

        f1 = new FoodItem("Chicken Shawarma", 8);
        f2 = new FoodItem("Hummus with Pita", 5);
        f3 = new FoodItem("Falafel Wrap", 4);
        f4 = new FoodItem("Beef Shawarma", 8);
        f5 = new FoodItem("Chicken Saj", 7);

        o1.addToOrder(f1);
        o1.addToOrder(f2);
        o2.addToOrder(f3);
        o2.addToOrder(f4);

        p1.addOrder(o1);
        p1.addOrder(o2);
    }


    /**
     * orderedMealsBudgetTest tests the orderedMealsBudget method in the BudgetingInteractor use case, which takes
     * the price of the last ordered meal and subtracts it from the current budget
     */
     
    @Test
    public void orderedMealsBudgetTest() {
        user.getBudget().setCurrentBudget(250);
        Budget budget = user.getBudget();
        BudgetingInteractor budgetingInteractor = new BudgetingInteractor();
        HashMap<String, Order> pastOrdersMap = new HashMap<String, Order>();
        pastOrdersMap.put(o1.getDateOrdered(), o1);
        pastOrdersMap.put(o2.getDateOrdered(), o2);
        double price = p1.getCostOfLastOrdered();
        budgetingInteractor.orderedMealsBudget(budget, p1);
        double currBudget = 250 - price;

        Assertions.assertEquals(currBudget, budget.getCurrentBudget());
    }

    /**
     * newBudgetConfirmPassTest tests the newBudgetConfirm method in the BudgetingInteractor use case, which takes
     * the new budgets that are entered(new monthly budget and confirm monthly budget) and will return true/pass when
     * the values entered are equal
     */

    @Test
    public void newBudgetConfirmPassTest() {
        double b1 = 1000;
        double cb1 = 1000;
        BudgetingInteractor budgetingInteractor = new BudgetingInteractor();
        assertTrue(budgetingInteractor.newBudgetConfirm(b1, cb1));
    }

    /**
     * newBudgetConfirmFailTest tests the newBudgetConfirm method in the BudgetingInteractor use case, which takes
     * the new budgets that are entered(new monthly budget and confirm monthly budget) and will fail when
     * the values entered are not equal
     */
    @Test
    public void newBudgetConfirmFailTest() {
        double b1 = 1000;
        double cb1 = 1200;
        BudgetingInteractor budgetingInteractor = new BudgetingInteractor();
        assertFalse(budgetingInteractor.newBudgetConfirm(b1, cb1));
    }

    /**
     * adjustBudgetNegativeErrorCaseTest tests the adjustBudget method in the BudgetingInteractor use case, which takes
     * the new budget that the user wants and returns an error since the budget entered is a negative value
     */
    @Test
    public void adjustBudgetNegativeErrorCaseTest() {
        boolean thrown = false;

        try {
            Budget budget = user.getBudget();
            BudgetingInteractor budgetingInteractor = new BudgetingInteractor();
            budgetingInteractor.adjustMonthlyBudget(budget, -120);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    /**
     * adjustBudgetSameErrorCaseTest tests the adjustBudget method in the BudgetingInteractor use case, which takes
     * the new budget that the user wants and returns an error since the budget is the same as the initial budget
     */
     
    @Test
    public void adjustBudgetSameErrorCaseTest() {
        boolean thrown = false;

        try {
            BudgetingInteractor budgetingInteractor = new BudgetingInteractor();
            Budget budget = user.getBudget();
            budgetingInteractor.adjustMonthlyBudget(budget, 1000);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    /**
     * adjustBudgetDecreaseTest tests the adjustBudget method in the BudgetingInteractor use case, which takes
     * the new budget that the user wants to decrease their monthly budget to and sets the initial monthly budget and current
     * budget accordingly
     */
     
    @Test
    public void adjustBudgetDecreaseTest() {

        user.getBudget().setCurrentBudget(15);
        Budget budget = user.getBudget();
        BudgetingInteractor budgetingInteractor = new BudgetingInteractor();
        budgetingInteractor.adjustMonthlyBudget(budget, 800);

        Assertions.assertEquals(800.0, budget.getInitialBudget());
        Assertions.assertEquals(-185.0, budget.getCurrentBudget());
    }

    /**
     * adjustBudgetIncreaseTest tests the adjustBudget method in the BudgetingInteractor use case, which takes
     * the new budget that the user wants to increase their monthly budget to and sets the initial monthly budget and current
     * budget accordingly
     */
     
    @Test
    public void adjustBudgetIncreaseTest() {

        user.getBudget().setCurrentBudget(15);
        Budget budget = user.getBudget();
        BudgetingInteractor budgetingInteractor = new BudgetingInteractor();
        budgetingInteractor.adjustMonthlyBudget(budget,1200);

        Assertions.assertEquals(1200.0, budget.getInitialBudget());
        Assertions.assertEquals(215.0, budget.getCurrentBudget());
    }
}
