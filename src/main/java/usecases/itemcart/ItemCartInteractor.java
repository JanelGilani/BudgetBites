package usecases.itemcart;

import entities.FoodItem;
import entities.ItemCart;

import java.util.ArrayList;

public class ItemCartInteractor {
    private ItemCart itemCart;
    private ArrayList<FoodItem> menu;
    
    public ItemCartInteractor(ArrayList<FoodItem> menu) {
        this.menu = menu;
        itemCart = new ItemCart();
    }
    
    public void addFood(String foodName){
        for (FoodItem food: menu) {
            if (food.getItemName().equals(foodName)) {
                itemCart.addToCart(food);
            }
        }
    }

    public void removeFood(String foodName){
        for (FoodItem food: menu) {
            if (food.getItemName().equals(foodName)) {
                itemCart.removeFromCart(food);
            }
        }
    }

    public ArrayList<String> getFoodInItemCart() {
        ArrayList<String> result = new ArrayList<>();
        for (FoodItem food:
        itemCart.getCurrentOrder()) {
            result.add(food.getItemName());
        }
        return result;
    }


//    public Order makeOrder() {
//        return itemCart.makeOrder()
//    }
}