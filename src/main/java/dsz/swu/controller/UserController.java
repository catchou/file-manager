package dsz.swu.controller;

import dsz.swu.service.UserService;
import dsz.swu.model.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@Scope(value="prototype")
//@RequestMapping("/user")

public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) throws Exception{
        User user = new User();
        user.setUserName(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));

        user = userService.checkLogin(user.getUserName(), user.getPassword());

        if(user!=null){
            model.addAttribute(user);
            session.setAttribute("userID", user.getId());
            session.setAttribute("userName", user.getUserName());
            System.out.println("welcome");
//            try {
//                userService.showUserDocList(user);
//            }catch(Exception ex){
//                ex.printStackTrace();
//            }
            return "Manager_user";// 路径 WEB-INF/pages/welcome.jsp
        }
        System.out.println("fail");
        return "fail";
    }

    @RequestMapping(value="/registerok", method = RequestMethod.POST)
    public void register(HttpServletRequest request, HttpServletResponse response){
        if(userService.checkUserExistByName(request.getParameter("username"))){
            //此用户名已被注册
            System.out.println("用户名已经被注册!");
        }else{
            userService.userRegister(request.getParameter("username"), request.getParameter("password"));
            System.out.println("register username=" + request.getParameter("username"));
            System.out.println("register password=" + request.getParameter("password"));
            System.out.println("注册成功！");
        }

    }
    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String userInfoPage(){
        return "Manager_user";
    }
    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    public String changePassword(HttpServletRequest request, HttpSession session){
        int id = Integer.parseInt(String.valueOf(session.getAttribute("userID")));
        System.out.println("new password:" + request.getParameter("newPassword"));
        userService.changePassword(request.getParameter("newPassword"), id);
        return "redirect:/userInfo";
    }
}
