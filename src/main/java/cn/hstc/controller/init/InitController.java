package cn.hstc.controller.init;

import cn.hstc.pojo.Article;
import cn.hstc.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author chen
 * @crete 2021-04-14-22:57
 */
@Controller
public class InitController {

    @Resource
     private ArticleService articleService;

    @GetMapping({"", "/index", "index.html"})
    public String toIndex(HttpServletRequest request) {
        List<Article> list=(List<Article>) request.getSession().getAttribute("list");
        if (list==null||list.size()==0){
            request.getSession().setAttribute("list",articleService.page());
        }
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
