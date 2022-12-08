package presenters;

public interface UserRegisterPresenter {
    void setResponse(String username, String password, String confirmPassword);
    String getMessage();
}
