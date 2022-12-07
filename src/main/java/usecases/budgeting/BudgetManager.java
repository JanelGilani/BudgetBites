package usecases.budgeting;

import entities.User;
import entities.Budget;
import entities.PastOrders;
import gateways.MainMongoDB;
import usecases.BudgetDAI;

public class BudgetManager {

    private final BudgetDAI budgetDAI = new MainMongoDB();

    /**
     * The newBudgetConfirm method takes the inputs of the user when changing their budget in the UI and checks to see
     * if what they've inputted in each box is equal to oe another to confirm that they want to change their budget to
     * this new Monthly Budget
     * @param newMonthlyBudget budget inputted by user that they want to change their initial budget too
     * @param confirmNewMonthlyBudget confirmation input by user to confirm this is the budget that they want to change
     *                               their initial budget too
     * @return boolean
     */
    public static boolean newBudgetConfirm(double newMonthlyBudget, double confirmNewMonthlyBudget) {
        if (newMonthlyBudget == confirmNewMonthlyBudget) {
            return true;
        }
        else
            return false;
    }
    /**
     * * The adjustMonthlyBudget method allows the user to voluntarily update their monthly budget whenever they would
     * * like by inputting a new budget in the UI
     * * @param newBudgetSize
     *
     * @param budget budget of the user of the application
     * @param newBudgetSize the budget the user now wants to change their monthly budget into
     */

    public static void adjustMonthlyBudget(Budget budget, double newBudgetSize) {
        if (newBudgetSize < 0) {
            throw new IllegalArgumentException("Monthly Budget cannot be less than zero");
        }
        if (newBudgetSize == budget.getInitialBudget()) {
            throw new IllegalArgumentException("Budget is the same");
        }
        if (newBudgetSize > budget.getInitialBudget()) {
            double increasingDifference = newBudgetSize - budget.getInitialBudget();
            budget.setInitialBudget(newBudgetSize);
            double newCurrentBudget = budget.getCurrentBudget() + increasingDifference;
            budget.setCurrentBudget(newCurrentBudget);
        } else {
            double decreasingDifference = budget.getInitialBudget() - newBudgetSize;
            budget.setInitialBudget(newBudgetSize);
            double newCBudget = budget.getCurrentBudget() - decreasingDifference;
            budget.setCurrentBudget(newCBudget);
        }
    }


    /**
     * orderedMealsBudget method automatically decreases the user's current budget when an order is placed
     *
     * @param user user of the application
     * @param orders user's past order
     */

    public void orderedMealsBudget (User user, PastOrders orders){
        Budget budget = user.getBudget();
        double newCBudget = budget.getCurrentBudget() - orders.getCostOfLastOrdered();
        budget.setCurrentBudget(newCBudget);
        budgetDAI.updateAttributeByUsername (user.getUsername(), "budget", budget);
    }
}
