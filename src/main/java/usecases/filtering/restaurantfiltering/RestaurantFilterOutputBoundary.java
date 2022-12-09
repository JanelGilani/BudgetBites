package usecases.filtering.restaurantfiltering;
import javax.swing.*;


public interface RestaurantFilterOutputBoundary {
    void allRestaurants();

    void updateRestaurants(String pricePref, String cuisinePref, String foodTypePref);

    JList<String> getList();
}
