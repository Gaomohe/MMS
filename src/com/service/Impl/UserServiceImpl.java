package com.service.Impl;

import com.dao.Impl.UserDaoImpl;
import com.pojo.User;
import com.service.UserService;
import com.util.LayuiTable;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static com.util.Vessel.userDao;

public class UserServiceImpl implements UserService {
    UserDaoImpl userDao = new UserDaoImpl();
    LayuiTable<User> layuiTable = new LayuiTable<>();
    //用户登录
    @Override
    public int login(User user) {
        return userDao.login(user);
    }

    //条件查询用户——通过id查询用户所有信息
    @Override
    public User getUserById(User user) {
        return null;
    }

    @Override
    public LayuiTable<User> getAllUser(int page, int limit) {
        ResultSet userSet = userDao.getAll(page, limit, "user");
        List<User> userList = new ArrayList<>();
        int count = 0;
        try {
            while (userSet.next()){
                User user = new User();
                user.setId(userSet.getInt(1));
                user.setUserName(userSet.getString(2));
                user.setPassword(userSet.getString(3));
                user.setCardBalance(userSet.getInt(4));
                user.setCode(userSet.getString(5));
                user.setTelNumber(userSet.getString(6));
                user.setAddress(userSet.getString("address"));
                user.setSex(userSet.getString("sex"));
                user.setAge(userSet.getInt("age"));
                user.setBirthday(userSet.getString("birthday"));
                user.setCreateDate(userSet.getString("createDate"));
                user.setWechat(userSet.getString("wechat"));
                userList.add(user);
                count++;
            }
            layuiTable.setCode(0);
            layuiTable.setData(userList);
            layuiTable.setCount(count);
            layuiTable.setMsg("");


        }catch (Exception e){
            e.printStackTrace();
        }
        return layuiTable;
    }
}