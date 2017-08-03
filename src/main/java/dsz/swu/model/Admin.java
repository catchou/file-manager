package dsz.swu.model;

public class Admin {
    private Integer adminId;
    private String adminPwd;
    private Integer groupId;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminPwd() {
        return adminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Admin() {
        super();
    }

    public Admin(Integer adminId, String adminPwd, Integer groupId) {
        super();
        this.adminId = adminId;
        this.adminPwd = adminPwd;
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "AdminId="+this.adminId+"AdminPwd="+this.adminPwd;
    }
}
