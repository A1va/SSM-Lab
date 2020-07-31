package com.controller;
/*
 * Created by Nolva on 2020/7/9.
 */

import com.domain.Position;
import com.github.pagehelper.PageInfo;
import com.service.IPositionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/position")
public class PositionController {

    private Logger LOG = LoggerFactory.getLogger(DepartmentController.class);
    private final IPositionService positionService;

    public PositionController(IPositionService positionService) {
        this.positionService = positionService;
    }

    /**
     * 查询全部订单
     * @param model
     * @return
     */
    @GetMapping("/findAll")
    public String findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "5") Integer size, Model model){
        List<Position> positions = positionService.findAllByPage(page, size);
        // PageInfo就是一个分页Bean
        PageInfo<Position> pageInfo = new PageInfo<>(positions);
        model.addAttribute("pageInfo", pageInfo);
        return "positionList";
    }
}
