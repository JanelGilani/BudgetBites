package ui;

import presenters.UserLoginPresenter;
import usecases.login.UserLoginInteractor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
@SuppressWarnings({"ALL", "unused"})
public class LoginFrame extends JFrame implements ActionListener{

    private final UserLoginInteractor userLoginInteractor = new UserLoginInteractor();

    private static JLabel userLabel;
    private static JTextField userText;
    private static JLabel passwordLabel;
    private static JPasswordField passwordText;
    private static JButton loginButton;
    private static JButton backButton;
    private static JLabel successLogin;

    private UserLoginPresenter userLoginPresenter;

    public LoginFrame() {

        JPanel panel = new JPanel();
        this.setTitle("BudgetBites");
        this.setSize(420, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);

        panel.setLayout(null);


        // the user label for user log in text
        userLabel = new JLabel("UTORid:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);
        // text field for the user to input their username
        userText = new JTextField();
        userText.setBounds(100, 20 , 165, 25);
        panel.add(userText);

        // the password label for password log in text
        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);
        // text field for the user to input their password, characters entered will not be visible
        passwordText = new JPasswordField();
        passwordText.setBounds(100, 50 , 165, 25);
        panel.add(passwordText);


        // UserLoginInteractor button
        loginButton = new JButton("Login");
        loginButton.setBounds(10, 80, 80, 25);
        loginButton.addActionListener(this);
        panel.add(loginButton);

        backButton = new JButton("Back");
        backButton.setBounds(10, 120, 80, 25);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exit();
                OnboardingFrame onboardingFrame = new OnboardingFrame();
            }
        });
        panel.add(backButton);

        // UserLoginInteractor label to return message upon Login attempt
        userLoginPresenter = new UserLoginPresenter();
        panel.add((JLabel) userLoginPresenter);


        this.setVisible(true);

    }

    private void exit() {
        this.setVisible(false);
        this.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == loginButton){
            String user = userText.getText();
            String password = passwordText.getText();
            userLoginPresenter.setResponse(user,password);

            if (userLoginPresenter.getMessage().equals("Success")) {
                exit();
                RestaurantListFrame restaurantListFrame = new RestaurantListFrame(user);
            }
        }
    }

    public static void main(String[] args) {
        new LoginFrame();
    }
}
