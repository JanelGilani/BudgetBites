import entities.FoodItem;
import entities.Order;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import entities.*;
import org.junit.jupiter.api.Assertions;
import gateways.MainMongoDB;
import usecases.TestDAI;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class MainMongoDBTest {

    private final TestDAI testDAI = new MainMongoDB();

    private User user;
    private User persistentUser;
    private Order o3;
    private Restaurant restaurant;
    private Restaurant persistentRestaurant;

    /*@Before
    public void init () {
        Order o1 = new Order(LocalDateTime.now().minusDays(2).toString(), "Food from East");
        Order o2 = new Order(LocalDateTime.now().minusDays(1).toString(), "Food from East");
        o3 = new Order(LocalDateTime.now().toString(), "Food from East");
        PastOrders p1 = new PastOrders();

        FoodItem f1 = new FoodItem("Chicken Shawarma", 8);
        FoodItem f2 = new FoodItem("Hummus with Pita", 5);
        FoodItem f3 = new FoodItem("Falafel Wrap", 4);
        FoodItem f4 = new FoodItem("Beef Shawarma", 8);
        FoodItem f5 = new FoodItem("Chicken Saj", 7);
        ArrayList<FoodItem> menu = new ArrayList<>(Arrays.asList(f1, f2, f3, f4, f5));

        o1.addToOrder(f1);
        o1.addToOrder(f2);
        o2.addToOrder(f3);
        o2.addToOrder(f4);
        o3.addToOrder(f1);
        o3.addToOrder(f2);
        o3.addToOrder(f3);
        o3.addToOrder(f4);
        o3.addToOrder(f5);

        p1.addOrder(o1);
        p1.addOrder(o2);

        Budget budget = new Budget(100);

        user = new User("Mongo", "Test", "MongoTest", "MongoTest@123", p1, budget);
        restaurant = new Restaurant("Mongo Test Restaurant", "Expensive", "Italian", "Lunch",5,  menu);

        persistentUser = new User("Persistent", "Mongo", "persistentUser", "persistentUser", p1, budget);
        persistentRestaurant = new Restaurant("Persistent Restaurant", "Expensive", "Indian", "Dinner", 5, menu);
    }*/

    /*@After
    public void teardown () {
        testDAI.deleteUser("MongoTest");
        testDAI.deleteRestaurant("Mongo Test Restaurant");

        testDAI.deleteUser(persistentUser.getUsername());
        testDAI.saveUser(persistentUser);

        testDAI.deleteRestaurant("Persistent Restaurant");
        testDAI.saveRestaurant(persistentRestaurant);

    }*/


    @Test
    public void saveUserTest() {
//        Object ID is changed when object is saved on database, so we will check whether the attribute is the same
        testDAI.saveUser(user);

        Assertions.assertEquals(testDAI.findUserByUsername("MongoTest").getFirstName(), user.getFirstName());
    }

    @Test
    public void saveRestaurantTest() {
        testDAI.saveRestaurant(restaurant);

        Assertions.assertEquals(testDAI.findRestaurantByRestaurantName("Mongo Test Restaurant").getRestaurantName(), restaurant.getRestaurantName());
    }

    @Test
    public void userExistsTest() {
        Assertions.assertTrue(testDAI.userExists("persistentUser"));
        Assertions.assertFalse(testDAI.userExists("falseUser"));
    }

    @Test
    public void getUserAttributeTest() {
        Assertions.assertEquals(testDAI.getUserAttribute("persistentUser", "username"), "persistentUser");
        Assertions.assertEquals(testDAI.getUserAttribute("persistentUser", "firstName"), "Persistent");
        Assertions.assertEquals(testDAI.getUserAttribute("persistentUser", "lastName"), "Mongo");
        Assertions.assertEquals(testDAI.getUserAttribute("persistentUser", "password"), "persistentUser");
    }

    @Test
    public void getRestaurantAttributeTest() {
        Assertions.assertEquals(testDAI.getRestaurantAttribute("Persistent Restaurant", "restaurantName"), "Persistent Restaurant");
        Assertions.assertEquals(testDAI.getRestaurantAttribute("Persistent Restaurant", "cuisine"), "Indian");
        Assertions.assertEquals(testDAI.getRestaurantAttribute("Persistent Restaurant", "foodType"), "Dinner");
        Assertions.assertEquals(testDAI.getRestaurantAttribute("Persistent Restaurant", "priceRange"), "Expensive");
        Assertions.assertEquals(testDAI.getRestaurantAttribute("Persistent Restaurant", "avgRating"), "5.0");
    }

    @Test
    public void getMenuTest() {
//        Cannot compare the ArrayList directly because of different object ids, so we are confirming whether the list of food item names are the same
        ArrayList<String> localFoodNames = new ArrayList<>(
                Arrays.asList("Chicken Shawarma", "Hummus with Pita", "Falafel Wrap", "Beef Shawarma", "Chicken Saj"));

        ArrayList<String> mongoFoodNames = new ArrayList<>();
        for (FoodItem foodItem : testDAI.getMenu("Persistent Restaurant")) {
            mongoFoodNames.add(foodItem.getItemName());
        }

        Assertions.assertEquals(localFoodNames, mongoFoodNames);
    }

    @Test
    public void updateAttributeByUsernameTest() {
        testDAI.updateAttributeByUsername("persistentUser", "firstName", "testchange");

        Assertions.assertEquals(testDAI.getUserAttribute("persistentUser", "firstName"), "testchange");
    }

    @Test
    public void findPastOrdersTest() {
        PastOrders pastOrders = testDAI.findPastOrders("persistentUser");

//        From the database, we can see the cost of the last ordered is 12, and the number of orders in the map is 2
        Assertions.assertEquals(pastOrders.getCostOfLastOrdered(), 12);
        Assertions.assertEquals(pastOrders.getPastOrdersMap().size(), 2);
        Assertions.assertEquals(pastOrders.getTotalCost(), 25);
    }

    @Test
    public void addToPastOrdersTest() {
        testDAI.addToPastOrders("persistentUser", o3);
        PastOrders pastOrders = testDAI.findPastOrders("persistentUser");

//        The new cost of last ordered is 17, and there are now 3 orders in pastOrdersMap
        Assertions.assertEquals(pastOrders.getCostOfLastOrdered(), 32);
        Assertions.assertEquals(pastOrders.getPastOrdersMap().size(), 3);
        Assertions.assertEquals(pastOrders.getTotalCost(), 57);
    }

    @Test
    public void makeRestaurant1() {
        FoodItem f1 = new FoodItem("Risotto", 18);
        FoodItem f2 = new FoodItem("Il Tartufo", 25);
        FoodItem f3 = new FoodItem("Pasta", 16);
        FoodItem f4 = new FoodItem("Lasagne", 29);
        FoodItem f5 = new FoodItem("Ravioli", 17);
        FoodItem f6 = new FoodItem("Fiorentina", 35);
        ArrayList<FoodItem> menu = new ArrayList<>(Arrays.asList(f1, f2, f3, f4, f5, f6));

        Restaurant restaurant1 = new Restaurant("Donatello's Restaurant", "Expensive", "Italian", "Dinner", 4.8, menu);

        FoodItem f7 = new FoodItem("Cheese Pizza", 10);
        FoodItem f8 = new FoodItem("Pepperoni Pizza", 10);
        FoodItem f9 = new FoodItem("Veggie Pizza", 13);
        FoodItem f10 = new FoodItem("Barbeque Chicken Pizza", 15);
        FoodItem f11 = new FoodItem("Hawaiian Pizza", 13);
        FoodItem f12 = new FoodItem("Meat Lover's Pizza", 12);
        ArrayList<FoodItem> menu1 = new ArrayList<>(Arrays.asList(f7, f8, f9, f10, f11, f12));

        Restaurant restaurant2 = new Restaurant("Ralph's Pizzeria", "Cheap", "Italian", "Lunch", 3.7, menu1);

        FoodItem f13 = new FoodItem("Frittata", 16);
        FoodItem f14 = new FoodItem("", 25);
        FoodItem f15 = new FoodItem("Bruschetta", 12);
        FoodItem f16 = new FoodItem("Cannoli", 28);
        FoodItem f17 = new FoodItem("Panzerotti", 17);
        ArrayList<FoodItem> menu2 = new ArrayList<>(Arrays.asList(f13, f14, f15, f16, f17));

        Restaurant restaurant3 = new Restaurant("Little Italy", "Intermediate", "Italian", "Snack", 4.1, menu2);

        FoodItem f18 = new FoodItem("Frittata", 12);
        FoodItem f19 = new FoodItem("Ricotta Pancakes", 10);
        FoodItem f20 = new FoodItem("Sausage", 8);
        FoodItem f21 = new FoodItem("Baked Eggs", 9);
        FoodItem f22 = new FoodItem("Brioche", 6);
        ArrayList<FoodItem> menu3 = new ArrayList<>(Arrays.asList(f18, f19, f20, f21, f22));

        Restaurant restaurant4 = new Restaurant("Wake Up Italian", "Cheap", "Italian", "Breakfast", 2.1, menu3);

        FoodItem f23 = new FoodItem("Enchiladas", 12);
        FoodItem f24 = new FoodItem("Nachos Supreme", 10);
        FoodItem f25 = new FoodItem("Mexican Rice", 8);
        FoodItem f26 = new FoodItem("Quesadilla", 9);
        FoodItem f27 = new FoodItem("Tamales", 6);
        ArrayList<FoodItem> menu4 = new ArrayList<>(Arrays.asList(f23, f24, f25, f26, f27));

        Restaurant restaurant5 = new Restaurant("Mexico's Finest", "Cheap", "Mexican", "Lunch", 3.1, menu4);

        FoodItem f28 = new FoodItem("Regular Taco", 10);
        FoodItem f29 = new FoodItem("Chicken Taco", 12);
        FoodItem f30 = new FoodItem("Veggie Taco", 15);
        FoodItem f31 = new FoodItem("Fish Tacos", 18);
        FoodItem f32 = new FoodItem("Lebron Tacos", 20);
        ArrayList<FoodItem> menu5 = new ArrayList<>(Arrays.asList(f28, f29, f30, f31, f32));

        Restaurant restaurant6 = new Restaurant("Lebron's Taco Tuesday", "Intermediate", "Mexican", "Snack", 3.6, menu5);

        FoodItem f33 = new FoodItem("Chilaquiles", 15);
        FoodItem f34 = new FoodItem("Burritos", 22);
        FoodItem f35 = new FoodItem("Tamales", 25);
        FoodItem f36 = new FoodItem("Chips with Fresh Guacamole", 28);
        FoodItem f37 = new FoodItem("Carnitas", 30);
        ArrayList<FoodItem> menu6 = new ArrayList<>(Arrays.asList(f33, f34, f35, f36, f37));

        Restaurant restaurant7 = new Restaurant("Viva La Mexicana", "Expensive", "Mexican", "Dinner", 3.6, menu6);

        testDAI.saveRestaurant(restaurant1);
        testDAI.saveRestaurant(restaurant2);
        testDAI.saveRestaurant(restaurant3);
        testDAI.saveRestaurant(restaurant4);
        testDAI.saveRestaurant(restaurant5);
        testDAI.saveRestaurant(restaurant6);
        testDAI.saveRestaurant(restaurant7);
    }
}