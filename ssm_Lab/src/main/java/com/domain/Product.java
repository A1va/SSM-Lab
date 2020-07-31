package com.domain;
/*
 * Created by Nolva on 2020/6/10.
 */

import com.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Product implements Serializable {

//    主键
    private Integer id;
//    编号 唯一
    private String productNum;
//    产品名称
    private String productName;
//    生产时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date createTime;
    private String createTimeStr;
//    产品价格
    private double productPrice;
//    产品库存
    private Integer stock;
//    产品描述
    private String productDesc;
//    状态  0 关闭  1开启
    private Integer productStatus;
    private String productStatusStr;
//    category外键依赖
    private Integer categoryId;
//    一对多关系映射：一个产品对应一个分类
    private Category category;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum == null ? null : productNum.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateTimeStr() {
        if(createTime != null){
            createTimeStr= DateUtils.date2String(createTime,"yyyy-MM-dd HH:mm:ss");
        }
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc == null ? null : productDesc.trim();
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductStatusStr() {
        if (productStatus != null) {
            // 状态 0 关闭 1 开启
            if(productStatus == 0)
                productStatusStr="关闭";
            if(productStatus == 1)
                productStatusStr="开启";
        }
        return productStatusStr;
    }

    public void setProductStatusStr(String productStatusStr) {
        this.productStatusStr = productStatusStr;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productNum='" + productNum + '\'' +
                ", productName='" + productName + '\'' +
                ", createTimeStr='" + createTimeStr + '\'' +
                ", productPrice=" + productPrice +
                ", stock=" + stock +
                ", productDesc='" + productDesc + '\'' +
                ", productStatusStr='" + productStatusStr + '\'' +
                ", categoryId='" + categoryId +
                '}';
    }
}
