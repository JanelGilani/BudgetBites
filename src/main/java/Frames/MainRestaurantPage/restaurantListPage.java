package Frames.MainRestaurantPage;

import javax.swing.*;
import java.awt.*;

public class restaurantListPage extends JFrame{
    private JPanel middle;

    private JList restaurants;

    private JScrollPane scroll;

    public restaurantListPage() {
        this.setTitle("Restaurant List");
        this.setSize(420,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);


        middle = new JPanel(new BorderLayout());
        middle.setBackground(Color.WHITE);

        //TODO Use presenter here
        String week[]= { "Monday","Tuesday","Wednesday",
                "Thursday","Friday","Saturday","Sunday", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "Sunday"};


        //create list
        restaurants = new JList(week);

        //set a selected index
        restaurants.setSelectedIndex(2);

        //create scroll plane
        scroll = new JScrollPane();
        scroll.setViewportView(restaurants);

        //configure scroll plane
        restaurants.setLayoutOrientation(JList.VERTICAL);

        //add scroll plane to panel
        middle.add(scroll);

        this.add(middle);
        this.setVisible(true);

        //TODO use controller to update restaurants
    }

    public static void main(String[] args) {
        new restaurantListPage();
    }
}
