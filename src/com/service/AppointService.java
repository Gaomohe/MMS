package com.service;

import com.pojo.Appointment;
import com.pojo.Log;
import com.util.LayuiTable;

import java.util.List;

public interface AppointService {
    //删除预购药品
    public int delAppoint(int id);

    //获取全部批准
    public LayuiTable<Appointment> getAppointList(int page, int limit);

    //批量添加生成订单
    public int addAppoint(List<Integer> idList);
}
