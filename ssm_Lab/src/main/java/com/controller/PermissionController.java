package com.controller;
/*
 * Created by Nolva on 2020/7/8.
 */

import com.domain.Permission;
import com.github.pagehelper.PageInfo;
import com.service.IPermissionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {

    private final IPermissionService permissionService;

    public PermissionController(IPermissionService permissionService) {
        this.permissionService = permissionService;
    }

    /**
     * 查询所有权限
     * @param page
     * @param size
     * @param model
     * @return
     */
    @GetMapping("/findAll")
    public String findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "5") Integer size, Model model) {
        List<Permission> permissions = permissionService.findAllByPage(page, size);
        //PageInfo就是一个分页Bean
        PageInfo<Permission> pageInfo = new PageInfo<>(permissions);
        model.addAttribute("pageInfo", pageInfo);
        return "permissionList";
    }

    /**
     * 根据ID查询权限
     * @param permissionId
     * @param model
     * @return
     */
    @GetMapping("findById")
    public String findById(Integer permissionId, Model model){
        Permission permission = permissionService.findById(permissionId);
        model.addAttribute("permission", permission);
        return "permissionDetails";
    }

    /**
     * 跳转到添加页面
     * @return
     */
    @GetMapping("/goSave")
    public String save(){
        return "savePermission";
    }

    /**
     * 执行添加操作
     * @param permission
     * @return
     */
    @PostMapping("/save")
    public String savePermission(Permission permission){
        permissionService.savePermission(permission);
        return "redirect:findAll";
    }


    /**
     * 执行删除操作
     * @param permissioinId
     * @return
     * @throws Exception
     */
    @RequestMapping("/deletePermission")
    public String deletePermission(Integer permissioinId) throws Exception {
        permissionService.deleteById(permissioinId);
        return "redirect:findAll";
    }
}
