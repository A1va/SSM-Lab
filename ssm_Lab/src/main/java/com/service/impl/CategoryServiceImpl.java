package com.service.impl;/*
 * Created by Nolva on 2020/6/20.
 */

import com.dao.ICategoryDao;
import com.domain.Category;
import com.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("categoryService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)//只读型事务的配置
public class CategoryServiceImpl implements ICategoryService {

    private final ICategoryDao categoryDao;

    @Autowired
    public CategoryServiceImpl(ICategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public Category findCategoryById(Integer categoryId) {
        return categoryDao.findCategoryById(categoryId);
    }

    @Override
    public Category findCategoryByName(String categoryName) {
        return categoryDao.findCategoryByName(categoryName);
    }

    @Override
    public void saveCategory(Category category) {
        categoryDao.saveCategory(category);
    }
}
