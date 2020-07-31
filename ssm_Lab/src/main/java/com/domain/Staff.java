package com.domain;
/*
 * Created by Nolva on 2020/6/18.
 */

import com.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 员工表
 */
public class Staff implements Serializable {

//    主键
    private Integer id;
//    姓名
    private String staffName;
//    性别
    private String sex;
//    电话号码
    private String phoneNum;
//    邮件地址
    private String email;
//    薪资
    private double salary;
//    Department外键依赖
    private Integer departmentId;
//    一对多关系映射：一个员工对应一个部门
    private Department department;
//    Position外键依赖
    private Integer positionId;
//    一对多关系映射：一个员工对应一个职务
    private Position position;
//    应该有订单表

//    入职时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date hireDate;
    private String hireDateStr;

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getHireDateStr() {
        if(hireDate != null){
            hireDateStr = DateUtils.date2String(hireDate,"yyyy-MM-dd HH:mm:ss");
        }
        return hireDateStr;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public void setHireDateStr(String hireDateStr) {
        this.hireDateStr = hireDateStr;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum == null ? null : phoneNum.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", staffName='" + staffName + '\'' +
                ", sex='" + sex + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", email='" + email + '\'' +
                ", salary='" + salary + '\'' +
                ", department=" + department +
                ", position=" + position +
                ", hireDateStr=" + hireDateStr +
                '}';
    }
}
