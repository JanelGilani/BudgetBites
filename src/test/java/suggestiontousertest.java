import Entities.Order;
import Use_Cases.FoodSuggestions.suggestionToUser;
import Use_Cases.ItemCart.pastOrders;
import Use_Cases.mainMongoDB;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;


public class suggestiontousertest {
    private final pastOrders testPastOrder = mainMongoDB.findPastOrders("aryangoel24");

    @Test(timeout = 500)
    public void testItemCount() {
        HashMap<String, Integer> testItemCountMap = new HashMap<>();
        testItemCountMap.put("")
        assertEquals(testItemCountMap, suggestionToUser.itemCount(testPastOrder));
    }

//    @Test(timeout = 500)
//    public void testSortingHashMap() {
//        testPastOrder.addOrder(newOrder);
//        HashMap<String, Integer> testItemCountMap = new HashMap<>();
//        testItemCountMap.put();
//        testItemCountMap.put();
//        testItemCountMap.put();
//        assertEquals(testItemCountMap, suggestionToUser.itemCount(testPastOrder));
//    }
//
//    public void testgetFinalSuggestion() {
//        testPastOrder.addOrder(newOrder);
//        HashMap<String, Integer> testItemCountMap = new HashMap<>();
//        testItemCountMap.put();
//        testItemCountMap.put();
//        testItemCountMap.put();
//        assertEquals(testItemCountMap, suggestionToUser.itemCount(testPastOrder));
//    }
//
//    @Test(timeout = 500)
//    public void getSuggestionToUser() {
//        testPastOrder.addOrder(newOrder);
//        HashMap<String, Integer> testItemCountMap = new HashMap<>();
//        testItemCountMap.put();
//        testItemCountMap.put();
//        testItemCountMap.put();
//        assertEquals(testItemCountMap, suggestionToUser.itemCount(testPastOrder));
//    }
}
