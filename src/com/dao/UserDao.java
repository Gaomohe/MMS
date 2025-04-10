package com.dao;

import com.pojo.OnlineUser;
import com.pojo.User;
import com.util.ResultData;

import java.sql.ResultSet;
import java.util.List;

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

    //申请人姓名回显
    public List<User> getAppUser();

    //药师姓名的回显
    public List<User> getPhaName();

    //财务姓名的回显
    public List<User> getFinName();

    public String getUserName(int id);

    //获得所有在线用户
    public List<OnlineUser> getActiveUser();
    //改变用户登录时间
    public int upUserOnlineTime(int id);
    //改变登录状态
    public int upCode(User user);
}
