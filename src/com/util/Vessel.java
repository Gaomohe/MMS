package com.util;

import com.dao.Impl.MenuDaoImpl;
import com.dao.Impl.UserDaoImpl;
import com.dao.MenuDao;
import com.dao.UserDao;
import com.service.Impl.MenuServiceImpl;
import com.service.Impl.UserServiceImpl;
import com.service.MenuService;
import com.service.UserService;

public class Vessel {
    public static UserDao userDao = new UserDaoImpl();
    public static UserService userService = new UserServiceImpl();
    public static MenuDao menuDao = new MenuDaoImpl();
    public static MenuService menuService = new MenuServiceImpl();
}
