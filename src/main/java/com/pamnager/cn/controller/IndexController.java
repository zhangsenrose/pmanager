package com.pamnager.cn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @RequestMapping("login")
    public String login(){
        return "login";
    }
    @RequestMapping("filelist")
    public String filelist(){
        return "filelist";
    }

}
