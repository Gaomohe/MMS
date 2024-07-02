package com.service.Impl;

import com.pojo.User;
import com.service.UserService;

import static com.util.Vessel.userDao;

public class UserServiceImpl implements UserService {
    //用户登录
    @Override
    public int login(User user) {
        return userDao.login(user);
    }

    //条件查询用户——通过id查询用户所有信息
    @Override
    public User getUserById(User user) {
        return null;
    }
}