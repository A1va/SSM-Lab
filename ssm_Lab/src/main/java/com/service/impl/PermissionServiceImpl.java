package com.service.impl;/*
 * Created by Nolva on 2020/7/8.
 */

import com.dao.IPermissionDao;
import com.domain.Permission;
import com.github.pagehelper.PageHelper;
import com.service.IPermissionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("permissionService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)//只读型事务的配置
public class PermissionServiceImpl implements IPermissionService {

    private final IPermissionDao permissionDao;

    public PermissionServiceImpl(IPermissionDao permissionDao) {
        this.permissionDao = permissionDao;
    }


    @Override
    public List<Permission> findAllByPage(int page, int size) {
        PageHelper.startPage(page, size);
        return permissionDao.findAll();
    }

    @Override
    public void savePermission(Permission permission) {
        permissionDao.savePermission(permission);
    }

    @Override
    public Permission findById(Integer permissionId) {
        return permissionDao.findById(permissionId);
    }

    /**
     * 1.删除有依赖的表Role_Permission的权限信息
     * 2.删除权限表的信息
     * @param id
     */
    @Override
    public void deleteById(Integer id) {
        permissionDao.deleteFromRole_Permission(id);
        permissionDao.deleteById(id);
    }
}
