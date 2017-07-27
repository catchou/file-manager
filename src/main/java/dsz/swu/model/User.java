package dsz.swu.model;

/**
 * 用户表
 */
public class User {
    private int id;
    private String username;
    private String password;

    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getUserName(){
        return this.username;
    }
    public void setUserName(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}
