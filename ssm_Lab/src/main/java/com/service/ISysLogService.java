package com.service;

import com.domain.SysLog;

import java.util.List;

public interface ISysLogService {

    void saveSysLog(SysLog sysLog);

    List<SysLog> findAll();

    List<SysLog> findAllByPage(int page, int size);
}
