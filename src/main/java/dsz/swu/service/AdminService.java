package dsz.swu.service;

import dsz.swu.model.Admin;
import dsz.swu.model.Log;
import dsz.swu.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
public interface AdminService {

    Admin checkLogin(Admin adminId,String password);
    Admin getAdminById(Integer adminId);
    List<User> getAllUser();
    User getUserById(Integer id);
    List<User> getUserByName(String name);
    String getDelete(Integer id);
    void insert(User user);
    List<Log> getAllLog(Integer id);
}
