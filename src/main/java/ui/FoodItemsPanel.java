package ui;

import controllers.FoodItemsController;
import controllers.RestaurantFilterController;
import presenters.FoodItemsPresenter;

import javax.swing.*;
import java.awt.*;

public class FoodItemsPanel extends JPanel implements FoodItemsPresenter{
    private JPanel panel;
    private JScrollPane scroll;
    private FoodItemsController controller;

    private JList<String> list;

    public FoodItemsPanel(String restaurantName) {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(420,500));
        scroll = new JScrollPane();
        controller = new FoodItemsController(restaurantName);
        list = new JList<>();
    }
    @Override
    public void allFoods() {
        DefaultListModel<String> model = new DefaultListModel<>();
        for(String val : controller.getAllFoodItems())
            model.addElement(val);
        list = new JList<>(model);
        scroll.setViewportView(list);

        list.setLayoutOrientation(JList.VERTICAL);

        this.add(scroll);
    }

    @Override
    public void updateFoods(String pricePref) {
        DefaultListModel<String> updatedModel = new DefaultListModel<>();
        for(String val : controller.filterFoodItems(pricePref))
            updatedModel.addElement(val);
        list = new JList<>(updatedModel);
        scroll.setViewportView(list);
    }

    @Override
    public JList<String> getList() {
        return list;
    }
}
