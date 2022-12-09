// Swami Shriji
package usecases.login;

import org.junit.Test;
import usecases.signup.UserSignUpInteractor;

import static org.junit.jupiter.api.Assertions.*;

public class UserSignUpInteractorTest {
    /**
     * Tests that the inputted password is extremely weak password and matches no strong password criteria such as
     * uppercase, digit and special character
     */
    @Test
    public void extremelyWeakPassword(){
        UserSignUpInteractor signUp = new UserSignUpInteractor();
        assertFalse(signUp.strongPassword("pass"));
    }

    /**
     * Tests that the inputted password is a weak password and matches only has an uppercase
     */
    @Test
    public void weakPasswordHasUpper(){
        UserSignUpInteractor signUp = new UserSignUpInteractor();
        assertFalse(signUp.strongPassword("Pass"));
    }

    /**
     * Tests that the inputted password is a weak password and matches has an uppercase, and a digit
     */
    @Test
    public void weakPasswordHasUpperDig(){
        UserSignUpInteractor signUp = new UserSignUpInteractor();
        assertFalse(signUp.strongPassword("Pass123"));
    }

    /**
     * Tests that the inputted password is a weak password and matches has an uppercase, a digit, and a special
     * character
     */
    @Test
    public void weakPasswordHasUpperDigSpecChar(){
        UserSignUpInteractor signUp = new UserSignUpInteractor();
        assertFalse(signUp.strongPassword("Pass_123"));
    }

    /**
     * Tests that the inputted password is a strong password with uppercase, digit, special character and 10 or more
     * characters
     */
    @Test
    public void strongPassword(){
        UserSignUpInteractor signUp = new UserSignUpInteractor();
        assertTrue(signUp.strongPassword("Password_123"));
    }

    /**
     * Tests the samePassword method by returning false for two different passwords
     */
    @Test
    public void differentPassword(){
        UserSignUpInteractor signUp = new UserSignUpInteractor();
        assertFalse(signUp.samePassword("Password_123", "Password_1234"));
    }

    /**
     * Tests the samePassword method by returning true for same passwords
     */
    @Test
    public void samePassword(){
        UserSignUpInteractor signUp = new UserSignUpInteractor();
        assertTrue(signUp.samePassword("Password_123", "Password_123"));
    }

    /**
     * Tests checks if user can sign up. This case returns 0 as the user already exits in database
     */
    @Test
    public void userExistsResult(){
        UserSignUpInteractor signUp = new UserSignUpInteractor();
        assertEquals(0, signUp.signUpCheck("aryangoel24", "Password_123", "Password_123"));
    }

    /**
     * Tests checks if user can sign up. This case returns 1 since samePassword is false
     */
    @Test
    public void differentPasswordResult(){
        UserSignUpInteractor signUp = new UserSignUpInteractor();
        assertEquals(1, signUp.signUpCheck("vandanpat123", "Password_123", "Password_132"));
    }

    /**
     * Tests checks if user can sign up. This case returns 2 since strongPassword is false
     */
    @Test
    public void weakPasswordResult(){
        UserSignUpInteractor signUp = new UserSignUpInteractor();
        assertEquals(2, signUp.signUpCheck("vandanpat123", "Password", "Password"));
    }

    /**
     * Tests checks if user can sign up. This case returns 3 and allows user to signup
     */
    @Test
    public void signUpResult(){
        UserSignUpInteractor signUp = new UserSignUpInteractor();
        assertEquals(3, signUp.signUpCheck("vandanpat123", "Password_123", "Password_123"));
    }
}