package com.dao;

import com.domain.Indent;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("indentDao")
//@CacheNamespace(blocking = true)// mybatis 基于注解方式实现配置二级缓存
public interface IndentDao {

    /**
     * 查询所有员工
     * @return
     */
    @Select("select * from indent")
    @Results(id = "indentMap", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "indentNum", property = "indentNum"),
            @Result(column = "receiver", property = "receiver"),
            @Result(column = "mobile", property = "mobile"),
            @Result(column = "address", property = "address"),
            @Result(column = "createTime", property = "createTime"),
            @Result(column = "payType", property = "payType"),
            @Result(column = "payTime", property = "payTime"),
            @Result(column = "deliveryTime", property = "deliveryTime"),
            @Result(column = "confirmTime", property = "confirmTime"),
            @Result(column = "indentStatus", property = "indentStatus"),
            @Result(column = "indentDesc", property = "indentDesc"),
            @Result(property = "customer", column = "customerId",
                    one = @One(select = "com.dao.ICustomerDao.findCustomerById", fetchType = FetchType.EAGER)),
    })
    List<Indent> findAll();

    /**
     * 根据ID查询产品
     * @param indentId
     * @return
     */
    @Select("select * from indent where id = #{indentId}")
    @Results(value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "indentNum", property = "indentNum"),
            @Result(column = "receiver", property = "receiver"),
            @Result(column = "mobile", property = "mobile"),
            @Result(column = "address", property = "address"),
            @Result(column = "createTime", property = "createTime"),
            @Result(column = "payType", property = "payType"),
            @Result(column = "payTime", property = "payTime"),
            @Result(column = "deliveryTime", property = "deliveryTime"),
            @Result(column = "confirmTime", property = "confirmTime"),
            @Result(column = "indentStatus", property = "indentStatus"),
            @Result(column = "indentDesc", property = "indentDesc"),
            @Result(property = "customer", column = "customerId",
                    one = @One(select = "com.dao.ICustomerDao.findCustomerById", fetchType = FetchType.EAGER)),
            @Result(property = "indentItems", column = "id",
                    many = @Many(select = "com.dao.IndentItemDao.findIndentItemByIndentId", fetchType = FetchType.LAZY))
    })
    Indent findIndentById(Integer indentId);

    /**
     * 插入产品数据
     * @SelectKety: 确定插入数据的主键
     * @param indent
     */
    @Insert("insert into indent(indentNum, receiver, mobile, address, createTime, payType, payTime, deliveryTime, confirmTime, indentDesc, indentStatus, customerId) values (#{indentNum}, #{receiver}, #{mobile}, #{address}, #{createTime}, #{payType}, #{payTime}, #{deliveryTime}, #{confirmTime}, #{indentDesc}, #{indentStatus}, #{customerId})")
    @SelectKey(keyColumn = "id", keyProperty = "id", resultType = Integer.class, before = false, statement = "select last_insert_id()")
    void saveIndent(Indent indent);

}
