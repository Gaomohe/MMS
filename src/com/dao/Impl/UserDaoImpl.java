package com.dao.Impl;

import com.dao.Impl.init.InitDaoImpl;
import com.dao.UserDao;
import com.pojo.User;
import com.util.JDBC;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class UserDaoImpl extends InitDaoImpl implements UserDao {

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

    @Override
    public ResultSet queryUserIsRole(int id) {
        String sql = "select * from role where id in (select roleId from user_role where userId = ?)";
        Object[] objects = new Object[]{id};
        return JDBC.select(sql,objects);
    }

    @Override
    public boolean doUpdateUser(User user) {
        String sql = "update user set userName=?,password=?,cardBalance=?,code=?,telNumber=?,address=?,sex=?,age=?,birthday=?,createDate=?,wechat=? where id=?";
        Object[] objects = new Object[]{user.getUserName(),user.getPassword(),user.getCardBalance(),user.getCode(),user.getTelNumber(),user.getAddress(),user.getSex(),user.getAge(),user.getBirthday(),user.getCreateDate(),user.getWechat(),user.getId()};
        return JDBC.update(sql,objects) > 0;
    }

    @Override
    public boolean addUser(User user) {
        String sql = "insert into user(userName, password, cardBalance, code, telNumber, address, sex, age, birthday, createDate, wechat) VALUE (?,?,?,?,?,?,?,?,?,?,?)";
        Object[] objects = new Object[]{user.getUserName(),user.getPassword(),user.getCardBalance(),user.getCode(),user.getTelNumber(),user.getAddress(),user.getSex(),user.getAge(),user.getBirthday(),user.getCreateDate(),user.getWechat()};
        return JDBC.update(sql,objects) > 0;
    }


}
