package com.service.Impl;

import com.dao.Impl.UserDaoImpl;
import com.pojo.Role;
import com.pojo.User;
import com.service.UserService;
import com.util.LayuiTable;
import com.util.ResultData;

import javax.print.attribute.standard.NumberUp;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static com.util.Vessel.userDao;

public class UserServiceImpl implements UserService {
    UserDaoImpl userDao = new UserDaoImpl();
    LayuiTable<User> layuiTable = new LayuiTable<>();
    ResultData resultData = new ResultData();
    RoleServiceImpl roleService = new RoleServiceImpl();
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
            ResultSet userDaoAll = userDao.getAll("user");
            while (userDaoAll.next()){
                count++;
            }
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

    @Override
    public ResultData delUser(int id) {
        if (userDao.delOne(id,"id","user")){
            resultData.setStatus(200);
            resultData.setMsg("删除成功");
            resultData.setData(null);
        }else {
            resultData.setStatus(400);
            resultData.setMsg("删除失败");
            resultData.setData(null);
        }
        return resultData;
    }

    @Override
    public ResultData allUserByUserid(int id) {
        ResultSet userSet = userDao.getOne(id, "id", "user");
        User user = new User();
        try {
            if (userSet.next()){
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
            }
            resultData.setData(user);
            resultData.setMsg("");
            resultData.setStatus(200);

        }catch (Exception e){
            e.printStackTrace();
        }
        return resultData;
    }

    @Override
    public ResultData allRole() {
        resultData.setData(roleService.getRoleList());
        resultData.setStatus(200);
        resultData.setMsg("");
        return resultData;
    }

    @Override
    public ResultData queryUserIsRole(int id) {
        ResultSet resultSet = userDao.queryUserIsRole(id);
        try {
            Role role = new Role();
            if (resultSet.next()){
                role.setId(resultSet.getInt(1));
                role.setState(resultSet.getInt(2));
                role.setName(resultSet.getString(3));
                role.setRoleKey(resultSet.getString(4));
                role.setDescription(resultSet.getString(5));
                resultData.setData(role);
                resultData.setStatus(200);
                resultData.setMsg("");
            }else {
                resultData.setData(null);
                resultData.setStatus(400);
                resultData.setMsg("没有绑定角色");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return resultData;
    }

    @Override
    public ResultData doUpdateUser(User user) {
        try {
            if (userDao.doUpdateUser(user)){
                resultData.setStatus(200);
                resultData.setMsg("更新成功");
                resultData.setData(null);
            }else {
                resultData.setStatus(400);
                resultData.setMsg("更新失败");
                resultData.setData(null);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return resultData;
    }

    @Override
    public ResultData isUname(String name) {
        try {
            if (userDao.getOne(name,"userName","user").next()){
                resultData.setData(null);
                resultData.setMsg("有重名");
                resultData.setStatus(400);
            }else {
                resultData.setData(null);
                resultData.setMsg("没有重名");
                resultData.setStatus(200);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return resultData;
    }

    @Override
    public ResultData addUser(User user) {
        if (userDao.addUser(user)){
            resultData.setStatus(200);
            resultData.setMsg("添加成功");
            resultData.setData(null);
        }else {
            resultData.setStatus(400);
            resultData.setMsg("添加失败");
            resultData.setData(null);
        }
        return resultData;
    }
}