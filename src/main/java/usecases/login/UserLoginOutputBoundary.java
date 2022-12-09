package usecases.login;

public interface UserLoginOutputBoundary {
    void setResponse(String username, String password);
    String getMessage();
}
