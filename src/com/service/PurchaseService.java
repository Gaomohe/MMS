package com.service;

import com.pojo.Apply;
import com.pojo.Appointment;
import com.pojo.User;
import com.util.LayuiTable;

import java.util.List;

public interface PurchaseService {
    //获取全部未批准
    public LayuiTable<Appointment> getAppointList(int page, int limit);


}
