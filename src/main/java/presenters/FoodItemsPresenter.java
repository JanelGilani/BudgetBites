package presenters;
import javax.swing.*;

public interface FoodItemsPresenter {
    void allFoods();

    void updateFoods(String pricePref);

    JList<String> getList();
}
