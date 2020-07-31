package com.domain;/*
 * Created by Nolva on 2020/6/19.
 */

import java.io.Serializable;
import java.util.List;

/**
 * 分类表
 */
public class Category implements Serializable {

//    主键
    private Integer id;
//    分类名称
    private String categoryName;
//    一个分类对应多个产品
    private List<Product> products;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
