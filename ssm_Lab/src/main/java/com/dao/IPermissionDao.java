package com.dao;

import com.domain.Permission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("permissionDao")
//@CacheNamespace(blocking = true)// mybatis 基于注解方式实现配置二级缓存
public interface IPermissionDao {

    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{id})")
    List<Permission> findPermissionByRoleId(Integer permissionId);

    @Select("select * from permission")
    List<Permission> findAll();

    @Insert("insert into permission(permissionName, url) values(#{permissionName}, #{url})")
    void savePermission(Permission permission);

    @Select("select * from permission where id = #{id}")
    Permission findById(Integer permissionId);

    @Delete("delete from role_permission where permissionId=#{id}")
    void deleteFromRole_Permission(Integer id) ;

    @Delete("delete from permission where id=#{id}")
    void deleteById(Integer id) ;
}
