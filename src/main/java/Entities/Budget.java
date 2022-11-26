package Entities;

public class Budget {
    protected double initialBudget;
    protected static double currentBudget;

    public Budget () {
    }

    public Budget (double initialBudget){
        Budget.currentBudget = initialBudget;
        this.initialBudget = initialBudget;
    }
    public double getInitialBudget() {
        return initialBudget;
    }

    public void setInitialBudget(double initialBudget) {
        this.initialBudget = initialBudget;
    }

    public double getCurrentBudget() {
        return currentBudget;
    }

    public void setCurrentBudget(double currentBudget) {
        Budget.currentBudget = currentBudget;
    }
}