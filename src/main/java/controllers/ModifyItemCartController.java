package controllers;

import gateways.MainMongoDB;
import usecases.FoodItemsDAI;
import usecases.itemcart.ModifyItemCartInteractor;
import usecases.itemcart.MakeOrderInteractor;

import java.util.ArrayList;


public class ModifyItemCartController {
    private final ModifyItemCartInteractor modifyItemCartInteractor;
    private final MakeOrderInteractor makeOrderInteractor;

    public ModifyItemCartController(String restaurantName) {
        FoodItemsDAI foodItemsDAI = new MainMongoDB();
        modifyItemCartInteractor = new ModifyItemCartInteractor(foodItemsDAI.getMenu(restaurantName));
        makeOrderInteractor = new MakeOrderInteractor();
    }

    public void addToItemCart(String choice) {
        String[] split = choice.split("-", 0);
        String foodName = split[0].strip();
        modifyItemCartInteractor.addFood(foodName);
    }

    public void removeFromItemCart(String choice) {
        String[] split = choice.split("-", 0);
        String foodName = split[0].strip();
        modifyItemCartInteractor.removeFood(foodName);
    }

    public ArrayList<String> getItems() {
        return modifyItemCartInteractor.getFoodInItemCart();
    }

    public String getItemCartCost() {
        return modifyItemCartInteractor.getItemCartCost() + "";
    }

    public void makeOrder(String restaurantName, String username) {
        makeOrderInteractor.makeNewOrder(restaurantName, modifyItemCartInteractor.getItemCart(), username);
    }
}
