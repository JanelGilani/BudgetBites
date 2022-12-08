package entities.designpatterns;

import entities.FoodItem;
import entities.Restaurant;

import java.util.ArrayList;

public class RestaurantFactory {
    public static Restaurant getRestaurant(String restaurantName, String priceRange, String cuisine,
                                           String foodType, double avgRating, ArrayList<FoodItem> menu) {
        return new Restaurant(restaurantName, priceRange, cuisine, foodType, avgRating, menu);
    }
}