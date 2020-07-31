package com.service;

import com.domain.Customer;

import java.util.List;

public interface ICustomerService {

    /**
     * 查询所有客户
     * @return
     */
    List<Customer> findAll();

    /**
     * 分页查询所有产品
     * @return
     */
    List<Customer> findAllByPage(int page, int size);

    /**
     * 根据ID查询客户
     * @param customerId
     * @return
     */
    Customer findCustomerById(Integer customerId);

    /**
     * 根据姓名查询客户
     * @param customerName
     * @return
     */
    Customer findCustomerByName(String customerName);

    /**
     * 插入客户数据
     * @SelectKety: 确定插入数据的主键
     * @param customer
     */
    void saveCustomer(Customer customer);

    /**
     * 删除客户数据
     * @param customerId
     */
    void deleteCustomer(Integer customerId);

    /**
     * 更新客户数据
     * @param customer
     */
    void updateCustomer(Customer customer);

    /**
     * 查找客户总数
     * @return
     */
    int findTotalCustomer();
}
