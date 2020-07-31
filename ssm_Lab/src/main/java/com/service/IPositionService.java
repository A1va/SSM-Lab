package com.service;

import com.domain.Position;

import java.util.List;

public interface IPositionService {

    /**
     * 查询所有职位
     * @return
     */
    List<Position> findAll();

    /**
     * 分页查询所有职位
     * @return
     */
    List<Position> findAllByPage(Integer page, Integer size);

    /**
     * 根据ID查询职位
     * @param positionId
     * @return
     */
    Position findPositionById(Integer positionId);

    /**
     * 根据姓名查询职位
     * @param positionName
     * @return
     */
    Position findPositionByName(String positionName);

    /**
     * 插入产品数据
     * @SelectKety: 确定插入数据的主键
     * @param position
     */
//    void savePosition(Position position);
}
