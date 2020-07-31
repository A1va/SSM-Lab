package com.controller;
/*
 * Created by Nolva on 2020/6/2.
 */

import com.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // 由于@RestController注解，将list转成json格式返回
@Controller
public class AjaxController {

    private Logger LOG = LoggerFactory.getLogger(AjaxController.class);
    private final IUserService userService;

    public AjaxController(IUserService userService) {
        this.userService = userService;
    }


    @RequestMapping("/testRegisterName")
    public String testRegisterName(String name){
        String msg = "";
        LOG.info("testRegisterName...");
        if (name != null && !"".equals(name)){
//            用户名应该在数据库中查
            if (userService.findUserByName(name) != null){
                msg = "用户名已存在";
            }else {
                msg = "有效的用户名";
            }
        }else {
            msg = "用户名不能为空";
        }
        return msg;
    }

    @RequestMapping("/testRegisterPwd")
    public String testRegisterPwd(String password){
        String msg = "";
        LOG.info("testRegisterPwd:");
        if (password != null && !"".equals(password)){
            int length = password.length();
            if (length > 8 && length < 16){
                msg = "密码符合规则";
            }else {
                msg = "密码长度需在8-16位之间";
            }
        }else {
            msg = "密码不能为空";
        }
        return msg;
    }
}
