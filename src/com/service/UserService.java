package com.service;

import com.pojo.User;

public interface UserService {
    //用户登录
    public int login(User user);

    //条件查询用户——通过id查询用户所有信息
    public User getUserById(User user);


}
