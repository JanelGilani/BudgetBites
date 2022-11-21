package Use_Cases.Budgeting;

import Entities.Budget;
import Use_Cases.ItemCart.pastOrders;
import Use_Cases.mainMongoDB;

public class budgetManager extends Budget {

    public void adjustMonthlyBudget(double newBudgetSize) {
        if (newBudgetSize > initialBudget) {
            initialBudget = newBudgetSize;
            double increasingDifference = newBudgetSize - initialBudget;
            currentBudget = currentBudget + increasingDifference;
        }
        if (newBudgetSize == initialBudget) {
            throw new IllegalArgumentException("Budget is the same");
        }
        else {
            initialBudget = newBudgetSize;
            double decreasingDifference = initialBudget - newBudgetSize;
            if (currentBudget > decreasingDifference) {
                currentBudget = currentBudget - decreasingDifference;
            } else
                throw new IllegalArgumentException("You've exceeded your monthly limit");
        }
    }

    public static double orderedMealsBudget(pastOrders pastOrders){
        return currentBudget - pastOrders.getCostOfLastOrdered();
    }
}