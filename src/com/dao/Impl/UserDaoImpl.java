package com.dao.Impl;

import com.dao.UserDao;
import com.pojo.User;
import com.util.JDBC;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class UserDaoImpl implements UserDao {

    //用户登录
    @Override
    public int login(User user) {
        String sql = "select * from user where id=? and password=?";
        Object[] objects = new Object[2];
        objects[0] = user.getId();
        objects[1] = user.getPassword();
        ResultSet resultSet = JDBC.select(sql,objects);
        List<User> userList = new ArrayList<User>();
        int count = 0;
        try{
            while(resultSet.next()){
                User user1 = new User();
                user1.setId(resultSet.getInt("id"));
                count = user1.getId();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return count;
    }
}
