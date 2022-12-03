package ui;

import controllers.RestaurantFilterController;
import presenters.RestaurantFilteringPresenter;

import javax.swing.*;
import java.awt.*;

public class RestaurantsPanel extends JPanel implements RestaurantFilteringPresenter {
    private JScrollPane scroll;
    private RestaurantFilterController controller;
    public JList<String> list;

    public RestaurantsPanel() {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(420,500));
        scroll = new JScrollPane();
        controller = new RestaurantFilterController();
        list = new JList<>();
    }

    @Override
    public void allRestaurants() {
        DefaultListModel<String> model = new DefaultListModel<>();
        for(String val : controller.getRestaurants("No Preference", "No Preference", "No Preference"))
            model.addElement(val);
        list = new JList<>(model);
        scroll.setViewportView(list);

        list.setLayoutOrientation(JList.VERTICAL);

        this.add(scroll);
    }

    @Override
    public void updateRestaurants(String pricePref, String cuisinePref, String foodTypePref) {
        DefaultListModel<String> updatedModel = new DefaultListModel<>();
        for(String val : controller.getRestaurants(pricePref, cuisinePref, foodTypePref))
            updatedModel.addElement(val);
        list = new JList<>(updatedModel);
        scroll.setViewportView(list);
    }

    @Override
    public JList<String> getList() {
        return list;
    }
}
