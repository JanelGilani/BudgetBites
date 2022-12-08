package presenters;

import controllers.UserLoginController;

import javax.swing.*;

public class UserLoginPresenter extends JLabel implements usecases.login.UserLoginOutputBoundary {
    private UserLoginController userLoginController;

    public UserLoginPresenter() {
        this.setBounds(10, 160, 300, 25);
        userLoginController = new UserLoginController();
    }

    @Override
    public void setResponse(String username, String password) {
        int val = userLoginController.loginCheck(username, password);
        if (val == 2) {
            this.setText("Success");
        } else if (val == 1) {
            this.setText("Incorrect Password");
        } else if (val == 0) {
            this.setText("Username Does Not Exist");
        }
    }

    @Override
    public String getMessage() {
        return this.getText();
    }
}
