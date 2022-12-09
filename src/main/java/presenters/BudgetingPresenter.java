package presenters;

import controllers.BudgetingController;

import javax.swing.*;

public class BudgetingPresenter extends JLabel implements usecases.budgeting.BudgetingOutputBoundary{
    public final BudgetingController budgetingController;

    public BudgetingPresenter() {
        this.setBounds(10, 270, 10000, 55);
        this.budgetingController = new BudgetingController();
    }

    @Override
    public void setResponse(double budget, double confirmBudget, String user) {
        int val = budgetingController.changeBudget(budget, confirmBudget, user);
        if (val == 0) {
            this.setText("User does not exist");
        } else if (val == 1) {
            this.setText("Invalid Inputs, please enter values again.");
        } else if (val == 2) {
            this.setText("Success");
        }
    }

    @Override
    public String getMessage() {
        return this.getText();
    }
}
