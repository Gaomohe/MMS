package com.service;

import com.pojo.Apply;
import com.pojo.Appointment;
import com.pojo.Purchase;
import com.pojo.User;
import com.util.LayuiTable;
import com.util.ResultData;
import com.util.init.StringDeal;

import java.util.List;

public interface PurchaseService {
    //获取全部未批准
    public LayuiTable<Appointment> getAppointList(int page, int limit);

    public LayuiTable<Purchase> getId(int id);

    public ResultData<Integer> isok(int[] ins, String name);


}
