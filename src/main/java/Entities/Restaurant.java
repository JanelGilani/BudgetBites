package Entities;

import java.util.List;

public class Restaurant {
    private String priceRange;
    private String cuisine;
    private String foodType;
    public double avgRating;
    protected foodItem[] menu;
    public List<Object[]> reviews;

    public Restaurant (String priceRange, String cuisine, String foodType, double avgRating, foodItem[] menu) {
        this.priceRange = priceRange;
        this.cuisine = cuisine;
        this.foodType = foodType;
        this.avgRating = avgRating;
        this.menu = menu;
    }


    public String getPriceRange(){
        return this.priceRange;
    }

    public String getCuisine() {
        return this.cuisine;
    }

    public String getFoodType() {
        return this.foodType;
    }


}
