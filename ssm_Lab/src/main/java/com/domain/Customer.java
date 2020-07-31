package com.domain;

import java.io.Serializable;

/*
 * Created by Nolva on 2020/6/18.
 */
// 客户--订单、供应商--合同
public class Customer implements Serializable {

//    主键
    private Integer id;
//    姓名
    private String customerName;
//    性别
    private String sex;
//    电话号码
    private String phoneNum;
//    证件类型
    private Integer credentialsType;
    private String credentialsTypeStr;
//    证件号码
    private String credentialsNum;
//    客户类型
    private Integer customerType;
    private String customerTypeStr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum == null ? null : phoneNum.trim();
    }

    public Integer getCredentialsType() {
        return credentialsType;
    }

    public void setCredentialsType(Integer credentialsType) {
        this.credentialsType = credentialsType;
    }

    public String getCredentialsTypeStr() {
        //证件类型 0身份证 1护照 2军官证
        if (credentialsType != null) {
            if (credentialsType == 0) {
                credentialsTypeStr = "身份证";
            } else if (credentialsType == 1) {
                credentialsTypeStr = "护照";
            } else if (credentialsType == 2) {
                credentialsTypeStr = "军官证";
            }
        }
        return credentialsTypeStr;
    }

    public void setCredentialsTypeStr(String credentialsTypeStr) {
        this.credentialsTypeStr = credentialsTypeStr;
    }

    public String getCredentialsNum() {
        return credentialsNum;
    }

    public void setCredentialsNum(String credentialsNum) {
        this.credentialsNum = credentialsNum == null ? null : credentialsNum.trim();
    }

    public Integer getCustomerType() {
        return customerType;
    }

    public void setCustomerType(Integer customerType) {
        this.customerType = customerType;
    }

    public String getCustomerTypeStr() {
        if (customerType != null){
            if (customerType == 0){
                customerTypeStr = "普通客户";
            } else if (customerType == 1){
                customerTypeStr = "会员";
            } else if (customerType == 2){
                customerTypeStr = "合作伙伴";
            } else if (customerType == 3){
                customerTypeStr = "中大型企业";
            }
        }
        return customerTypeStr;
    }

    public void setCustomerTypeStr(String customerTypeStr) {
        this.customerTypeStr = customerTypeStr;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", sex='" + sex + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", credentialsTypeStr='" + credentialsTypeStr + '\'' +
                ", credentialsNum='" + credentialsNum + '\'' +
                ", customerTypeStr=" + customerTypeStr +
                '}';
    }
}
