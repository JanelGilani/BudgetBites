package usecases;

import entities.User;

public interface LoginDAI {
    boolean userExists (String username);
    void saveUser (User user);
    Object getUserAttribute (String username, String attribute);
}
