package com.service;

import com.pojo.Appointment;
import com.pojo.echarts.GSPSupply;
import com.pojo.echarts.GetString;
import com.util.LayuiTable;
import com.util.ResultData;

import java.util.List;

public interface GSPReportProService {
    public ResultData<?> reTimes(int dayNum);

    public ResultData<List<GSPSupply>> getAllSup();


    public ResultData<List<GetString>> getChoise01();

    public ResultData<List<GetString>> getChoise02();

    public ResultData<List<GetString>> getChoise03();

    public LayuiTable<Appointment> search(String[] key,String[] value);
}
