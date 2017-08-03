package dsz.swu.dao;
import dsz.swu.model.Doc;
import dsz.swu.model.User;
import dsz.swu.model.Log;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    //接口方法，通过用户名得到user对象
    public User findUserByName(String username);

    public void insertUserByNameAndPassword(@Param("username") String username, @Param("password") String password);
    public String getUserNameById(int id);
    public void changePassword(@Param("newPassword") String newPassword, @Param("userId") int userId);

    public void insertUser(User user);
    List<User> selectAllUser();
    User selectUserById(Integer id);
    //删除用户
    int delete(Integer id);
    //用户的模糊查找
    List<User> selectUserByName(String name);

    //Log相关操作
    void insertLog(Log log);
    List<Log> getAllLog(Integer id);

}
