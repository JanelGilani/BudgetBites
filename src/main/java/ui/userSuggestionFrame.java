package ui;

import javax.swing.*;
import java.awt.*;


public class userSuggestionFrame extends JFrame {


    public userSuggestionFrame() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        this.setBackground(Color.WHITE);
        this.setTitle("BudgetBites - Suggestions");
        this.setSize(new Dimension(420,600));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);


        JScrollPane scrollPanel = new JScrollPane();
//        this.add(scrollPanel);
        JList<String> r = new JList<>();
        scrollPanel.setViewportView(r);

        r.setLayoutOrientation(JList.VERTICAL);

        panel.add(scrollPanel);


        this.setVisible(true);
    }

    // use for implementation

}
