package com.dao.Impl;

import com.dao.MenuDao;
import com.pojo.Btn;
import com.pojo.Menu;
import com.util.JDBC;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
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

    @Override
    public Menu getMenuById(int id) {
        String sql = "select * from resources where resId = ?";
        Object[] objects = new Object[1];
        objects[0] = id;
        ResultSet resultSet = JDBC.select(sql,objects);
        Menu menu = new Menu();
        try{
            while(resultSet.next()){
                menu.setResId(resultSet.getInt(1));
                menu.setName(resultSet.getString(2));
                menu.setParentId(resultSet.getInt(3));
                menu.setResKey(resultSet.getString(4));
                menu.setType(resultSet.getInt(5));
                menu.setResUrl(resultSet.getString(6));
                menu.setLevel(resultSet.getInt(7));
                menu.setIcon(resultSet.getString(8));
                menu.setDescription(resultSet.getString(9));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return menu;
    }


    //通过用户id与菜单的编号id获取用户所在菜单目录的按钮
    @Override
    public List<Menu> getMenuBtn(int id, int resId) {
        String sql = "SELECT * FROM resources WHERE resources.resId IN(\n" +
                "SELECT resid FROM `role_res` WHERE roleid\n" +
                "IN(SELECT roleId FROM `user_role` WHERE userId=?)\n" +
                ") AND TYPE = 2 AND parentId = ?";
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

    @Override
    public Menu isExist(String s) {
        String sql = "SELECT * FROM `resources` WHERE `resKey`= ?;";
        Object[] objects = new Object[1];
        objects[0] = "'"+s+"'";
        ResultSet resultSet = JDBC.select(sql,objects);
        Menu menu = new Menu();
        try{
            while(resultSet.next()){
                menu.setResKey(resultSet.getString(4));
                System.out.println(menu.getResKey());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return menu;
    }

    //新增菜单
    @Override
    public int addMenu(Menu menu) {
        String sql="INSERT INTO `resources` \n" +
                "(`name`,`parentId`,`resKey`,`type`,`resUrl`,`level`,`icon`,`description`) \n" +
                "VALUES \n" +
                "(?,?,?,?,?,?,?,?);";
        Object[] objects= new Object[8];
        objects[0] = menu.getName();
        objects[1] = menu.getParentId();
        objects[2] = menu.getResKey();
        objects[3] = menu.getType();
        objects[4] = menu.getResUrl();
        objects[5] = menu.getLevel();
        objects[6] = menu.getIcon();
        objects[7] = menu.getDescription();
        int count= JDBC.update(sql,objects);
        return count;
    }

    //删除菜单
    @Override
    public int delMenu(int id) {
        String sql="DELETE FROM `resources` WHERE `resId` = ?";
        Object[]  objects= new Object[1];
        objects[0]=id;
        int count= JDBC.update(sql,objects);
        return count;
    }

    //修改菜单
    @Override
    public int updateMenu(Menu menu) {
        String sql="UPDATE `resources` SET " +
                "`name`=?,`parentId`=?,`resKey`=?,`type`=?, `resUrl`=?,`level`=?,`icon`=?,`description`=?" +
                "WHERE `resId`=?";
        Object[]  objects= new Object[9];
        objects[0] = menu.getName();
        objects[1] = menu.getParentId();
        objects[2] = menu.getResKey();
        objects[3] = menu.getType();
        objects[4] = menu.getResUrl();
        objects[5] = menu.getLevel();
        objects[6] = menu.getIcon();
        objects[7] = menu.getDescription();
        objects[8] = menu.getResId();
        int count= JDBC.update(sql,objects);
        return count;
    }

    //获取所有按钮
    @Override
    public List<Btn> getBtnAll() {
        String sql=" SELECT * FROM button where id > ?";
        Object[]  objects= new Object[1];
        objects[0]=0;
        ResultSet resultSet = JDBC.select(sql, objects);
        List<Btn> list = new ArrayList<Btn>();
        try {
            while (resultSet.next()){
                Btn btn = new Btn();
                btn.setBtnType(resultSet.getString("btntype"));
                list.add(btn);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    //根据目录类型获取目录
    @Override
    public List<Menu> getMenuByType(int type) {
        String sql=" SELECT * FROM `resources` WHERE type = ? ";
        Object[]  objects= new Object[1];
        objects[0]=type;
        ResultSet baseSelect = JDBC.select(sql, objects);
        List<Menu> list = new ArrayList<Menu>();
        try {
            while (baseSelect.next()){
                Menu menus = new Menu();
                menus.setResId(baseSelect.getInt(1));
                menus.setName(baseSelect.getString(2));
                menus.setResUrl(baseSelect.getString("resUrl"));
                list.add(menus);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    //根据id获取所有目录
    @Override
    public List<Menu> allMenuById(Menu menu) {
        String sql = "SELECT * FROM `resources` WHERE resId =?";
        Object[] objects = new Object[1];
        objects[0]=menu.getResId();
        ResultSet resultSet = JDBC.select(sql, objects);
        List<Menu> menuList = new ArrayList<>();
        try{
            while (resultSet.next()){
                Menu menus = new Menu();
                menus.setResId(resultSet.getInt(1));
                menus.setName(resultSet.getString(2));
                menus.setParentId(resultSet.getInt(3));
                menus.setResKey(resultSet.getString(4));
                menus.setType(resultSet.getInt(5));
                menus.setResUrl(resultSet.getString(6));
                menus.setLevel(resultSet.getInt(7));
                menus.setIcon(resultSet.getString(8));
                menus.setDescription(resultSet.getString(9));
                menuList.add(menus);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return menuList;
    }

    @Override
    public List<Menu> getFatherName(int id) {
        String sql = "SELECT * FROM `resources` WHERE resId =?";
        Object[] objects = new Object[1];
        objects[0] = id;
        ResultSet resultSet = JDBC.select(sql, objects);
        List<Menu> menuList = new ArrayList<>();
        try{
            while (resultSet.next()){
                Menu menus = new Menu();
                menus.setName(resultSet.getString(2));
                menuList.add(menus);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return menuList;
    }

    @Override
    public int isMenuName(Menu menu) {
        int num = 0;
        String sql = "SELECT * FROM `resources` WHERE name = ?";
        Object[] objects = new Object[1];
        objects[0]=menu.getName();
        ResultSet resultSet = JDBC.select(sql, objects);
        try {
            while (resultSet.next()){
                Menu menus = new Menu();
                menus.setResId(resultSet.getInt(1));
                num = menus.getResId();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return num;
    }

    //验证请求路径是否存在
    @Override
    public int isMenuUrl(Menu menu) {
        int num = 0;
        String sql = "SELECT * FROM `resources` WHERE resUrl = ?";
        Object[] objects = new Object[1];
        objects[0]=menu.getResUrl();
        ResultSet resultSet = JDBC.select(sql, objects);
        try {
            while (resultSet.next()){
                Menu menus = new Menu();
                menus.setResId(resultSet.getInt(1));
                num = menus.getResId();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return num;
    }
}
