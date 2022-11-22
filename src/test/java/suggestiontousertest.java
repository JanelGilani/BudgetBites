import Entities.Order;
import Entities.foodItem;
import Use_Cases.FoodSuggestions.suggestionToUser;
import Use_Cases.ItemCart.pastOrders;
import Use_Cases.mainMongoDB;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;

import static org.junit.Assert.assertEquals;


public class suggestiontousertest {
    private final pastOrders testPastOrder = mainMongoDB.findPastOrders("aryangoel24");

    @Test(timeout = 500)
    public void te() {
        LinkedHashMap<foodItem, Integer> populatedSortedMap = new LinkedHashMap<>();
//        foodItem food1 = new foodItem("food1", 10.00);
//        foodItem food2 = new foodItem("food2", 13.50);
//        foodItem food3 = new foodItem("food3", 5.00);
//        foodItem food4 = new foodItem("food4", 8.00);
//        populatedSortedMap.put(food1, 4);
//        populatedSortedMap.put(food2, 4);
//        populatedSortedMap.put(food3, 3);
//        populatedSortedMap.put(food4, 2);
    }
}
