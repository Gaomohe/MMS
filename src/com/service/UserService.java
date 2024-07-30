package com.service;

import com.pojo.OnlineUser;
import com.pojo.User;
import com.util.LayuiTable;
import com.util.ResultData;

import java.util.List;

public interface UserService {
    //用户登录
    public int login(User user);

    //条件查询用户——通过id查询用户所有信息
    public User getUserById(User user);

    //返回所有用户(分页)--------参数（页数，区间）
    public LayuiTable<User> getAllUser(int page,int limit);

    //删除某个人----------参数（id）
    public ResultData delUser(int id);

    //获取某个人所有信息----------参数（人物id）
    public ResultData allUserByUserid(int id);

    //获取所有权限------------参数（无）
    public ResultData allRole();

    //按照人物id查绑定的角色------------参数（人物id）
    public ResultData queryUserIsRole(int id);

    //更新人员信息-------------参数（User）
    public ResultData doUpdateUser(User user);

    //重名验证-------------参数(名称)
    public ResultData isUname(String name);

    //添加--------------参数（User）
    public ResultData addUser(User user);

    //根据id获取名称
    public String getName(int id);

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
