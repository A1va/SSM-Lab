package com.controller;
/*
 * Created by Nolva on 2020/6/18.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    private Logger LOG = LoggerFactory.getLogger(MainController.class);

//    @RequestMapping("/")
//    public String goMain(){
//        return "dashboard";
//    }

    @RequestMapping("/dashboard")
    public String main(){
        return "dashboard";
    }

//    注销用户，返回首页
    @GetMapping("/logout")
    public String logout(HttpSession session){
//        用户注销，使 session 过期
        session.removeAttribute("activeUser");
        return "redirect:/";
    }

}
