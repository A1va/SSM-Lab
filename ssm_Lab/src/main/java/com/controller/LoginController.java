package com.controller;
/*
 * Created by Nolva on 2020/6/1.
 */

import com.domain.User;
import com.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    private Logger LOG = LoggerFactory.getLogger(LoginController.class);
    private final IUserService userService;

    public LoginController(IUserService userService) {
        this.userService = userService;
    }


    //    首页--到登录页面
    @GetMapping("/")
    public String index(){
        return "login";
    }

    //    到登录页面
    @GetMapping("/toLogin")
    public String login(){
        return "login";
    }

    @GetMapping("/UserInfo")
    public String UserInfo(Integer id, Model model){
        LOG.info("用户个人信息ID："+id);
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "UserInfo";
    }

    /**
     * 登录提交
     */
    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute User user, HttpSession session, Model model){
        LOG.info("正在进行登录的用户信息: " + user);
//        均正确返回1，密码错误返回-1，用户名不存在返回0
        int flag = userService.userLogin(user);
//        检测用户名和密码，是否为有效用户->1
        if (flag > 0){
            int status = userService.findUserByName(user.getUsername()).getStatus();
            if (status != 1){
                model.addAttribute("msg", "用户状态已关闭，没有权限进行操作！");
                return "login";
            }else {
                LOG.info("用户检测存在且输入正确，登录成功！");
//                向session写入用户信息
                User userByName = userService.findUserByName(user.getUsername());
                if (user.getUsername().equals("admin")){
                    session.setAttribute("admin", user);
                }else {
                    session.setAttribute("activeUser", user);
                }
                LOG.info("登录成功的用户信息："+userByName);
                model.addAttribute("user", userByName);
                return "dashboard";
            }

        }else {
//            用户名或密码错误
//            1. 用户名存在，说明密码错误->(-1)
            if (flag < 0){
                LOG.info("登录失败，密码错误！");
                model.addAttribute("msg", "登录失败，密码错误！");
            }else {
//                2. 用户名不存在->0
                LOG.info("登录失败，用户名不存在！");
                model.addAttribute("msg", "登录失败，用户名不存在！");
            }
            return "login";
        }
    }
}
