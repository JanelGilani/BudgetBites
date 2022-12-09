package controllers;

import gateways.MainMongoDB;
import usecases.FoodItemsDAI;
import usecases.filtering.pricefiltering.PriceFilterInteractor;

import java.util.ArrayList;

public class PriceFilterController {
    private final PriceFilterInteractor priceFilterInteractor;

    public PriceFilterController(String restaurantName) {
        FoodItemsDAI foodItemsDAI = new MainMongoDB();
        priceFilterInteractor = new PriceFilterInteractor(foodItemsDAI.getMenu(restaurantName));
    }

    public ArrayList<String> filterFoodItems(String priceRange) {
        if (priceRange.equals("No Preference")){
            return priceFilterInteractor.allFood();
        } else {
            return priceFilterInteractor.filter(priceRange);
        }
    }

    public ArrayList<String> getAllFoodItems() {
        return priceFilterInteractor.allFood();
    }
}
