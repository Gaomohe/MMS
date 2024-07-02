package com.service;

import com.pojo.Menu;
import com.util.InitJson;

import java.util.List;

public interface MenuService {
    //查询所有菜单列表
    public List<Menu> getMenuList();

    //通过用户id与目录类型type查询用户目录(查询2级目录)
    public InitJson getMenuList(int id);

    //通过用户id与菜单的编号id获取用户所在菜单目录的按钮
    public List<Menu> getMenuBtn(int id,int resId);
}