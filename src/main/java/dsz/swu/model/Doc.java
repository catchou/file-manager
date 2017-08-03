package dsz.swu.model;
import java.util.Date;
public class Doc  {
    private Integer docID;
    private String DocName;
    private Date updateDate;
    private int authorID;
    private String docLabel;

    public Integer getDocID() {
        return docID;
    }
    public void setDocID(Integer docID) {
        this.docID = docID;
    }

    public String getDocName() {
        return DocName;
    }
    public void setDocName(String docName) {
        DocName = docName;
    }

    public Date getUploadDate() {
        return updateDate;
    }
    public void setUploadDate(Date uploadDate) {
        this.updateDate = uploadDate;
    }

    public int getAuthorID() {
        return authorID;
    }
    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }

    public String getDocLabel() {
        return docLabel;
    }

    public void setDocLabel(String docLabel) {
        this.docLabel = docLabel;
    }
}
