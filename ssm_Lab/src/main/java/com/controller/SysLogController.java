package com.controller;
/*
 * Created by Nolva on 2020/7/9.
 */

import com.domain.SysLog;
import com.github.pagehelper.PageInfo;
import com.service.ISysLogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/sysLog")
public class SysLogController {

    private final ISysLogService sysLogService;

    public SysLogController(ISysLogService sysLogService) {
        this.sysLogService = sysLogService;
    }

    @GetMapping("/findAll")
    public String findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "5") Integer size, Model model){
        List<SysLog> sysLogs = sysLogService.findAllByPage(page, size);
        //PageInfo就是一个分页Bean
        PageInfo<SysLog> pageInfo = new PageInfo<>(sysLogs);
        model.addAttribute("pageInfo", pageInfo);
        return "syslogList";
    }
}
