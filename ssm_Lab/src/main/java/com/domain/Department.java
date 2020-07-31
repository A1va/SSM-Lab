package com.domain;
/*
 * Created by Nolva on 2020/6/19.
 */

import java.io.Serializable;
import java.util.List;

/**
 * 部门表
 */
public class Department implements Serializable {

//    主键
    private Integer id;
//    部门名称
    private String departmentName;
//    部门详情
    private String departmentDesc;
//    多对一：一个部门对应多个员工
    private List<Staff> staffs;

    public String getDepartmentDesc() {
        return departmentDesc;
    }

    public void setDepartmentDesc(String departmentDesc) {
        this.departmentDesc = departmentDesc;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<Staff> staffs) {
        this.staffs = staffs;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
