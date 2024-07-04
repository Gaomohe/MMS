package com.service;

import com.pojo.Btn;
import com.pojo.Menu;
import com.util.InitJson;
import com.util.LayuiTable;
import com.util.TreeTable;

import java.util.List;

public interface MenuService {
    //获取所有权限目录
    public LayuiTable<TreeTable> getMenus();
    //查询所有菜单列表
    public List<Menu> getMenuList();

    //通过用户id与目录类型type查询用户目录(查询2级目录)
    public InitJson getMenuList(int id);

    //通过资源ID查找资源
    public Menu getMenuById(int id);

    //通过用户id与菜单的编号id获取用户所在菜单目录的按钮
    public List<Menu> getMenuBtn(int id,int resId);

    //通过菜单唯一标识判断菜单是否存在
    public boolean isExist(String s);

    //添加新菜单列表
    public int addMenu(Menu menu);

    //根据ID删除菜单列表
    public int delMenu(int id);

    //修改菜单信息
    public int updateMenu(Menu menu);

    //获取所有按钮
    public List<Btn> getBtnAll();

    //根据目录类型获取目录
    public List<Menu> getMenuByType(int type);

    //通过目录id获取目录
    public Menu allMenuById(Menu menu);

    //跟据id获取父级名称
    public Menu getFatherName(int id);

    //判断权限名是否存在
    public int isMenuName(Menu menu);

    //判断请求路径是否存在
    public int isMenuUrl(Menu menu);
}
