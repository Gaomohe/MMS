package com.dao;

import com.pojo.Log;
import com.util.Result;

import java.sql.ResultSet;

public interface LogDao {
    //日志记录列表
    public ResultSet getLogList();

    //日志记录
    public int setLog(Log log);
}
