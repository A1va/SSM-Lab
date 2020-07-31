package com.service;

import com.domain.Permission;

import java.util.List;

public interface IPermissionService {

    List<Permission> findAllByPage(int page, int size);

    void savePermission(Permission permission);

    Permission findById(Integer permissionId);

    void deleteById(Integer id);
}
