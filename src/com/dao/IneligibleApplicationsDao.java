package com.dao;

import com.pojo.echarts.GetString;
import com.pojo.echarts.IneligibleApplications;
import com.pojo.echarts.Times;
import com.util.LayuiTable;
import com.util.ResultData;

import java.sql.ResultSet;
import java.util.List;

public interface IneligibleApplicationsDao {
    public ResultSet getAll(int pages, int limits);

    public ResultSet GSPGetNum(String time);

    public ResultSet getChoise01(String unit);

    public ResultSet  getChoise02(String mName);
}
