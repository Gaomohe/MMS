package com.service;

import com.pojo.echarts.GetString;
import com.pojo.echarts.Times;
import com.util.ResultData;

import java.sql.ResultSet;
import java.util.List;

public interface ReceivingService {
    public ResultData<List<Times>> getAll(int day);

    public ResultData<List<GetString>> getChoise01();

    public ResultData<List<GetString>> getChoise02();


}
