package dsz.swu.model;
import java.util.Date;
public class Doc  {
    private int docID;
    private String DocName;
    private String DocLabel;
    private Date uploadDate;
    private Date lastEditDate;
    private int authorID;

    public int getDocID() {
        return docID;
    }
    public void setDocID(int docID) {
        this.docID = docID;
    }

    public String getDocName() {
        return DocName;
    }
    public void setDocName(String docName) {
        DocName = docName;
    }

    public String getDocLabel() {
        return DocLabel;
    }

    public void setDocLabel(String docLabel) {
        DocLabel = docLabel;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Date getLastEditDate() {
        return lastEditDate;
    }

    public void setLastEditDate(Date lastEditDate) {
        this.lastEditDate = lastEditDate;
    }

    public int getAuthorID() {
        return authorID;
    }

    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }
}
