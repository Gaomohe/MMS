package com.dao;

import com.pojo.Log;
import com.util.Result;

import java.sql.ResultSet;
import java.util.List;

public interface LogDao {
    //日志记录列表
    public ResultSet getLogList();

    //日志记录
    public int setLog(Log log);

    //获取事务类型（名称）
    public List<Log> getLogItem();

    //获取日志动作类型
    public List<Log> getLogAction();

    //获取操作描述
    public List<Log> getLogOperate();

    //条件查询所有日志信息
    public List<Log> Search(String sql);

    //删除日志记录
    public int delLog(int id);
}
