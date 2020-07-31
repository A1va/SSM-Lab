package com.service;

import com.domain.Staff;

import java.util.List;

public interface IStaffService {

    /**
     * 查询所有产品
     * @return
     */
    List<Staff> findAll();

    /**
     * 分页查询所有产品
     * @return
     */
    List<Staff> findAllByPage(int page, int size);

    /**
     * 根据ID查询产品
     * @param staffId
     * @return
     */
    Staff findStaffById(Integer staffId);

    /**
     * 根据姓名查询产品
     * @param staffName
     * @return
     */
    Staff findStaffByName(String staffName);

    /**
     * 插入产品数据
     * @SelectKety: 确定插入数据的主键
     * @param staff
     */
    void saveStaff(Staff staff);

    /**
     * 删除产品数据
     * @param staffId
     */
    void deleteStaff(Integer staffId);

    /**
     * 更新产品数据
     * @param staff
     */
    void updateStaff(Staff staff);

    /**
     * 查找产品总数量
     * @return
     */
    int findTotalStaff();
}
