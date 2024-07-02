package com.dao.Impl;

import com.dao.MenuDao;
import com.pojo.Menu;
import com.util.JDBC;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MenuDaoImpl implements MenuDao {

    //查询所有菜单列表
    @Override
    public List<Menu> getMenuList() {
        String sql = "select * from resources where resId > ?";
        Object[] objects = new Object[1];
        objects[0] = 0;
        ResultSet resultSet = JDBC.select(sql,objects);
        List<Menu> menulist = new ArrayList<Menu>();
        try{
            while(resultSet.next()){
                Menu menu = new Menu();
                menu.setResId(resultSet.getInt(1));
                menu.setName(resultSet.getString(2));
                menu.setParentId(resultSet.getInt(3));
                menu.setResKey(resultSet.getString(4));
                menu.setType(resultSet.getInt(5));
                menu.setResUrl(resultSet.getString(6));
                menu.setLevel(resultSet.getInt(7));
                menu.setIcon(resultSet.getString(8));
                menu.setDescription(resultSet.getString(9));
                menulist.add(menu);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return menulist;
    }

    //通过用户id与目录类型type查询用户目录(查询2级目录)
    @Override
    public List<Menu> getMenuList(int id, int type) {
        String sql = "SELECT * FROM resources\n" +
                "WHERE resId IN (\n" +
                "    SELECT resId FROM role_res\n" +
                "WHERE roleId IN (\n" +
                "    SELECT roleId FROM user_role WHERE userId = ?\n" +
                "    )\n" +
                "    ) AND type = ?;";
        Object[] objects = new Object[2];
        objects[0] = id;
        objects[1] = type;
        ResultSet resultSet = JDBC.select(sql,objects);
        List<Menu> menulist = new ArrayList<Menu>();
        try{
            while(resultSet.next()){
                Menu menu = new Menu();
                menu.setResId(resultSet.getInt(1));
                menu.setName(resultSet.getString(2));
                menu.setParentId(resultSet.getInt(3));
                menu.setResKey(resultSet.getString(4));
                menu.setType(resultSet.getInt(5));
                menu.setResUrl(resultSet.getString(6));
                menu.setLevel(resultSet.getInt(7));
                menu.setIcon(resultSet.getString(8));
                menu.setDescription(resultSet.getString(9));
                menulist.add(menu);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return menulist;
    }

    //通过用户id与菜单的编号id获取用户所在菜单目录的按钮
    @Override
    public List<Menu> getMenuBtn(int id, int resId) {
        String sql = "SELECT * FROM resources WHERE resources.resId IN(\n" +
                "SELECT resid FROM `role_res` WHERE roleid\n" +
                "IN(SELECT roleId FROM `user_role` WHERE userId=?)\n" +
                ") AND TYPE = 1 AND parentId = ?";
        Object[] objects = new Object[2];
        objects[0] = id;
        objects[1] = resId;
        ResultSet resultSet = JDBC.select(sql,objects);
        List<Menu> menulist = new ArrayList<Menu>();
        try{
            while(resultSet.next()){
                Menu menu = new Menu();
                menu.setResId(resultSet.getInt(1));
                menu.setName(resultSet.getString(2));
                menu.setParentId(resultSet.getInt(3));
                menu.setResKey(resultSet.getString(4));
                menu.setType(resultSet.getInt(5));
                menu.setResUrl(resultSet.getString(6));
                menu.setLevel(resultSet.getInt(7));
                menu.setIcon(resultSet.getString(8));
                menu.setDescription(resultSet.getString(9));
                menulist.add(menu);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return menulist;
    }
}
