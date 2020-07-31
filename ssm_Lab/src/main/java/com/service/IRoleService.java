package com.service;

import com.domain.Permission;
import com.domain.Role;

import java.util.List;

public interface IRoleService {

    List<Role> findAllByPage(int page, int size);

    void saveRole(Role role);

    Role findById(Integer roleId);

    List<Permission> findOtherPermissions(Integer roleId);

    void addPermissionToRole(Integer roleId, Integer[] permissionIds);

    void deleteRoleById(Integer roleId);
}
