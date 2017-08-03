package dsz.swu.dao;
import dsz.swu.model.Doc;
import java.util.List;
import java.util.Date;
import org.apache.ibatis.annotations.Param;

public interface DocDao {
    public Doc getDocByNameAndAuthorID(@Param("docName") String docName, @Param("authorID") int authorID);
    public void addDocIntoDB(@Param("docName") String docName, @Param("updateDate") Date updateDate, @Param("authorID") int authorID, @Param("docLabel") String docLabel);
    public List<Doc> getDocListByUserID(int id);
    public List<Doc> getDocListByUserIDAndDoclabel(@Param("userID") int userID, @Param("docLabel") String docLabel);
    public void deleteDocFromDB(@Param("docName") String docName, @Param("authorID") int authorID);
    public void batchDeleteDoc(List<Integer> idList);
    public Integer getDocIdByUserIDAndDocLabel(@Param("userID") int userID, @Param("docName") String docName);
    public String getDocNameById(Integer docID);
}
