package cn.hstc.controller.init;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author chen
 * @crete 2021-04-14-22:57
 */
@Controller
public class InitController {

    @GetMapping({"", "/index", "index.html"})
    public String toIndex() {
        return "/index";
    }

    @GetMapping({"/show", "/show.html"})
    public String toShow() {
        return "/show";
    }

    @GetMapping({"/list", "/list.html"})
    public String toList() {
        return "/list";
    }

    @GetMapping({"/login", "/login.html"})
    public String login() {
        return "/login";
    }

    @GetMapping({"/logout", "/logout.html"})
    public String loginout(HttpServletRequest request) {
        request.getSession().setAttribute("user", null);
        return "/index";
    }

}
