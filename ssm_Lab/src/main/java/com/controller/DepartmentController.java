package com.controller;
/*
 * Created by Nolva on 2020/7/9.
 */

import com.domain.Department;
import com.github.pagehelper.PageInfo;
import com.service.IDepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    private Logger LOG = LoggerFactory.getLogger(DepartmentController.class);
    private final IDepartmentService departmentService;

    public DepartmentController(IDepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    /**
     * 查询全部订单
     * @param model
     * @return
     */
    @GetMapping("/findAll")
    public String findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "5") Integer size, Model model){
        List<Department> departments = departmentService.findAllByPage(page, size);
        // PageInfo就是一个分页Bean
        PageInfo<Department> pageInfo = new PageInfo<>(departments);
        model.addAttribute("pageInfo", pageInfo);
        return "departmentList";
    }
}
