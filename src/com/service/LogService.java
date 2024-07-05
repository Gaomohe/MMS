package com.service;

import com.pojo.Log;
import com.pojo.User;
import com.util.LayuiTable;

public interface LogService {
    //获取日志记录列表
    public LayuiTable<Log> getLogList(int page, int limit);

    //日志记录
    public int setLog(String name,String action,String item);

}
