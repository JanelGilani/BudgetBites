// Swami Shriji
package usecases.login;

import org.junit.Test;
import usecases.signup.UserSignUpInteractor;

import static org.junit.jupiter.api.Assertions.*;

public class UserSignUpInteractorTest {
    @Test
    public void extremelyWeakPassword(){
        UserSignUpInteractor signUp = new UserSignUpInteractor();
        assertFalse(signUp.strongPassword("pass"));
    }

    @Test
    public void weakPasswordHasUpper(){
        UserSignUpInteractor signUp = new UserSignUpInteractor();
        assertFalse(signUp.strongPassword("Pass"));
    }

    @Test
    public void weakPasswordHasUpperDig(){
        UserSignUpInteractor signUp = new UserSignUpInteractor();
        assertFalse(signUp.strongPassword("Pass123"));
    }

    @Test
    public void weakPasswordHasUpperDigSpecChar(){
        UserSignUpInteractor signUp = new UserSignUpInteractor();
        assertFalse(signUp.strongPassword("Pass_123"));
    }

    @Test
    public void strongPassword(){
        UserSignUpInteractor signUp = new UserSignUpInteractor();
        assertTrue(signUp.strongPassword("Password_123"));
    }

    @Test
    public void differentPassword(){
        UserSignUpInteractor signUp = new UserSignUpInteractor();
        assertFalse(signUp.samePassword("Password_123", "Password_1234"));
    }

    @Test
    public void samePassword(){
        UserSignUpInteractor signUp = new UserSignUpInteractor();
        assertTrue(signUp.samePassword("Password_123", "Password_123"));
    }

    @Test
    public void userExistsResult(){
        UserSignUpInteractor signUp = new UserSignUpInteractor();
        assertEquals(0, signUp.signUpCheck("aryangoel24", "Password_123", "Password_123"));
    }

    @Test
    public void differentPasswordResult(){
        UserSignUpInteractor signUp = new UserSignUpInteractor();
        assertEquals(1, signUp.signUpCheck("vandanpat123", "Password_123", "Password_132"));
    }

    @Test
    public void weakPasswordResult(){
        UserSignUpInteractor signUp = new UserSignUpInteractor();
        assertEquals(2, signUp.signUpCheck("vandanpat123", "Password", "Password"));
    }

    @Test
    public void signUpResult(){
        UserSignUpInteractor signUp = new UserSignUpInteractor();
        assertEquals(3, signUp.signUpCheck("vandanpat123", "Password_123", "Password_123"));
    }
}