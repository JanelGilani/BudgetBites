// Swami Shriji
package usecases.login;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserLoginInteractorTest {
    @Test
    public void userLoggedIn(){
        UserLoginInteractor userLoginInteractor = new UserLoginInteractor();
        assertEquals(2, userLoginInteractor.loginCheck("aryangoel24", "goelaryan25"));
    }

    @Test
    public void userLogInPasswordIncorrect(){
        UserLoginInteractor userLoginInteractor = new UserLoginInteractor();
        assertEquals(1, userLoginInteractor.loginCheck("aryangoel24", "goelaryan2"));
    }

    @Test
    public void userLogInUserDoesNotExist(){
        UserLoginInteractor userLoginInteractor = new UserLoginInteractor();
        assertEquals(0, userLoginInteractor.loginCheck("aryangoel", "goelaryan25"));
    }
}