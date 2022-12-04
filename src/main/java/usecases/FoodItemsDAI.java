package usecases;

import entities.FoodItem;

import java.util.ArrayList;

public interface FoodItemsDAI {
    public ArrayList<FoodItem> getMenu(String restaurantName);
}
