package Frames;

import Use_Cases.Filtering.RestaurantFiltering.RestaurantFilteringPresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserPreferenceFrame extends JFrame implements ActionListener {
    private static JLabel userPriceLabel;
    private static JComboBox userPriceText;
    private static JLabel userCuisineLabel;
    private static JComboBox UserCuisineText;
    private static JLabel userMealLabel;
    private static JComboBox userMealText;
    private static JButton submitButton;
    private JPanel restaurants;

    private RestaurantFilteringPresenter restaurantPresenter;

    public UserPreferenceFrame() {

        JPanel panel = new JPanel();
        this.setTitle("BudgetBites-UserPreference");
        this.setSize(420, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        panel.setPreferredSize(new Dimension(100, 100));

        // the user label for user price preference text
        userPriceLabel = new JLabel("Price Preference");
        userPriceLabel.setBounds(10, 20, 120, 25);
        panel.add(userPriceLabel);
        // combobox for the user to choose their price preference
        String[] priceRanges = {"No Preference", "Cheap", "Intermediate", "Expensive"};
        userPriceText = new JComboBox(priceRanges);
        userPriceText.setBounds(140, 20 , 165, 25);
        panel.add(userPriceText);

        // the user label for cuisine preference text
        userCuisineLabel = new JLabel("Cuisine Preference:");
        userCuisineLabel.setBounds(10, 50, 120, 25);
        panel.add(userCuisineLabel);
        // combobox for the user to choose their cuisine preference
        String[] cuisines = {"No Preference", "Italian", "Chinese", "Thai", "French", "Arabic", "Mexican", "Indian", "Middle-East"};
        UserCuisineText = new JComboBox(cuisines);
        UserCuisineText.setBounds(140, 50 , 165, 25);
        panel.add(UserCuisineText);

        // the user label for user meal preference text
        userMealLabel = new JLabel("Meal Preference");
        userMealLabel.setBounds(10, 80, 120, 25);
        panel.add(userMealLabel);
        // combobox for the user to choose their meal preference
        String[] meals = {"No Preference", "Breakfast", "Lunch", "Dinner", "Snack"};
        userMealText = new JComboBox(meals);
        userMealText.setBounds(140, 80 , 165, 25);
        panel.add(userMealText);


        // Submit button.
        submitButton = new JButton("Submit Preferences");
        submitButton.setBounds(10, 110, 160, 25);
        submitButton.addActionListener(this);
        panel.add(submitButton);
        this.add(panel);

        restaurantPresenter = new restaurantsPanel();
        restaurants = restaurantPresenter.allRestaurants();
        this.add(restaurants);

        this.pack();
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new UserPreferenceFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.remove(restaurants);
        restaurants = restaurantPresenter.updateRestaurants((String) userPriceText.getSelectedItem(), (String) UserCuisineText.getSelectedItem(), (String) userMealText.getSelectedItem());
        this.add(restaurants);
        this.validate();
    }
}
