package Use_Cases.Filtering.RestaurantFiltering;
import Use_Cases.mainMongoDB;

import java.util.ArrayList;

public class RestaurantFilteringGateway {
    public static ArrayList<String> getListOfRestaurants() {
        return mainMongoDB.getAllRestaurants();
    }

    public static String getRestaurantCuisine(String name) {
        return mainMongoDB.getRestaurantAttribute(name, "cuisine");
    }

    public static String getRestaurantPriceRange(String name) {
        return mainMongoDB.getRestaurantAttribute(name, "priceRange");
    }

    public static String getRestaurantFoodType(String name) {
        return mainMongoDB.getRestaurantAttribute(name, "foodType");
    }

    public static String getRestaurantAvgRating(String name) {
        return mainMongoDB.getRestaurantAttribute(name, "avgRating");
    }
}
