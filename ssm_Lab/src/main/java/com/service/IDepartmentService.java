package com.service;

import com.domain.Department;

import java.util.List;

public interface IDepartmentService {

    /**
     * 查询所有产品
     * @return
     */
    List<Department> findAll();

    /**
     * 根据ID查询产品
     * @param departmentId
     * @return
     */
    Department findDepartmentById(Integer departmentId);

    /**
     * 根据姓名查询产品
     * @param departmentName
     * @return
     */
    Department findDepartmentByName(String departmentName);

    /**
     * 插入产品数据
     * @SelectKety: 确定插入数据的主键
     * @param department
     */
    void saveDepartment(Department department);

    /**
     * 删除产品数据
     * @param departmentId
     */
    void deleteDepartment(Integer departmentId);

    /**
     * 更新产品数据
     * @param department
     */
    void updateDepartment(Department department);

    /**
     * 查找产品总数量
     * @return
     */
    int findTotalDepartment();

    List<Department> findAllByPage(Integer page, Integer size);
}
