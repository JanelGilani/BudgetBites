import Frames.OnboardingFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main implements ActionListener {


    // makes all usage of the labels and buttons accessible throughout the file by giving a larger scope
    private static JLabel userLabel;
    private static JTextField userText;
    private static JLabel passwordLabel;
    private static JPasswordField passwordText;
    private static JButton loginButton;
    private static JLabel successLogin;




    public static void main(String[] args) {

//        OnboardingFrame onboardingFrame = new OnboardingFrame();


        // formation of the panel and frame for the user log in screen
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setTitle("BudgetBites");
        frame.setSize(420, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);


        // the user label for user log in text
        userLabel = new JLabel("User:");
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


        // login button
        loginButton = new JButton("Login");
        loginButton.setBounds(10, 80, 80, 25);
        loginButton.addActionListener(new main());
        panel.add(loginButton);

        // login label to return message upon login attempt
        successLogin = new JLabel();
        successLogin.setBounds(10, 110, 300, 25);
        panel.add(successLogin);


        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user = userText.getText();
        String password = String.valueOf(passwordText.getPassword());
        System.out.println(user + ", " + password);

        if (user.equals("Darpan") && password.equals("123")){
            successLogin.setText("Login Successful!");
        } else {
            successLogin.setText("Login unsuccessful :(");
        }
    }
}
