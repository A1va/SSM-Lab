package com.service;

import com.domain.Indent;
import com.domain.IndentItem;

import java.util.List;

public interface IndentItemService {

    /**
     * 查询所有订单详情
     * @return
     */
    List<IndentItem> findAll();

    /**
     * 根据productId查询订单详情
     * @param productId
     * @return
     */
    List<IndentItem> findIndentItemByProductId(Integer productId);

    /**
     * 根据customerId查询订单详情
     * @param customerId
     * @return
     */
    List<IndentItem> findIndentItemByCustomerId(Integer customerId);

    /**
     * 根据indentId查询订单详情
     * @param indentId
     * @return
     */
    List<IndentItem> findIndentItemByIndentId(Integer indentId);

    /**
     * 根据ID查询订单详情
     * @param indentItemId
     * @return
     */
    IndentItem findIndentItemById(Integer indentItemId);

    /**
     * 根据ID添加订单详情
     * @param indentItem
     */
    void insertIndentItem(IndentItem indentItem);

    /**
     * 删除订单详情
     * @param indentItem
     */
    void deleteIndentItem(Integer indentItem);

    void fillIndents(List<Indent> indents);

    void fillIndent(Indent indent);

}
