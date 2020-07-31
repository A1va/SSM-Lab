package com.dao;

import com.domain.Category;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("categoryDao")
//@CacheNamespace(blocking = true)// mybatis 基于注解方式实现配置二级缓存
public interface ICategoryDao {

    /**
     * 查询所有产品
     * @return
     */
    @Select("select * from category")
    @Results(id = "categoryMap", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "categoryName", property = "categoryName"),
    })
    List<Category> findAll();

    /**
     * 根据ID查询产品
     * @param categoryId
     * @return
     */
    @Select("select * from category where id = #{id}")
    @ResultMap("categoryMap")
    Category findCategoryById(Integer categoryId);

    /**
     * 根据姓名查询产品
     * @param categoryName
     * @return
     */
    @Select("select * from category where categoryName = #{categoryName}")
    Category findCategoryByName(String categoryName);

    /**
     * 插入产品数据
     * @SelectKety: 确定插入数据的主键
     * @param category
     */
    @Insert("insert into category(categoryName) values (#{categoryName})")
    @SelectKey(keyColumn = "id", keyProperty = "id", resultType = Integer.class, before = false, statement = "select last_insert_id()")
    void saveCategory(Category category);
}
