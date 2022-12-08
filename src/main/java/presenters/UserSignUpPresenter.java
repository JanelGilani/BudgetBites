package presenters;

import controllers.UserSignUpController;

import javax.swing.*;

public class UserSignUpPresenter extends JLabel implements usecases.signup.UserSignUpOutputBoundary {
    private UserSignUpController userSignUpController;

    public UserSignUpPresenter(UserSignUpController controller) {
        this.setBounds(10, 270, 10000, 55);
        userSignUpController = controller;
    }

    @Override
    public void setResponse(String username, String password, String confirmPassword) {
        int val = userSignUpController.signUpCheck(username, password, confirmPassword);
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
