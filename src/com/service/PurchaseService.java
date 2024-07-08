package com.service;

import com.pojo.Appointment;
import com.util.LayuiTable;

public interface PurchaseService {
    //获取全部未批准
    public LayuiTable<Appointment> getAppointList(int page, int limit);
}
