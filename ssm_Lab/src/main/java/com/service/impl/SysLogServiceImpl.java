package com.service.impl;
/*
 * Created by Nolva on 2020/7/9.
 */

import com.dao.ISysLogDao;
import com.domain.SysLog;
import com.github.pagehelper.PageHelper;
import com.service.ISysLogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("syslogService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)//只读型事务的配置
public class SysLogServiceImpl implements ISysLogService {

    private final ISysLogDao sysLogDao;

    public SysLogServiceImpl(ISysLogDao sysLogDao) {
        this.sysLogDao = sysLogDao;
    }

    @Override
    public void saveSysLog(SysLog sysLog) {
        sysLogDao.saveSysLog(sysLog);
    }

    @Override
    public List<SysLog> findAll() {
        return sysLogDao.findAll();
    }

    @Override
    public List<SysLog> findAllByPage(int page, int size) {
        PageHelper.startPage(page, size);
        return sysLogDao.findAll();
    }
}
