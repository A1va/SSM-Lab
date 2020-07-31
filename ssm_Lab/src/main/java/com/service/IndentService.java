package com.service;

import com.domain.Indent;

import java.util.List;

public interface IndentService {

    /**
     * 查询所有产品
     * @return
     */
    List<Indent> findAll();

    /**
     * 分页查询所有产品
     * @return
     */
    List<Indent> findAllByPage(int page, int size);

    /**
     * 插入订单项
     * @param indent
     */
    void saveIndent(Indent indent);

    /**
     * 根据ID查找
     * @param indentId
     * @return
     */
    Indent findIndentById(Integer indentId);
}
