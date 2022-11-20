package Use_Cases.FoodSuggestions;
import Entities.foodItem;
import Use_Cases.ItemCart.pastOrders;
import Use_Cases.mainMongoDB;
import java.util.*;

public class suggestionToUser {
    public ArrayList<String> suggestionToUser(String userName) {
        pastOrders currentPastOrder = mainMongoDB.findPastOrders(userName);
        assert currentPastOrder != null;
        HashMap<String, Integer> currentItemCount = itemCount(currentPastOrder);
        LinkedHashMap<String, Integer> sortedList = sortingHashMap(currentItemCount);
        return getFinalSuggestion(userName, sortedList);
    }

    private String lastOrderDate;

    private HashMap<String, Integer> itemCount(pastOrders currentOrder) {
        if (currentOrder == null) {
            return null;
        }
        ArrayList<foodItem> currentOrderFoodItem = currentOrder.getOrderedItemsByDate(currentOrder.getLastOrdered());
        HashMap<String, Integer> countItems = new HashMap<>();
        if (!currentOrder.getLastOrdered().equals(lastOrderDate)) {
            for (foodItem item : currentOrderFoodItem) {
                if (!countItems.containsKey(item.getItemName())) {
                    countItems.put(item.getItemName(), 1);
                } else {
                    countItems.replace(item.getItemName(), countItems.get(item.getItemName()) + 1);
                }
            }
        }
        lastOrderDate = currentOrder.getLastOrdered();
        return countItems;
    }
    private LinkedHashMap<String, Integer> sortingHashMap(HashMap<String, Integer> populatedCountItem) {
        ArrayList<Integer> list = new ArrayList<>();
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : populatedCountItem.entrySet()) {
            list.add(entry.getValue());
        }
        list.sort(Collections.reverseOrder());
        for (int num : list) {
            for (Map.Entry<String, Integer> entry : populatedCountItem.entrySet()) {
                if (entry.getValue().equals(num)) {
                    sortedMap.put(entry.getKey(), num);
                }
            }
        }
        return sortedMap;
    }
    private ArrayList<String> getFinalSuggestion(String userName, LinkedHashMap<String, Integer> populatedSortedMap) {
        double budgetSoFar = 0;
        assert mainMongoDB.getUserAttribute(userName, "budget") != null;
        double currentBudget = (double) mainMongoDB.getUserAttribute(userName, "budget");
        ArrayList<String> finalSuggestion = new ArrayList<>();
        for (String item: populatedSortedMap.keySet()) {
            if (budgetSoFar > currentBudget) {
                break;
            }
            finalSuggestion.add(item);
        }
        return finalSuggestion;
    }
}
