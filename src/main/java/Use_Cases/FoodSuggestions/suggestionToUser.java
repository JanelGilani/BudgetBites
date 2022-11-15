package Use_Cases.FoodSuggestions;
import Entities.foodItem;
import Use_Cases.ItemCart.pastOrders;

import java.time.LocalDateTime;
import java.util.*;

public class suggestionToUser {
    private LocalDateTime lastOrderDate;

    private final HashMap<String, Integer> countItems = new HashMap<>();
    public LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
    ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<String> finalSuggestion = new ArrayList<>();

    private double currentSuggesitonBudget = 0;

    private final pastOrders currentOrder = new pastOrders();
    private final ArrayList<foodItem> currentOrderFoodItem = currentOrder.getOrderedItemsByDate(currentOrder.getLastOrdered());

    public void itemCount() {
        if (currentOrder.lastOrdered != lastOrderDate) {
            for (foodItem item : currentOrderFoodItem) {
                if (!countItems.containsKey(item.getItemName())) {
                    countItems.put(item.getItemName(), 1);
                } else {
                    countItems.replace(item.getItemName(), countItems.get(item.getItemName()) + 1);
                }
            }
        }
        lastOrderDate = currentOrder.lastOrdered;
    }

    public HashMap<String, Integer> sortingHashMap() {

        for (Map.Entry<String, Integer> entry : countItems.entrySet()) {
            list.add(entry.getValue());
        }
        Collections.sort(list, Collections.reverseOrder());
        for (int num : list) {
            for (Map.Entry<String, Integer> entry : countItems.entrySet()) {
                if (entry.getValue().equals(num)) {
                    sortedMap.put(entry.getKey(), num);
                }
            }
        }
        return sortedMap;
    }

    double budgetSoFar = 0;
    public ArrayList<String> getFinalSuggestion() {
        for (String item: sortedMap.keySet()) {
            ///
            if (budgetSoFar > currentSuggesitonBudget) {
                break;
            }
            finalSuggestion.add(item);
        }
        return finalSuggestion;
    }
}
