package Frames;

import javax.swing.*;

public class SignUpFrame extends JFrame{

    private static JLabel userLabel;
    private static JTextField userText;
    private static JLabel passwordLabel;
    private static JPasswordField passwordText;
    private static  JLabel confirmPasswordLabel;
    private static JPasswordField confirmPasswordText;
    private static JButton signUpButton;
    private static JLabel successSignUp;

    public SignUpFrame() {

        JPanel panel = new JPanel();
        this.setTitle("BudgetBites - SignUpFrame");
        this.setSize(420, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);

        panel.setLayout(null);


        // the user label for user log in text
        userLabel = new JLabel("Enter your UTORid:");
        userLabel.setBounds(10, 20, 200, 25);
        panel.add(userLabel);
        // text field for the user to input their username
        userText = new JTextField();
        userText.setBounds(200, 20 , 165, 25);
        panel.add(userText);

        // the password label for password log in text
        passwordLabel = new JLabel("Enter your new password:");
        passwordLabel.setBounds(10, 50, 200, 25);
        panel.add(passwordLabel);
        // text field for the user to input their password, characters entered will not be visible
        passwordText = new JPasswordField();
        passwordText.setBounds(200, 50 , 165, 25);
        panel.add(passwordText);

        // the confirmation password label for password log in text
        confirmPasswordLabel = new JLabel("Confirm your new password:");
        confirmPasswordLabel.setBounds(10, 80, 200, 25);
        panel.add(confirmPasswordLabel);
        // text field for the user to confirm their password, characters entered will not be visible
        confirmPasswordText = new JPasswordField();
        confirmPasswordText.setBounds(200, 80 , 165, 25);
        panel.add(confirmPasswordText);


        // login button
        signUpButton = new JButton("SignUp");
        signUpButton.setBounds(10, 110, 80, 25);
        panel.add(signUpButton);

        // login label to return message upon login attempt
        successSignUp = new JLabel();
        successSignUp.setBounds(10, 140, 300, 25);
        panel.add(successSignUp);


        this.setVisible(true);

    }



}
