package usecases.itemcart;

import entities.FoodItem;
import entities.ItemCart;

import java.util.ArrayList;

public class ModifyItemCartInteractor {
    private final ItemCart itemCart;
    private final ArrayList<FoodItem> menu;


    /**
     *
     * @param menu of restaurant selected by the user
     */
    public ModifyItemCartInteractor(ArrayList<FoodItem> menu) {
        this.menu = menu;
        itemCart = new ItemCart();
    }


    /**
     * getter function for the ItemCart
     * @return the itemCart
     */
    public ItemCart getItemCart() {
        return itemCart;
    }


    /**
     *
     * @param foodName name of food
     * Adds food to the itemCart based on if the foodItem name matches the food name
     * matches inputted.
     */
    public void addFood(String foodName){
        for (FoodItem food: menu) {
            if (food.getItemName().equals(foodName)) {
                itemCart.addToCart(food);
            }
        }
    }


    /**
     *
     * @param foodName name of food
     * Removes food to the itemCart based on if the foodItem name matches the food name
     * matches inputted.
     */
    public void removeFood(String foodName){
        for (FoodItem food: menu) {
            if (food.getItemName().equals(foodName)) {
                itemCart.removeFromCart(food);
            }
        }
    }

    /**
     * Getter function for the Foods in the ItemCart
     * @return an ArrayList with FoodItem objects
     */
    public ArrayList<String> getFoodInItemCart() {
        ArrayList<String> result = new ArrayList<>();
        for (FoodItem food:
        itemCart.getCurrentOrder()) {
            result.add(food.getItemName());
        }
        return result;
    }


    /**
     * Getter function for the total cost of the foods in the ItemCart.
     * @return a double of the ItemCart cost
     */
    public double getItemCartCost() {
        double result = 0;
        for (FoodItem food :itemCart.getCurrentOrder()) {
            result += food.getItemCost();
        }
        return result;
    }
}