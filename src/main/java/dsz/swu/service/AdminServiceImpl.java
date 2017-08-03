package dsz.swu.service;

import dsz.swu.dao.AdminDao;
import dsz.swu.dao.UserDao;
import dsz.swu.model.Admin;
import dsz.swu.model.Log;
import dsz.swu.model.User;
import dsz.swu.service.AdminService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminDao adminDao;
    @Resource
    private UserDao userDao;

    public User getUserById(Integer userId) {
        return userDao.selectUserById(userId);
    }

    public List<User> getAllUser() {
        return userDao.selectAllUser();
    }

    public void insert(User user){
        userDao.insertUser(user);
    }

    public String getDelete(Integer id){

        int u=userDao.delete(id);
        String msg="";
        if (u>0){
            msg="删除成功";
        }else {
            msg="删除失败";
        }
        return msg;
    }

    public Admin getAdminById(Integer adminId) {
        Admin admin=adminDao.getAdminById(adminId);
        return admin;
    }

    public Admin checkLogin(Admin admin,String password) {
        if (admin.getAdminPwd().equals(password)){
            return admin;
        }
        return null;
    }

    public List<Log> getAllLog(Integer id) {
        return userDao.getAllLog(id);
    }

    public List<User> getUserByName(String name) {
        return userDao.selectUserByName(name);
    }
}
