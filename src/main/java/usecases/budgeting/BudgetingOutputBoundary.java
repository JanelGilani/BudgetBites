package usecases.budgeting;

public interface BudgetingOutputBoundary {
    void setResponse(double budget, double confirmBudget, String user);
    String getMessage();
}
