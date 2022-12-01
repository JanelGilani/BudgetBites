import entities.FoodItem;
import entities.Order;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class OrderEntityTest {

    // Test cases for the getter functionalities of the Order Entity

    private Order o1;
    private FoodItem f1;
    private FoodItem f2;
    private FoodItem f3;
    private FoodItem f4;

    @Before
    public void init () {
        o1 = new Order(LocalDateTime.of(2022, 7, 25, 1, 30).toString(),
                "Food from East");
        f1 = new FoodItem("Chicken Shawarma", 8);
        f2 = new FoodItem("Hummus with Pita", 5);
        f3 = new FoodItem("Falafel Wrap", 4);
        f4 = new FoodItem("Beef Shawarma", 8);
        o1.addToOrder(f1);
        o1.addToOrder(f2);
        o1.addToOrder(f3);
    }

    @After
    public void teardown () {
        o1.getOrderedItems().remove(f4);
    }


    @Test
    public void getOrderedItemsTest() {
        ArrayList<FoodItem> orderedItems = new ArrayList<>(Arrays.asList(f1, f2, f3));
        Assertions.assertEquals(orderedItems, o1.getOrderedItems());
    }

    @Test
    public void getTotalCostTest() {
        double totalCost = 17;
        Assertions.assertEquals(totalCost, o1.getTotalCost());

    }

    @Test
    public void getDateOrderedTest() {
        String orderDate = "2022-07-25T01:30";
        Assertions.assertEquals(orderDate, o1.getDateOrdered());
    }

    @Test
    public void getRestaurantNameTest() {
        String restaurantName = "Food from East";
        Assertions.assertEquals(restaurantName, o1.getRestaurantName());
    }

    @Test
    public void addToOrderTest() {
        int numItemsBefore = o1.getOrderedItems().size();
        double totalCostBefore = o1.getTotalCost();
        o1.addToOrder(f4);
        int numItemsAfter = o1.getOrderedItems().size();
        double totalCostAfter = o1.getTotalCost();

//        The number of items in orderedItems should increase by 1 after the order is added
//        The total cost should increase by the price of f4
        Assertions.assertEquals(numItemsBefore + 1, numItemsAfter);
        Assertions.assertEquals(totalCostBefore + f4.getItemCost(), totalCostAfter);

    }


}