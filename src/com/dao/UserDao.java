package com.dao;

import com.pojo.User;
import com.util.ResultData;

import java.sql.ResultSet;

public interface UserDao {
    //用户登录
    public int login(User user);

    //查询用户有没有角色----------参数（用户id）
    public ResultSet queryUserIsRole(int id);

    //更新---------------参数(User)
    public boolean doUpdateUser(User user);

    //添加--------------参数（User）
    public boolean addUser(User user);

    //根据id查询用户名称
    public ResultSet getNameById(int id);



}
