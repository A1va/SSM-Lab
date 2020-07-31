package com.dao;

import com.domain.Permission;
import com.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("roleDao")
//@CacheNamespace(blocking = true)// mybatis 基于注解方式实现配置二级缓存
public interface IRoleDao {

    //根据用户id查询出所有对应的角色
    @Select("select * from role where id in (select roleId from user_role where userId = #{userId})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions",column = "id",
                    many = @Many(select = "com.dao.IPermissionDao.findPermissionByRoleId"))
    })
    List<Role> findRoleByUserId(Integer userId) throws Exception;

    @Select("select * from role")
    List<Role> findAll();

    @Insert("insert into role(roleName,roleDesc) values(#{roleName}, #{roleDesc})")
    void saveRole(Role role);

    @Select("select * from role where id=#{roleId}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "com.dao.IPermissionDao.findPermissionByRoleId"))
    })
    Role findById(Integer roleId);

    /**
     * 根据roleId查询出中间表role_permission，该角色所关联权限的Id(_permissionId)
     * 再根据permissionId从permission表查出不包含(_permissionId)的所有权限信息
     * 即，所查的权限信息，均为当前角色所没有关联的权限信息
     * @param roleId
     * @return
     */
    @Select("select * from permission where id not in (select permissionId from role_permission where roleId=#{roleId})")
    List<Permission> findOtherPermissions(Integer roleId);

    @Insert("insert into role_permission(roleId,permissionId) values(#{roleId},#{permissionId})")
    void addPermissionToRole(@Param("roleId") Integer roleId, @Param("permissionId") Integer permissionId);

    @Delete("delete from users_role where roleId=#{roleId}")
    void deleteFromUser_RoleByRoleId(Integer roleId);

    @Delete("delete from role_permission where roleId=#{roleId}")
    void deleteFromRole_PermissionByRoleId(Integer roleId);

    @Delete("delete from role where id=#{roleId}")
    void deleteRoleById(Integer roleId);


}
