package dsz.swu.service;

import dsz.swu.dao.UserDao;
import dsz.swu.dao.DocDao;
import dsz.swu.model.User;
import dsz.swu.model.Doc;
import org.springframework.stereotype.Service;
import java.util.List;
import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService{
    @Resource
    private UserDao userDao;

    @Resource
    private DocDao docDao;

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
    public void changePassword(String newPassword, int userId) {
        userDao.changePassword(newPassword, userId);
        System.out.println("new password: " + newPassword);
        System.out.println("id: " + userId);
    }

    /* 检查密码是否符合规范*/
    public int isValidPassword(String password){
        int passwordStatusCode = 0;
        if(password.length() <= 6 || password.length() >= 16){
            passwordStatusCode = 1;
        }

        return passwordStatusCode;
    }
    public void showUserDocList(User user) {
        List<Doc> docList = docDao.getDocListByUserID(user.getId());
        for(Doc doc:docList){
            System.out.println("docname=" + doc.getDocName());
            System.out.println("updatetime=" + doc.getUploadDate());
            System.out.println("authorid="+doc.getAuthorID());
        }
    }
}
