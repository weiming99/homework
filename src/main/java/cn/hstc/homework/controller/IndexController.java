package cn.hstc.homework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author chen
 * @create 2021-04-15 17:21
 */
@Controller
public class IndexController {

    @GetMapping({"/","/index"})
    public String toIndex(){
        return  "index";
    }

}