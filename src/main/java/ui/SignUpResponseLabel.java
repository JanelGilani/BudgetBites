package ui;

import controllers.UserRegisterController;
import presenters.UserRegisterPresenter;

import javax.swing.*;

public class SignUpResponseLabel extends JLabel implements UserRegisterPresenter {
    private UserRegisterController userRegisterController;

    public SignUpResponseLabel(UserRegisterController controller) {
        this.setBounds(10, 270, 10000, 55);
        userRegisterController = controller;
    }

    @Override
    public void setResponse(String username, String password, String confirmPassword) {
        int val = userRegisterController.signUpCheck(username, password, confirmPassword);
        if (val == 3) {
            this.setText("Success");
        } else if (val == 2) {
            this.setText("Password is not strong enough");
        } else if (val == 1) {
            this.setText("Passwords do not match");
        } else if (val == 0) {
            this.setText("Username already exists.");
        }
    }

    @Override
    public String getMessage() {
        return this.getText();
    }
}
