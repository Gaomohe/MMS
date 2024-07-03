package com.service;

import com.pojo.Menu;
import com.util.InitJson;

import java.util.List;

public interface MenuService {
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
}
