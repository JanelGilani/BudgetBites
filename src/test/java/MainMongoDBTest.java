import com.sun.tools.javac.Main;
import entities.FoodItem;
import entities.Order;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import entities.*;
import org.junit.jupiter.api.Assertions;
import usecases.MainMongoDB;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class MainMongoDBTest {

    private User user;
    private Budget budget;
    private PastOrders p1;
    private Order o1;
    private Order o2;
    private Restaurant restaurant;
    private FoodItem f1;
    private FoodItem f2;
    private FoodItem f3;
    private FoodItem f4;
    private FoodItem f5;

    @Before
    public void init () {
        o1 = new Order(LocalDateTime.now().minusDays(2).toString(), "Food from East");
        o2 = new Order(LocalDateTime.now().minusDays(1).toString(), "Food from East");
        p1 = new PastOrders();

        f1 = new FoodItem("Chicken Shawarma", 8);
        f2 = new FoodItem("Hummus with Pita", 5);
        f3 = new FoodItem("Falafel Wrap", 4);
        f4 = new FoodItem("Beef Shawarma", 8);
        f5 = new FoodItem("Chicken Saj", 7);
        ArrayList<FoodItem> menu = new ArrayList<>(Arrays.asList(f1, f2, f3, f4, f5));

        o1.addToOrder(f1);
        o1.addToOrder(f2);
        o2.addToOrder(f3);
        o2.addToOrder(f4);

        p1.addOrder(o1);
        p1.addOrder(o2);

        budget = new Budget(100);

        user = new User("Mongo", "Test", "MongoTest", "MongoTest@123", p1, budget);
        restaurant = new Restaurant("Mongo Test Restaurant", "Expensive", "Italian", "Lunch",5,  menu);
    }

    @After
    public void teardown () {
        MainMongoDB.deleteUser("MongoTest");
        MainMongoDB.deleteRestaurant("Mongo Test Restaurant");
    }


    @Test
    public void saveUserTest() {
//        Object ID is changed when object is saved on database, so we will check whether the attribute is the same
        MainMongoDB.saveUser(user);

        Assertions.assertEquals(MainMongoDB.findUserByUsername("MongoTest").getFirstName(), user.getFirstName());
    }

    @Test
    public void saveRestaurantTest () {
        MainMongoDB.saveRestaurant(restaurant);

        Assertions.assertEquals(MainMongoDB.findRestaurantByRestaurantName("Mongo Test Restaurant").getRestaurantName(), restaurant.getRestaurantName());
    }

    @Test
    public void userExistsTest () {
        Assertions.assertTrue(MainMongoDB.userExists("aryangoel24"));
        Assertions.assertFalse(MainMongoDB.userExists("falseUser"));
    }

    @Test
    public void getUserAttributeTest () {
        Assertions.assertEquals(MainMongoDB.getUserAttribute("aryangoel24", "username"), "aryangoel24");
        Assertions.assertEquals(MainMongoDB.getUserAttribute("aryangoel24", "firstName"), "Aryan");
        Assertions.assertEquals(MainMongoDB.getUserAttribute("aryangoel24", "lastName"), "Goel");
        Assertions.assertEquals(MainMongoDB.getUserAttribute("aryangoel24", "password"), "goelaryan25");
    }

    @Test
    public void getRestaurantAttributeTest () {
        Assertions.assertEquals(MainMongoDB.getRestaurantAttribute("Food from East", "restaurantName"), "Food from East");
        Assertions.assertEquals(MainMongoDB.getRestaurantAttribute("Food from East", "cuisine"), "Middle-East");
        Assertions.assertEquals(MainMongoDB.getRestaurantAttribute("Food from East", "foodType"), "Lunch");
        Assertions.assertEquals(MainMongoDB.getRestaurantAttribute("Food from East", "priceRange"), "Intermediate");
        Assertions.assertEquals(MainMongoDB.getRestaurantAttribute("Food from East", "avgRating"), "5.0");
    }


}