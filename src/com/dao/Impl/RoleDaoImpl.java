package com.dao.Impl;

import com.dao.RoleDao;
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
        Role role = new Role();
        try {
            while (baseSelect.next()){
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
        String sql=" insert into ly_user(state,name,roleKey,description) value(?,?,?,?)";
        Object[]  objects= new Object[4];
        objects[0]=role.getState();
        objects[1]=role.getName();
        objects[2]=role.getRoleKey();
        objects[3]=role.getDescription();
        int count= JDBC.update(sql,objects);
        return count;
    }
}
