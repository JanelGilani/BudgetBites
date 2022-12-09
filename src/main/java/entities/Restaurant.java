package entities;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    public String restaurantName;
    public String priceRange;
    public String cuisine;
    public String foodType;
    public double avgRating;
    public ArrayList<FoodItem> menu;
    public List<Object[]> reviews;

    public Restaurant () {

    }

    /**
     * Instantiating a new restaurant
     * @param name name of the restaurant
     * @param priceRange price of the restaurant
     * @param cuisine cuisine of the restaurant
     * @param foodType food type of the restaurant
     * @param avgRating average rating of the restaurant
     * @param menu menu of the restaurant
     */
    public Restaurant (String name, String priceRange, String cuisine, String foodType, double avgRating, ArrayList<FoodItem> menu) {
        this.restaurantName = name;
        this.priceRange = priceRange;
        this.cuisine = cuisine;
        this.foodType = foodType;
        this.avgRating = avgRating;
        this.menu = menu;
    }

    /**
     * Price range of the restaurant
     * @return price of the restaurant
     */
    public String getPriceRange(){
        return this.priceRange;
    }

    /**
     * Getter for restaurant cuisine
     * @return cuisine for restaurant
     */
    public String getCuisine() {
        return this.cuisine;
    }

    /**
     * Getter for restaurant food type
     * @return string of food type
     */
    public String getFoodType() {
        return this.foodType;
    }

    /**
     * Getter method for restaurant name
     * @return Name of the restaurant
     */
    public String getRestaurantName () {
        return this.restaurantName;
    }

    /**
     * Getter method for average rating
     * @return average rating of the restaurant
     */
    public double getAvgRating () {
        return this.avgRating;
    }

    /**
     * List of food items from menu
     * @return Array list of food items
     */
    public ArrayList<FoodItem> getMenu () {
        return this.menu;
    }


}
