package com.service;

import com.pojo.Log;
import com.pojo.User;
import com.util.LayuiTable;

public interface LogService {
    public LayuiTable<Log> getLogList(int page, int limit);
}
