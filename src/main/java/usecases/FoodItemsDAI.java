package usecases;

import entities.FoodItem;

import java.util.ArrayList;

public interface FoodItemsDAI {
    ArrayList<FoodItem> getMenu(String restaurantName);
}
