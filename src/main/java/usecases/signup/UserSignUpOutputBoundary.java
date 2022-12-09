package usecases.signup;

public interface UserSignUpOutputBoundary {
    void setResponse(String username, String password, String confirmPassword);
    String getMessage();
}
