package com.service.impl;
/*
 * Created by Nolva on 2020/6/10.
 */

import com.dao.ICategoryDao;
import com.dao.IProductDao;
import com.domain.Product;
import com.github.pagehelper.PageHelper;
import com.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("productService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)//只读型事务的配置
public class ProductServiceImpl implements IProductService {

    private final IProductDao productDao;
    private final ICategoryDao categoryDao;

    @Autowired
    public ProductServiceImpl(IProductDao productDao, ICategoryDao categoryDao) {
        this.productDao = productDao;
        this.categoryDao = categoryDao;
    }

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public List<Product> findAllByPage(int page, int size) {
        PageHelper.startPage(page, size);
        return productDao.findAll();
    }

    @Override
    public Product findProductById(Integer productId) {
        return productDao.findProductById(productId);
    }

    @Override
    public Product findProductByName(String productName) {
        return productDao.findProductByName(productName);
    }

    @Override
    public void saveProduct(Product product) {
//        新增产品：把产品中的分类对象赋值再提交到数据库
        product.setCategory(categoryDao.findCategoryById(product.getCategoryId()));
        productDao.saveProduct(product);
    }

    @Override
    public void deleteProduct(Integer productId) {
        productDao.deleteProduct(productId);
    }

    @Override
    public void updateProduct(Product product) {
        productDao.updateProduct(product);
    }

    @Override
    public int findTotalProduct() {
        return productDao.findTotalProduct();
    }
}
