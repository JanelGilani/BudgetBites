package entityTesting;

import entities.Budget;
import entities.User;
import entities.PastOrders;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class UserTest {
    /**
     * Tests the getFirstName getter function by checking if accurate first name is gotten
     */
    @Test
    public void getFirstNameTest() {
        User newUser = new User("Darpan", "Mishra", "darmish", "pass",
                new PastOrders(), new Budget());
        String firstName = "Darpan";
        Assertions.assertEquals(firstName, newUser.getFirstName());
    }

    /**
     * Tests the getLastName getter function by checking if accurate last name is gotten
     */
    @Test
    public void getLastNameTest() {
        User newUser = new User("Darpan", "Mishra", "darmish", "pass",
                new PastOrders(), new Budget());
        String lastName = "Mishra";
        Assertions.assertEquals(lastName, newUser.getLastName());
    }

    /**
     * Tests the getUsername getter function by checking if accurate username is gotten
     */
    @Test
    public void getUsernameTest() {
        User newUser = new User("Darpan", "Mishra", "darmish", "pass",
                new PastOrders(), new Budget());
        String username = "darmish";
        Assertions.assertEquals(username, newUser.getUsername());
    }

    /**
     * Tests the getPassword getter function by checking if accurate password is gotten
     */
    @Test
    public void getPasswordTest() {
        User newUser = new User("Darpan", "Mishra", "darmish", "pass",
                new PastOrders(), new Budget());
        String password = "pass";
        Assertions.assertEquals(password, newUser.getPassword());
    }


    /**
     * Tests the getPastOrders getter function by checking if accurate past order is gotten
     */
    @Test
    public void getPastOrdersTest() {
        PastOrders pastOrders;
        pastOrders = new PastOrders();

        Budget budget;
        budget = new Budget();

        User newUser = new User("Darpan", "Mishra", "darmish", "pass",
                pastOrders, budget);
        Assertions.assertEquals(pastOrders, newUser.getPastOrders());
    }

    /**
     * Tests the getBudget getter function by checking if accurate budget is gotten
     */
    @Test
    public void getBudgetTest() {
        PastOrders pastOrders;
        pastOrders = new PastOrders();

        Budget budget;
        budget = new Budget();

        User newUser = new User("Darpan", "Mishra", "darmish", "pass",
                pastOrders, budget);
        Assertions.assertEquals(budget, newUser.getBudget());
    }
}
