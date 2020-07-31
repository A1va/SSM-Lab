package com.dao;

import com.domain.Category;
import com.domain.Product;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("productDao")
//@CacheNamespace(blocking = true)// mybatis 基于注解方式实现配置二级缓存
public interface IProductDao {

    /**
     * 查询所有产品
     * @return
     */
    @Select("select * from product")
    @Results(id = "productMap", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "productNum", property = "productNum"),
            @Result(column = "productName", property = "productName"),
            @Result(column = "createTime", property = "createTime"),
            @Result(column = "productPrice", property = "productPrice"),
            @Result(column = "stock", property = "stock"),
            @Result(column = "productDesc", property = "productDesc"),
            @Result(column = "productStatus", property = "productStatus"),
            @Result(property = "category", column = "categoryId", javaType = Category.class,
                    one = @One(select = "com.dao.ICategoryDao.findCategoryById", fetchType = FetchType.EAGER))
    })
    List<Product> findAll();

    /**
     * 根据ID查询产品
     * @param productId
     * @return
     */
    @Select("select * from product where id = #{id}")
    @ResultMap("productMap")
    Product findProductById(Integer productId);

    /**
     * 根据姓名查询产品
     * @param productName
     * @return
     */
    @Select("select * from product where productName = #{productName}")
    Product findProductByName(String productName);

    /**
     * 插入产品数据
     * @SelectKety: 确定插入数据的主键
     * @param product
     */
    @Insert("insert into product(productNum, categoryId, productName, createTime, productPrice, stock, productDesc, productStatus) values (#{productNum}, #{categoryId}, #{productName}, #{createTime}, #{productPrice}, #{stock}, #{productDesc}, #{productStatus})")
    @SelectKey(keyColumn = "id", keyProperty = "id", resultType = Integer.class, before = false, statement = "select last_insert_id()")
    void saveProduct(Product product);

    /**
     * 删除产品数据
     * @param productId
     */
    @Delete("delete from product where id = #{id}")
    void deleteProduct(Integer productId);

    /**
     * 更新产品数据
     * @param product
     */
    @Update("update product set productNum = #{productNum}, categoryId = #{categoryId}, productName = #{productName}, createTime = #{createTime}, productPrice = #{productPrice}, stock = #{stock}, productDesc = #{productDesc}, productStatus = #{productStatus} where id = #{id}")
    void updateProduct(Product product);

    /**
     * 查找产品总数量
     * @return
     */
    @Select("select count(*) from product")
    int findTotalProduct();
}
