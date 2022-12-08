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

    public ArrayList<String> filter(String pricePref, String cuisinePref, String foodTypePref, ArrayList<String> allRestaurants) {

        ArrayList<String> cuisineChoice = cuisineFilter.getOrDefault(cuisinePref, null);
        ArrayList<String> foodTypeChoice = foodTypeFilter.getOrDefault(foodTypePref, null);
        ArrayList<String> priceChoice = priceFilter.getOrDefault(pricePref, null);

        if (!Objects.isNull(cuisineChoice)) {
            allRestaurants.retainAll(cuisineChoice);
            if (!Objects.isNull(foodTypeChoice)) {
                allRestaurants.retainAll(foodTypeChoice);
            }
            if (!Objects.isNull(priceChoice)) {
                allRestaurants.retainAll(priceChoice);
            }
            return allRestaurants;
        } else if (!Objects.isNull(foodTypeChoice)) {
            allRestaurants.retainAll(foodTypeChoice);
            if (!Objects.isNull(priceChoice)) {
                allRestaurants.retainAll(priceChoice);
            }
            return allRestaurants;
        } else {
            allRestaurants.retainAll(priceChoice);
            return allRestaurants;
        }
    }
}
