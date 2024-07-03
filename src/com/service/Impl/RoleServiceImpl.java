package com.service.Impl;

import com.dao.RoleDao;
import com.pojo.Menu;
import com.pojo.Role;
import com.service.RoleService;
import com.util.Dtree;
import com.util.LayuiTable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.util.Vessel.roleDao;

public class RoleServiceImpl implements RoleService {
    @Override
    public List<Role> getRoleList() {
        return roleDao.selectAllRole();
    }

    @Override
    public Role getRoleById(int id) {
        return roleDao.getRoleById(id);
    }

    @Override
    public int delRoleById(int id) {
        int i = roleDao.delRole(id);
        int i1 = roleDao.delRole_Res(id);
        return i+i1;
    }

    @Override
    public int updateDoRole(Role role) {
        return roleDao.updateRole(role);
    }

    @Override
    public int addDoRole(Role role) {
        return roleDao.addRole(role);
    }

    @Override
    public int isUname(Role role) {
        return roleDao.isUname(role);
    }

    //获取角色全部权限
    @Override
    public LayuiTable<Dtree> getMenus() {
        LayuiTable<Dtree> layuiTable = new LayuiTable<>();
        List<Menu> menuList = roleDao.getMenus();
        List<Dtree> treeTableList = new ArrayList<>();
        for (Menu menu : menuList) {
            Dtree dtree = new Dtree();
            dtree.setId(menu.getResId());
            dtree.setTitle(menu.getName());
            dtree.setParentId(menu.getParentId());
            dtree.setCheckArr("0");
            treeTableList.add(dtree);
        }
        layuiTable.setMsg("");
        layuiTable.setCode(0);
        layuiTable.setCount(100);
        layuiTable.setData(treeTableList);
        return layuiTable;
    }

    //回显角色已有权限
    @Override
    public List<Menu> menuByRoleid(int id) {
        return roleDao.menuByRoleid(id);
    }

    //修改角色权限
    @Override
    public int UpdateRoleMenu(int id,int[] resId) {
        int i = roleDao.delRoleMenu(id);//删除角色原有权限
        int i1 = 0;
        int i2 = 0;
        for (int j = 0; j < resId.length; j++) {
            i1 = roleDao.addNewMenu(id, resId[j]);//为角色添加新权限
        }
        if (i > 0 && i1 > 0){
            i2 = 1;
        }
        return i2;
    }
}
