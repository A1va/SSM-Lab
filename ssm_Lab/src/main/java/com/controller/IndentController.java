package com.controller;
/*
 * Created by Nolva on 2020/6/20.
 */

import com.domain.Indent;
import com.domain.IndentItem;
import com.github.pagehelper.PageInfo;
import com.service.IndentItemService;
import com.service.IndentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/indent")
public class IndentController {

    private Logger LOG = LoggerFactory.getLogger(IndentController.class);
    private final IndentService indentService;
    private final IndentItemService indentItemService;

    public IndentController(IndentService indentService, IndentItemService indentItemService) {
        this.indentService = indentService;
        this.indentItemService = indentItemService;
    }

    /**
     * 查询全部订单
     * @param model
     * @return
     */
    @GetMapping("/findAll")
    public String findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "5") Integer size, Model model){
        List<Indent> indents = indentService.findAllByPage(page, size);
        // PageInfo就是一个分页Bean
        PageInfo<Indent> pageInfo = new PageInfo<>(indents);
        model.addAttribute("pageInfo", pageInfo);
        return "indentList";
    }

    /**
     * 产品添加
     * @return
     */
    @GetMapping("/goSave")
    public String save(){
        return "saveIndent";
    }

    /**
     * 产品添加
     * @return
     */
    @PostMapping("/save")
    public String saveProduct(Indent indent){
        LOG.info("新增订单数据：" + indent);
        List<IndentItem> indentItems = indent.getIndentItems();
        for (IndentItem indentItem : indentItems){
            indentItemService.insertIndentItem(indentItem);
        }
        indentService.saveIndent(indent);
        return "redirect:findAll";
    }

    @GetMapping("/findById")
    public String findById(@RequestParam(name = "id",required = true) Integer indentId, Model model){
        Indent indent = indentService.findIndentById(indentId);
        LOG.info("通过productId查找到的产品" + indent);
        model.addAttribute("indent", indent);
        return "indentDetails";
    }
}
