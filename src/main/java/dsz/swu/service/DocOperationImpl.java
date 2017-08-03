package dsz.swu.service;

import dsz.swu.dao.DocDao;
import dsz.swu.model.Doc;
import dsz.swu.pojo.UploadStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dsz.swu.dao.UserDao;

@Service("docOperation")
public class DocOperationImpl implements DocOperation{
    @Resource
    private DocDao docDao;
    private UserDao userDao;

    //上传文件并保存文件到数据库
    public int uploadFile(MultipartFile word, HttpSession session, String docLabel) {
        Object idObj = session.getAttribute("userID");

        //获取session中存储的user id
        /*
          **  直接使用session存储用户名而不是根据id去表中查询，效率更高
         */
        //String userName = userDao.getUserNameById(new Integer(id));
        int id = Integer.parseInt(String.valueOf(idObj));
        String userName = (String)session.getAttribute("userName");

        if(!word.isEmpty()){
            //设置目标文件的目录:在/target/file-manager/WEB-INF/upload/${用户名}文件夹下
            String path = session.getServletContext().getRealPath("WEB-INF/upload/" + userName);
            session.setAttribute("path", path);
            //设置目标文件的文件名
            String filename = word.getOriginalFilename();

            if(filename.endsWith(".docx") || filename.endsWith(".doc")){
                /**
                 * 使用复制方式上传文件
                 * @file: 要复制到的目标文件对象
                 */
                File file = new File(path, filename);
                if(!file.exists()){
                    //如果文件夹不存在，则创建文件夹
                    file.mkdirs();
                }

                try{
                    System.out.println(filename);
                    if(docDao.getDocByNameAndAuthorID(filename, id) != null){
                        System.out.println(filename + " already exists");
                    }else{
                        System.out.println(filename + " does not exist");
                        word.transferTo(file);
                        if(file.canRead()){
                            /**
                             * 文件上传成功
                             * 向数据库中插入一条记录
                             */
                            Date updateTime=new Date();
                            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            System.out.println("文件更新时间:" + dateFormat.format(updateTime));
                            docDao.addDocIntoDB(filename, updateTime, id, docLabel);
                        }
                    }

                }catch (Exception ex){
                    ex.printStackTrace();
                }

            }else{
                return UploadStatusCode.uploadFailure;
            }
        }else{
            System.out.println("word is empty");
        }


        return UploadStatusCode.uploadSuccess;
    }

    public void showDocContents(int id) {
    }

    public void deleteDocByDocnameAndAuthorID(String docName, int authorID) {
        docDao.deleteDocFromDB(docName, authorID);
    }

    public List<Doc> getDocListByUserAndLabel(int userID, String docLabel) {
        return docDao.getDocListByUserIDAndDoclabel(userID, docLabel);
    }

    //批量删除文件
    public void batchDeleteDoc(List<Integer> idList, String path) {
        List<String> deleteDocName = new ArrayList<String>();
        List<File> fileList = new ArrayList<File>();
        for(Integer id:idList){
            deleteDocName.add(docDao.getDocNameById(id));
        }
        for(String filename:deleteDocName){
            File file = new File(path, filename);
            if(file.canRead()){
                file.delete();
            }else{
                System.out.println("此路径下没有名为"+filename+"的文件。");
            }
        }

        docDao.batchDeleteDoc(idList);
    }

    public Integer getDocID(int userID, String docName){
        return docDao.getDocIdByUserIDAndDocLabel(userID, docName);
    }
}
