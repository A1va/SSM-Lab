package com.service.impl;/*
 * Created by Nolva on 2020/6/20.
 */

import com.dao.IndentDao;
import com.domain.Indent;
import com.github.pagehelper.PageHelper;
import com.service.IndentItemService;
import com.service.IndentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("indentService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)//只读型事务的配置
public class IndentServiceImpl implements IndentService {

    private final IndentDao indentDao;
    private final IndentItemService indentItemService;

    @Autowired
    public IndentServiceImpl(IndentDao indentDao, IndentItemService indentItemService) {
        this.indentDao = indentDao;
        this.indentItemService = indentItemService;
    }

    @Override
    public List<Indent> findAll() {
        List<Indent> indents = indentDao.findAll();
        indentItemService.fillIndents(indents);
        return indents;
    }

    @Override
    public List<Indent> findAllByPage(int page, int size) {
//        参数pageNum 是页码值   参数pageSize 代表是每页显示条数
        PageHelper.startPage(page, size);
        List<Indent> indents = indentDao.findAll();
        indentItemService.fillIndents(indents);
        return indents;
    }

    @Override
    public void saveIndent(Indent indent) {
        indentDao.saveIndent(indent);
    }

    @Override
    public Indent findIndentById(Integer indentId) {
        Indent indent = indentDao.findIndentById(indentId);
        indentItemService.fillIndent(indent);
        return indent;
    }

//    /**
//     *
//     * @param indents
//     */
//    public void setCustomers(List<Indent> indents){
//        for (Indent indent : indents){
//            setCustomer(indent);
//        }
//    }
//
//    /**
//     * 填充Indent订单表的顾客对象Customer
//     * @param indent
//     */
//    public void setCustomer(Indent indent){
//        Integer customerId = indent.getCustomerId();
//        Customer customer = customerService.findCustomerById(customerId);
//        indent.setCustomer(customer);
//    }
}
