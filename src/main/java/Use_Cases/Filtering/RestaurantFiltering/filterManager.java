package Use_Cases.Filtering.RestaurantFiltering;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class filterManager {
    private HashMap<String, ArrayList<String>> cuisineFilter;

    private HashMap<String, ArrayList<String>> foodTypeFilter;

    private HashMap<String, ArrayList<String>> priceFilter;

    public filterManager(HashMap<String, ArrayList<String>> cuisineFilter,
                         HashMap<String, ArrayList<String>> foodTypeFilter,
                         HashMap<String, ArrayList<String>> priceFilter) {
        this.cuisineFilter = cuisineFilter;
        this.foodTypeFilter = foodTypeFilter;
        this.priceFilter = priceFilter;
    }

    public ArrayList<String> filter(String pricePref, String cuisinePref, String foodTypePref) {
        ArrayList<String> cuisineChoice = cuisineFilter.getOrDefault(cuisinePref, null);
        ArrayList<String> foodTypeChoice = foodTypeFilter.getOrDefault(foodTypePref, null);
        ArrayList<String> priceChoice = priceFilter.getOrDefault(pricePref, null);
        if (!Objects.isNull(cuisineChoice)) {
            if (!Objects.isNull(foodTypeChoice)) {
                cuisineChoice.retainAll(foodTypeChoice);
            }
            if (!Objects.isNull(priceChoice)) {
                cuisineChoice.retainAll(priceChoice);
            }
            return cuisineChoice;
        } else if (!Objects.isNull(foodTypeChoice)) {
            if (!Objects.isNull(priceChoice)) {
                foodTypeChoice.retainAll(priceChoice);
            }
            return foodTypeChoice;
        } else {
            return priceChoice;
        }
    }
}
