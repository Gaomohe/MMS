package com.service;

import com.pojo.User;
import com.util.LayuiTable;

public interface UserService {
    //用户登录
    public int login(User user);

    //条件查询用户——通过id查询用户所有信息
    public User getUserById(User user);

    //返回所有用户(分页)--------参数（页数，区间）
    public LayuiTable<User> getAllUser(int page,int limit);


}
