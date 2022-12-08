//Swami Shriji
package usecases.login;
import usecases.LoginDAI;
import gateways.MainMongoDB;

public class UserLoginInteractor {
    private final LoginDAI loginDAI = new MainMongoDB();

    /**
     * checks the login attempt of the user and returns whether the login is correct
     * @param user inputted by the user
     * @param password inputted by the user
     * @return specific user message based on the password input
     */
    public int loginCheck(String user, String password){
        if (loginDAI.userExists(user)){
            String correctPassword = (String) loginDAI.getUserAttribute(user, "password");
            if (password.equals(correctPassword)){
                return 2;
            } else {
                // incorrect Password
                return 1;
            }
        } else{
            // user doesn't exist
            return 0;
        }
    }

//    public static void Main(String[] args) {
//        UserLoginInteractor.loginCheck("aryangoel24", "goelaryan25");
//    }
}
