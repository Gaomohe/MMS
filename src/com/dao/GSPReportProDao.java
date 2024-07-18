package com.dao;

import com.pojo.echarts.GSPSupply;
import com.pojo.echarts.GetString;
import com.util.ResultData;
import com.util.init.StringDeal;

import java.sql.ResultSet;
import java.util.List;

public interface GSPReportProDao {
    //
    public ResultSet GSPGetTimes();

    public ResultSet GSPGetNum(String time);

    public ResultSet getAllSup(String supply);

    public ResultSet getChoise01(String unit);

    public ResultSet  getChoise02(String mName);

    public ResultSet getChoise03(String mName);
}
