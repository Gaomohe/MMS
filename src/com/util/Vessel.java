package com.util;

import com.dao.Impl.UserDaoImpl;
import com.dao.UserDao;
import com.service.Impl.UserServiceImpl;
import com.service.UserService;

public class Vessel {
    public static UserDao userDao = new UserDaoImpl();
    public static UserService userService = new UserServiceImpl();
}
