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
}
