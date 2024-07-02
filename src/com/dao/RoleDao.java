package com.dao;

import com.pojo.Role;
import com.pojo.User;

import java.util.List;

public interface RoleDao {
    //查询全部角色
    public List<Role> selectAllRole();
    //根据id查询角色信息
    public Role getRoleById(int id);
    //根据id删除角色
    public int delRole(int id);
    //修改角色信息
    public int updateRole(Role role);
    //新增角色
    public int addRole(Role role);
}
