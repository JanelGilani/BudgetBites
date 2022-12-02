package entityTesting;
import entities.Budget;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;

public class BudgetEntityTest {


    /**
     * getInitialBudgetTest tests the getInitialBudget function in the Budget Entity, by checking if it returns the
     * correct initial budget
     */

    @Test
    public void getInitialBudgetTest() {

        Budget budget = new Budget(1000);
        double initialBudget = budget.getInitialBudget();

        Assertions.assertEquals(1000, initialBudget);
    }


    /**
     * getCurrentBudgetTest tests the getCurrentBudget function in the Budget Entity, by checking if it returns the
     * correct current budget
     */

    @Test
    public void getCurrentBudgetTest() {

        Budget budget = new Budget(1000);
        double currentBudget = budget.getCurrentBudget();

        Assertions.assertEquals(1000, currentBudget);
    }


    /**
     * setInitialBudgetTest tests the setInitialBudget function in the Budget Entity, by checking if it returns the
     * sets the initial budget to the new budget
     */

    @Test
    public void setInitialBudgetTest() {

        Budget budget = new Budget(1000);
        budget.setInitialBudget(2022);

        Assertions.assertEquals(2022, budget.getInitialBudget());
    }


    /**
     * setCurrentBudgetTest tests the setCurrentBudget function in the Budget Entity, by checking if it returns the
     * sets the current budget to the new budget
     */

    @Test
    public void setCurrentBudgetTest() {

        Budget budget = new Budget(1000);
        budget.setCurrentBudget(2003);

        Assertions.assertEquals(2003, budget.getCurrentBudget());
    }

