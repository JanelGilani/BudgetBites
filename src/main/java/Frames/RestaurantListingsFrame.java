package Frames;

import javax.swing.*;

public class RestaurantListingsFrame extends JFrame{
    // Table
    JTable j;

    // Constructor
    public RestaurantListingsFrame() {
        JPanel panel = new JPanel();
        this.setTitle("BudgetBites - Restaurant Listings");
        this.setSize(420, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);


        String[][] data = {
                { "Kundan Kumar Jha", "4031", "CSE", "2.0" },
                { "Anand Jha", "6014", "IT", "5.0" }
        };

        // Column Names
        String[] columnNames = { "Restaurant", "Cuisine", "Price Range", "Rating"};

        // Initializing the JTable
        j = new JTable(data, columnNames);
        j.setBounds(30, 40, 200, 300);

        // adding it to JScrollPane
        JScrollPane sp = new JScrollPane(j);
        this.add(sp);
        // Frame Size
        this.setSize(500, 200);
        // Frame Visible = true
        this.setVisible(true);
    }

    public static void main(String[] args)
    {
        new RestaurantListingsFrame();
    }
}