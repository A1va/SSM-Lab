package com.service.impl;

import com.dao.IStaffDao;
import com.domain.Staff;
import com.github.pagehelper.PageHelper;
import com.service.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
 * Created by Nolva on 2020/6/19.
 */
@Service("staffService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)//只读型事务的配置
public class StaffServiceImpl implements IStaffService {

    private final IStaffDao staffDao;

    @Autowired
    public StaffServiceImpl(IStaffDao staffDao) {
        this.staffDao = staffDao;
    }

    @Override
    public List<Staff> findAll() {
        return staffDao.findAll();
    }

    @Override
    public List<Staff> findAllByPage(int page, int size) {
        PageHelper.startPage(page, size);
        return staffDao.findAll();
    }

    @Override
    public Staff findStaffById(Integer staffId) {
        return staffDao.findStaffById(staffId);
    }

    @Override
    public Staff findStaffByName(String staffName) {
        return staffDao.findStaffByName(staffName);
    }

    @Override
    public void saveStaff(Staff staff) {
        staffDao.saveStaff(staff);
    }

    @Override
    public void deleteStaff(Integer staffId) {
        staffDao.deleteStaff(staffId);
    }

    @Override
    public void updateStaff(Staff staff) {
        staffDao.updateStaff(staff);
    }

    @Override
    public int findTotalStaff() {
        return staffDao.findTotalStaff();
    }
}
