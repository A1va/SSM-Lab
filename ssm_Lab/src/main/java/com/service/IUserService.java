package com.service;
/*
 * Created by Nolva on 2020/7/8.
 */


import com.domain.Role;
import com.domain.User;

import java.util.List;

public interface IUserService {

    List<User> findAllByPage(int page, int size);

    /**
     * 根据姓名查询学生
     * @param userName
     * @return
     */
    User findUserByName(String userName);

    /**
     * 删除学生数据
     * @param userId
     */
    void deleteUser(Integer userId);

    /**
     * 更新学生数据
     * @param user
     */
    void updateUser(User user);

    /**
     * 检验用户是否有效
     * @param user
     * @return
     */
    int validateUser(User user);

    /**
     * 登录逻辑
     * @param user
     * @return
     */
    int userLogin(User user);

    /**
     * 查询用户总数
     * @return
     */
    int findTotalUser();

    boolean saveUser(User user);

    User findById(Integer userId);

    List<Role> findOtherRoles(Integer userId);

    void addRoleToUser(Integer userId, Integer[] roleIds);

}
