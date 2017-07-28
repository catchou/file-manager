package dsz.swu.service;

import dsz.swu.dao.UserDao;
import dsz.swu.model.User;
import dsz.swu.model.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService{
    @Resource
    private UserDao userDao;

    /* 注册 */
    public void userRegister(String userName, String password) {
        userDao.insertUserByNameAndPassword(userName, password);
    }

    /* 登录验证 */
    public User checkLogin(String userName, String password) {
        //根据用户名实例化用户对象
        User user = userDao.findUserByName(userName);
        if(user == null){
            System.out.println("user == null");
        }else{
            System.out.println("user != null");
        }

        System.out.println("user.getUserName:"+user.getUserName());
        System.out.println("user.getPassword:"+user.getPassword());
        System.out.println("userName:"+userName);
        System.out.println("password:"+password);
        //return user;
        if(user.getPassword().equals(password) && user.getUserName().equals(userName)){
            return user;
        }else{
            return null;
        }

    }

    /*查看用户是否存在
     */
    public boolean checkUserExistByName(String username) {
        User user = userDao.findUserByName(username);
        if(user!=null){
            return true;
        }else{
            return false;
        }
    }

    /* 修改密码*/
    public void changePassword(String newPassword) {

    }
}
