package cn.hstc.homework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author chen
 * @create 2021-04-15 17:21
 */
@Controller
public class IndexController {

    @GetMapping({"/","/index","/index.html"})
    public String toIndex(){
        return  "index";
    }


    @GetMapping({"/show","/show.html"})
    public String toShow(){
        return  "show";
    }

    @GetMapping({"/list","/list.html"})
    public String toList(){
        return  "list";
    }

    @GetMapping({"/404","/404.html"})
    public String to404(){
        return  "404";
    }


}