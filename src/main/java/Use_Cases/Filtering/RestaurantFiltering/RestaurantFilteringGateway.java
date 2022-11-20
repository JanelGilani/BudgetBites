package Use_Cases.Filtering.RestaurantFiltering;
import Entities.Restaurant;
import Use_Cases.mainMongoDB;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RestaurantFilteringGateway {
    public static ArrayList<String> getListOfRestaurants() {
        return null;
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
