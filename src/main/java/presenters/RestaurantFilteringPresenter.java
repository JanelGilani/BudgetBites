package presenters;
import javax.swing.*;


public interface RestaurantFilteringPresenter {
    void allRestaurants();

    void updateRestaurants(String pricePref, String cuisinePref, String foodTypePref);

    JList<String> getList();
}
