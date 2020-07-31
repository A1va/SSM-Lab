package com.controller;
/*
 * Created by Nolva on 2020/7/8.
 */

import com.domain.Permission;
import com.domain.Role;
import com.github.pagehelper.PageInfo;
import com.service.IRoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    private final IRoleService roleService;

    public RoleController(IRoleService roleService) {
        this.roleService = roleService;
    }

    /**
     * 跳转到添加页面
     * @return
     */
    @GetMapping("/goSave")
    public String goSave(){
        return "saveRole";
    }

    /**
     * 执行保存处理
     * @param role
     * @return
     */
    @PostMapping("/save")
    public String saveRole(Role role){
        roleService.saveRole(role);
        return "redirect:findAll";
    }

    /**
     * 查询所有
     * @param page
     * @param size
     * @param model
     * @return
     */
    @GetMapping("/findAll")
    public String findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "5") Integer size, Model model) {
        List<Role> roles = roleService.findAllByPage(page, size);
        //PageInfo就是一个分页Bean
        PageInfo<Role> pageInfo = new PageInfo<>(roles);
        model.addAttribute("pageInfo", pageInfo);
        return "roleList";
    }

    /**
     *
     * @param roleId
     * @return
     */
    @GetMapping("/findById")
    public String findById(@RequestParam(name="id",required = true) Integer roleId, Model model){
        Role role = roleService.findById(roleId);
        model.addAttribute("role", role);
        return "roleDetails";
    }

    /**
     * 删除对应的角色，并跳转回findAll
     * @param roleId
     * @return
     */
    @RequestMapping("/deleteRole")
    public String deleteRole(@RequestParam(name="id",required = true) Integer roleId){
        roleService.deleteRoleById(roleId);
        return "redirect:findAll";
    }

    /**
     * findRoleByIdAndAllPermission查出未添加的权限后，给角色添加权限
     * 获取需要添加的权限的所有ID，以及对应角色的ID
     * 由service调用
     * @param roleId
     * @param permissionIds
     * @return
     */
    @RequestMapping("/addPermissionToRole")
    public String addPermissionToRole(@RequestParam(name = "roleId", required = true) Integer roleId, @RequestParam(name = "ids", required = true) Integer[] permissionIds){
        roleService.addPermissionToRole(roleId, permissionIds);
        return "redirect:findAll";
    }

    /**
     * 根据roleId查询role表，并查询出可以添加的权限
     * 当前角色未包含的权限
     * @param roleId
     * @return
     */
    @RequestMapping("/findRoleByIdAndAllPermission")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id", required = true) Integer roleId){
        ModelAndView mv = new ModelAndView();
//        根据roleId查询role
        Role role = roleService.findById(roleId);
//        根据roleId查询可以添加的权限
        List<Permission> otherPermissions = roleService.findOtherPermissions(roleId);
        mv.addObject("role", role);
        mv.addObject("permissionList", otherPermissions);
        mv.setViewName("addRolePermission");
        return mv;
    }


}
