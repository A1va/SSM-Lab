package com.service.impl;
/*
 * Created by Nolva on 2020/6/30.
 */


import com.dao.IndentItemDao;
import com.domain.Indent;
import com.domain.IndentItem;
import com.service.IndentItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("indentItemService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)//只读型事务的配置
public class IndentItemServiceImpl implements IndentItemService {

    private final IndentItemDao indentItemDao;

    @Autowired
    public IndentItemServiceImpl(IndentItemDao indentItemDao) {
        this.indentItemDao = indentItemDao;
    }


    @Override
    public List<IndentItem> findAll() {
        return indentItemDao.findAll();
    }

    @Override
    public List<IndentItem> findIndentItemByProductId(Integer productId) {
        return indentItemDao.findIndentItemByProductId(productId);
    }

    @Override
    public List<IndentItem> findIndentItemByCustomerId(Integer customerId) {
        return indentItemDao.findIndentItemByCustomerId(customerId);
    }

    @Override
    public List<IndentItem> findIndentItemByIndentId(Integer indentId) {
        return indentItemDao.findIndentItemByIndentId(indentId);
    }


    public void fillIndents(List<Indent> indents){
        for (Indent indent : indents){
            fillIndent(indent);
        }
    }

    /**
     * 1. 根据订单id查询出其对应的所有订单项
     * 3. 遍历所有的订单项，然后计算出该订单的总金额和总数量
     * 4. 最后再把订单项设置在订单的indentItems属性上
     * @param indent
     */
    public void fillIndent(Indent indent){
        List<IndentItem> indentItems = indentItemDao.findIndentItemByIndentId(indent.getId());

        float totalAmount = 0;
        int totalNumber = 0;
        for (IndentItem indentItem : indentItems){
            totalAmount += indentItem.getNumber() * indentItem.getProduct().getProductPrice();
            totalNumber += indentItem.getNumber();
        }
        indent.setTotalAmount(totalAmount);
        indent.setTotalNumber(totalNumber);
        indent.setIndentItems(indentItems);
    }

    @Override
    public IndentItem findIndentItemById(Integer indentItemId) {
        return indentItemDao.findIndentItemById(indentItemId);
    }

    @Override
    public void insertIndentItem(IndentItem indentItem) {
        indentItemDao.insertIndentItem(indentItem);
    }

    @Override
    public void deleteIndentItem(Integer indentItem) {
        indentItemDao.deleteIndentItem(indentItem);
    }

}
