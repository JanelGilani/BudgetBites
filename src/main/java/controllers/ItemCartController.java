package controllers;

import gateways.MainMongoDB;
import usecases.FoodItemsDAI;
import usecases.itemcart.ItemCartInteractor;

import java.util.ArrayList;

public class ItemCartController {
    private ItemCartInteractor itemCartInteractor;

    private final FoodItemsDAI foodItemsDAI = new MainMongoDB();

    public ItemCartController(String restaurantName) {
        itemCartInteractor = new ItemCartInteractor(foodItemsDAI.getMenu(restaurantName));
    }

    public void addToItemCart(String choice) {
        String[] split = choice.split("-", 0);
        String foodName = split[0].strip();
        itemCartInteractor.addFood(foodName);
    }

    public void removeFromItemCart(String choice) {
        String[] split = choice.split("-", 0);
        String foodName = split[0].strip();
        itemCartInteractor.removeFood(foodName);
    }

    public ArrayList<String> getItems() {
        return itemCartInteractor.getFoodInItemCart();
    }
}
