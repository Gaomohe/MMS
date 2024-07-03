package com.dao.Impl;

import com.dao.RoleDao;
import com.pojo.Menu;
import com.pojo.Role;
import com.pojo.User;
import com.util.JDBC;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoleDaoImpl implements RoleDao {
    @Override
    public List<Role> selectAllRole() {
        String sql=" select * from role";
        ResultSet baseSelect = JDBC.select(sql, new Object[1]);
        List<Role> roleList = new ArrayList<Role>();
        try {
            while (baseSelect.next()){
                Role role = new Role();
                role.setId(baseSelect.getInt(1));
                role.setState(baseSelect.getInt(2));
                role.setName(baseSelect.getString(3));
                role.setRoleKey(baseSelect.getString(4));
                role.setDescription(baseSelect.getString(5));
                roleList.add(role);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return roleList;

    }

    @Override
    public Role getRoleById(int id) {
        String sql=" select * from role where id=?";
        Object[]  objects= new Object[1];
        objects[0]=id;
        ResultSet baseSelect = JDBC.select(sql, objects);
        Role role = new Role();
        try {
            while (baseSelect.next()){
                role.setId(baseSelect.getInt(1));
                role.setState(baseSelect.getInt(2));
                role.setName(baseSelect.getString(3));
                role.setRoleKey(baseSelect.getString(4));
                role.setDescription(baseSelect.getString(5));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return role;
    }

    @Override
    public int delRole(int id) {
        String sql=" delete from role where id=?";
        Object[]  objects= new Object[1];
        objects[0]=id;
        int count= JDBC.update(sql,objects);
        return count;
    }
    public int delRole_Res(int id) {
        String sql=" DELETE FROM `role_res` WHERE `roleId`=?";
        Object[]  objects= new Object[1];
        objects[0]=id;
        int count= JDBC.update(sql,objects);
        return count;
    }

    @Override
    public int updateRole(Role role) {
        String sql=" update role set state=?,name=?,roleKey=?,description=? where id=?";
        Object[]  objects= new Object[5];
        objects[0]=role.getState();
        objects[1]=role.getName();
        objects[2]=role.getRoleKey();
        objects[3]=role.getDescription();
        objects[4]=role.getId();
        int count= JDBC.update(sql,objects);
        return count;
    }

    @Override
    public int addRole(Role role) {
        String sql=" insert into role(state,name,roleKey,description) value(?,?,?,?)";
        Object[]  objects= new Object[4];
        objects[0]=role.getState();
        objects[1]=role.getName();
        objects[2]=role.getRoleKey();
        objects[3]=role.getDescription();
        int count= JDBC.update(sql,objects);
        return count;
    }






    @Override
    public List<Role> getRoleAll(int page, int limit) {
        String sql=" select * from ly_role limit ?,?";
        Object[]  objects= new Object[2];
        objects[0]=page;
        objects[1]=limit;
        ResultSet resultSet = JDBC.select(sql, objects);
        List<Role> roleList = new ArrayList<Role>();
        try {
            while (resultSet.next()){
                Role role = new Role();
                role.setId(resultSet.getInt(1));
                role.setState(resultSet.getInt(2));
                role.setName(resultSet.getString(3));
                role.setRoleKey(resultSet.getString(4));
                role.setDescription(resultSet.getString(5));
                roleList.add(role);
                roleList.add(role);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return roleList;
    }

    @Override
    public List<Role> getRoleAll() {
        String sql="select * from ly_role";
        Object[]  objects= new Object[1];

        ResultSet resultSet = JDBC.select(sql, objects);
        List<Role> roleList = new ArrayList<Role>();
        try {
            while (resultSet.next()){
                Role role = new Role();
                role.setId(resultSet.getInt(1));
                role.setState(resultSet.getInt(2));
                role.setName(resultSet.getString(3));
                role.setRoleKey(resultSet.getString(4));
                role.setDescription(resultSet.getString(5));
                roleList.add(role);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return roleList;
    }

    @Override
    public int isUname(Role role) {
        String sql="select * from ly_role where name=?";
        Object[]  objects= new Object[1];
        objects[0]=role.getName();
        ResultSet resultSet = JDBC.select(sql, objects);
        int i = 0;
        try {
            while(resultSet.next()){
                Role role1 = new Role();
                role1.setId(resultSet.getInt(1));
                i = role1.getId();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public Role allRoleByRoleid(int roleid) {
        String sql = "SELECT * FROM ly_role WHERE id=?";
        Object[] objects= new Object[1];
        objects[0]=roleid;
        ResultSet resultSet = JDBC.select(sql, objects);
        Role role1 = new Role();
        try{
            while (resultSet.next()){
                Role role = new Role();
                role.setId(resultSet.getInt(1));
                role.setState(resultSet.getInt(2));
                role.setName(resultSet.getString(3));
                role.setRoleKey(resultSet.getString(4));
                role.setDescription(resultSet.getString(5));
                role1 = role;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return role1;
    }




    @Override
    public List<Menu> menuByRoleid(int id) {
        String sql = "SELECT * FROM ly_role_res WHERE roleid=?";
        Object[] objects = new Object[1];
        objects[0]=id;
        ResultSet resultSet = JDBC.select(sql,objects);
        List<Menu> List = new ArrayList<>();
        try{
            while(resultSet.next()){
                Menu menu = new Menu();
                menu.setResId(resultSet.getInt(1));
                List.add(menu);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return List;
    }



    @Override
    public int delRoleMenu(int id) {
        String sql="DELETE FROM ly_role_res WHERE roleid = ?";
        Object[]  objects= new Object[1];
        objects[0]=id;
        int count= JDBC.update(sql,objects);
        return count;
    }

    @Override
    public int addNewMenu(int id, int resId) {
        String sql=" insert into ly_role_res(roleid,resid) value(?,?)";
        Object[]  objects= new Object[2];
        objects[0]=id;
        objects[1]=resId;
        int count= JDBC.update(sql,objects);
        return count;
    }
}
