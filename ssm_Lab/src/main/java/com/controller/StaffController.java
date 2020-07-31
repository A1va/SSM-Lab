package com.controller;
/*
 * Created by Nolva on 2020/6/30.
 */

import com.domain.Staff;
import com.github.pagehelper.PageInfo;
import com.service.IStaffService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/staff")
public class StaffController {

    private Logger LOG = LoggerFactory.getLogger(StaffController.class);
    private final IStaffService staffService ;

    @Autowired
    public StaffController(IStaffService staffService) {
        this.staffService = staffService;
    }

    /**
     * 查询全部员工
     * @param model
     * @return
     */
    @GetMapping("/findAll")
    public String findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "5") Integer size, Model model){

        List<Staff> staff = staffService.findAllByPage(page, size);
        //PageInfo就是一个分页Bean
        PageInfo<Staff> pageInfo = new PageInfo<>(staff);
        model.addAttribute("pageInfo", pageInfo);
        return "staffList";
    }

    /**
     * 员工添加
     * @return
     */
    @GetMapping("/goSave")
    public String save(){
        return "saveStaff";
    }

    /**
     * 员工添加
     * @return
     */
    @PostMapping("/save")
    public String saveStaff(Staff staff){
        LOG.info("新增员工数据：" + staff);
        staffService.saveStaff(staff);
        return "redirect:findAll";
    }
}
