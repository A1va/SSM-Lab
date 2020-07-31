package com.dao;

import com.domain.Role;
import com.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
//@CacheNamespace(blocking = true)// mybatis 基于注解方式实现配置二级缓存
public interface IUserDao {

    @Select("select * from user where username = #{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(column = "email" ,property = "email"),
            @Result(column = "phoneNum", property = "phoneNum"),
            @Result(column = "status", property = "status"),
            @Result(property = "roles", column = "id",
                    many = @Many(select = "com.dao.IRoleDao.findRoleByUserId", fetchType = FetchType.LAZY))
    })
    User findByUsername(String username);

    @Select("select * from user")
    List<User> findAll();

    @Insert("insert into user(username, password, email, phoneNum, status) values(#{username}, #{password}, #{email}, #{phoneNum}, #{status})")
    void saveUser(User user);

    @Select("select * from user where id = #{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(column = "email" ,property = "email"),
            @Result(column = "phoneNum", property = "phoneNum"),
            @Result(column = "status", property = "status"),
            @Result(property = "roles", column = "id",
                    many = @Many(select = "com.dao.IRoleDao.findRoleByUserId", fetchType = FetchType.LAZY))
    })
    User findById(Integer userId);

    /**
     * 根据姓名查询学生，用于验证注册时用户名是否存在
     * @param userName
     * @return
     */
    @Select("select * from user where username = #{username}")
    User findUserByName(String userName);

    /**
     * 检验是否为有效的用户
     * @param user
     * @return
     */
    @Select("select count(*) from user where username = #{username} and password = #{password}")
    int validateUser(User user);

    /**
     * 根据userId查询出中间表user_role，该用户所关联角色的Id(_roleId)
     * 再根据roleId从role表查出不包含(_roleId)的所有角色信息
     * 即，当前所查的角色信息，均为用户所没有关联的角色信息
     * @param userId
     * @return
     */
    @Select("select * from role where id not in (select roleId from user_role where userId=#{userId})")
    List<Role> findOtherRoles(Integer userId);

    /**
     * 只需要对中间表user_role操作，根据用户ID和角色ID进行添加
     * @param userId
     * @param roleId
     */
    @Insert("insert into user_role(userId,roleId) values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") Integer userId, @Param("roleId") Integer roleId);

    /**
     * 删除学生数据
     * @param userId
     */
    @Delete("delete from user where id = #{id}")
    void deleteUser(Integer userId);

    /**
     * 更新学生数据
     * @param user
     */
    @Update("update user set username = #{username}, password = #{password}, email = #{email}, phoneNum = #{phoneNum}, status = #{status} where id = #{id}")
    void updateUser(User user);

    /**
     * 查找用户数目
     * @return
     */
    @Select("select count(*) from user")
    int findTotalUser();

}
