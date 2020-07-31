package com.service.impl;
/*
 * Created by Nolva on 2020/7/8.
 */

import com.dao.IRoleDao;
import com.domain.Permission;
import com.domain.Role;
import com.github.pagehelper.PageHelper;
import com.service.IRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("roleService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)//只读型事务的配置
public class RoleServiceImpl implements IRoleService {

    private final IRoleDao roleDao;

    public RoleServiceImpl(IRoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<Role> findAllByPage(int page, int size) {
        PageHelper.startPage(page, size);
        return roleDao.findAll();
    }

    @Override
    public void saveRole(Role role) {
        roleDao.saveRole(role);
    }

    @Override
    public Role findById(Integer roleId) {
        return roleDao.findById(roleId);
    }

    @Override
    public List<Permission> findOtherPermissions(Integer roleId) {
        return roleDao.findOtherPermissions(roleId);
    }

    /**
     * 为角色添加权限
     * 根据permissionIds，获取所有需要增加的权限
     * 通过roleDao为逐个角色增加权限
     * @param roleId
     * @param permissionIds
     */
    @Override
    public void addPermissionToRole(Integer roleId, Integer[] permissionIds) {
        for(Integer permissionId:permissionIds){
            roleDao.addPermissionToRole(roleId,permissionId);
        }
    }

    /**
     * 根据角色Id删除所有关联的角色信息
     * 先从有依赖关系的user_role和role_permission删除
     * @param roleId
     */
    @Override
    public void deleteRoleById(Integer roleId) {

        //从user_role表中删除
        roleDao.deleteFromUser_RoleByRoleId(roleId);
        //从role_permission表中删除
        roleDao.deleteFromRole_PermissionByRoleId(roleId);
        //从role表中删除
        roleDao.deleteRoleById(roleId);
    }
}
