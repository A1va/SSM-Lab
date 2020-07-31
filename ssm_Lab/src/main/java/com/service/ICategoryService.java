package com.service;

import com.domain.Category;

import java.util.List;

public interface ICategoryService {

    /**
     * 查询所有产品
     * @return
     */
    List<Category> findAll();

    /**
     * 根据ID查询产品
     * @param categoryId
     * @return
     */
    Category findCategoryById(Integer categoryId);

    /**
     * 根据姓名查询产品
     * @param categoryName
     * @return
     */
    Category findCategoryByName(String categoryName);

    /**
     * 插入产品数据
     * @SelectKety: 确定插入数据的主键
     * @param category
     */
    void saveCategory(Category category);

}
