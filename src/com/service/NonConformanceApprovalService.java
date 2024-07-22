package com.service;

import com.pojo.echarts.GetString;
import com.pojo.echarts.IneligibleApplications;
import com.pojo.echarts.NonConformanceApproval;
import com.pojo.echarts.Times;
import com.util.LayuiTable;
import com.util.ResultData;

import java.util.List;

public interface NonConformanceApprovalService {
    public LayuiTable<NonConformanceApproval> getAll(int pages,int limits);

    public ResultData<List<Times>> getAllDay(int dayNum);

    public ResultData<List<GetString>> getChoise01();

    public ResultData<List<GetString>> getChoise02();
}
