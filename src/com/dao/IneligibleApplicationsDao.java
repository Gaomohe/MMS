package com.dao;

import com.pojo.echarts.IneligibleApplications;
import com.util.LayuiTable;

import java.sql.ResultSet;

public interface IneligibleApplicationsDao {
    public ResultSet getAll(int pages, int limits);
}
