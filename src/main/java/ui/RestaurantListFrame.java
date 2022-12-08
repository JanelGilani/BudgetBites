package ui;

import controllers.FoodSuggestionsController;
import gateways.MainMongoDB;
import presenters.FoodSuggestionsPresenter;
import presenters.RestaurantFilterPresenter;
import usecases.SuggestionToUserDAI;
import usecases.foodsuggestions.FoodSuggestionsInteractor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestaurantListFrame extends JFrame implements ActionListener {
    private static JLabel userPriceLabel;
    private static JComboBox userPriceText;
    private static JLabel userCuisineLabel;
    private static JComboBox UserCuisineText;
    private static JLabel userMealLabel;
    private static JButton profileButton;
    private static JComboBox userMealText;
    private static JButton submitButton;

    private static JButton userSuggestion;

    private RestaurantFilterPresenter restaurantPresenter;

    private static JButton pickRestaurant;
    private static JPanel bottom;
    private String currentUser;

    public RestaurantListFrame(String currentUser) {

        this.currentUser = currentUser;

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
        String[] priceRanges = {"No Preference", "Cheap ($5-$10)", "Intermediate ($10-$20)", "Expensive (20+)"};
        userPriceText = new JComboBox(priceRanges);
        userPriceText.setBounds(140, 20 , 165, 25);
        panel.add(userPriceText);

        // the user label for cuisine preference text
        userCuisineLabel = new JLabel("Cuisine Preference:");
        userCuisineLabel.setBounds(10, 50, 120, 25);
        panel.add(userCuisineLabel);
        // combobox for the user to choose their cuisine preference
        String[] cuisines = {"No Preference", "Italian", "Chinese", "Mexican", "Indian", "Middle-East"};
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

        profileButton = new JButton("Profile");
        profileButton.setBounds(10, 140, 165, 25);
        profileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exit();
                UserPageFrame userPageFrame = new UserPageFrame(currentUser);
            }
        });
        panel.add(profileButton);

        restaurantPresenter = new RestaurantFilterPresenter();
        restaurantPresenter.allRestaurants();
        this.add((JPanel) restaurantPresenter);

        bottom = new JPanel();
        pickRestaurant = new JButton("Pick Restaurant");
        pickRestaurant.setBounds(10, 110, 160, 25);
        pickRestaurant.addActionListener(this);
        bottom.add(pickRestaurant);

        userSuggestion = new JButton("Food Suggestions");
        userSuggestion.setBounds(10, 110, 180, 25);
        userSuggestion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exit();
                SuggestionToUserDAI dataBase = new MainMongoDB();
                FoodSuggestionsPresenter presenter = new FoodSuggestionsPresenter();
                FoodSuggestionsInteractor foodSuggestionsInteractor = new FoodSuggestionsInteractor(dataBase);
                FoodSuggestionsController controller = new FoodSuggestionsController();
                userSuggestionFrame test = new userSuggestionFrame(currentUser);

                controller.setUseCase(foodSuggestionsInteractor);
                foodSuggestionsInteractor.setPresenter(presenter);
                presenter.setViewer(test);
                test.setFoodSuggestionsController(controller);
                controller.callUseCase(currentUser);
            }
        });
        bottom.add(userSuggestion);
        this.add(bottom);

        this.pack();
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new RestaurantListFrame("darpanmi");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == submitButton) {
            restaurantPresenter.updateRestaurants((String) userPriceText.getSelectedItem(), (String) UserCuisineText.getSelectedItem(), (String) userMealText.getSelectedItem());
            this.validate();
        } else if (obj == pickRestaurant) {
            JList<String> selection = restaurantPresenter.getList();
            String restaurant = selection.getSelectedValue();
            if (restaurant.length() > 0) {
                exit();
                new FoodItemsFrame(restaurant, this.currentUser);
            }
        }
    }

    private void exit() {
        this.setVisible(false);
        this.dispose();
    }
}
