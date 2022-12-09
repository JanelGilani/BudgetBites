package entities;

public class User {
    public String firstName;
    public String lastName;
    public String username;
    public String password;
    public Budget budget;
    public PastOrders pastOrders;

    public User () {
    }

    /**
     * Instantiating new User
     * @param firstName first name of the user
     * @param lastName last name of the user
     * @param username username of the user
     * @param password password of the user
     * @param pastOrders past order of the user
     * @param budget initial and current budget of the user
     */
    public User (String firstName, String lastName, String username, String password, PastOrders pastOrders, Budget budget) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.budget = budget;
        this.pastOrders = pastOrders;
    }

    /**
     * Getter function for first name
     * @return first name of the user
     */
    public String getFirstName () {
        return this.firstName;
    }

    /**
     * Getter function for first name
     * @return last name of the user
     */
    public String getLastName () {
        return lastName;
    }

    /**
     * Getter function for first name
     * @return username
     */
    public String getUsername () {
        return username;
    }

    /**
     * Getter function for first name
     * @return get password
     */
    public String getPassword () {
        return password;
    }

    /**
     * Getter function for first name
     * @return past order
     */
    public PastOrders getPastOrders () {
        return pastOrders;
    }

    /**
     * Getter function for first name
     * @return current budget
     */
    public Budget getBudget () {
        return budget;
    }

    /**
     * Setter function for first name
     * @param firstName first name of the user
     */
    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }

    /**
     * Setter for last name
     * @param lastName last name of the user
     */
    public void setLastName (String lastName) {
        this.lastName = lastName;
    }

    /**
     * Setter method for username
     * @param username username of the user
     */
    public void setUsername (String username) {
        this.username = username;
    }

    /**
     * Setter for password
     * @param password password for the user
     */
    public void setPassword (String password) {
        this.password = password;
    }

    /**
     * Set past order of the user
     * @param pastOrders past order of the user
     */
    public void setPastOrders (PastOrders pastOrders) {
        this.pastOrders = pastOrders;
    }

    /**
     * Setter budget method
     * @param budget set budget of the user
     */
    public void setBudget (Budget budget) {
        this.budget = budget;
    }


}
