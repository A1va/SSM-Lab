package com.dao;

import com.domain.Customer;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("customerDao")
//@CacheNamespace(blocking = true)// mybatis 基于注解方式实现配置二级缓存
public interface ICustomerDao {

    /**
     * 查询所有客户
     * @return
     */
    @Select("select * from customer")
    @Results(id = "customerMap", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "customerName", property = "customerName"),
            @Result(column = "sex", property = "sex"),
            @Result(column = "phoneNum", property = "phoneNum"),
            @Result(column = "credentialsType", property = "credentialsType"),
            @Result(column = "credentialsNum", property = "credentialsNum"),
            @Result(column = "customerType", property = "customerType")
    })
    List<Customer> findAll();

    /**
     * 根据ID查询客户
     * @param customerId
     * @return
     */
    @Select("select * from customer where id = #{id}")
    @ResultMap("customerMap")
    Customer findCustomerById(Integer customerId);

    /**
     * 根据姓名查询客户
     * @param customerName
     * @return
     */
    @Select("select * from customer where customerName = #{customerName}")
    Customer findCustomerByName(String customerName);

    /**
     * 插入客户数据
     * @SelectKety: 确定插入数据的主键
     * @param customer
     */
    @Insert("insert into customer(customerName, sex, phoneNum, credentialsType, credentialsNum, customerType) values (#{customerName}, #{sex}, #{phoneNum}, #{credentialsType}, #{credentialsNum}, #{customerType})")
    @SelectKey(keyColumn = "id", keyProperty = "id", resultType = Integer.class, before = false, statement = "select last_insert_id()")
    void saveCustomer(Customer customer);

    /**
     * 删除客户数据
     * @param customerId
     */
    @Delete("delete from customer where id = #{id}")
    void deleteCustomer(Integer customerId);

    /**
     * 更新客户数据
     * @param customer
     */
    @Update("update customer set customerName = #{customerName}, sex = #{sex}, phoneNum = #{phoneNum}, credentialsType = #{credentialsType}, credentialsNum = #{credentialsNum}, customerType = #{customerType} where id = #{id}")
    void updateCustomer(Customer customer);

    /**
     * 查找客户总数
     * @return
     */
    @Select("select count(*) from customer")
    int findTotalCustomer();
}
