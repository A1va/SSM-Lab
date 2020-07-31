package com.service;

import com.domain.Product;

import java.util.List;

public interface IProductService {

    /**
     * 查询所有产品
     * @return
     */
    List<Product> findAll();

    /**
     * 分页查询所有产品
     * @return
     */
    List<Product> findAllByPage(int page, int size);

    /**
     * 根据ID查询产品
     * @param productId
     * @return
     */
    Product findProductById(Integer productId);

    /**
     * 根据姓名查询产品
     * @param productName
     * @return
     */
    Product findProductByName(String productName);

    /**
     * 插入产品数据
     * @SelectKety: 确定插入数据的主键
     * @param product
     */
    void saveProduct(Product product);

    /**
     * 删除产品数据
     * @param productId
     */
    void deleteProduct(Integer productId);

    /**
     * 更新产品数据
     * @param product
     */
    void updateProduct(Product product);

    /**
     * 查找产品总数量
     * @return
     */
    int findTotalProduct();
}
