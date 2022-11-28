package presenters;
import javax.swing.*;


public interface RestaurantFilteringPresenter {
    JPanel allRestaurants();

    JPanel updateRestaurants(String pricePref, String cuisinePref, String foodTypePref);
}
