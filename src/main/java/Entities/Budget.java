package Entities;

public class Budget {
    private double initialBudget;
    private double currentBudget;

    public Budget (double initialBudget, double currentBudget){
        this.initialBudget = initialBudget;
        this.currentBudget = currentBudget;
    }

    public Budget () {
        this.initialBudget = 0;
        this.currentBudget = 0;
    }
}
