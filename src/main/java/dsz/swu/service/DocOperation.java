package dsz.swu.service;
import javax.servlet.http.HttpSession;
import org.springframework.web.multipart.MultipartFile;
import dsz.swu.model.Doc;
import java.util.List;

public interface DocOperation {
    public int uploadFile(MultipartFile word, HttpSession session, String docLabel);

    public void showDocContents(int id);

    public void deleteDocByDocnameAndAuthorID(String docName, int authorID);

    public List<Doc> getDocListByUserAndLabel(int userID, String docLabel);

    public void batchDeleteDoc(List<Integer> id, String path);

    public Integer getDocID(int userID, String docName);
}
