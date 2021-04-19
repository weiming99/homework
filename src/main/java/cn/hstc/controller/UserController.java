package cn.hstc.controller;

import cn.hstc.helper.JsonResult;
import cn.hstc.pojo.User;
import cn.hstc.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author chen
 * @crete 2021-04-17-15:43
 */
@Controller
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/user/get")
    @ResponseBody
    public String get(String username, String password, Model model) {
        System.out.println("username+\"\\t\"+password = " + username + "\t" + password);
        User user = userService.get(16);
        model.addAttribute("username", user.getUsername());
        System.out.println("user.getUsername() = " + user.getUsername());
        return "/index";
    }

    @PostMapping(value = "/user/login", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Object login(@RequestBody User user, HttpServletRequest request) {
        // 根据用户名和密码创建token
        UsernamePasswordToken token = new
                UsernamePasswordToken(user.getUsername(), user.getPassword());
        // 获取subject认证主体
        Subject subject = SecurityUtils.getSubject();
        try {
            // 开始认证，这一步会跳到我们自定义的realm中
            subject.login(token);
            request.getSession().setAttribute("user", user);
            return new JsonResult();
        } catch (Exception e) {
            e.printStackTrace();

            request.setAttribute("error", "用户名或密码错误！");
            return new JsonResult("404", "用户名或密码错误");
        }
    }


}
