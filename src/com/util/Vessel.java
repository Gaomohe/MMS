package com.util;

import com.dao.Impl.MenuDaoImpl;
import com.dao.Impl.RoleDaoImpl;
import com.dao.Impl.UserDaoImpl;
import com.dao.Impl.WarehouseDaoImpl;
import com.dao.MenuDao;
import com.dao.RoleDao;
import com.dao.UserDao;
import com.dao.WarehouseDao;
import com.service.Impl.MenuServiceImpl;
import com.service.Impl.RoleServiceImpl;
import com.service.Impl.UserServiceImpl;
import com.service.Impl.WarehouseServiceImpl;
import com.service.MenuService;
import com.service.RoleService;
import com.service.UserService;
import com.service.WarehouseService;

public class Vessel {
    public static UserDao userDao = new UserDaoImpl();
    public static UserService userService = new UserServiceImpl();
    public static MenuDao menuDao = new MenuDaoImpl();
    public static MenuService menuService = new MenuServiceImpl();

    public static WarehouseDao warehouseDao = new WarehouseDaoImpl();
    public static WarehouseService warehouseService = new WarehouseServiceImpl();
    public static RoleDao roleDao = new RoleDaoImpl();
    public static RoleService roleService = new RoleServiceImpl();
}
