package dsz.swu.dao;
import dsz.swu.model.User;

public interface UserDao {
    //接口方法，通过用户名得到user对象
    public User findUserByName(String username);
    public void deleteUserByName(String username);
    public void changePassword();
}
