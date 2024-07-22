package com.dao;

import com.pojo.echarts.NonConformanceApproval;
import com.util.LayuiTable;

import java.sql.ResultSet;

public interface NonConformanceApprovalDao {
    public ResultSet getAll(int pages,int limits);
}
