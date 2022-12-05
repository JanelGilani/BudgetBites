package controllers;

import gateways.MainMongoDB;
import usecases.FoodItemsDAI;
import usecases.filtering.pricefiltering.PriceFilter;

import java.util.ArrayList;

public class FoodItemsController {
    private final FoodItemsDAI foodItemsDAI = new MainMongoDB();
    private PriceFilter priceFilter;

    public FoodItemsController(String restaurantName) {
        priceFilter = new PriceFilter(foodItemsDAI.getMenu(restaurantName));
    }

    public ArrayList<String> filterFoodItems(String priceRange) {
        if (priceRange.equals("No Preference")){
            return priceFilter.allFood();
        } else {
            return priceFilter.filter(priceRange);
        }
    }

    public ArrayList<String> getAllFoodItems() {
        return priceFilter.allFood();
    }
}
