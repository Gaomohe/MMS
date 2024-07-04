package com.dao;

import java.sql.ResultSet;

public interface AppointDao {
    //删除预购药品
    public int delAppoint(int id);

    //获取所有已批订单
    public ResultSet getAppointList();
}
