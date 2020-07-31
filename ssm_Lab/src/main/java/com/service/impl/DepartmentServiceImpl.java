package com.service.impl;/*
 * Created by Nolva on 2020/6/20.
 */

import com.dao.IDepartmentDao;
import com.domain.Department;
import com.github.pagehelper.PageHelper;
import com.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("departmentService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)//只读型事务的配置
public class DepartmentServiceImpl implements IDepartmentService {

    private final IDepartmentDao departmentDao;

    @Autowired
    public DepartmentServiceImpl(IDepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public List<Department> findAll() {
        return departmentDao.findAll();
    }

    @Override
    public Department findDepartmentById(Integer departmentId) {
        return departmentDao.findDepartmentById(departmentId);
    }

    @Override
    public Department findDepartmentByName(String departmentName) {
        return departmentDao.findDepartmentByName(departmentName);
    }

    @Override
    public void saveDepartment(Department department) {
        departmentDao.saveDepartment(department);
    }

    @Override
    public void deleteDepartment(Integer departmentId) {
        departmentDao.deleteDepartment(departmentId);
    }

    @Override
    public void updateDepartment(Department department) {
        departmentDao.updateDepartment(department);
    }

    @Override
    public int findTotalDepartment() {
        return departmentDao.findTotalDepartment();
    }

    @Override
    public List<Department> findAllByPage(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        return departmentDao.findAll();
    }
}
