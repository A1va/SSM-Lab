package com.controller;
/*
 * Created by Nolva on 2020/6/19.
 */

import com.domain.Customer;
import com.github.pagehelper.PageInfo;
import com.service.ICustomerService;
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
@RequestMapping("/customer")
public class CustomerController {

    private Logger LOG = LoggerFactory.getLogger(CustomerController.class);
    private final ICustomerService customerService;

    @Autowired
    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * 查询全部客户
     * @param model
     * @return
     */
    @GetMapping("/findAll")
    public String findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "5") Integer size, Model model){

        List<Customer> customers = customerService.findAllByPage(page, size);
        //PageInfo就是一个分页Bean
        PageInfo<Customer> pageInfo = new PageInfo<>(customers);
        model.addAttribute("pageInfo", pageInfo);
        return "customerList";
    }

    /**
     * 产品添加
     * @return
     */
    @GetMapping("/goSave")
    public String save(){
        return "saveCustomer";
    }

    /**
     * 产品添加
     * @return
     */
    @PostMapping("/save")
    public String saveCustomer(Customer customer){
        LOG.info("新增产品数据：" + customer);
        customerService.saveCustomer(customer);
        return "redirect:findAll";
    }

    public String findById(@RequestParam(name = "customerId",required = true) Integer customerId){
        Customer customer = customerService.findCustomerById(customerId);
        LOG.info("通过customerId查找到的产品" + customer);
        return "";
    }
}
