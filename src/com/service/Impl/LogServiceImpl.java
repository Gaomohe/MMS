package com.service.Impl;

import com.dao.Impl.LogDaoImpl;
import com.dao.LogDao;
import com.pojo.Log;
import com.pojo.User;
import com.service.LogService;
import com.util.LayuiTable;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class LogServiceImpl implements LogService {
    LayuiTable<Log> layuiTable = new LayuiTable<Log>();
    LogDaoImpl logDao = new LogDaoImpl();
    @Override
    public LayuiTable<Log> getLogList(int page, int limit) {
        ResultSet logSet = logDao.getAll(page, limit, "log");
        List<Log> logList = new ArrayList<Log>();
        int count = 0;
        try {
            ResultSet userDaoAll = logDao.getAll("log");
            while (userDaoAll.next()){
                count++;
            }
            while (logSet.next()){
                Log log = new Log();
                log.setLogId(logSet.getInt(1));
                log.setTime(logSet.getString(2));
                log.setName(logSet.getString(3));
                log.setAction(logSet.getString(4));
                log.setItem(logSet.getString(5));
                logList.add(log);
            }
            layuiTable.setCode(0);
            layuiTable.setData(logList);
            layuiTable.setCount(count);
            layuiTable.setMsg("");


        }catch (Exception e){
            e.printStackTrace();
        }
        return layuiTable;
    }
}
