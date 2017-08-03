package dsz.swu.service;
import dsz.swu.model.User;

public interface UserService {
    //登录验证
    public User checkLogin(String userName, String password);
    //查看用户是否存在
    public boolean checkUserExistByName(String username);
    //用户注册
    public void userRegister(String userName, String password);
    //修改密码
    public void changePassword(String newPassword, int userId);
    //查看用户上传的文件
    public void showUserDocList(User user);
}
