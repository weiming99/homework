package cn.hstc.controller.init;

import cn.hstc.pojo.Article;
import cn.hstc.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        List<Article> list = (List<Article>) request.getSession().getAttribute("list");
        if (list == null || list.size() == 0) {
            request.getSession().setAttribute("list", articleService.page());
        }
        List<Article> listByNewComment = (List<Article>) request.getSession().getAttribute("articleListByNewComment");
        if (listByNewComment == null || listByNewComment.size() == 0) {
            List<Article> articleListByNewComment = articleService.pageByNewComment();
            request.getSession().setAttribute("articleListByNewComment", articleListByNewComment);
        }

        return "/index";
    }

    @GetMapping({"/show", "/show.html"})
    public String toShow(Model model, HttpServletRequest request) {
        Object list1 = model.getAttribute("list");
        Object article = model.getAttribute("article");
        if (list1 == null || article == null) {
            List<Article> list = articleService.page();
            model.addAttribute("list", list);
            List<String> tags = articleService.getTags();
            List<String> categorys = articleService.getCategorys();

            model.addAttribute("tags", tags);
            model.addAttribute("categorys", categorys);
            return "/list";
        }
        List<Article> listByNewComment = (List<Article>) request.getSession().getAttribute("articleListByNewComment");
        if (listByNewComment == null || listByNewComment.size() == 0) {
            List<Article> articleListByNewComment = articleService.pageByNewComment();
            request.getSession().setAttribute("articleListByNewComment", articleListByNewComment);
        }

        return "/show";
    }

    @GetMapping({"/list", "/list.html"})
    public String toList(Model model, HttpServletRequest request) {
        List<Article> list1 = (List<Article>) model.getAttribute("list");
        if (list1 == null || list1.size() == 0) {
            model.addAttribute("list", articleService.page());
        }
        List<Article> listByNewComment = (List<Article>) request.getSession().getAttribute("articleListByNewComment");
        if (listByNewComment == null || listByNewComment.size() == 0) {
            List<Article> articleListByNewComment = articleService.pageByNewComment();
            request.getSession().setAttribute("articleListByNewComment", articleListByNewComment);
        }
        List<String> tags = articleService.getTags();
        List<String> categorys = articleService.getCategorys();

        model.addAttribute("tags", tags);
        model.addAttribute("categorys", categorys);

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

    @GetMapping({"/404", "/404.html"})
    public String error() {
        return "/404";
    }
}
