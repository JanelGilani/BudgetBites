package usecases.filtering.restaurantfiltering;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class RestaurantFilter {
    private HashMap<String, ArrayList<String>> cuisineFilter;

    private HashMap<String, ArrayList<String>> foodTypeFilter;

    private HashMap<String, ArrayList<String>> priceFilter;

    public RestaurantFilter(HashMap<String, ArrayList<String>> cuisineFilter,
                            HashMap<String, ArrayList<String>> foodTypeFilter,
                            HashMap<String, ArrayList<String>> priceFilter) {
        this.cuisineFilter = cuisineFilter;
        this.foodTypeFilter = foodTypeFilter;
        this.priceFilter = priceFilter;
    }


    /**
     * @param pricePref given by the user on the userPrefernceFrame
     * @param cuisinePref given by the user on the userPrefernceFrame
     * @param foodTypePref given by the user on the userPrefernceFrame
     * @return the preference given by the user and ensure that the inputted preference is not null
     */


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
