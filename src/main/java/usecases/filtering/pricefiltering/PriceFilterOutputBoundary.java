package usecases.filtering.pricefiltering;
import javax.swing.*;

public interface PriceFilterOutputBoundary {
    void allFoods();

    void updateFoods(String pricePref);

    JList<String> getList();
}
