package com.service;

import com.pojo.Menu;
import com.pojo.Role;
import com.pojo.Warehouse;
import com.util.Dtree;
import com.util.LayuiTable;

import java.util.List;

public interface RoleService {
    public List<Role> getRoleList();
    public Role getRoleById(int id);
    public int delRoleById(int id);
    public int updateDoRole(Role role);
    public int addDoRole(Role role);
    //重名验证
    public int isUname(Role role);

    //获取角色全部权限
    public LayuiTable<Dtree> getMenus();

    //回显角色已有权限
    public List<Menu> menuByRoleid(int id);

    //修改角色绑定的权限
    public int UpdateRoleMenu(int id,int[] resId);
}
