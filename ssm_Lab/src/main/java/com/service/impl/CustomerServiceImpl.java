package com.service.impl;/*
 * Created by Nolva on 2020/6/19.
 */

import com.dao.ICustomerDao;
import com.domain.Customer;
import com.github.pagehelper.PageHelper;
import com.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("customerService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)//只读型事务的配置
public class CustomerServiceImpl implements ICustomerService {

    private final ICustomerDao customerDao;

    @Autowired
    public CustomerServiceImpl(ICustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public List<Customer> findAll() {
        return customerDao.findAll();
    }

    @Override
    public List<Customer> findAllByPage(int page, int size) {
        PageHelper.startPage(page, size);
        return customerDao.findAll();
    }

    @Override
    public Customer findCustomerById(Integer customerId) {
        return customerDao.findCustomerById(customerId);
    }

    @Override
    public Customer findCustomerByName(String customerName) {
        return customerDao.findCustomerByName(customerName);
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerDao.saveCustomer(customer);
    }

    @Override
    public void deleteCustomer(Integer customerId) {
        customerDao.deleteCustomer(customerId);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerDao.updateCustomer(customer);
    }

    @Override
    public int findTotalCustomer() {
        return customerDao.findTotalCustomer();
    }
}
