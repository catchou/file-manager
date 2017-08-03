package dsz.swu.dao;

import dsz.swu.model.Admin;
import dsz.swu.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminDao {
    Admin getAdminById(Integer adminId);
}

