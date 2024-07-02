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
}
