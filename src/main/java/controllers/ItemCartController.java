package controllers;

import gateways.MainMongoDB;
import usecases.FoodItemsDAI;
import usecases.itemcart.ItemCartEditor;

import java.util.ArrayList;

public class ItemCartController {
    private ItemCartEditor itemCartEditor;

    private final FoodItemsDAI foodItemsDAI = new MainMongoDB();

    public ItemCartController(String restaurantName) {
        itemCartEditor = new ItemCartEditor(foodItemsDAI.getMenu(restaurantName));
    }

    public void addToItemCart(String choice) {
        String[] split = choice.split("-", 0);
        String foodName = split[0].strip();
        itemCartEditor.addFood(foodName);
    }

    public void removeFromItemCart(String choice) {
        String[] split = choice.split("-", 0);
        String foodName = split[0].strip();
        itemCartEditor.removeFood(foodName);
    }

    public ArrayList<String> getItems() {
        return itemCartEditor.getFoodInItemCart();
    }

    public String getItemCartCost() {
        return itemCartEditor.getItemCartCost() + "";
    }
}
