package cn.hstc.controller;

import cn.hstc.pojo.Article;
import cn.hstc.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

/**
 * @author chen
 * @crete 2021-04-17-15:43
 */
@Controller
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @GetMapping("/article/show")
    public String get(Model model) {
        Article article = articleService.get(1);
        model.addAttribute("article", article);
        return "/show";
    }


}
