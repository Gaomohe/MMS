package com.service;

import com.pojo.Role;
import com.pojo.Warehouse;

import java.util.List;

public interface RoleService {
    public List<Role> getRoleList();
    public Role getRoleById(int id);
    public int delRoleById(int id);
    public int updateDoRole(Role role);
    public int addDoRole(Role role);
}
