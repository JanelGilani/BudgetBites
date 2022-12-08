package usecases.filtering.pricefiltering;

import entities.FoodItem;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class PriceFilter {

    private HashMap<String, ArrayList<String>> filter;
    private ArrayList<String> foods;

    /**
     * Uses the selection from the restaurantFiltering of specific restaurant
     * and then filters by price in the single restaurant by increments of $5
     * @param menu of the restaurant that has been selected
     * Instantiates the instances of priceFiltering
     */
    public PriceFilter(ArrayList<FoodItem> menu) {
        filter = new HashMap<>();
        foods = new ArrayList<>();
        filter.put("$0 to $5", new ArrayList<String>());
        filter.put("$5 to $10", new ArrayList<String>());
        filter.put("$10 to $15", new ArrayList<String>());
        filter.put("$15 to $20", new ArrayList<String>());
        filter.put("$20 to $25", new ArrayList<String>());
        filter.put("$25+", new ArrayList<String>());

        for (FoodItem food : menu) {
            String name = food.getItemName() + " - Price: $" + food.getItemCost();
            if (food.getItemCost() < 5) {
                filter.get("$0 to $5").add(name);
            } else if (food.getItemCost() < 10) {
                filter.get("$5 to $10").add(name);
            } else if (food.getItemCost() < 15) {
                filter.get("$10 to $15").add(name);
            } else if (food.getItemCost() < 20) {
                filter.get("$15 to $20").add(name);
            } else if (food.getItemCost() < 25) {
                filter.get("$20 to $25").add(name);
            } else {
                filter.get("25+").add(name);
            }
            foods.add(name);
        }
    }

    /**
     *
     * @param price_range inputted by the user
     * @return
     * the filter method returns a food item after checking whether it is included in a price range
     * if it is not in the price range it then returns null
     */
    public ArrayList<String> filter(String price_range) {
        return filter.getOrDefault(price_range, null);
    }

    /**
     *
     * @return
     * the allFood methods returns an arrayList of all the names of the foods available
     * at the restaurant
     */
    public ArrayList<String> allFood() {return foods;}
}
