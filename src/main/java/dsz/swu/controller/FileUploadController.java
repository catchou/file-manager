package dsz.swu.controller;

import dsz.swu.pojo.UploadStatusCode;
import dsz.swu.service.DocOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

import dsz.swu.pojo.FileMeta;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dsz.swu.model.Doc;

import javax.annotation.Resource;

@Controller
public class FileUploadController extends HttpServlet{
    @Autowired
    private ServletContext servletContext;

    @Resource
    private DocOperation docOperation;

//
     /*
          * @param files 上传文件 MultipartFile 的对象数组
          * @return 成功上传文件的信息, [{"fileName":"app_engine-85x77.png","fileSize":"8 Kb","fileType":"image/png"}, ...]
      */
    @RequestMapping(value = "/file-upload-info", method = RequestMethod.POST)
    public LinkedList<FileMeta> infoUpLoadFiles(@RequestParam("files") MultipartFile[] files){
        LinkedList<FileMeta> uploadedFiles = new LinkedList<FileMeta>();

        return uploadedFiles;
    }

    /**
     * 上传文件
     * transferTo上传文件要点：
     * 1. 如果目录不存在会报错
     * 2. 同名文件会自动覆盖
     */
    @RequestMapping(value = "/file-upload", method = RequestMethod.GET)
    public String fileUploadPage(HttpSession session){
        String docLabel = String.valueOf(session.getAttribute("docLabel"));
        return("Manage_u" + docLabel);
    }

    @RequestMapping(value = "/file-upload", method = RequestMethod.POST)
    public String uploadFiles(@RequestParam(value = "file", required = false) MultipartFile file, HttpSession session, HttpServletRequest request, RedirectAttributes redirect) throws ServletException, IOException{
        ModelAndView mav = new ModelAndView();
        mav.setViewName("success");
        String docLabel = request.getParameter("docLabel");
        session.setAttribute("docLabel", docLabel);
        redirect.addFlashAttribute("docLabel", docLabel);
        try{
            if(docOperation.uploadFile(file, session, docLabel) == UploadStatusCode.uploadSuccess){
                System.out.println("上传成功");
                redirect.addFlashAttribute("uploadState", "success");
                return "redirect:/file-upload";
            }else{
                redirect.addFlashAttribute("uploadState", "fail");
                return "fail";
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return "WEB-INF/jsp/Manage_u"+docLabel+".jsp";
    }

    @RequestMapping(value = "/test-forward", method = RequestMethod.POST)
    public void testForward(){
        System.out.println("重定向到这个url");
    }

    @RequestMapping(value = "/show-files", method = RequestMethod.POST)
    public ModelAndView showFileList(@RequestParam(value = "docLabel", required = false) String docLabel, HttpSession session){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Manage_u"+docLabel);
        int userID=Integer.parseInt(String.valueOf(session.getAttribute("userID")));
        //System.out.println("userid = " + userID);
        List<Doc> docList = docOperation.getDocListByUserAndLabel(userID, docLabel);
        if(docList.isEmpty()){
            System.out.println("doclist is empty");
        }else{
            System.out.println("doclist size: " + docList.size());
        }
//        for(Doc doc:docList){
//            System.out.println("docid = "+ docOperation.getDocID(doc.getAuthorID(), doc.getDocName()));
//        }
        List<Integer> docIdList = new ArrayList<Integer>();
        for(Doc doc:docList){
            docIdList.add(Integer.valueOf(docOperation.getDocID(doc.getAuthorID(), doc.getDocName())));
        }

        for(Integer id:docIdList){
            System.out.println("doc id = " + id);
        }
        session.setAttribute("docIdList", docIdList);
        mav.addObject("docList", docList);
        mav.addObject("docIdList", docIdList);
        return mav;
    }
    private static String makeFileName(String filename){
        //为防止文件覆盖的现象发生，要为上传文件产生一个唯一的文件名
        System.out.println(UUID.randomUUID().toString()+"_"+filename);
        return UUID.randomUUID().toString() + "_" + filename;
    }


    @RequestMapping(value="/delete-file", method = RequestMethod.POST)
    public void deleteFile(String docName, int authorID){
        //delete file
        //docOperation.deleteDocByDocnameAndAuthorID(docName, authorID);
        System.out.println("delete");
    }

    @RequestMapping(value = "/batch-delete-file", method = RequestMethod.POST)
    public String batchDeleteFile(HttpSession session){
        List<Integer> list = new ArrayList<Integer>();
        String path = String.valueOf(session.getAttribute("path"));
        docOperation.batchDeleteDoc(list, path);
        return "redirect:/";
    }

    /**
    * 为防止一个目录下面出现太多文件，要使用hash算法打散存储
    * @Method: makePath
     */
    private String makePath(String filename,String savePath){
        //得到文件名的hashCode的值，得到的就是filename这个字符串对象在内存中的地址
        int hashcode = filename.hashCode();
        int dir1 = hashcode&0xf; //0--15
        int dir2 = (hashcode&0xf0)>>4; //0-15
        //构造新的保存目录
        String dir = savePath + "\\" + dir1 + "\\" + dir2; //upload\2\3 upload\3\5
        //File既可以代表文件也可以代表目录
        File file = new File(dir);
        //如果目录不存在
        if(!file.exists()){
            //创建目录
            file.mkdirs();
        }
        return dir;
    }


}
