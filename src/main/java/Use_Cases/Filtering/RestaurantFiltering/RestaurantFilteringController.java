package Use_Cases.Filtering.RestaurantFiltering;

import java.util.ArrayList;

public class RestaurantFilteringController {
    private String pricePreference;

    private String cuisinePreference;

    private String foodTypePreference;

    public RestaurantFilteringController() {
        pricePreference = null;
        cuisinePreference = null;
        foodTypePreference = null;
    }

    public void setCuisinePreference(String cuisinePreference) {
        this.cuisinePreference = cuisinePreference;
    }

    public void setFoodTypePreference(String foodTypePreference) {
        this.foodTypePreference = foodTypePreference;
    }

    public void setPricePreference(String pricePreference) {
        this.pricePreference = pricePreference;
    }

    public String getCuisinePreference() {
        return cuisinePreference;
    }

    public String getFoodTypePreference() {
        return foodTypePreference;
    }

    public String getPricePreference() {
        return pricePreference;
    }
}
