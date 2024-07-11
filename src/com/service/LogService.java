package com.service;

import com.pojo.Log;
import com.pojo.User;
import com.util.LayuiTable;

import java.util.List;

public interface LogService {
    //获取日志记录列表
    public LayuiTable<Log> getLogList(int page, int limit);

    //日志记录
    public int setLog(String name,String action,String item,String operate);

    //获取事务类型（名称）
    public List<Log> getLogItem();

    //获取日志动作类型
    public List<Log> getLogAction();

    //获取操作描述
    public List<Log> getLogOperate();

    //条件查询日志内容
    public LayuiTable<Log> Search(Log log,String startTime ,String endTime,int page, int limit);

    //删除日志记录
    public int delLog(int id);
}
