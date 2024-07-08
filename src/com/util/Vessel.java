package com.util;

import com.dao.*;
import com.dao.Impl.*;
import com.pojo.Log;
import com.pojo.User;
import com.service.*;
import com.service.Impl.*;

public class Vessel {
    public static UserDao userDao = new UserDaoImpl();
    public static UserService userService = new UserServiceImpl();
    public static MenuDao menuDao = new MenuDaoImpl();
    public static MenuService menuService = new MenuServiceImpl();

    public static WarehouseDao warehouseDao = new WarehouseDaoImpl();
    public static WarehouseService warehouseService = new WarehouseServiceImpl();
    public static RoleDao roleDao = new RoleDaoImpl();
    public static RoleService roleService = new RoleServiceImpl();

    public static LogDao logDao = new LogDaoImpl();
    public static LogService logService = new LogServiceImpl();

    public static AppointService appointService = new AppointServiceImpl();
    public static AppointDao appointDao = new AppointDaoImpl();
    public static OrdersDao ordersDao = new OrdersDaoImpl();
    public static OrdersService ordersService = new OrdersServiceImpl();

    public static ShoppingService shoppingService = new ShoppingServiceImpl();
}
