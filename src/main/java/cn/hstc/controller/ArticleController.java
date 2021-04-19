package cn.hstc.controller;

import cn.hstc.pojo.Article;
import cn.hstc.service.ArticleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chen
 * @crete 2021-04-17-15:43
 */
@Controller
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @GetMapping("/article/show/{id}")
    public String get(@PathVariable Integer id, Model model) {
        Article article = articleService.get(id);
        List<Article> list=articleService.page();
        if (article==null){
            return "/404";
        }
        model.addAttribute("article", article);
        model.addAttribute("list", list);
        return "/show";
    }


}
