package entities;

public class Budget {
    public double initialBudget;
    public double currentBudget;

    public Budget () {
    }

    /**
     * Initializing initial budget
     * @param initialBudget initial budget inputted by th user
     */
    public Budget (double initialBudget){
        this.currentBudget = initialBudget;
        this.initialBudget = initialBudget;
    }

    /**
     * Getter method for initial budget
     * @return budget as double
     */
    public double getInitialBudget() {
        return initialBudget;
    }

    /**
     * Getter method for current budget
     * @return budget as double
     */
    public double getCurrentBudget() {
        return currentBudget;
    }

    /**
     * Setter method for initial budget
     */
    public void setInitialBudget(double initialBudget) {
        this.initialBudget = initialBudget;
    }

    /**
     * Setter method for current budget
     */
    public void setCurrentBudget(double currentBudget) {
        this.currentBudget = currentBudget;
    }
}