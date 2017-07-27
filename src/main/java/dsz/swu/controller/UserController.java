package dsz.swu.controller;

import dsz.swu.service.UserService;
import dsz.swu.model.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.annotation.Resource;

@Controller
@Scope(value="prototype")
//@RequestMapping("/user")

public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(value="/login", method = RequestMethod.POST)

    public String login(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception{
        User user = new User();
        user.setUserName(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));

        System.out.println("in controller: username=" + user.getUserName());
        System.out.println("in controller: password=" + user.getPassword());

        user = userService.checkLogin(user.getUserName(), user.getPassword());

        if(user!=null){
            model.addAttribute(user);
            System.out.print("welcome");
            return "welcome";// 路径 WEB-INF/pages/welcome.jsp
        }
        System.out.print("fail");
        return "fail";
    }
}
