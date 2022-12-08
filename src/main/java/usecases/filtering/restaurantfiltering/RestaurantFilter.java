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

<<<<<<< javadocs

    /**
     * @param pricePref given by the user on the userPrefernceFrame
     * @param cuisinePref given by the user on the userPrefernceFrame
     * @param foodTypePref given by the user on the userPrefernceFrame
     * @return the preference given by the user and ensure that the inputted preference is not null
     */


    public ArrayList<String> filter(String pricePref, String cuisinePref, String foodTypePref) {
=======
    public ArrayList<String> filter(String pricePref, String cuisinePref, String foodTypePref, ArrayList<String> allRestaurants) {

>>>>>>> main
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
