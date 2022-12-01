import entities.FoodItem;
import entities.Order;
import entities.PastOrders;
import usecases.MainMongoDB;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import usecases.foodsuggestions.SuggestionToUser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import static usecases.foodsuggestions.SuggestionToUser.*;

public class suggestionToUserTest {

    private String testUser = "aryangoel24";
    private String testUser2 = "darpanmi";

    @Test
    public void testSortingHashMapMongo() {
        PastOrders testOrder = MainMongoDB.findPastOrders(testUser);
        assert testOrder != null;
        final HashMap<String, Order> pastOrdersMap = testOrder.getPastOrdersMap();
        LinkedHashMap<FoodItem, Integer> testSortingHashMap = sortingHashMap(itemCount(testOrder, pastOrdersMap));
        List<Integer> expectedValues = new ArrayList<Integer>(testSortingHashMap.values());
        List<Integer> expectedSortedListValue = new ArrayList<>();
        expectedSortedListValue.add(3);
        expectedSortedListValue.add(2);
        expectedSortedListValue.add(1);
        expectedSortedListValue.add(1);
        Assertions.assertEquals(expectedValues, expectedSortedListValue);
    }

    @Test
    public void testSortingHashMapLocal() {
        HashMap<FoodItem, Integer> testCountPopulatedItem = new HashMap<>();
        FoodItem foodItem1 = new FoodItem("foodItem1", 21.00);
        FoodItem foodItem2 = new FoodItem("foodItem2", 10.00);
        testCountPopulatedItem.put(foodItem1, 1);
        testCountPopulatedItem.put(foodItem2, 2);
        LinkedHashMap<FoodItem, Integer> expectedList = new LinkedHashMap<>();
        expectedList.put(foodItem2, 2);
        expectedList.put(foodItem1, 1);
        Assertions.assertEquals(sortingHashMap(testCountPopulatedItem), expectedList);
    }

    @Test
    public void testGetFinalSuggestion() {
        PastOrders testOrder = MainMongoDB.findPastOrders(testUser);
        assert testOrder != null;
        final HashMap<String, Order> pastOrdersMap = testOrder.getPastOrdersMap();
        HashMap<FoodItem, Integer> currentItemCount = itemCount(testOrder, pastOrdersMap);
        LinkedHashMap<FoodItem, Integer> sortedList = sortingHashMap(currentItemCount);
        ArrayList<String> actualList = getFinalSuggestion(testUser, sortedList);
        ArrayList<String> expectedList = new ArrayList<>();
        expectedList.add("Falafel Wrap");
        expectedList.add("Chicken Shawarma");
        Assertions.assertEquals(actualList, expectedList);
    }

    @Test
    public void testGetSuggestionToUser() {
        ArrayList<String> expectedList = new ArrayList<>();
        expectedList.add("Falafel Wrap");
        expectedList.add("Chicken Shawarma");
        ArrayList<String> actualList = SuggestionToUser.getSuggestionToUser(testUser);
        Assertions.assertEquals(actualList, expectedList);
    }

    @Test
    public void testGetSuggestionToUserNoItem() {
        ArrayList<String> expectedList = new ArrayList<>();
        ArrayList<String> actualList = SuggestionToUser.getSuggestionToUser(testUser2);
        Assertions.assertEquals(actualList, expectedList);
    }

}
