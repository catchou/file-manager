package dsz.swu.service;
import dsz.swu.model.User;

public interface UserService {
    public User checkLogin(String userName, String password);
}
