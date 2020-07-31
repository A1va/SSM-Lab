package com.dao;

import com.domain.IndentItem;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("indentItemDao")
//@CacheNamespace(blocking = true)// mybatis 基于注解方式实现配置二级缓存
public interface IndentItemDao {

    /**
     * 查询所有订单详情
     * @return
     */
    @Select("select * from indentItem")
    @Results(id = "indentItemMap", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "number", property = "number"),
            @Result(property = "product", column = "productId",
                    one = @One(select = "com.dao.IProductDao.findProductById", fetchType = FetchType.EAGER)),
            @Result(property = "indent", column = "indentId",
                    one = @One(select = "com.dao.IndentDao.findIndentById", fetchType = FetchType.EAGER)),
            @Result(property = "customer", column = "customerId",
                    one = @One(select = "com.dao.ICustomerDao.findCustomerById", fetchType = FetchType.EAGER)),
    })
    List<IndentItem> findAll();

    /**
     * 根据ID查询订单详情
     * @param indentItemId
     * @return
     */
    @Select("select * from indentItem where id = #{id}")
    @ResultMap("indentItemMap")
    IndentItem findIndentItemById(Integer indentItemId);

    /**
     * 根据产品ID查询订单详情
     * @param productId
     * @return
     */
    @Select("select * from indentItem where productId = #{productId}")
    @ResultMap("indentItemMap")
    List<IndentItem> findIndentItemByProductId(Integer productId);

    /**
     * 根据客户ID查询订单详情
     * @param customerId
     * @return
     */
    @Select("select * from indentItem where customerId = #{customerId}")
    @ResultMap("indentItemMap")
    List<IndentItem> findIndentItemByCustomerId(Integer customerId);

    /**
     * 根据客户ID查询订单详情
     * @param indentId
     * @return
     */
    @Select("select * from indentItem where indentId = #{indentId}")
    @ResultMap("indentItemMap")
    List<IndentItem> findIndentItemByIndentId(Integer indentId);

    /**
     * 插入订单详情
     * @param indentItem
     */
    @Insert("insert into indentItem(productId, indentId, customerId, number) values (#{productId}, #{indentId}, #{customerId}), #{number}")
    void insertIndentItem(IndentItem indentItem);

    /**
     * 根据学生ID和课程ID删除选课表
     * @param indentItemId
     */
    @Delete("delete from indentItem where id = #{id}")
    void deleteIndentItem(Integer indentItemId);


}
