package ui;

import controllers.UserRegisterController;
import presenters.UserRegisterPresenter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Double.parseDouble;

public class SignUpFrame extends JFrame{
    private static JLabel firstNameLabel;
    private static JTextField firstNameText;
    private static JLabel lastNameLabel;
    private static JTextField lastNameText;
    private static JLabel budgetLabel;
    private static JTextField budgetText;
    private static JLabel userLabel;
    private static JTextField userText;
    private static JLabel passwordLabel;
    private static JPasswordField passwordText;
    private static  JLabel confirmPasswordLabel;
    private static JPasswordField confirmPasswordText;
    private static JButton signUpButton;
    private static JLabel successSignUp;
    private static JButton backButton;

    private UserRegisterPresenter userRegisterPresenter;
    private UserRegisterController userRegisterController;

    public SignUpFrame() {
        userRegisterController = new UserRegisterController();
        userRegisterPresenter = new SignUpResponseLabel(userRegisterController);

        //sign-up frame panel
        JPanel panel = new JPanel();
        this.setTitle("BudgetBites - SignUpFrame");
        this.setSize(420, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);

        panel.setLayout(null);

        firstNameLabel = new JLabel("Enter your First Name:");
        firstNameLabel.setBounds(10, 20, 200, 25);
        panel.add(firstNameLabel);
        firstNameText = new JTextField();
        firstNameText.setBounds(200, 20 , 165, 25);
        panel.add(firstNameText);

        lastNameLabel = new JLabel("Enter your Last Name:");
        lastNameLabel.setBounds(10, 50, 200, 25);
        panel.add(lastNameLabel);
        lastNameText = new JTextField();
        lastNameText.setBounds(200, 50 , 165, 25);
        panel.add(lastNameText);

        budgetLabel = new JLabel("Enter your Budget:");
        budgetLabel.setBounds(10, 80, 200, 25);
        panel.add(budgetLabel);
        budgetText = new JTextField();
        budgetText.setBounds(200, 80 , 165, 25);
        panel.add(budgetText);

        // the user label for user log in text
        userLabel = new JLabel("Enter your UTORid:");
        userLabel.setBounds(10, 110, 200, 25);
        panel.add(userLabel);
        // text field for the user to input their username
        userText = new JTextField();
        userText.setBounds(200, 110 , 165, 25);
        panel.add(userText);

        // the password label for password log in text
        passwordLabel = new JLabel("Enter your new password:");
        passwordLabel.setBounds(10, 140, 200, 25);
        panel.add(passwordLabel);
        // text field for the user to input their password, characters entered will not be visible
        passwordText = new JPasswordField();
        passwordText.setBounds(200, 140 , 165, 25);
        panel.add(passwordText);

        // the confirmation password label for password log in text
        confirmPasswordLabel = new JLabel("Confirm your new password:");
        confirmPasswordLabel.setBounds(10, 170, 200, 25);
        panel.add(confirmPasswordLabel);
        // text field for the user to confirm their password, characters entered will not be visible
        confirmPasswordText = new JPasswordField();
        confirmPasswordText.setBounds(200, 170 , 165, 25);
        panel.add(confirmPasswordText);


        // SignUp button
        signUpButton = new JButton("SignUp");
        signUpButton.setBounds(10, 200, 165, 25);
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = firstNameText.getText();
                String lastName = lastNameText.getText();
                double budget = parseDouble(budgetText.getText());
                String user = userText.getText();
                String password = passwordText.getText();
                String confirmPassword = confirmPasswordText.getText();

                userRegisterPresenter.setResponse(user,password,confirmPassword);

                if (userRegisterPresenter.getMessage().equals("Success")) {
                    exit();
                    userRegisterController.register(firstName, lastName, budget, user, password);
                    RestaurantListFrame restaurantListFrame = new RestaurantListFrame(user);
                }

            }
        });


        panel.add(signUpButton);

        backButton = new JButton("Back");
        backButton.setBounds(10, 230, 165, 25);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exit();
                OnboardingFrame onboardingFrame = new OnboardingFrame();
            }
        });
        panel.add(backButton);


        panel.add((JLabel) userRegisterPresenter);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new SignUpFrame();
    }

    private void exit() {
        this.setVisible(false);
        this.dispose();
    }

}