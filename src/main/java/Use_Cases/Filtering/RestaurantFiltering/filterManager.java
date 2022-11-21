package Use_Cases.Filtering.RestaurantFiltering;

import Entities.Restaurant;
import Use_Cases.Filtering.RestaurantFiltering.restaurantFilter;
import Use_Cases.Filtering.RestaurantFiltering.RestaurantFilteringController;

import java.util.ArrayList;
import java.util.Objects;

public class filterManager {
    private restaurantFilter cuisineFilter;

    private restaurantFilter foodTypeFilter;

    private restaurantFilter priceFilter;

    public filterManager(restaurantFilter cuisineFilter, restaurantFilter foodTypeFilter, restaurantFilter priceFilter) {
        this.cuisineFilter = cuisineFilter;
        this.foodTypeFilter = foodTypeFilter;
        this.priceFilter = priceFilter;
    }

    public ArrayList<String> filter(String pricePref, String cuisinePref, String foodTypePref) {
        ArrayList<String> cuisineChoice = cuisineFilter.filter(cuisinePref);
        ArrayList<String> foodTypeChoice = foodTypeFilter.filter(foodTypePref);
        ArrayList<String> priceChoice = priceFilter.filter((pricePref));
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
