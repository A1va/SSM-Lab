package com.controller;
/*
 * Created by Nolva on 2020/6/10.
 */

import com.domain.Product;
import com.github.pagehelper.PageInfo;
import com.service.IProductService;
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
@RequestMapping("/product")
public class ProductController {

    private Logger LOG = LoggerFactory.getLogger(ProductController.class);
    private final IProductService productService;

    @Autowired
    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    /**
     * 查询全部产品
     * @param model
     * @return
     */
    @GetMapping("/findAll")
    public String findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "5") Integer size, Model model){

        List<Product> products = productService.findAllByPage(page, size);
        //PageInfo就是一个分页Bean
        PageInfo<Product> pageInfo = new PageInfo<>(products);
        model.addAttribute("pageInfo", pageInfo);
        return "productList";
    }

    /**
     * 产品添加
     * @return
     */
    @GetMapping("/goSave")
    public String save(){
        return "saveProduct";
    }

    /**
     * 产品添加
     * @return
     */
    @PostMapping("/save")
    public String saveProduct(Product product){
        LOG.info("新增产品数据：" + product);
        productService.saveProduct(product);
        return "redirect:findAll";
    }

    /**
     * 产品编辑
     * @return
     */
    @GetMapping("/goUpdate")
    public String goUpdate(Integer id, Model model){
        LOG.info("正在修改的产品：" + id);
        Product product = productService.findProductById(id);
        LOG.info("正在修改的产品：" + product);
        model.addAttribute("product", product);
        return "updateProduct";
    }

    /**
     * 产品添加
     * @return
     */
    @PostMapping("/update")
    public String updateProduct(Product product){
        LOG.info("新增产品数据：" + product);
        productService.updateProduct(product);
        return "redirect:findAll";
    }

    /**
     * 产品删除
     * @return
     */
    @RequestMapping("/delete")
    public String deleteProduct(Integer id){
        LOG.info("删除产品的ID：" + id);
        productService.deleteProduct(id);
        return "redirect:findAll";
    }

    @GetMapping("/findById")
    public String findById(@RequestParam(name = "productId",required = true) Integer productId){
        Product product = productService.findProductById(productId);
        LOG.info("通过productId查找到的产品" + product);
        return "productDetails";
    }
}
