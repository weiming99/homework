package cn.hstc.controller;

import cn.hstc.pojo.Article;
import cn.hstc.service.ArticleService;
import cn.hstc.service.SchoolService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author chen
 * @crete 2021-04-17-15:43
 */
@Controller
public class SchoolController {

    @Resource
    private ArticleService articleService;

    @Resource
    private SchoolService schoolService;

    @GetMapping({"/schoollist.html", "/schoollist"})
    public String get(Model model, HttpServletRequest request) {
        List<Article> listByNewComment = (List<Article>) request.getSession().getAttribute("articleListByNewComment");
        if (listByNewComment == null || listByNewComment.size() == 0) {
            List<Article> articleListByNewComment = articleService.pageByNewComment();
            request.getSession().setAttribute("articleListByNewComment", articleListByNewComment);
        }

        model.addAttribute("list", schoolService.getList());

        return "/schoollist";
    }

    @GetMapping("/school/show/{id}")
    public String get(@PathVariable Integer id, Model model, HttpServletRequest request) {
        List<Article> listByNewComment = (List<Article>) request.getSession().getAttribute("articleListByNewComment");
        if (listByNewComment == null || listByNewComment.size() == 0) {
            List<Article> articleListByNewComment = articleService.pageByNewComment();
            request.getSession().setAttribute("articleListByNewComment", articleListByNewComment);
        }

        model.addAttribute("school", schoolService.get(id));

        return "/schoolshow";
    }


}
