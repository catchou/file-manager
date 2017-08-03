package dsz.swu.model;
import java.util.List;
/**
 * 用户表
 */
public class User {
    private int id;
    private String username;
    private String password;
    private List<Doc> docList;

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

    public List<Doc> getDocList() {
        return docList;
    }

    public void setDocList(List<Doc> docList) {
        this.docList = docList;
    }

}
