package Entities;

import Use_Cases.ItemCart.itemCart;

public class foodItem {
    protected String itemName;
    protected double itemCost;
    protected Restaurant restaurant;

    public foodItem (String itemName, double itemCost, Restaurant restaurant) {
        this.itemName = itemName;
        this.itemCost = itemCost;
        this.restaurant = restaurant;
    }

    public double getItemCost () {
        return this.itemCost;
    }

    public String getItemName () {
        return this.itemName;
    }

    public Restaurant getRestaurant () {
        return this.restaurant;
    }

    public void addToItemCart (itemCart cart) {
        cart.addToCart(this);
    }
    public void addToOrder (Order order) {
        order.addToOrder(this);
    }
}
