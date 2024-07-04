package com.dao;

import com.pojo.Btn;
import com.pojo.Menu;

import java.util.List;

public interface MenuDao {
    //查询所有菜单列表
    public List<Menu> getMenuList();

    //通过用户id与目录类型type查询用户目录(查询2级目录)
    public List<Menu> getMenuList(int id,int type);

    //通过资源ID查找资源
    public Menu getMenuById(int id);
    //通过用户id与菜单的编号id获取用户所在菜单目录的按钮
    public List<Menu> getMenuBtn(int id,int resId);
    //通过菜单唯一标识判断菜单是否存在
    public Menu isExist(String s);
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

    //根据id获取所有目录
    public List<Menu> allMenuById(Menu menu);

    //跟据据id获取父级名称
    public List<Menu> getFatherName(int id);

    //判断权限名是否存在
    public int isMenuName(Menu menu);

    //判断请求路径是否存在
    public int isMenuUrl(Menu menu);
}
