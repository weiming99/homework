package cn.hstc.controller;

import cn.hstc.pojo.Article;
import cn.hstc.pojo.CommentRecord;
import cn.hstc.service.ArticleService;
import cn.hstc.service.CommentRecordService;
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
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @Resource
    private CommentRecordService commentRecordService;

    @GetMapping("/article/show/{id}")
    public String get(@PathVariable Integer id, Model model, HttpServletRequest request) {
        Article article = articleService.get(id);

        if (article == null) {
            return "/404";
        }
        List<Article> list = articleService.page();
        List<CommentRecord> commentRecordList =commentRecordService.pageByArticleId(article.getId());

        model.addAttribute("article", article);
        model.addAttribute("list", list);
        model.addAttribute("commentRecordList", commentRecordList);

        List<Article> listByNewComment = (List<Article>) request.getSession().getAttribute("articleListByNewComment");
        if (listByNewComment == null || listByNewComment.size()==0){
            List<Article> articleListByNewComment = articleService.pageByNewComment();
            request.getSession().setAttribute("articleListByNewComment", articleListByNewComment);
        }

        return "/show";
    }

    @GetMapping("/article/show/")
    public String toList(Model model) {
        List<String> tags = articleService.getTags();
        List<String> categorys = articleService.getCategorys();

        model.addAttribute("tags",tags);
        model.addAttribute("categorys",categorys);
        return "/list";
    }

    @GetMapping("/article/List/tag/{tag}")
    public String toListByTag(@PathVariable String tag, Model model, HttpServletRequest request) {


        List<Article> list = articleService.pageByTag(tag);
        model.addAttribute("list", list);

        List<Article> listByNewComment = (List<Article>) request.getSession().getAttribute("articleListByNewComment");
        if (listByNewComment == null || listByNewComment.size()==0){
            List<Article> articleListByNewComment = articleService.pageByNewComment();
            request.getSession().setAttribute("articleListByNewComment", articleListByNewComment);
        }
        List<String> tags = articleService.getTags();
        List<String> categorys = articleService.getCategorys();

        model.addAttribute("tags",tags);
        model.addAttribute("categorys",categorys);
        return "/list";
    }

    @GetMapping("/article/List/category/{category}")
    public String toListByCategory(@PathVariable String category, Model model, HttpServletRequest request) {

        List<Article> list = articleService.pageByCategory(category);
        model.addAttribute("list", list);

        List<Article> listByNewComment = (List<Article>) request.getSession().getAttribute("articleListByNewComment");
        if (listByNewComment == null || listByNewComment.size()==0){
            List<Article> articleListByNewComment = articleService.pageByNewComment();
            request.getSession().setAttribute("articleListByNewComment", articleListByNewComment);
        }
        List<String> tags = articleService.getTags();
        List<String> categorys = articleService.getCategorys();

        model.addAttribute("tags",tags);
        model.addAttribute("categorys",categorys);
        return "/list";
    }


}
