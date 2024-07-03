package com.service.Impl;

import com.dao.RoleDao;
import com.pojo.Role;
import com.service.RoleService;

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
}
