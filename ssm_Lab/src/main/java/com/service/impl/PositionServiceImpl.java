package com.service.impl;/*
 * Created by Nolva on 2020/6/20.
 */

import com.dao.IPositionDao;
import com.domain.Position;
import com.github.pagehelper.PageHelper;
import com.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("positionService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)//只读型事务的配置
public class PositionServiceImpl implements IPositionService {

    private final IPositionDao positionDao;

    @Autowired
    public PositionServiceImpl(IPositionDao positionDao) {
        this.positionDao = positionDao;
    }


    @Override
    public List<Position> findAll() {
        return positionDao.findAll();
    }

    @Override
    public List<Position> findAllByPage(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        return positionDao.findAll();
    }

    @Override
    public Position findPositionById(Integer positionId) {
        return positionDao.findPositionById(positionId);
    }

    @Override
    public Position findPositionByName(String positionName) {
        return positionDao.findPositionByName(positionName);
    }

//    @Override
//    public void savePosition(Position position) {
//        positionDao.savePosition(position);
//    }
}
