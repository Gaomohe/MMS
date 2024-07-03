package com.dao;

import com.pojo.Menu;
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
    public int delRole_Res(int id);
    //修改角色信息
    public int updateRole(Role role);
    //新增角色
    public int addRole(Role role);

    //分页
    public List<Role> getRoleAll(int page, int limit);

    //无条件查询获取所有的角色信息
    public List<Role> getRoleAll();

    //重名验证
    public int isUname(Role role);

    //id查所有
    public Role allRoleByRoleid(int roleid);


    public List<Menu> menuByRoleid(int id);

    //删除原有权限
    public int delRoleMenu(int id);

    //添加新的绑定
    public int addNewMenu(int id,int resId);
}
