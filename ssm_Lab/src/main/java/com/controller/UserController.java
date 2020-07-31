package com.controller;
/*
 * Created by Nolva on 2020/7/8.
 */

import com.domain.Role;
import com.domain.User;
import com.github.pagehelper.PageInfo;
import com.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private Logger LOG = LoggerFactory.getLogger(UserController.class);
    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    /**
     * findUserByIdAndAllRole之后为用户添加相应的角色
     * @param userId
     * @param roleIds
     * @return
     */
    @PostMapping("/addRoleToUser")
    public String addRoleToUser(@RequestParam(name = "userId", required = true) Integer userId, @RequestParam(name = "ids", required = true) Integer[] roleIds) {
        userService.addRoleToUser(userId, roleIds);
        return "redirect:findAll";
    }

    /**
     * 查询用户以及用户可以添加的角色
     * 1. 根据userId查询用户
     * 2. 根据userId查询用户可以添加的角色
     * 3. 给用户添加角色
     * @param userId
     * @param model
     * @return
     */
    @GetMapping("/findUserByIdAndAllRole")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id", required = true) Integer userId, Model model) {

        ModelAndView mv = new ModelAndView();
//        1.根据用户ID查询用户
        User user = userService.findById(userId);
//        2.根据用户ID查询可以添加的角色
        List<Role> otherRoles = userService.findOtherRoles(userId);
        mv.addObject("user", user);
        mv.addObject("roleList", otherRoles);
        mv.setViewName("addUserRole");
        return mv;
    }

    @GetMapping("/findAll")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "5") Integer size, Model model) {
        List<User> users = userService.findAllByPage(page, size);
        //PageInfo就是一个分页Bean
        PageInfo<User> pageInfo = new PageInfo<>(users);
        model.addAttribute("pageInfo", pageInfo);
        return "userList";
    }

    /**
     * 产品添加
     *
     * @return
     */
    @GetMapping("/goSave")
    public String save() {
        return "saveUser";
    }

    @PostMapping("/save")
    public String saveUser(User user) {
        userService.saveUser(user);
        return "redirect:findAll";
    }

    /**
     * 查询指定的id的用户
     *
     * @param userId
     * @return
     */
    @GetMapping("/findById")
    public String findById(@RequestParam(name = "id", required = true) Integer userId, Model model) {
        User user = userService.findById(userId);
        model.addAttribute("user", user);
        return "userDetails";
    }

    @GetMapping("/goUpdate")
    public String goUpdate(Integer id, Model model){
        User user = userService.findById(id);
        LOG.info("正在修改的用户：" + user);
        model.addAttribute("user", user);
        return "updateUser";
    }

    /**
     * 产品添加
     * @return
     */
    @PostMapping("/update")
    public String updateUser(User user){
        LOG.info("修改用户数据：" + user);
        userService.updateUser(user);
        LOG.info("修改用户数据后->" + user);
        return "redirect:findAll";
    }

    /**
     * 产品添加
     * @return
     */
    @RequestMapping("/delete")
    public String deleteUser(Integer id){
        LOG.info("删除产品的ID：" + id);
        userService.deleteUser(id);
        return "redirect:findAll";
    }

}
