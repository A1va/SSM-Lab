package com.service.impl;/*
 * Created by Nolva on 2020/7/8.
 */

import com.dao.IUserDao;
import com.domain.Role;
import com.domain.User;
import com.github.pagehelper.PageHelper;
import com.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)//只读型事务的配置
public class UserServiceImpl implements IUserService {

    private final IUserDao userDao;

    public UserServiceImpl(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> findAllByPage(int page, int size) {
        PageHelper.startPage(page, size);
        return userDao.findAll();
    }

    /**
     * 用户添加逻辑：若用户名存在，返回false；用户名不存在，则创建用户并返回true.
     */
    @Override
    public boolean saveUser(User user) {
//        对密码进行加密
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User isPresence = userDao.findUserByName(user.getUsername());
        if (isPresence == null){
            userDao.saveUser(user);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public User findById(Integer userId) {
        return userDao.findById(userId);
    }

    @Override
    public List<Role> findOtherRoles(Integer userId) {
        return userDao.findOtherRoles(userId);
    }

    /**
     * 从得到的roleIDs中，循环为userId对应的用户添加角色
     * @param userId
     * @param roleIds
     */
    @Override
    public void addRoleToUser(Integer userId, Integer[] roleIds) {
        for(Integer roleId:roleIds){
            userDao.addRoleToUser(userId, roleId);
        }
    }

    @Override
    public User findUserByName(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public void deleteUser(Integer userId) {
        userDao.deleteUser(userId);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public int validateUser(User user) {
        List<Role> roles = user.getRoles();
        for (Role role : roles){
            if (role.getRoleName().equals("ADMIN")){
                user.setRoleStr(1);
            }else {
                user.setRoleStr(0);
            }
        }
        return userDao.validateUser(user);
    }

    /**
     * 登录逻辑：
     * 1. 用户名和密码正确，返回1
     * 2. 判断用户名是否存在，若存在，密码错误，返回-1
     * 3. 用户名不存在，返回0
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public int userLogin(User user){
//        检测用户名和密码，是否为有效用户
        if (userDao.validateUser(user) > 0){
            return 1;
        }else {
//            用户名或密码错误
//            1. 用户名存在，说明密码错误
            if (userDao.findUserByName(user.getUsername()) != null){
                return -1;
            }else {
//            2. 否则用户名不存在
                return 0;
            }
        }
    }

    @Override
    public int findTotalUser() {
        return userDao.findTotalUser();
    }

}
