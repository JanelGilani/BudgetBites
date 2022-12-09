package controllers;

import gateways.MainMongoDB;
import usecases.BudgetDAI;
import usecases.budgeting.BudgetingInteractor;
import entities.Budget;


public class BudgetingController {
    private final BudgetDAI budgetDAI = new MainMongoDB();

    public BudgetingController() {
    }

    public int changeBudget(double budget, double confirmBudget, String user) {
        if (!budgetDAI.userExists(user)) {
            return 0;
        } else if (BudgetingInteractor.newBudgetConfirm(budget, confirmBudget)) {
            Budget userBudget = budgetDAI.getUserBudget(user);
            BudgetingInteractor.adjustMonthlyBudget(userBudget, budget);
            budgetDAI.updateAttributeByUsername(user, "budget", userBudget);
            return 2;
        } else {
            return 1;
        }
    }


}
