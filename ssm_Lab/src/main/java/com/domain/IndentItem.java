package com.domain;
/*
 * Created by Nolva on 2020/6/30.
 */

import java.io.Serializable;

/**
 * 订单详情表
 */
public class IndentItem implements Serializable {
//    主键
    private Integer id;
//    购买产品数量
    private Integer number;
//    产品外键依赖
    private Integer productId;
//    订单外键依赖
    private Integer indentId;
//    顾客外键依赖
    private Integer customerId;
//    非数据库字段：产品
    private Product product;
    private Indent indent;
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
        this.customerId = customer.getId();
    }

    public Indent getIndent() {
        return indent;
    }

    public void setIndent(Indent indent) {
        this.indent = indent;
        this.indentId = indent.getId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getIndentId() {
        return indentId;
    }

    public void setIndentId(Integer indentId) {
        this.indentId = indentId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
        this.productId = product.getId();
    }

    @Override
    public String toString() {
        return "IndentItem{" +
                "id=" + id +
                ", number="+ number +
                ", productId=" + productId +
                ", indentId=" + indentId +
                ", customerId=" + customerId +
                ", product=" + product +
//                ", indent=" + indent +
//                ", customer=" + customer +
                '}';
    }
}
