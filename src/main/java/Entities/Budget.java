package Entities;

public class Budget {
    public double initialBudget;
    public double currentBudget;

    public Budget () {
    }

    public Budget (double initialBudget){
        currentBudget = initialBudget;
        this.initialBudget = initialBudget;
    }
    public double getInitialBudget() {
        return initialBudget;
    }

    public double getCurrentBudget() {
        return currentBudget;
    }

    public void setInitialBudget(double initialBudget) {
        this.initialBudget = initialBudget;
    }

    public void setCurrentBudget(double currentBudget) {
        this.currentBudget = currentBudget;
    }
}