package com.domain;
/*
 * Created by Nolva on 2020/6/18\.
 */

import com.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Indent implements Serializable {

//    主键
    private Integer id;
//    订单编号
    private String indentNum;
//    收货人信息
    private String receiver;
//    电话号码
    private String mobile;
//    地址
    private String address;
//    创建订单时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date createTime;
    private String createTimeStr;
//    支付时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date payTime;
    private String payTimeStr;
//    发货时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date deliveryTime;
    private String deliveryTimeStr;
//    确认收货时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date confirmTime;
    private String confirmTimeStr;
//    订单详情
    private String indentDesc;
//    支付方式
    private Integer payType;
    private String payTypeStr;
//    订单状态
    private int indentStatus;
    private String indentStatusStr;
//    顾客外键依赖
    private Integer customerId;
//    非数据库字段
//    多：订单项
    private List<IndentItem> indentItems;
//    一：客户列表
    private Customer customer;
//    订单总金额
    private float totalAmount;
//    订单总数
    private int totalNumber;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIndentNum() {
        return indentNum;
    }

    public void setIndentNum(String indentNum) {
        this.indentNum = indentNum == null ? null : indentNum.trim();
    }

    public String getIndentDesc() {
        return indentDesc;
    }

    public void setIndentDesc(String indentDesc) {
        this.indentDesc = indentDesc == null ? null : indentDesc.trim();
    }

    public int getIndentStatus() {
        return indentStatus;
    }

    public void setIndentStatus(int indentStatus) {
        this.indentStatus = indentStatus;
    }

    public void setIndentStatusStr(String indentStatusStr) {
        this.indentStatusStr = indentStatusStr;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public void setPayTypeStr(String payTypeStr) {
        this.payTypeStr = payTypeStr;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver == null ? null : receiver.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateTimeStr() {
        if(createTime != null){
            createTimeStr = DateUtils.date2String(createTime,"yyyy-MM-dd HH:mm");
        }
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getPayTimeStr() {
        if(payTime != null){
            payTimeStr = DateUtils.date2String(payTime,"yyyy-MM-dd HH:mm");
        }
        return payTimeStr;
    }

    public void setPayTimeStr(String payTimeStr) {
        this.payTimeStr = payTimeStr;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getDeliveryTimeStr() {
        if(deliveryTime != null){
            deliveryTimeStr= DateUtils.date2String(deliveryTime,"yyyy-MM-dd HH:mm");
        }
        return deliveryTimeStr;
    }

    public void setDeliveryTimeStr(String deliveryTimeStr) {
        this.deliveryTimeStr = deliveryTimeStr;
    }

    public Date getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(Date confirmTime) {
        this.confirmTime = confirmTime;
    }

    public String getConfirmTimeStr() {
        if(confirmTime != null){
            confirmTimeStr= DateUtils.date2String(confirmTime,"yyyy-MM-dd HH:mm");
        }
        return confirmTimeStr;
    }

    public void setConfirmTimeStr(String confirmTimeStr) {
        this.confirmTimeStr = confirmTimeStr;
    }

    public List<IndentItem> getIndentItems() {
        return indentItems;
    }

    public void setIndentItems(List<IndentItem> indentItems) {
        this.indentItems = indentItems;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }
    public String getIndentStatusStr() {
        //订单状态(0 未支付 1 已支付)
        if(indentStatus == 0){
            indentStatusStr = "未支付";
        }else if(indentStatus == 1){
            indentStatusStr = "已支付";
        }
        return indentStatusStr;
    }

    public String getPayTypeStr() {
        //支付方式(0 支付宝  1 微信  2 银行卡  3 其他)
        if(payType == 0){
            payTypeStr = "支付宝";
        }else if(payType == 1){
            payTypeStr = "微信";
        }else if(payType == 2){
            payTypeStr = "银行卡";
        }else if(payType == 3){
            payTypeStr = "其他";
        }
        return payTypeStr;
    }

    @Override
    public String toString() {
        return "Indent{" +
                "id=" + id +
                ", indentNum='" + indentNum + '\'' +
                ", receiver='" + receiver + '\'' +
                ", mobile='" + mobile + '\'' +
                ", address='" + address + '\'' +
                ", createTimeStr='" + createTimeStr + '\'' +
                ", payTimeStr='" + payTimeStr + '\'' +
                ", deliveryTimeStr='" + deliveryTimeStr + '\'' +
                ", confirmTimeStr='" + confirmTimeStr + '\'' +
                ", indentDesc='" + indentDesc + '\'' +
                ", payTypeStr='" + payTypeStr + '\'' +
                ", indentStatusStr='" + indentStatusStr + '\'' +
                ", customerId=" + customerId +
                ", indentItems=" + indentItems +
                ", customer=" + customer +
                ", totalAmount=" + totalAmount +
                ", totalNumber=" + totalNumber +
                '}';
    }
}
