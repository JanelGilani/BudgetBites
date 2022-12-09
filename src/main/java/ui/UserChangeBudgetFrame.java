package ui;

import presenters.BudgetingPresenter;

import usecases.budgeting.BudgetingInteractor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings({"ALL", "unused"})
public class UserChangeBudgetFrame extends JFrame{


    private final BudgetingInteractor budgetingInteractor = new BudgetingInteractor();
    private static JLabel enterUserNameLabel;
    private static JLabel enterBudgetLabel;
    private static JTextField userNameText;
    private static JTextField budgetText;
    private static JTextField confirmBudgetText;
    private static JLabel confirmBudgetLabel;
    private static JButton enterButton;
    private static JButton backButton;
    private static JLabel successChange;
    private String currentUser;

    private BudgetingPresenter budgetingPresenter;

    public UserChangeBudgetFrame(String currentUser) {
        budgetingPresenter = new BudgetingPresenter();

        JPanel panel = new JPanel();
        this.currentUser = currentUser;
        this.setTitle("Change Budget");
        this.setSize(420, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);

        panel.setLayout(null);


        enterUserNameLabel = new JLabel("Enter Your UTORid:");
        enterUserNameLabel.setBounds(10, 20, 200, 25);
        panel.add(enterUserNameLabel);
        // text field for the user to input their username
        userNameText = new JTextField();
        userNameText.setBounds(200, 20 , 165, 25);
        panel.add(userNameText);

        enterBudgetLabel = new JLabel("Enter New Monthly Budget:");
        enterBudgetLabel.setBounds(10, 50, 200, 25);
        panel.add(enterBudgetLabel);
        budgetText = new JTextField();
        budgetText.setBounds(200, 50 , 165, 25);
        panel.add(budgetText);


        confirmBudgetLabel = new JLabel("Confirm New Monthly Budget:");
        confirmBudgetLabel.setBounds(10, 80, 200, 25);
        panel.add(confirmBudgetLabel);
        confirmBudgetText = new JTextField();
        confirmBudgetText.setBounds(200, 80 , 165, 25);
        panel.add(confirmBudgetText);


        // enter button
        enterButton = new JButton("Enter");
        enterButton.setBounds(10, 115, 80, 25);
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = userNameText.getText();
                double budget = Double.parseDouble(budgetText.getText());
                double confirmBudget = Double.parseDouble(confirmBudgetText.getText());

                budgetingPresenter.setResponse(budget, confirmBudget, userName);
                if (budgetingPresenter.getMessage().equals("Success")) {
                    exit();
                    new UserPageFrame(userName);
                }
                }
            });

        panel.add(enterButton);

        backButton = new JButton("Back");
        backButton.setBounds(10, 150, 80, 25);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exit();
                UserPageFrame userPageFrame = new UserPageFrame(currentUser);
            }
        });
        panel.add(backButton);

        panel.add((JLabel) budgetingPresenter);


        this.setVisible(true);

    }

    private void exit() {
        this.setVisible(false);
        this.dispose();
    }
}
