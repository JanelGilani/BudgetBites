package ui;

import controllers.RestaurantFilterController;
import presenters.RestaurantFilteringPresenter;

import javax.swing.*;
import java.awt.*;

public class RestaurantsPanel implements RestaurantFilteringPresenter {
    private JPanel panel;
    private JScrollPane scroll;
    private RestaurantFilterController controller;

    public RestaurantsPanel() {
        panel = new JPanel();
        panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.setPreferredSize(new Dimension(420,500));
        scroll = new JScrollPane();
        controller = new RestaurantFilterController();
    }

    @Override
    public JPanel allRestaurants() {
        DefaultListModel<String> model = new DefaultListModel<>();
        for(String val : controller.getRestaurants("No Preference", "No Preference", "No Preference"))
            model.addElement(val);
        JList<String> r = new JList<>(model);
        scroll.setViewportView(r);

        r.setLayoutOrientation(JList.VERTICAL);

        panel.add(scroll);
        return panel;
    }

    @Override
    public JPanel updateRestaurants(String pricePref, String cuisinePref, String foodTypePref) {
        DefaultListModel<String> updatedModel = new DefaultListModel<>();
        for(String val : controller.getRestaurants(pricePref, cuisinePref, foodTypePref))
            updatedModel.addElement(val);
        JList<String> r = new JList<>(updatedModel);
        scroll.setViewportView(r);
        return panel;
    }
}
